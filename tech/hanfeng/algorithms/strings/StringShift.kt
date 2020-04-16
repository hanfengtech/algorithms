package tech.hanfeng.algorithms.strings

fun stringShift(s: String, shift: Array<IntArray>) : String {
    if (s.isEmpty() || s.length == 1 || shift.isEmpty()) return s

    var movement = 0
    var i = 0

    do {
        movement += shift[i][1] * if (shift[i][0] == 0) -1 else 1
        i++
    } while (i < shift.size)

    movement %= s.length

    return when {
        movement < 0 -> {  // left shift
            movement *= -1
            s.substring(movement) + s.substring(0, movement)
        }
        movement > 0 -> {  // right shift
            s.substring(s.length - movement) + s.substring(0, s.length - movement)
        }
        else -> {
            s
        }
    }
}

fun main() {
    println(stringShift("abc", arrayOf(intArrayOf(0,1), intArrayOf(1,2), intArrayOf(1,2), intArrayOf(1,2),intArrayOf(1,2))))
    println(stringShift("abcdefg", arrayOf(intArrayOf(1,1), intArrayOf(1,1), intArrayOf(0,2), intArrayOf(1,3))))
    println(stringShift("wpdhhcj", arrayOf(intArrayOf(0,7), intArrayOf(1,7), intArrayOf(1,0), intArrayOf(1,3), intArrayOf(0,3), intArrayOf(0,6), intArrayOf(1,2))))
}