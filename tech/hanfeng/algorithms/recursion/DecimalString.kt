package tech.hanfeng.algorithms.recursion

/*
 Permutation of decimal with given number of positions
 */
fun decimalString(n : Int) {

    fun helper(slate : String, n : Int) {
        if (n == 0) {
            println(slate)
            return
        }

        for (i in 0..9) {
            helper(slate + i, n - 1)
        }
    }

    helper("", n)
}

fun main() {
    decimalString(2)
}