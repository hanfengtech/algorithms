package tech.hanfeng.algorithms.array

fun sortSML(sizes : CharArray) {
    var i = 0
    var j = sizes.size -1

    while (sizes[i] == 'S' && i <= j) {
        i++
    }

    while (i < j) {
        if (sizes[j] == 'S') {
            var tmp = sizes[i]
            sizes[i++] = sizes[j]
            sizes[j] = tmp
        }
        j--
    }

    j = sizes.size - 1
    while (sizes[j] == 'L' && j > i) {
        j--
    }


    while (i < j) {
        if (sizes[i] == 'L') {
            var tmp = sizes[j]
            sizes[j--] = sizes[i]
            sizes[i] = tmp
        }
        i++
    }
}

fun main() {
    var arr = charArrayOf('S', 'S', 'M', 'L', 'M', 'S', 'L', 'L')
    sortSML(arr)
    println(arr.contentToString())
}