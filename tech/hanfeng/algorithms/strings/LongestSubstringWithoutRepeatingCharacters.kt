package tech.hanfeng.algorithms.strings

import kotlin.math.max

fun longestSubstringWithoutRepeatingCharactersMap(str : String) : Int {
    if (str.isBlank()) return 0

    val map = HashMap<Char, Int>()

    var ans = 0
    var i = 0
    for (j in str.indices) {
        if (map.containsKey(str[j])) {
            i = max(map[str[j]]!! + 1, i)
        }
        ans = max(ans, j - i + 1)
        map[str[j]] = j
    }

    return ans
}

fun longestSubstringWithoutRepeatingCharacters(str : String) : Int {
    if (str.isBlank()) return 0

    val chars = IntArray(128) { -1 }
    var ans = 0
    var i = 0
    for (j in str.indices) {
        if (chars[str[j].toInt()] != -1) {
            i = max(chars[str[j].toInt()] + 1, i)
        }
        ans = max(ans, j - i + 1)
        chars[str[j].toInt()] = j
    }
    return ans
}


fun main() {
    println("O(N)")
    println(longestSubstringWithoutRepeatingCharactersMap("abcabcbb"))
    println(longestSubstringWithoutRepeatingCharactersMap("bbbbb"))
    println(longestSubstringWithoutRepeatingCharactersMap("pwwkew"))
    println(longestSubstringWithoutRepeatingCharactersMap("a"))
    println(longestSubstringWithoutRepeatingCharactersMap(""))
    //println(longestSubstringWithoutRepeatingCharactersMap(null))

    println("\nO(1)")
    println(longestSubstringWithoutRepeatingCharacters("abcabcbb"))
    println(longestSubstringWithoutRepeatingCharacters("bbbbb"))
    println(longestSubstringWithoutRepeatingCharacters("pwwkew"))
    println(longestSubstringWithoutRepeatingCharacters("a"))
    println(longestSubstringWithoutRepeatingCharacters(""))
}