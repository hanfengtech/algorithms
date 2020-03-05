package tech.hanfeng.algorithms.recursion

fun combinationSum(candidates : IntArray, target : Int) : List<List<Int>> {
    var resList = ArrayList<List<Int>>()
    if (candidates.isEmpty()) return resList

    fun helper(slate : ArrayList<Int>, remaining : Int, i : Int) {
        if (remaining < 0) return
        if (remaining == 0) {
            resList.add(slate.toList())
            return
        }

        for (k in i until candidates.size) {
            slate.add(candidates[k])
            helper(slate, remaining - candidates[k], k)  // not i + 1 since we can reuse the same element
            slate.removeAt(slate.lastIndex)
        }
    }

    helper(ArrayList(), target, 0)
    return resList
}

fun main() {
    println(combinationSum(intArrayOf(2,3,6,7), 7))
}