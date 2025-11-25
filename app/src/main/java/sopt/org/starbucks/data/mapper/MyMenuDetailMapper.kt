package sopt.org.starbucks.data.mapper

import sopt.org.starbucks.data.dto.response.MyMenuDetailDto
import sopt.org.starbucks.data.dto.response.PersonalOptionDto
import sopt.org.starbucks.data.dto.response.SizePricesDto
import sopt.org.starbucks.data.model.MenuDetailModel
import sopt.org.starbucks.data.model.PersonalOption
import sopt.org.starbucks.data.model.SizePrices

fun MyMenuDetailDto.toDomain(): MenuDetailModel =
    MenuDetailModel(
        myMenuId = this.myMenuId,
        categoryName = this.categoryName,
        hotMenuKr = this.hotMenuKr,
        hotMenuEng = this.hotMenuEng,
        hotMenuImageUrl = this.hotMenuImageUrl,
        iceMenuKr = this.iceMenuKr,
        iceMenuEng = this.iceMenuEng,
        iceMenuImageUrl = this.iceMenuImageUrl,
        info = this.info,
        price = this.price,
        count = this.count,
        isHot = this.isHot,
        size = this.size,
        sizePrices = this.sizePrices.toDomain(),
        personalOptions = this.personalOptions.map { it.toDomain() },
        summary = this.summary,
        isNew = true,
        notices = listOf(
            "* 리치 과육의 숙 캡슐이 있을 수 있지만 안심하고 드세요.",
            "* 대체당(스테비아)을 일부 사용하여 당과 칼로리를 낮췄습니다."
        )
    )

fun SizePricesDto.toDomain(): SizePrices =
    SizePrices(
        tall = this.tall,
        grande = this.grande,
        venti = this.venti
    )

fun PersonalOptionDto.toDomain(): PersonalOption =
    PersonalOption(
        name = this.name,
        price = this.price
    )
