package tech.hanfeng.algorithms.strings

fun isIsomorphic(s : String, t: String) : Boolean {
    var m1 = IntArray(256)
    var m2 = IntArray(256)
    val n = s.length
    for (i in 0 until n) {
        var j = s[i].toInt()
        var k = t[i].toInt()
        if (m1[j] != m2[k]) return false
        m1[j] = i + 1
        m2[k] = i + 1
    }
    return true
}

fun main() {
    println(isIsomorphic("egggd", "adddy"))
    println(isIsomorphic("foo", "bar"))
    println(isIsomorphic("paper", "title"))
}