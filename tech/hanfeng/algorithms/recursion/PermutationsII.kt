package tech.hanfeng.algorithms.recursion

fun permuteUnique(nums: IntArray) : List<List<Int>> {
    val resList = ArrayList<List<Int>>()
    fun helper(slate : IntArray, i : Int) {
        val set = HashSet<Int>()
        if (i == slate.size) {
            resList.add(slate.toList())
            return
        }

        for (j in i until slate.size) {
            if (set.contains(slate[j]))
                continue

            slate.swap(i, j)
            helper(slate, i + 1)
            slate.swap(j, i)
            set.add(slate[j])
        }
    }

    helper(nums, 0)
    return resList
}

fun main() {
    println(permuteUnique(intArrayOf(1,1,2)))
}
