package tech.hanfeng.algorithms.recursion

fun graycode(n : Int) : List<Int> {
    val res = ArrayList<Int>()
    val count = 1.shl(n)  // 2 power to the n  number of gray codes
    for (i in 0 until count) {
        val tmp = i.shr(1)    /*  i / 2  */
        res.add(i.xor(tmp))           // i ^ ( i / 2 )
    }
    return res
}

fun main() {
    println(graycode(4))
}