package tech.hanfeng.algorithms.recursion

fun palindromepartition(s : String) : List<List<String>> {
    val resList = ArrayList<List<String>>()
    if (s.isEmpty()) return resList

    fun backtrack(slate : ArrayList<String>, start : Int) {
        if (start == s.length) {
            resList.add(slate.toList())
            return
        }

        for (i in start until s.length) {
            if (isPalindrome(s, start, i)) {
                slate.add(s.substring(start, i + 1))
                backtrack(slate, i + 1)
                slate.removeAt(slate.lastIndex)
            }
        }
    }

    backtrack(ArrayList(), 0)
    return resList
}

fun isPalindrome(s : String, low: Int, high : Int) : Boolean {
    var l = low
    var h = high

    while (l < h) {
        if (s[l++] != s[h--])
            return false
    }
    return true
}

fun main() {
    println(palindromepartition("aab"))
}