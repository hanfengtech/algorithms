package tech.hanfeng.algorithms.strings

/*
       123
     45678

 */
fun addStrings(num1 : String, num2 : String) : String {
    var n = num1.length - 1
    var m = num2.length - 1
    val result = StringBuilder()
    var carry = 0

    while(n >= 0 || m >= 0) {
        var sum = carry

        if (n >= 0) {
            sum += num1[n] - '0'
        }

        if (m >= 0) {
            sum += num2[m] - '0'
        }

        result.append(sum % 10)
        carry = sum / 10
        n--
        m--
    }

    if (carry == 1) result.append('1')

    return result.reverse().toString()
}

fun main() {
    println(addStrings("123", "45678"))
    println(addStrings("78965", "45678"))
}