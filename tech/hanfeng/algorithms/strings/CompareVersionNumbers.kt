package tech.hanfeng.algorithms.strings

fun compareVersion(v1 : String, v2 : String) : Int {
    val l1 = v1.split(".")
    val l2 = v2.split(".")

    val len = Math.max(l1.size, l2.size)

    for (i in 0 until len) {
        val n1 = if (i < l1.size) l1[i].toInt() else 0
        val n2 = if (i < l2.size) l2[i].toInt() else 0

        val compare = n1.compareTo(n2)
        if (compare != 0)
            return compare
    }
    return 0
}

fun main() {
    println(compareVersion("1.1", "1.2"))
    println(compareVersion("1.5", "0.8"))
    println(compareVersion("1.1", "1.1"))
}