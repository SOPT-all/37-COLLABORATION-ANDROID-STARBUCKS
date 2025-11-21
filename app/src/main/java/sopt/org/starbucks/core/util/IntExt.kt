package sopt.org.starbucks.core.util

fun Int.toStringWithFormat(): String = java.text.DecimalFormat("#,###").format(this)
