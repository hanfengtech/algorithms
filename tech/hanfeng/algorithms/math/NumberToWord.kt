package tech.hanfeng.algorithms.math

val ones = arrayOf("", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine","Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen")
val tens = arrayOf("", "", "Twenty", "Thirty", "Forty","Fifty", "Sixty", "Seventy", "Eighty", "Ninety")
val thousands = arrayOf("", " Thousand", " Million", " Billion")


fun parseSection(num : Int, builder : StringBuilder) {
    if (num == 0) return

    if (builder.isNotEmpty()) {
        builder.append(" ")
    }

    if (num < 20) {
        builder.append(ones[num])
    } else if (num < 100) {
        builder.append(tens[num / 10])
        parseSection(num % 10, builder)
    } else if (num < 1000) {
        builder.append(ones[num / 100])
        builder.append(" Hundred")
        parseSection(num % 100, builder)
    }
}

fun buildString(builder : StringBuilder, num : Int, sectionIndex : Int, hasMoreSection : Boolean) {
    if (hasMoreSection)
        buildString(builder,  num / 1000, sectionIndex + 1, num >= 1000)

    val currSection = num % 1000
    if (currSection > 0) {
        parseSection(currSection, builder)
        builder.append(thousands[sectionIndex])
    }
}

fun numberToWords(num : Int) : String {
    if (num == 0) return "Zero"
    val result = StringBuilder()
    buildString(result, num, 0, num >= 1000)
    return result.toString()
}

fun main() {
    println(numberToWords(123))
    println(numberToWords(12345))
    println(numberToWords(1234567))
    println(numberToWords(1234567891))
}


fun one(num: Int): String {
    when (num) {
        1 -> return "One"
        2 -> return "Two"
        3 -> return "Three"
        4 -> return "Four"
        5 -> return "Five"
        6 -> return "Six"
        7 -> return "Seven"
        8 -> return "Eight"
        9 -> return "Nine"
    }
    return ""
}

fun twoLessThan20(num: Int): String {
    when (num) {
        10 -> return "Ten"
        11 -> return "Eleven"
        12 -> return "Twelve"
        13 -> return "Thirteen"
        14 -> return "Fourteen"
        15 -> return "Fifteen"
        16 -> return "Sixteen"
        17 -> return "Seventeen"
        18 -> return "Eighteen"
        19 -> return "Nineteen"
    }
    return ""
}

fun ten(num: Int): String {
    when (num) {
        2 -> return "Twenty"
        3 -> return "Thirty"
        4 -> return "Forty"
        5 -> return "Fifty"
        6 -> return "Sixty"
        7 -> return "Seventy"
        8 -> return "Eighty"
        9 -> return "Ninety"
    }
    return ""
}

fun two (num : Int) : String {
    if (num == 0) return ""
    else if (num < 10)
        return one(num)
    else if (num < 20)
        return twoLessThan20(num)
    else {
        val tenner = num / 10
        val rest = num - tenner * 10
        return if (rest != 0) {
            ten(tenner) + " " + one(rest)
        } else {
            ten(tenner)
        }
    }
}

fun three(num : Int) : String {
    val hundred = num / 100
    val rest = num - hundred * 100
    val result = StringBuilder()
    if (hundred * rest != 0)
        result.append(one(hundred) + " Hundred " + two(rest))
    else if ((hundred == 0) && (rest != 0))
        result.append(two(rest))
    else if ((hundred != 0) && (rest == 0))
        result.append(one(hundred) + " Hundred")
    return result.toString()
}

fun numberToWords2(num : Int) : String {
    if (num == 0) return "Zero"

    val billion = num / 1000000000
    val million = (num - billion * 1000000000) / 1000000
    val thousand = (num - billion * 1000000000 - million * 1000000) / 1000
    val rest = num - billion * 1000000000 - million * 1000000 - thousand * 1000

    val result = StringBuilder()
    if (billion != 0)
        result.append(three(billion) + " Billion")
    if (million != 0) {
        if (result.isNotEmpty()) result.append(" ")
        result.append(three(million) + " Million")
    }
    if (thousand != 0) {
        if (result.isNotEmpty()) result.append(" ")
        result.append(three(thousand) + " Thousand")
    }
    if (rest != 0) {
        if (result.isNotEmpty()) result.append(" ")
        result.append(three(rest))
    }
    return result.toString()
}
