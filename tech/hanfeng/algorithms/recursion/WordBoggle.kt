package tech.hanfeng.algorithms.recursion

/*
Input: dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};
boggle[][]   = {{'G','I','Z'},
    {'U','E','K'},
    {'Q','S','E'}};
*/

fun wordBoggle(dict : List<String>, boggle : Array<CharArray>) : List<String>? {
    if (dict.isEmpty() || boggle.isEmpty() || boggle[0].isEmpty()) return null

    val resultList = ArrayList<String>()

    dict.forEach{
        if (isFound(boggle, it)) {
            resultList.add(it)
        }
    }

    return resultList
}

fun isFound(boggle : Array<CharArray>, word : String) : Boolean {
    fun exist(y : Int, x : Int, i: Int) : Boolean {
        if (i == word.length) return true

        if (x < 0 || y < 0 || y == boggle.size || x == boggle[y].size) return false

        if (boggle[y][x] != word[i]) return false

        val tmp = boggle[y][x]

        val exist = exist(y, x + 1, i + 1)
                || exist(y, x - 1, i + 1)
                || exist(y + 1, x , i + 1)
                || exist(y - 1, x, i + 1)

                || exist(y + 1, x + 1, i + 1)
                || exist(y - 1, x - 1, i + 1)
                || exist(y + 1, x - 1, i + 1)
                || exist(y - 1, x + 1, i + 1)
        
        boggle[y][x] = tmp
        return exist
    }


    for (y in boggle.indices) {
        for (x in boggle[y].indices) {
            if (exist(y,x,0)) {
                return true
            }
        }
    }

    return false
}

fun main() {
    val boggle = arrayOf(
            charArrayOf('G', 'I', 'Z'),
            charArrayOf('U', 'E', 'K'),
            charArrayOf('Q', 'S', 'E'))

    val list = wordBoggle(listOf("GEEKS", "FOR", "QUIZ", "GO"), boggle)

    list?.forEach {
        println(it)
    }
}

