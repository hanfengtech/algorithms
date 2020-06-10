package tech.hanfeng.algorithms.dp

fun accountsMerge(accounts: List<List<String>>) : List<List<String>> {
    val dsu = DSU()

    var emailToName = HashMap<String, String>()
    var emailToID = HashMap<String, Int>()

    var id = 0

    for ( account in accounts) {
        var name = ""
        for (email in account) {
            if (name == "") {
                name = email
            } else {
                emailToName[email] = name
                if (!emailToID.containsKey(email)) {
                    emailToID[email] = id++
                }
                val myName = account[1]
                val myID = emailToID[myName]
                val myEmailID = emailToID[email]

                dsu.union(myID!!, myEmailID!!)
            }
        }
    }

    var ans = HashMap<Int, ArrayList<String>>()

    for (email in emailToName.keys) {
        val index = dsu.find(emailToID[email]!!)
        ans.getOrPut(index, {ArrayList()}).add(email)
    }

    for (component in ans.values) {
        component.sort()
        component.add(0, emailToName[component[0]]!!)
    }

    return ans.values.toList()
}

class DSU {
    var parent : IntArray? = null

    init {
        parent =  IntArray(10001) { i -> i}
    }

    fun find(x : Int) : Int {
        if (parent!![x] != x) parent!![x] = find(parent!![x])
        return parent!![x]
    }

    fun union(x : Int, y : Int) {
        parent!![find(x)] = find(y)
    }
}

fun main() {
    val input = listOf(listOf("John", "johnsmith@mail.com", "john00@mail.com"),
            listOf("John", "johnnybravo@mail.com"),
            listOf("John", "johnsmith@mail.com", "john_newyork@mail.com"),
            listOf("Mary", "mary@mail.com"))

    val output = accountsMerge(input)
    output.forEach{
        println(it.joinToString())
    }

}