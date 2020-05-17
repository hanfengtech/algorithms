package tech.hanfeng.algorithms.strings

fun countAndSay(n : Int) : String {
    var curr = StringBuilder("1")
    var prev : StringBuilder
    var count : Int
    var say : Char

    for (i in 1 until n) {
        prev = curr
        curr = StringBuilder()
        count = 1
        say = prev[0]

        var j = 1
        var len = prev.length

        while(j < len) {
            if ( prev[j] != say) {
                curr.append(count).append(say)
                count = 1
                say = prev[j]
            } else {
                count++
            }
            j++
        }
        curr.append(count).append(say)
    }

    return curr.toString()
}

fun main() {
    println(countAndSay(2))
    println(countAndSay(3))
    println(countAndSay(4))
    println(countAndSay(5))
    println(countAndSay(6))
}