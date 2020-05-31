package tech.hanfeng.algorithms.implementation

class Read {

    private val buffer = CharArray(4)
    private var consume = 0
    private var fed = 0

    private fun feed(buf : CharArray) : Int {
        val temp = CharArray(4)
        var n = read4(temp)
        for (i in 0 until n) {
            buf[i] = temp[i]
        }
        consume = 0
        return n
    }

    fun read(buf: CharArray, n: Int): Int {
        var filled = 0

        // basically serve from buffer, once buffer is consumed, call read4 and transfer and then consume
        while(filled < n) {
            if (consume % 4 == 0) {
                fed = feed(buffer)
                if (fed == 0)
                    break
            }
            if (consume == fed)
                break
            buf[filled++] = buffer[consume++]
        }
        return filled
    }

    fun read4(buf: CharArray): Int {
        return 0
    }
}