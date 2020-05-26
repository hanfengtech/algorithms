package tech.hanfeng.algorithms.strings

import tech.hanfeng.algorithms.recursion.removeLast

fun removeInvalidParentheses(s : String) : List<String> {
    var set = HashSet<String>()
    var resultList = ArrayList<String>()
    if (s.isEmpty()) return resultList

    var left = 0
    var right = 0

    for (c in s) {
        if (c == '(')
            left++
        if (c == ')') {
            if (left == 0) {
                right++
            } else {
                left--
            }
        }
    }

    fun dfs(depth : Int, left : Int, right : Int, leftRem : Int, rightRem : Int, result: StringBuilder) {
        if (depth == s.length) {
            if (left == right && leftRem == 0 && rightRem == 0) {
                set.add(result.toString())
                return
            }
        } else {
            if (s[depth] == '(') {
                if (leftRem > 0) {
                    dfs(depth + 1, left, right, leftRem - 1, rightRem, result)
                }
                dfs(depth + 1, left + 1, right, leftRem, rightRem, result.append('('))
                result.removeLast()
            } else if (s[depth] == ')') {
                if (rightRem > 0) {
                    dfs(depth + 1, left, right, leftRem, rightRem - 1, result)
                }
                if (left > right) {
                    dfs(depth + 1, left, right + 1, leftRem, rightRem, result.append(')'))
                    result.removeLast()
                }
            } else {
                dfs(depth + 1, left, right, leftRem, rightRem, result.append(s[depth]))
                result.removeLast()
            }
        }
    }


    var result = StringBuilder()
    dfs(0,0,0,left,right, result)
    return set.toList()
}

fun main() {
    var list = removeInvalidParentheses(")()(")
    list = removeInvalidParentheses("((a)())))b))")

    list.forEach{
        println(it)
    }
}