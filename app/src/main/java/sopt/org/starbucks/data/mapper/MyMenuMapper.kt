package sopt.org.starbucks.data.mapper

import sopt.org.starbucks.data.dto.response.MyMenuDto
import sopt.org.starbucks.data.dto.response.MyMenuListDto
import sopt.org.starbucks.data.model.MyMenu
import sopt.org.starbucks.ui.order.OrderTab

fun MyMenuDto.toDomain(): MyMenu =
    MyMenu(
        myMenuId = this.myMenuId,
        category = when (this.categoryName) {
            "DRINK" -> OrderTab.DRINK
            "FOOD" -> OrderTab.FOOD
            else -> OrderTab.ALL
        },
        myMenuName = this.myMenuName,
        menuName = this.menuName,
        myMenuOption = this.myMenuOption,
        price = this.price,
        imgUrl = this.myMenuImage
    )

fun MyMenuListDto.toDomain(): List<MyMenu> = this.myMenuList.map { it.toDomain() }
