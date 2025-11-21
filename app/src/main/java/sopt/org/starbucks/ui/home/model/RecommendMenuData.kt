package sopt.org.starbucks.ui.home.model

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import sopt.org.starbucks.R

object RecommendMenuData {
    val menuList: ImmutableList<RecommendMenuModel> = persistentListOf(
        RecommendMenuModel(1, R.drawable.img_home_menu_01, "코코말차"),
        RecommendMenuModel(2, R.drawable.img_home_menu_02, "아이스 윈터 스카치 바닐라 라떼"),
        RecommendMenuModel(3, R.drawable.img_home_menu_03, "토피넛 라떼"),
        RecommendMenuModel(4, R.drawable.img_home_menu_04, "카페 아메리카노"),
        RecommendMenuModel(5, R.drawable.img_home_menu_01, "콜드브루"),
        RecommendMenuModel(6, R.drawable.img_home_menu_02, "화이트 캔들 케이크"),
        RecommendMenuModel(7, R.drawable.img_home_menu_03, "캐모마일 릴렉서"),
        RecommendMenuModel(8, R.drawable.img_home_menu_04, "카페라떼")
    )
}
