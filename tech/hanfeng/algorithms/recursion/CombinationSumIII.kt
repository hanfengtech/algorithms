package tech.hanfeng.algorithms.recursion

fun combinationSumIII(k : Int, n : Int) : List<List<Int>> {
    val resList = ArrayList<List<Int>>()
    if (k < 1) return resList

    fun helper(slate: ArrayList<Int>, remaining : Int, start : Int) {
        if (remaining < 0) return
        if (remaining == 0 && slate.size == k) {
            resList.add(slate.toList())
            return
        }

        for (i in start .. 9) {
            slate.add(i)
            helper(slate, remaining - i, i + 1)
            slate.removeAt(slate.lastIndex)
        }
    }

    helper(ArrayList(), n, 1)
    return resList
}

fun main() {
    println(combinationSumIII(3,7))
    println(combinationSumIII(3,9))
}