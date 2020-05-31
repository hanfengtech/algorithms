package tech.hanfeng.algorithms.array

fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    var set1 = nums1.toSet()
    var set2 = nums2.toSet()
    var result = ArrayList<Int>()

    set1.forEach {
        if (set2.contains(it)) {
            result.add(it)
        }
    }

    return result.toIntArray()
}

fun intersection2(nums1: IntArray, nums2: IntArray): IntArray {
    var n = nums1.size
    var m = nums2.size
    if(n == 0 || m == 0) return IntArray(0)

    nums1.sort()
    nums2.sort()

    var i = 0
    var j = 0

    var resultSet = HashSet<Int>()

    while (i < n && j < m) {
        when {
            nums1[i] == nums2[j] -> {
                resultSet.add(nums1[i])
                i++
                j++
            }
            nums1[i] < nums2[j] -> {
                i++
            }
            else -> {
                j++
            }
        }
    }

    return resultSet.toIntArray()
}

fun main() {
    println(intersection2(intArrayOf(4,9,5), intArrayOf(9,4,9,8,4)).contentToString())
}