package tech.hanfeng.algorithms.recursion

fun isValid(s : String) : Boolean {
   return !(s.isEmpty() || s.length > 3 || (s[0] == '0' && s.length > 1) || s.toInt() > 255)
}

fun restoreIPAddresses(s : String) : List<String> {
    val resList = ArrayList<String>()
    val len = s.length
    if (len > 12)
        return resList

    var i = 1
    while (i < 4 && i < len - 2) {
        var j = i + 1
        while(j < i + 4 && j < len - 1) {
            var k = j + 1
            while(k < j + 4 && k < len) {
                val s1 = s.substring(0, i)
                val s2 = s.substring(i, j)
                val s3 = s.substring(j, k)
                val s4 = s.substring(k, len)

                if (s4.length > 5) break  // skip if last portion greater than len 5, because it cannot form a valid IP
                                          // xxx.yyy.zww.www
                if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                    resList.add("$s1.$s2.$s3.$s4")
                }
                k++
            }
            j++
        }
        i++
    }
    return resList
}

fun main() {
    println(restoreIPAddresses("25525511135"))
    println(restoreIPAddresses("251235"))
    println(restoreIPAddresses("255166231563"))
    println(restoreIPAddresses("1252437"))
}

