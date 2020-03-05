package tech.hanfeng.algorithms.recursion

fun binaryString(n : Int) : List<String> {
    return if ( n == 1) {
        var list = ArrayList<String>()
        list.add("0")
        list.add("1")
        list
    } else {
        var pre = binaryString(n - 1)
        var result = ArrayList<String>()
        for (s in pre) {
            result.add(s + "0")
            result.add(s + "1")
        }
        result
    }
}

fun main() {
    print(binaryString(3))
}