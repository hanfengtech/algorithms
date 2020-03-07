package tech.hanfeng.algorithms.recursion

fun generateParenthesis(n : Int) : List<String> {
    val resList = ArrayList<String>()
    if (n < 1) return resList

    fun backtrack(slate : StringBuilder, open : Int, close : Int) {
        if (slate.length == n * 2) {
            resList.add(slate.toString())
            return
        }

        if (open < n) {
            backtrack(slate.append('('), open + 1, close)
            slate.deleteCharAt(slate.lastIndex)
        }

        if (close < open) {
            backtrack(slate.append(')'), open, close + 1)
            slate.deleteCharAt(slate.lastIndex)
        }
    }

    backtrack(StringBuilder(), 0, 0)
    return resList
}

fun main() {
    println(generateParenthesis(3))
}