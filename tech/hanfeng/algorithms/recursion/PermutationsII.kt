package tech.hanfeng.algorithms.recursion

fun permuteUnique(nums: IntArray) : List<List<Int>> {
    val resList = ArrayList<List<Int>>()
    fun helper(slate : IntArray, i : Int) {
        val set = HashSet<Int>()
        if (i == slate.size) {
            resList.add(slate.toList())
        } else {
            for (k in i until slate.size) {
                if (set.contains(slate[k]))
                    continue

                slate.swap(i, k)
                helper(slate, i + 1)
                slate.swap(k, i)
                set.add(slate[k])
            }
        }
    }

    helper(nums, 0)
    return resList
}

fun main() {
    println(permuteUnique(intArrayOf(1,1,2)))
}
