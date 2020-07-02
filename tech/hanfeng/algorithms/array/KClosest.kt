package tech.hanfeng.algorithms.array

import java.util.*
import kotlin.random.Random

class Solution {
    private lateinit var points : Array<IntArray>

    fun kClosest2(points: Array<IntArray>, K: Int): Array<IntArray> {
        /*
        points.sortWith(Comparator{ a, b ->
            when {
                a[0] * a[0] + a[1] * a[1] > b[0] * b[0] + b[1] * b[1] -> 1
                a[0] * a[0] + a[1] * a[1] < b[0] * b[0] + b[1] * b[1] -> -1
                else -> 0
            }
        })
        */

        this.points = points
        sort(0, points.size - 1, K)

        return points.copyOfRange(0, K)
    }

    private fun sort(i : Int, j : Int, K : Int) {
        if (i >= j) {
            return
        }

        var k = Random.nextInt(i,j)
        swap(i,k)

        val mid = partition(i, j)
        val leftLength = mid - i + 1
        if (K < leftLength)
            sort(i, mid - 1, K)
        else if (K > leftLength)
            sort(mid+1, j, K - leftLength)
    }

    private fun partition(ai : Int, aj : Int) : Int {
        var i = ai
        var j = aj
        val oi = i
        val pivot = dist(i)
        i++

        while (true) {
            while (i < j && dist(i) < pivot)
                i++
            while (i < j && dist(j) > pivot)
                j--
            if (i >= j) break
            swap(i, j)
        }
        swap(oi, j)
        return j
    }

    private fun dist(i : Int) : Int {
        return points[i][0] * points[i][0] + points[i][1] * points[i][1]
    }

    private fun swap(i : Int, j : Int) {
        val t0 = points[i][0]
        val t1 = points[i][0]

        points[i][0] = points[j][0]
        points[i][1] = points[j][1]
        points[j][0] = t0
        points[j][1] = t1
    }


    fun kClosest(points: Array<IntArray>, K: Int): Array<IntArray> {
        var q = PriorityQueue<IntArray> { a , b ->
            a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1]
        }

        for (point in points) {
            q.offer(point)
        }

        var n = Math.min(points.size, K)

        var res = Array(n) { IntArray(2) }
        for (i in 0 until n) {
            res[i] = q.poll()
        }

        return res
    }
}

fun main() {
    val s = Solution()
    val list = s.kClosest(arrayOf(intArrayOf(1,3), intArrayOf(-2,2)), 1)
    list.forEach {
        println(it.contentToString())
    }
}



