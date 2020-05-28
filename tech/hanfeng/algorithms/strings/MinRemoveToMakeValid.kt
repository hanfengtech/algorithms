package tech.hanfeng.algorithms.strings

fun minRemoveToMakeValid(s: String) : String {
    val sb = StringBuilder()
    var openSeen = 0
    var balance = 0

    for (c in s) {
        if (c == '(') {
            openSeen++
            balance++
        } else if (c == ')') {
            if (balance == 0) {
                continue
            }
            balance--
        }
        sb.append(c)
    }

    val result = StringBuilder()
    var openToKeep = openSeen - balance

    for (c in sb) {
        if (c == '(') {
            openToKeep--
            if (openToKeep < 0) {
                continue
            }
        }
        result.append(c)
    }

    return result.toString()
}

fun main() {
    println(minRemoveToMakeValid("lee(t(c)o)de)"))
}