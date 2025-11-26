package sopt.org.starbucks.data.model

import sopt.org.starbucks.ui.order.OrderTab

data class MyMenu(
    val myMenuId: Long,
    val category: OrderTab,
    val myMenuName: String,
    val menuName: String,
    val myMenuOption: String,
    val price: Int,
    val imgUrl: String
)
