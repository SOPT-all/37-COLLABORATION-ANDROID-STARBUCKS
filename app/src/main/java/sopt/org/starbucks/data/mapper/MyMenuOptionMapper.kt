package sopt.org.starbucks.data.mapper

import sopt.org.starbucks.data.dto.request.MyMenuOptionRequestDto
import sopt.org.starbucks.data.dto.request.PersonalOptionsRequestDto
import sopt.org.starbucks.data.dto.response.MyMenuOptionResponseDto
import sopt.org.starbucks.data.dto.response.PersonalOptionsDto
import sopt.org.starbucks.data.model.MyMenuOptionModel
import sopt.org.starbucks.data.model.OptionItemModel
import sopt.org.starbucks.data.model.PersonalOptions

fun OptionItemModel.toData(): MyMenuOptionRequestDto = MyMenuOptionRequestDto(
    isHot = this.isHot,
    size = this.size,
    personalOptions = this.personalOptions?.map { it.toData() }
)

fun MyMenuOptionResponseDto.toDomain(): MyMenuOptionModel = MyMenuOptionModel(
    myMenuId = this.myMenuId,
    isHot = this.isHot,
    size = this.size,
    summary = this.summary,
    personalOptions = this.personalOptions?.map { it.toDomain() }
)

fun PersonalOptions.toData(): PersonalOptionsRequestDto =
    PersonalOptionsRequestDto(
        name = this.name,
        price = this.price
    )
fun PersonalOptionsDto.toDomain(): PersonalOptions =
    PersonalOptions(
        name = this.name,
        price = this.price
    )
