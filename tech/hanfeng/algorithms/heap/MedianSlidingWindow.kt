package tech.hanfeng.algorithms.heap

import java.util.*


// O(n log k)
fun medianSlidingWindow(nums: IntArray, k: Int): DoubleArray {
    if (nums.isEmpty()) return doubleArrayOf()
    val res = DoubleArray(nums.size - k + 1)
    val left = TreeSet(Comparator { a: Int, b: Int -> if (nums[a] == nums[b]) a - b else nums[b].compareTo(nums[a]) })
    val right = TreeSet(Comparator { a: Int, b: Int -> if (nums[a] == nums[b]) a - b else nums[a].compareTo(nums[b]) })

    for (i in nums.indices) {
        left.add(i)
        right.add(left.pollFirst())
        if (left.size < right.size) {
            left.add(right.pollFirst())
        }
        if (left.size + right.size == k) {
            var median = if (left.size == right.size) {
                (nums[left.first()].toDouble() + nums[right.first()].toDouble()) / 2
            } else {
                nums[left.first()].toDouble()
            }
            val start = i - k + 1
            res[start] = median
            if (!left.remove(start)) {
                right.remove(start)
            }
        }
    }
    return res
}

// O(nk)
fun medianSlidingWindowHeap(nums: IntArray, k: Int): DoubleArray {
    val minHeap = PriorityQueue<Int>(Comparator { a: Int, b: Int -> if (nums[a] == nums[b]) a - b else nums[b].compareTo(nums[a]) })
    val maxHeap = PriorityQueue<Int>(Comparator { a: Int, b: Int -> if (nums[a] == nums[b]) a - b else nums[a].compareTo(nums[b]) })

    var index = 0
    val maxHeapSize = k / 2
    val minHeapSize = k - maxHeapSize
    val res = DoubleArray(nums.size - k + 1)

    for (i in nums.indices) {
        maxHeap.add(i)
        if (maxHeap.size > maxHeapSize) {
            minHeap.add(maxHeap.poll())
        }
        if (maxHeap.size == maxHeapSize && minHeap.size == minHeapSize) {
            if (k % 2 == 0) {
                res[index] = (nums[minHeap.peek()].toDouble() + nums[maxHeap.peek()].toDouble()) / 2.0
            } else {
                res[index] = nums[minHeap.peek()].toDouble()
            }

            if (!minHeap.remove(index)) {
                maxHeap.remove(index)
                maxHeap.add(minHeap.poll())
            }
            index++
        }
    }
    return res
}

fun main() {
    println(medianSlidingWindowHeap(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 6).contentToString())
 //   println(medianSlidingWindow(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 6).contentToString())
    println(medianSlidingWindow(intArrayOf(2147483647, 2147483647), 2).contentToString())
}