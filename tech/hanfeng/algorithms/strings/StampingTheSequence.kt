package tech.hanfeng.algorithms.strings

const val STAMPED_SYMBOL = '*'
class StampingTheSequence {
    fun movesToStamp(stamp : String, target : String) : IntArray {
        if (stamp.isEmpty() || target.isEmpty()) return intArrayOf()
        val res = ArrayList<Int>()
        val arr = target.toCharArray()
        val n = stamp.length
        val m = target.length
        val visited = BooleanArray(m)
        var count = 0

        while(count < m) {
            var stamped = false
            for(i in 0 .. m - n) {
                if (!visited[i] && canStamp(arr, i, stamp)) {
                    count = stamp(arr, i , stamp, count)
                    stamped = true
                    visited[i] = true
                    res.add(i)
                    if (count == m) break
                }
            }
            if (!stamped) return intArrayOf()
        }

        return res.reversed().toIntArray()
    }

    private fun canStamp(arr : CharArray, pos : Int, stamp : String) : Boolean {
        for (i in stamp.indices) {
            if (arr[i + pos] != STAMPED_SYMBOL && arr[i + pos] != stamp[i])
                return false
        }
        return true
    }

    private fun stamp(arr : CharArray, pos : Int, stamp : String, count : Int) : Int {
        var cnt = count
        for (i in stamp.indices) {
            if (arr[i + pos] != STAMPED_SYMBOL) {
                arr[i + pos] = STAMPED_SYMBOL
                cnt++
            }
        }
        return cnt
    }
}

fun main() {
    println(StampingTheSequence().movesToStamp("abc", "ababc").contentToString())
    println(StampingTheSequence().movesToStamp("abca", "aabcaca").contentToString())
}