package tech.hanfeng.algorithms.array

fun nextPermutation(nums: IntArray) {
    var i = nums.size - 2
    while (i >= 0 && nums[i + 1] <= nums[i]) {
        i--
    }

    if (i >= 0) {
        var j = nums.size - 1
        while (j >= 0 && nums[j] <= nums[i]) {
            j--
        }
        nums.swap(i,j)
    }

    nums.reserse(i+1)
}

fun IntArray.reserse(start : Int) {
    var i = start
    var j = this.size - 1
    while(i < j) {
        swap(i,j)
        i++
        j--
    }
}

fun main() {
    var nums = intArrayOf(1,3,2)
    nextPermutation(nums)
    println(nums.contentToString())

    nums = intArrayOf(3,2,1)
    //nextPermutation(nums)
    println(nums.contentToString())

    nums = intArrayOf(1,1,5)
  //  nextPermutation(nums)
    println(nums.contentToString())

    nums = intArrayOf(1,2)
    nextPermutation(nums)
    println(nums.contentToString())


    nums = intArrayOf(6,5)
    nextPermutation(nums)
    println(nums.contentToString())

}