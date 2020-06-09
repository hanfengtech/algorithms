package tech.hanfeng.algorithms.dp

// brute force,  recursion, and backtracking
class WordBreak {

    fun wordBreak(s : String, wordDict : List<String>) : Boolean {
        return helper(s, wordDict.toSet(), 0)
    }

    fun helper(s: String, wordDict : Set<String>, start : Int) : Boolean {
        if (start == s.length) {
            return true
        }

        for(end in start + 1 .. s.length) {
            val str = s.substring(start, end)
            if (wordDict.contains(str) &&
                    helper(s, wordDict, end)) {
                return true
            }
        }
        return false
    }

    fun wordBreakM(s: String, wordDict : List<String>) : Boolean {
        fun helper(wordDict : Set<String>, start : Int, memo : Array<Boolean?>) : Boolean {
            if (start == s.length) return true

            if (memo[start] != null) return memo[start]!!

            for (end in start + 1 .. s.length) {
                 if (wordDict.contains(s.substring(start, end)) &&
                         helper(wordDict, end, memo)) {
                     memo[start] = true
                     return true
                 }
            }
            memo[start] = false
            return false
        }

        return helper(wordDict.toSet(), 0, arrayOfNulls(s.length) )
    }

    fun wordBreakDP(s : String, wordDict : List<String>) : Boolean {
        val wordDictSet = wordDict.toSet()
        val dp = BooleanArray(s.length + 1)
        dp[0] = true

        for (i in 1 .. s.length) {
            for (j in 0 until i) {
                val str = s.substring(j,i)
                if (dp[j] && wordDictSet.contains(str)) {
                    dp[i] = true
                    break
                }
            }
        }
        return dp[s.length]
    }
}

fun main() {
 //   println(WordBreak().wordBreakM("leetcode", arrayListOf("leet", "code")))

    println(WordBreak().wordBreakDP("leetcode", arrayListOf("leet", "code")))
}