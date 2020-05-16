package tech.hanfeng.algorithms.array

// 3sum

// FindTripletsWithZeroSum

fun threeSum(nums : IntArray) : List<List<Int>> {
        val result =  ArrayList<List<Int>>()
        nums.sort()

        for (i in nums.indices) {
            var start = i + 1
            var end = nums.size - 1

            if (i > 0 && nums[i] == nums[i - 1]) continue   // skip same value number

            while(start < end) {
                if (end < nums.size - 1 && nums[end] == nums[end + 1]) {
                    end--
                    continue
                }

                val sum = nums[i] + nums[start] + nums[end]
                if (sum == 0) {
                    result.add(intArrayOf(nums[i], nums[start], nums[end]).toList())
                    start++
                    end--
                } else if (sum < 0) {
                    start++
                } else {
                    end--
                }
            }
        }

    return result
}

fun main() {
    val result = threeSum(intArrayOf(-1, 0, 1, 2, -1, -4))

    result?.forEach {
        println(it)
    }
}