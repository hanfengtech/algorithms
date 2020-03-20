package tech.hanfeng.algorithms.strings

import java.util.*

fun simplifyPath(path : String) : String {
    val stack = LinkedList<String>()
    val skip = HashSet(arrayListOf("..",".", ""))

    for (dir in path.split("/")) {
        if (dir == ".." && stack.isNotEmpty()) stack.pop()
        else if (!skip.contains(dir)) stack.push(dir)
    }

    var res = ""
    for (dir in stack) {
        res = "/$dir$res"
    }

    return if (res.isEmpty()) "/" else res
}

fun main() {
    println(simplifyPath("/home/"))
    println(simplifyPath("/a/./b/../../c/"))
}