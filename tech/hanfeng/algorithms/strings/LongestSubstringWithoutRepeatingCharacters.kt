package tech.hanfeng.algorithms.strings

import kotlin.math.max

/**
 *
 * T(N), S(N)
 *
 * @difficulty
 * Medium
 *
 * @type
 * Two pointers + Map
 *
 */
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

/**
 *　
 * T(N), S(1)
 *
 * @type
 * Two pointers
 *
 */
fun longestSubstringWithoutRepeatingCharacters(str : String) : Int {
    if (str.isEmpty()) return 0

    val chPos = IntArray(128){ -1 }
    var ans = Int.MIN_VALUE
    var i = 0
    var index :Int

    for (j in str.indices) {
        index = str[j].toInt()
        if (chPos[index] != -1) {
            i = max(chPos[index] + 1, i)
        }
        ans = max(ans, j - i + 1)
        chPos[index] = j
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