package tech.hanfeng.algorithms.strings

fun zigzagCoversion(s : String, nRows : Int) : String {
    val c = s.toCharArray()
    val len = c.size
    val sbA = Array(nRows){ StringBuilder() }

    var i = 0

    while (i < len) {
        // vertically down
        var row = 0
        while (row < nRows && i < len) {
            sbA[row++].append(c[i++])
        }

        // obliquely up
        row = nRows - 2
        while(row >= 1 && i < len) {
            sbA[row--].append(c[i++])
        }
    }

    for (j in 1 until sbA.size) {
        sbA[0].append(sbA[j])
    }

    return sbA[0].toString()
}

fun main() {
    println(zigzagCoversion("PAYPALISHIRING", 3))
    println(zigzagCoversion("ABCDEFGHIJKL", 4))
}