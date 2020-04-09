package tech.hanfeng.algorithms.strings

fun backspaceCompareS(S: String, T: String) : Boolean {

    if (S.isEmpty() && T.isEmpty()) return true
    if ( (S.isEmpty() && T.isNotEmpty()) || (S.isNotEmpty() && T.isEmpty()) ) return false

    fun helper(A : CharArray) : Int {
        var i = 0
        for(j in A.indices) {
            if (A[j] == '#') {
                if (i > 1)
                    i--
            } else {
                if (i != j) {
                    A[i] = A[j]
                }
                i++
            }
        }
        return i
    }

    var A = S.toCharArray()
    var B = T.toCharArray()

    var n = helper(A)
    var m = helper(B)

    if (n != m) return false

    for(i in 0 until n) {
       if (A[i] != B[i]) {
           return false
       }
    }

    return true
}


fun backspaceCompare(S: String, T: String) : Boolean {
    var i = S.length - 1
    var j = T.length - 1

    while (i >= 0 || j >= 0) {
        i = backspace(S, i)
        j = backspace(T, j)

        if (i < 0 && j < 0) return true
        if (i < 0 || j < 0 || S[i] != T[j]) return false
        i--
        j--
    }
    return true
}

fun backspace(S: String, i : Int) : Int {
    var skip = 0
    var k = i

    while (k >= 0 && ((skip > 0) || (S[k] == '#')) ) {
         if (S[k] == '#') skip++
         else skip--
         k--
    }
    return k
}

fun main() {
    var S = "ab#c"
    var T = "ad#c"

    println(backspaceCompare(S, T))
    println(backspaceCompare("ab##", "c#d#"))
    println(backspaceCompare("a#c", "b"))

}