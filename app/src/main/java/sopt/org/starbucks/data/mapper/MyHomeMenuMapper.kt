package sopt.org.starbucks.data.mapper

import sopt.org.starbucks.data.dto.response.MyHomeMenuDto
import sopt.org.starbucks.data.dto.response.MyHomeMenuListDto
import sopt.org.starbucks.data.model.MyHomeMenu

fun MyHomeMenuDto.toDomain(): MyHomeMenu =
    MyHomeMenu(
        myMenuId = myMenuId,
        myMenuName = myMenuName,
        myMenuOption = myMenuOption,
        myMenuImage = myMenuImage
    )

fun MyHomeMenuListDto.toDomain(): List<MyHomeMenu> = myMenuList.map { it.toDomain() }
