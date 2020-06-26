package tech.hanfeng.algorithms.dfs

fun addOperators(num : String, target : Int) : List<String> {
    var result = ArrayList<String>()
    if (num.isEmpty()) return result

    fun dfs(candidate: StringBuilder, index: Int, total: Double, prevAdd: Double, num: String, target: Double) {
        if (index == num.length && total == target) result.add(candidate.toString())

        for (j in index + 1..num.length) {
            val s = num.substring(index, j)
            val d = s.toDouble()

            if (num[index] == '0' && s != "0") continue

            if (candidate.isEmpty()) {
                dfs(candidate.append(s), j, d, d, num, target)
                candidate.delete(candidate.length - s.length, candidate.length)
            } else {
                var str = "+$s"
                dfs(candidate.append(str), j, total+d, d, num, target)
                candidate.delete(candidate.length - str.length, candidate.length)
                str = "-$s"
                dfs(candidate.append(str), j, total-d, -d, num, target)
                candidate.delete(candidate.length - str.length, candidate.length)
                str = "*$s"
                dfs(candidate.append(str), j, total-prevAdd + prevAdd*d, prevAdd*d, num, target)
                candidate.delete(candidate.length - str.length, candidate.length)
            }
        }
    }

    var sb = StringBuilder()
    dfs(sb, 0, 0.0, 0.0, num, target.toDouble())
    return result
}

fun main() {
    println(addOperators("123", 6).joinToString())
    println(addOperators("000", 0).joinToString())
    println(addOperators("3456237490", 9191).joinToString())
}
