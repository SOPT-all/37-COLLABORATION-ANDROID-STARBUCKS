package sopt.org.starbucks.ui.home.model

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import sopt.org.starbucks.R

object RecommendMenuData {
    val menuList: ImmutableList<RecommendMenuModel> = persistentListOf(
        RecommendMenuModel(1, R.drawable.img_home_menu_01, "바닐라 크림 콜드브루"),
        RecommendMenuModel(2, R.drawable.img_home_menu_02, "딸기 아사히 레모네이드 스타벅스 리프레셔"),
        RecommendMenuModel(3, R.drawable.img_home_menu_03, "딸기 촉촉 초코 생크림 케이크"),
        RecommendMenuModel(4, R.drawable.img_home_menu_04, "아이스 자몽 허니 블랙 티"),
        RecommendMenuModel(5, R.drawable.img_home_menu_05, "햄 & 루꼴라 페스토 샌드위치"),
        RecommendMenuModel(6, R.drawable.img_home_menu_06, "딸기 글레이즈드 크림 프라푸치노"),
        RecommendMenuModel(7, R.drawable.img_home_menu_07, "블루베리 쿠키 치즈 케이크"),
        RecommendMenuModel(8, R.drawable.img_home_menu_08, "아이스 스타벅스 돌체 라떼")
    )
}
