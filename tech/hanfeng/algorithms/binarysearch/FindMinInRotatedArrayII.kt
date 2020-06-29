package tech.hanfeng.algorithms.binarysearch

class FindMinInRotatedArrayII  {
    fun findMin(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        fun findMin(lo: Int, hi: Int): Int {
            if (lo == hi) return nums[lo]
            val mid = lo + (hi - lo) / 2
            return when {
                nums[mid] < nums[hi] -> findMin(lo, mid)
                nums[mid] > nums[hi] -> findMin(mid + 1, hi)
                else -> minOf(findMin(lo, mid), findMin(mid + 1, hi))
            }
        }
        return findMin(0, nums.size - 1)
    }
}

fun main() {
    println(FindMinInRotatedArrayII().findMin(intArrayOf(3,3,1,3)))
    println(FindMinInRotatedArrayII().findMin(intArrayOf(1,3,5)))
    println(FindMinInRotatedArrayII().findMin(intArrayOf(2,2,2,0,1)))

}