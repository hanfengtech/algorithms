package tech.hanfeng.algorithms.implementation

import java.util.*


internal class RandomizedCollection {
    var list = ArrayList<Int?>()    //  list added element
    var map = HashMap<Int, ArrayList<Int>>()
    var rand = Random()

    fun insert(`val`: Int): Boolean {
        val exist = map.containsKey(`val`)   // check if val exist
        list.add(`val`)                      // add val to the list
        val elements = map.getOrDefault(`val`, ArrayList())     // get the arrayList associate with the number
        elements.add(list.size - 1)          // add to the last position (index) of the list to the elements list
        map[`val`] = elements                // push the elements to the map,  all element
        return !exist                        // if not exist, return true.  Else return false
    }

    fun remove(`val`: Int): Boolean {
        val elements = map[`val`] ?: return false
        list[elements[0]] = null        // set first index of the element to null.  Means remove the element from the list
        elements.removeAt(0)      // remove the first element from element list
        if (elements.isEmpty()) map.remove(`val`)    // if the element list is empty, remove the entry from the map
        return true
    }

    fun getRandom() : Int {
        var random: Int = rand.nextInt(list.size)
        while (list[random] == null) {
            random = rand.nextInt(list.size)
        }
        return list[random]!!
    }
}

fun main() {
    val collection = RandomizedCollection()
    collection.insert(1)
    collection.insert(1)
    collection.insert(2)
    println(collection.getRandom())
    collection.remove(1)
    println(collection.getRandom())
}