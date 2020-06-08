package tech.hanfeng.algorithms.strings

fun smallestSubstringOfAllCh(arr: CharArray, str : String) : String {
    val map = HashMap<Char, Int>()

    for (c in arr) {
        map[c] = 0
    }

    var l = 0
    var r = 0

    //  arr:  x y z
    //        0 1 2 3 4 5 6 7 8
    //                  l
    //  str:  x y y z y z y x
    //                        r

    //  map:  x  =  1 0,1
    //        y  =  1,2,3,4, 3,2, 1
    //        z  =  1, 2, 1
    //
    //  curMinLen = 3
    //  minLen = 4

    var minLen = Int.MAX_VALUE
    var res = ""

    while (r < str.length) {
        val c = str[r++]
        if (map.containsKey(c)) {
            map[c] = map[c]!!.plus(1)

            while (containsAll(map)) {
                val curMinLen = r - l
                if (curMinLen < minLen) {
                    minLen = curMinLen
                    res = str.substring(l, r)
                }

                // remove the most left char
                val ch = str[l]
                if (map.containsKey(ch)) {
                    map[ch] = map[ch]!!.minus(1)
                }
                l++
            }
        }
    }
    return res
}

fun containsAll(map : Map<Char, Int>) : Boolean {
    for (v in map.values) {
        if (v == 0) return false
    }
    return true
}

fun main() {
    println(smallestSubstringOfAllCh(charArrayOf('x','y','z'), "xyywzyzyux"))

}