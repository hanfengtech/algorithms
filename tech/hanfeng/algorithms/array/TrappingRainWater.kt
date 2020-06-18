package tech.hanfeng.algorithms.array

fun trap(height : IntArray) : Int {
    var left = 0
    var right = height.size - 1
    var leftMax = 0
    var rightMax = 0
    var ans = 0
    while (left < right) {
        if (height[left] < height[right]) {
            if (height[left] >= leftMax) {
                leftMax = height[left]
            } else {
                ans += leftMax - height[left]
            }
            left++
        } else {
            if (height[right] > rightMax) {
                rightMax = height[right]
            } else {
                ans += rightMax - height[right]
            }
            right--
        }
    }

    return ans
}

fun main() {
    println(trap(intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)))
}