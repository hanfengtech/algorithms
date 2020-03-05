package tech.hanfeng.algorithms.recursion

fun binaryStringR(n : Int) : List<String> {
    return if ( n == 1) {
        var list = ArrayList<String>()
        list.add("0")
        list.add("1")
        list
    } else {
        var pre = binaryStringR(n - 1)
        var result = ArrayList<String>()
        for (s in pre) {
            result.add(s + "0")
            result.add(s + "1")
        }
        result
    }
}

fun binaryStringIt(n : Int) : List<String> {
    var list = ArrayList<String>()
    list.add("0")
    list.add("1")
    for (i in 2 .. n) {
        var tmpList = ArrayList<String>()
        for (s in list) {
            tmpList.add(s + "0")
            tmpList.add(s + "1")
        }
        list = tmpList
    }
    return list
}

fun binarystring(n : Int) {

    fun helper(slate : String, n : Int) {
        if (n == 0) {
            println(slate)
        } else {
            helper(slate + "0", n - 1)
            helper(slate + "1", n - 1)
        }
    }

    helper("", n)
}

fun binaryString(n : Int) : List<String>{

    var resList = ArrayList<String>()
    fun helper(slate : String, n : Int) {
        if (n == 0) {
            println(slate)
            resList.add(slate)
        } else {
            helper(slate + "0", n - 1)
            helper(slate + "1", n - 1)
        }
    }

    helper("", n)
    return resList
}

fun main() {
    println(binaryStringR(3))
    println(binaryStringIt(3))
    binarystring(3)
    println(binaryString(3))
}