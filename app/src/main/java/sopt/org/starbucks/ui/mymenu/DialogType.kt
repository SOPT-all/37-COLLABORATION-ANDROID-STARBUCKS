package sopt.org.starbucks.ui.mymenu

enum class DialogType(
    val label: String,
    val title: String
) {
    RESET(
        label = "전체 초기화",
        title = "퍼스널 옵션을 전체 초기화하시겠어요?"
    ),
    DELETE(
        label = "삭제하기",
        title = "퍼스널 옵션을 삭제하시겠어요?"
    )
}
