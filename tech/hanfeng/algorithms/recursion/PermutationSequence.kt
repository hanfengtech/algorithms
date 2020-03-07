package tech.hanfeng.algorithms.recursion

fun getPermutationR(n : Int, k : Int) : String {
    if(n < 1 || k < 1) return String()

    var res = String()
    var count = 1

    fun backtrack(slate : IntArray, start : Int) {
        if (count > k) return
        if (slate.size == start) {
            if (count++ == k) {
                res = slate.contentToString()
            }
            return
        } else {
            for (i in start until slate.size) {
                slate.swap(start, i)
                backtrack(slate, start + 1)
                slate.swap(i, start)
            }
        }
    }

    val nums = IntRange(1, n).step(1).toList().toIntArray()

    backtrack(nums, 0)
    return res
}

fun getPermutation(n : Int, k : Int) : String {
    if(n < 1 || k < 1) return String()

    val sb = StringBuilder()
    val nums = ArrayList<Int>()

    val fact = IntArray(n)

    var sum = 1
    fact[0] = 1
    for (i in 1 until n) {
        sum *= i
        fact[i] = sum
    }

    for (i in 0 until n) {
        nums.add(i + 1)
    }

    var seqPos = k - 1

    for (i in 1 .. n) {
        val index = seqPos / fact[n - i]
        if ( index >= nums.size) return "Cannot find the permutation"
        sb.append(nums[index])
        nums.removeAt(index)
        seqPos -= index * fact[n - i]
    }

    return sb.toString()
}

fun main() {
    println(getPermutation(4, 24))
}