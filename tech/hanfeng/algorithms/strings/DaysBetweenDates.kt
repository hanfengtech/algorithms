package tech.hanfeng.algorithms.strings

var days = intArrayOf(0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
fun daysBetweenDates(date1: String, date2 : String) : Int {
    return Math.abs(days(date1) - days(date2))
}

fun days(date : String) : Int {
    var parts = date.split("-")
    var year = parts[0].toInt()
    var month = parts[1].toInt()
    var day = parts[2].toInt()

    for (i in 1971 until year)
        day += if (isLeap(i)) 366 else 365

    if (month > 2)
        day += if (isLeap(year)) 1 else 0

    for (i in 1 until month)
        day += days[i]

    return day
}

fun isLeap(year : Int) : Boolean {
    return year % 4 == 0 && year % 100 != 0 || year % 400 == 0
}

