package tech.hanfeng.algorithms.strings

fun numJewelsInStones(J: String, S: String): Int {
    val set = HashSet<Char>()
    for (i in J.indices) {
        set.add(J[i])
    }

    var count = 0
    for (i in S.indices) {
        if (set.contains(S[i])) {
            count++
        }
    }

    return count
}

fun main() {
    println(numJewelsInStones("aA", "aAAAABBB"))
}