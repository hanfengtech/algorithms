package tech.hanfeng.algorithms.array

fun countElements(arr : IntArray) : Int {
    var set = HashSet<Int>()
    var count = 0

    arr.forEach {
        if (!set.contains(it)) {
            set.add(it)
        }
    }

    arr.forEach {
        if (set.contains(it + 1)) {
            count++
        }
    }
    return count
}

fun main() {
    println(countElements(intArrayOf(1,2,3)))
    println(countElements(intArrayOf(1,1,3,3,5,5,7,7)))
    println(countElements(intArrayOf(1,3,2,3,5,0)))
    println(countElements(intArrayOf(1,1,2,2)))
    println(countElements(intArrayOf(1,1,2)))
}