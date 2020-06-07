package tech.hanfeng.algorithms.graph

import java.util.*
import kotlin.collections.HashMap

/*
Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 */

class ReconstructItinerary {

    private val map = HashMap<String, PriorityQueue<String>>()
    val path = LinkedList<String>()

    fun findItinerary(tickets: List<List<String>>): List<String> {
        tickets.forEach{ map.getOrPut(it[0]){ PriorityQueue()}.add(it[1]) }  // construct adj list, only add one since it is unidirected graph

        dfs("JFK")   // dfs the graph
        return path
    }

    private fun dfs(origin : String) {
        if (map.containsKey(origin)) {   // origin still in the map
            val destList = map[origin]   // get a list of destinations
            while (destList!!.isNotEmpty()) {
                val dest = destList.poll()    // remove the dest from the list
                dfs(dest)                     // dfs on the dest
            }
        }
        path.offerFirst(origin)   // put the origin  to the path
    }
}

fun main() {
    val dest = arrayListOf(arrayListOf("MUC", "LHR"), arrayListOf("JFK", "MUC"),arrayListOf("SFO", "SJC"),arrayListOf("LHR", "SFO"))

    println(ReconstructItinerary().findItinerary(dest).joinToString())
}