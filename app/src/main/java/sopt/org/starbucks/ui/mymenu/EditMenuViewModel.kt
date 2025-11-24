package sopt.org.starbucks.ui.mymenu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import sopt.org.starbucks.ui.mymenu.component.DrinkSize
import sopt.org.starbucks.ui.mymenu.component.TabType
import javax.inject.Inject

@HiltViewModel
class EditMenuViewModel
    @Inject
    constructor() : ViewModel() {
        private val _uiState = MutableStateFlow(EditMenuUiState())
        val uiState = _uiState.asStateFlow()

        fun loadMenu(menuId: String) {
            viewModelScope.launch {
                // Mock 데이터
                _uiState.update {
                    it.copy(
                        menu = MenuDetail(
                            id = menuId,
                            koreanName = "아이스 핑크 팝 캐모마일 릴렉서",
                            englishName = "Iced Pink Pop Chamomile Relaxer",
                            description = "크리스마스에 어울리는 상큼한 핑크팝과 캐모마일 릴렉서! 리치, 레몬그라스, 캐모마일의 차분하면서도 새콤달콤한 조합",
                            imageUrl = null,
                            price = 6500,
                            isNew = true,
                            notices = listOf(
                                "* 리치 과육의 숙 캡슐이 있을 수 있지만 안심하고 드세요.",
                                "* 대체당(스테비아)을 일부 사용하여 당과 칼로리를 낮췄습니다."
                            )
                        )
                    )
                }
            }
        }

        fun selectTab(tab: TabType) {
            _uiState.update { it.copy(selectedTab = tab) }
        }

        fun selectSize(size: DrinkSize) {
            _uiState.update { it.copy(selectedSize = size) }
        }

        fun togglePersonalCup() {
            _uiState.update { it.copy(isPersonalCupChecked = !it.isPersonalCupChecked) }
        }
    }
