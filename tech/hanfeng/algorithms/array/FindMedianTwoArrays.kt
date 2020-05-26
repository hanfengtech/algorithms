package tech.hanfeng.algorithms.array

fun findMedianSortedArrays(nums1 : IntArray, nums2 : IntArray) : Double {
    val n = nums1.size
    val m = nums2.size
    if (m < n) {
        return findMedianSortedArrays(nums2, nums1)
    }
    val k = (n + m + 1) / 2
    var l = 0
    var r = n
    var m1 : Int
    var m2: Int

    while(l < r) {
        m1 = l + (r - l) / 2
        m2 = k - m1
        if (nums1[m1] < nums2[m2 - 1]) {
            l = m1 + 1
        } else {
            r = m1
        }
    }
    m1 = l
    m2 = k - m1

    val c1 = Math.max( if (m1 <= 0) Int.MIN_VALUE else nums1[m1 - 1],
            if (m2 <= 0) Int.MIN_VALUE else nums2[m2 - 1] )
    if ( (n + m) %2 == 1) {
        return c1 * 1.0
    }

    val c2 = Math.min( if (m1 >= n) Int.MAX_VALUE else nums1[m1],
            if (m2 >= m) Int.MAX_VALUE else nums2[m2])

    return (c1 + c2) / 2.0
}

fun main() {
    println(findMedianSortedArrays(intArrayOf(2,3), intArrayOf()))
    println(findMedianSortedArrays(intArrayOf(1,3), intArrayOf(4,6,8,9,10,16,90,190)))
    println(findMedianSortedArrays(intArrayOf(300,369), intArrayOf(4,6,8,9,10,16,90,190)))
}
