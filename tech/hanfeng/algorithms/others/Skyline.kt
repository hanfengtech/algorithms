package tech.hanfeng.algorithms.others

import java.util.*

data class Coordinate(var x : Int, var y : Int, var isStart : Boolean)

fun getSkyline(buildings: Array<IntArray>): List<List<Int>>? {
    val coordinateList = ArrayList<Coordinate>(buildings.size * 2)
    for (building in buildings) {
        coordinateList.add(Coordinate(building[0], building[2], true))
        coordinateList.add(Coordinate(building[1], building[2], false))
    }
    coordinateList.sortWith(Comparator { c1, c2 ->
        when {
            c1.x != c2.x -> c1.x - c2.x                            // low x comes first
            else -> {                                              // same x
                val c1Height = if (c1.isStart) -c1.y else c1.y     // if start reverse the order
                val c2Height = if (c2.isStart) -c2.y else c2.y     // if start reverse the order
                c1Height - c2Height
            }
        }
    })

    val queue = TreeMap<Int, Int>()
    queue[0] = 1                                // add height 0 with count 1 to begin
    var previousMaxHeight = 0
    val result = ArrayList<List<Int>>()
    for (coordinate in coordinateList) {
        if (coordinate.isStart) {
            queue[coordinate.y] = queue.getOrDefault(coordinate.y, 0) + 1
        } else {
            queue[coordinate.y] = queue[coordinate.y]!! - 1    // decrement the count
            if (queue[coordinate.y] == 0)                      // no more count
                queue.remove(coordinate.y)                     // remove
        }
        val currentMaxHeight = queue.lastKey()
        if (previousMaxHeight != currentMaxHeight) {      // check if it changes the max
            result.add(listOf(coordinate.x, currentMaxHeight))
            previousMaxHeight = currentMaxHeight
        }
    }
    return result
}