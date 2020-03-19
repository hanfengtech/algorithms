package tech.hanfeng.algorithms.strings

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun groupAnagrams(strs : Array<String>) : List<List<String>> {
    val rstList = ArrayList<ArrayList<String>> ()
    if (strs.isEmpty()) return rstList

    val hash = HashMap<String, ArrayList<String>>()

    for (str in strs) {
        val arr = str.toCharArray()
        Arrays.sort(arr)
        val key = String(arr)
        if (hash.contains(key)) {
            val list = hash[key]
            list?.add(str)
        } else {
            val list = ArrayList<String>()
            list.add(str)
            hash[key] = list
        }
    }

    for (value in hash.values) {
        rstList.add(value)
    }

    return rstList
}

fun main() {
    println(groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")))
}