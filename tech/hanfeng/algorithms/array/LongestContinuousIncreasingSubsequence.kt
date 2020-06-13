package tech.hanfeng.algorithms.array


/*

maxLen = 1
       0, 1, 2, 3, 4
      [1, 3, 5, 4, 7]


    start

        end


       if (nums[end] > nums[end - 1]) {
          val len = end - start  + 1    = 2
          maxLen = Math.max(maxLen, len)
       } else {
           start = end
       }


 */
fun findLengthOfLCIS(nums: IntArray) : Int {
    if (nums.isEmpty()) return 0

    var maxLen = 1
    var start = 0
    var end = 1

    while (end < nums.size) {
        if (nums[end] > nums[end - 1]) {
            val len = end - start + 1
            maxLen = Math.max(maxLen, len)
        } else {
            start = end
        }
        end++
    }
    return maxLen
}

fun main() {
    println(findLengthOfLCIS(intArrayOf(1,3,5,4,7)))
    println(findLengthOfLCIS(intArrayOf(2,2,2,2,2)))
    println(findLengthOfLCIS(intArrayOf()))
    println(findLengthOfLCIS(intArrayOf(9)))
    println(findLengthOfLCIS(intArrayOf(8,9)))
    println(findLengthOfLCIS(intArrayOf(7,5,3,1)))
    println(findLengthOfLCIS(intArrayOf(1,2,3,2,5,7,8)))
    println(findLengthOfLCIS(intArrayOf(1,2,3,2,2,2,5,7,8)))
}