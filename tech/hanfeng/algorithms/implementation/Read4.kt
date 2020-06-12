package tech.hanfeng.algorithms.implementation

fun read(buf : CharArray, n : Int) : Int {
    var currBuf = CharArray(4)
    var pos = 0

    do {
        val count = Math.min(n - pos, read4(currBuf))
        for (i in 0 until count) {
            buf[pos++] = currBuf[i]
        }
    } while (count > 0)

    return pos
}