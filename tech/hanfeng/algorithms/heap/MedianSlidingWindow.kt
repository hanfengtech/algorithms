package tech.hanfeng.algorithms.heap

import java.util.*


// O(n log k)
fun medianSlidingWindow(nums: IntArray, k: Int): DoubleArray {
    if (nums.isEmpty()) return doubleArrayOf()
    val res = DoubleArray(nums.size - k + 1)
    val left = TreeSet(Comparator { i: Int, j: Int -> if (nums[i] == nums[j]) i - j else nums[i].compareTo(nums[j]) })     // tree stores index, compare number with given index
    val right = left.clone() as TreeSet<Int>       // create the right tree same as left tree
    var index = 0                                  // index for the result array

    for (i in nums.indices) {
        left.add(i)                                // add index to the left tree
        right.add(left.pollLast())                 // move the largest value from left tree to the right tree
        if (left.size < right.size) {              // if the left tree size less than right
            left.add(right.pollFirst())            // move the smallest value from the right tree to the left tree
        }
        if (left.size + right.size == k) {         // if total size fo the two tree equals to k
            val median = if (left.size == right.size) {             // two trees has same size
                (nums[left.last()].toDouble() + nums[right.first()].toDouble()) / 2    // average the last value (max) of the left tree  and the first value (min) of the right tree
            } else {
                nums[left.last()].toDouble()       // if two tree size is not equal, the left tree will always have one extra value, and the last value (max) of the tree will be the median
            }
            res[index] = median                    // add median to the result
            if (!left.remove(index)) {             // try remove the index of the median from the left
                right.remove(index)                // since not able to remove from the left, remove the index from the right tree
            }
            index++
        }
    }
    return res
}

// O(nk)
fun medianSlidingWindowHeap(nums: IntArray, k: Int): DoubleArray {
    val minHeap = PriorityQueue<Int>(Comparator { i: Int, j: Int -> if (nums[i] == nums[j]) i - j else nums[i].compareTo(nums[j]) })
    val maxHeap = PriorityQueue<Int>(Comparator { i: Int, j: Int -> if (nums[i] == nums[j]) i - j else nums[j].compareTo(nums[i]) })

    var index = 0
    val minHeapSize = k / 2
    val maxHeapSize = k - minHeapSize
    val res = DoubleArray(nums.size - k + 1)

    for (i in nums.indices) {
        minHeap.add(i)
        if (minHeap.size > minHeapSize) {
            maxHeap.add(minHeap.poll())
        }
        if (minHeap.size == maxHeapSize && maxHeap.size == minHeapSize) {
            if (k % 2 == 0) {
                println("Min Heap (Peek) : ${nums[minHeap.peek()]}")
                println("Max Heap (Peek) : ${nums[maxHeap.peek()]}")
                res[index] = (nums[minHeap.peek()].toDouble() + nums[maxHeap.peek()].toDouble()) / 2
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
    println(medianSlidingWindowHeap(intArrayOf(1, 4, -1, -3, 5, 3, 6, 7), 6).contentToString())
    println(medianSlidingWindow(intArrayOf(1, 4, -1, -3, 5, 3, 6, 7), 6).contentToString())
    println(medianSlidingWindow(intArrayOf(2147483647, 2147483647), 2).contentToString())
}