package tech.hanfeng.algorithms.array

import java.util.*

fun thirdMax(nums: IntArray): Int {
    var queue = PriorityQueue<Int>()
    var set = HashSet<Int>()

    var max = Int.MIN_VALUE   // for less than three to get the max
    nums.forEach{
        if (!set.contains(it)) {
            max = Math.max(it, max)
            queue.add(it)
            if (queue.size > 3) queue.poll()
            set.add(it)
        }
    }

    return if(queue.size == 3) queue.peek() else max
}

fun main() {

    println(thirdMax(intArrayOf(1,2,2)))
    println(thirdMax(intArrayOf(5,2,4,1,3,6,0)))
}