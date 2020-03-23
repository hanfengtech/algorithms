package tech.hanfeng.algorithms.strings

//129.168.123.163

fun validateIPAddress(IP : String) : String {
    return if (isIPv4(IP)) "IPv4"
    else if (isIPv6(IP)) "IPv6"
    else {
        "Neither"
    }
}

fun isIPv4(ip : String) : Boolean {
    if (ip.isEmpty() || ip.length < 7 || ip.length > 15 ||
            ip.startsWith('.') || ip.endsWith('.'))
        return false

    val tokens = ip.split('.')

    if (tokens.size != 4)
        return false

    for (token in tokens) {
        if (!isValidIPv4Token(token))
            return false
    }

    return true
}

fun isValidIPv4Token(token : String) : Boolean {
    if (token.isEmpty() || token[0] == '0' && token.length > 1)
        return false

    try {
        val n = token.toInt()

        if (n < 0 || 255 < n)
            return false

        if (n == 0 && token[0] != '0')
            return false

    } catch (e : NumberFormatException) {
        return false
    }

    return true
}


fun isIPv6(ip : String) : Boolean {
    if (ip.isEmpty() || ip.length < 15 || ip.length > 39 ||
            ip.startsWith(':') || ip.endsWith(':'))
        return false

    val tokens = ip.split(':')

    if (tokens.size != 8)
        return false

    for (token in tokens) {
        if (!isValidIPv6Token(token))
            return false
    }

    return true
}

fun isValidIPv6Token(token : String) : Boolean {
    if (token.isEmpty() || token.length > 4) return false

    for (char in token) {
        if ( !((char in '0' .. '9')
            || (char in 'a' .. 'f')
            || (char in 'A' .. 'F')) )
            return false
    }

    return true
}

fun main() {
    println(validateIPAddress("16..1.23"))
    println(validateIPAddress("172.16.254.1"))
    println(validateIPAddress("172.16.254.1000"))
    println(validateIPAddress("172.16.254."))
    println(validateIPAddress("172.16.254.1.4"))
    println(validateIPAddress("One.16.254.1"))
    println(validateIPAddress(""))
    println(validateIPAddress("-252.16.254.1"))
    println(validateIPAddress("0.16.254.1"))
    println(validateIPAddress("01.16.254.1"))
    println(validateIPAddress("100.16.254.1"))
    println(validateIPAddress(".16.254.1"))
    println(validateIPAddress("16.254.1"))

    println(validateIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:7334"))

    println(validateIPAddress("20EE:FGb8:85a3:0:0:8A2E:0370:7334"))

}