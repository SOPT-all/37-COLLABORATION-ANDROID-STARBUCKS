package sopt.org.starbucks.ui.mymenu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import sopt.org.starbucks.core.state.UiState
import sopt.org.starbucks.data.model.OptionItemModel
import sopt.org.starbucks.data.model.PersonalOption
import sopt.org.starbucks.data.repository.MyMenuRepository
import sopt.org.starbucks.ui.mymenu.component.DrinkSize
import sopt.org.starbucks.ui.mymenu.component.TabType
import javax.inject.Inject

@HiltViewModel
class MyMenuViewModel
    @Inject
    constructor(
        private val myMenuRepository: MyMenuRepository
    ) : ViewModel() {
        private val _uiState = MutableStateFlow(MyMenuUiState())
        val uiState = _uiState.asStateFlow()

        fun loadMenu(menuId: Long) {
            viewModelScope.launch {
                _uiState.update { it.copy(menuLoadState = UiState.Loading) }

                myMenuRepository
                    .getMyMenuDetail(menuId)
                    .onSuccess { menu ->
                        _uiState.update {
                            val initialSize = when (menu.size) {
                                "GRANDE" -> DrinkSize.GRANDE
                                "VENTI" -> DrinkSize.VENTI
                                else -> DrinkSize.TALL
                            }
                            val sizePrice = when (initialSize) {
                                DrinkSize.TALL -> menu.sizePrices.tall
                                DrinkSize.GRANDE -> menu.sizePrices.grande
                                DrinkSize.VENTI -> menu.sizePrices.venti
                            }
                            val optionPrice = menu.personalOptions.sumOf { it.price }
                            val initialTotal = menu.price + sizePrice + optionPrice

                            it.copy(
                                menuLoadState = UiState.Success(menu),
                                selectedTab = if (menu.isHot) TabType.HOT else TabType.ICED,
                                selectedSize = initialSize,
                                optionList = menu.personalOptions.toImmutableList(),
                                totalPrice = initialTotal
                            )
                        }
                    }.onFailure { t ->
                        _uiState.update {
                            it.copy(
                                menuLoadState = UiState.Failure(
                                    t.message ?: "Failed to load menu"
                                )
                            )
                        }
                    }
            }
        }

        private fun calculatePrice(
            targetSize: DrinkSize? = null,
            targetList: List<PersonalOption>? = null
        ): Int {
            val currentState = _uiState.value
            val menu = (currentState.menuLoadState as? UiState.Success)?.data ?: return 0

            val sizeToCheck = targetSize ?: currentState.selectedSize
            val listToCheck = targetList ?: currentState.optionList

            val sizePrice = when (sizeToCheck) {
                DrinkSize.TALL -> menu.sizePrices.tall
                DrinkSize.GRANDE -> menu.sizePrices.grande
                DrinkSize.VENTI -> menu.sizePrices.venti
            }
            val optionPrice = listToCheck.sumOf { it.price }

            return menu.price + sizePrice + optionPrice
        }

        fun selectTab(tab: TabType) {
            _uiState.update { it.copy(selectedTab = tab) }
        }

        fun selectSize(size: DrinkSize) {
            _uiState.update { it.copy(selectedSize = size, totalPrice = calculatePrice(targetSize = size)) }
        }

        fun togglePersonalCup() {
            _uiState.update { it.copy(isPersonalCupChecked = !it.isPersonalCupChecked) }
        }

        fun onResetClick() {
            _uiState.update {
                it.copy(
                    showDialog = true,
                    dialogType = DialogType.RESET
                )
            }
        }

        fun onCancelClick(personalOption: PersonalOption) {
            _uiState.update {
                it.copy(
                    showDialog = true,
                    dialogType = DialogType.DELETE,
                    selectedOption = personalOption
                )
            }
        }

        fun onDismissRequest() {
            _uiState.update {
                it.copy(
                    showDialog = false
                )
            }
        }

        fun onDialogConfirm() {
            val currentList = _uiState.value.optionList.toMutableList()

            val newList = when (_uiState.value.dialogType) {
                DialogType.RESET -> {
                    persistentListOf<PersonalOption>()
                }

                DialogType.DELETE -> {
                    currentList.apply { remove(_uiState.value.selectedOption) }
                }
            }

            _uiState.update {
                it.copy(
                    optionList = newList.toImmutableList(),
                    showDialog = false,
                    totalPrice = calculatePrice(targetList = newList)
                )
            }
        }

        fun onSaveOption(menuId: Long) {
            viewModelScope.launch {
                val currentState = _uiState.value

                val optionItem = OptionItemModel(
                    isHot = currentState.selectedTab == TabType.HOT,
                    size = currentState.selectedSize.name,
                    personalOptions = currentState.optionList
                )

                myMenuRepository
                    .updateMyMenuOption(menuId, optionItem)
            }
        }
    }
