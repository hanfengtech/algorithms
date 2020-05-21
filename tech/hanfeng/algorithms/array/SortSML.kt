package tech.hanfeng.algorithms.array

fun sortSML(sizes : CharArray) {
    var i = 0
    var j = sizes.size -1

    while (sizes[i] == 'S' && i <= j) {
        i++
    }

    while (i < j) {
        if (sizes[j] == 'S') {
            swap(sizes, i, j)
        }
        j--
    }

    j = sizes.size - 1
    while (sizes[j] == 'L' && j > i) {
        j--
    }


    while (i < j) {
        if (sizes[i] == 'L') {
            swap(sizes, i, j)
        }
        i++
    }
}

fun sortSML2(sizes: CharArray) {
    var i = 0
    var j = sizes.size - 1

    while (sizes[i] == 'S' && i < j) {
        i++
    }

    while (sizes[j] == 'L' && i < j) {
        j--
    }

    var k = i + 1

    while (k < j) {
        if (sizes[k] == 'S') {
            swap(sizes, i, k)
            i++
        } else if (sizes[k] == 'L') {
            swap(sizes, j, k)
            j--
        } else {
            k++
        }
    }
}

fun swap(A : CharArray, i : Int, j : Int) {
    var tmp = A[i]
    A[i] = A[j]
    A[j] = tmp
}


fun main() {
    var arr = charArrayOf('S', 'S', 'M', 'L', 'M', 'S', 'L', 'L')
    sortSML2(arr)
    println(arr.contentToString())
}