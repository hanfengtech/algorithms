package tech.hanfeng.algorithms.strings

fun defangIPaddr(address: String): String {
    var strs = address.split('.')
    var sb = StringBuilder()

    strs.forEachIndexed { i, str ->
        sb.append(str)
        if (i < 3) {
            sb.append("[.]")
        }
    }
    return sb.toString()
}

fun main() {
    println(defangIPaddr("129.168.1.1"))
}