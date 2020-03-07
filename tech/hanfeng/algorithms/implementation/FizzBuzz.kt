package tech.hanfeng.algorithms.implementation

fun fizzbuzz(n : Int) : List<String> {

    val resList = ArrayList<String>()

    var f :Int
    var b :Int

    for (i in  1 .. n) {
        f = i % 3
        b = i % 5
        if (f == 0 && b == 0) {
            resList.add("FizzBuzz")
        } else if (f == 0) {
            resList.add("Fizz")
        } else if (b == 0) {
            resList.add("Buzz")
        } else {
            resList.add(i.toString())
        }
    }
    return resList
}

fun main() {
    println(fizzbuzz(15))
}