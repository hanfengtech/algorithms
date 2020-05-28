package tech.hanfeng.algorithms.strings


/*
     s = "hello world"  set = "lrw"
     O(n^3)
 */

fun shortestControlStringSet(s: String, controls : Set<Char>) : Int {
    var result = Int.MAX_VALUE

    for (i in s.indices) {
        for (j in i + controls.size until s.length) {
            var substring = s.substring(i, j)
            val len = isControlled(substring, controls)
            if (len > controls.size)
                result = Math.min(result, len)
        }
    }

    return if (result == Int.MAX_VALUE) -1 else result
}

fun isControlled(s: String, controls : Set<Char>) : Int {
    var set = controls.toMutableSet()

    s.forEachIndexed { index, c ->
        if (set.contains(c)) {
            set.remove(c)
        }
        if (set.isEmpty()) {
            return index + 1
        }
    }
    return 0
}

/*
    O(N^2)
 */
fun shortestControlStringSet2(s: String, controls : Set<Char>) : Int {
    var result = Int.MAX_VALUE

    for (i in s.indices) {
        var set = controls.toMutableSet()
        for (j in i + controls.size  until s.length) {
            var substring = s.substring(i, j)
            var len = 0
            val ch = substring[j]
            if (set.contains(ch)) {
                set.remove(ch)
            }
            if (set.isEmpty()) {
                len = j + 1
            }

            if (len > controls.size)
                result = Math.min(result, len)
        }
    }

    return if (result == Int.MAX_VALUE) -1 else result
}

fun shortestControlStringSet3(s: String, controls : Set<Char>) : Int {
    var i = 0
    var j = 0
    var len = 0
    var result = Int.MAX_VALUE
    val tmp = controls.toMutableSet()

    while(j < s.length) {
        if (tmp.contains(s[j])) {
            tmp.remove(s[j])

            if (tmp.isEmpty()) {
                len = j - i + 1
                result = Math.min(result, len)
                i++
            } else {
                j++
            }
        } else {
            j++
        }
    }

    return if (result == Int.MAX_VALUE) -1 else result
}


fun main() {
 //   println(shortestControlStringSet("hello world", charArrayOf('l','r','w').toSet()))
    println(shortestControlStringSet2("hello world", charArrayOf('l','r','w').toSet()))
}