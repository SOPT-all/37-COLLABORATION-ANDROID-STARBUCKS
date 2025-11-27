package sopt.org.starbucks.data.model

data class OptionItemModel(
    val isHot: Boolean?,
    val size: String?,
    val personalOptions: List<PersonalOption>?
)

data class MyMenuOptionModel(
    val myMenuId: Long = 0,
    val isHot: Boolean?,
    val size: String?,
    val summary: String = "",
    val personalOptions: List<PersonalOption>?
)
