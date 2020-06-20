package tech.hanfeng.algorithms.dp

class MaximumSumOf3NonOverlappingSubarrays {

    fun maxSumOfThreeSubarrays(nums: IntArray, k: Int): IntArray {
        val n: Int = nums.size
        val sum = IntArray(n + 1)

        for (i in 1 .. n) {
            sum[i] = sum[i - 1] + nums[i - 1]     //  calculate all sums
        }

        val firstArrayMaxSize = n - 2 * k
        var leftMax = 0
        var rightMax = 0
        var leftIndex = 0
        var rightIndex = n - k
        var leftMaxIndex = leftIndex
        var rightMaxIndex = rightIndex
        val leftMaxIndices = IntArray(firstArrayMaxSize + 1)
        val rightMaxIndices = IntArray(n - k + 1)

        for (i in 0 until firstArrayMaxSize) {
            var tmp = sum[leftIndex + k] - sum[leftIndex]
            if (leftMax < tmp) {
                leftMax = tmp
                leftMaxIndex = leftIndex
            }
            tmp = sum[rightIndex + k] - sum[rightIndex]
            if (rightMax <= tmp) {  // lexicographically smallest one.
                rightMax = tmp
                rightMaxIndex = rightIndex
            }
            leftMaxIndices[leftIndex++] = leftMaxIndex
            rightMaxIndices[rightIndex--] = rightMaxIndex
        }


        var res = 0
        var ret = IntArray(3)
        for (i in k..firstArrayMaxSize) {
            leftMaxIndex = leftMaxIndices[i - k]
            rightMaxIndex = rightMaxIndices[i + k]
            val max = sum[leftMaxIndex + k] - sum[leftMaxIndex] +
                    (sum[i + k] - sum[i]) +
                    (sum[rightMaxIndex + k] - sum[rightMaxIndex])
            if (max > res) {
                res = max
                ret = intArrayOf(leftMaxIndex, i, rightMaxIndex)
            }
        }
        return ret
    }
}

fun main() {
    println(MaximumSumOf3NonOverlappingSubarrays().maxSumOfThreeSubarrays(intArrayOf(1,2,1,2,6,7,5,1), 2).contentToString())
}
