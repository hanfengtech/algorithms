package tech.hanfeng.algorithms.implementation

class NumArray(nums : IntArray) {
    var nums = IntArray(0)
    var sums = IntArray(0)

    init{
        if (nums.isNotEmpty()) {
            this.nums = nums
            sums = IntArray(nums.size)
            sums[0] = nums[0]
            for (i in 1 until nums.size) {
                sums[i] = sums[i - 1] + nums[i]
            }
        }
    }

    fun sumRange(x : Int, y : Int) : Int {
        var sum = 0
        if (x < 0 || x > nums.size || y > nums.size || y < 0) {
            return Int.MAX_VALUE
        }
        if (x == 0) return sums[y]
        return sums[y] - sums[x -1]
    }
}

fun main() {
    val numArray = NumArray(intArrayOf(-2,0,3,-5,2,-1))
    println(numArray.sumRange(0,2))
    println(numArray.sumRange(2,5))
    println(numArray.sumRange(0,5))
}