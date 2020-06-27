package tech.hanfeng.algorithms.implementation

import java.util.*

class RandomizedCollection {

    data class Node(var value : Int, var index : Int, var duplicates : LinkedList<Node> = LinkedList())

    var map = HashMap<Int, Node>()
    var list = ArrayList<Node>()
    var random = Random()

    fun insert(`val`: Int): Boolean {
        val newNode = Node(`val`, list.size)
        list.add(newNode)                            // add new node to list
        val node = map[`val`]                        // get node from map
        return if (node == null) {
            map[`val`] = newNode                     // put the new node
            true
        } else {
            node.duplicates.add(newNode)                // add new node to the child of the node to handle duplicates
            false
        }
    }

    fun remove(`val`: Int): Boolean {
        val node = map[`val`]
        return if (node == null) {
            false
        } else {
            var removeNode: Node?
            if (node.duplicates.isEmpty()) {                // there are no more duplicates
                removeNode = node
                map.remove(removeNode.value)                // remove from the map
            } else {
                removeNode = node.duplicates.removeLast()   // remove the first added value from the duplicates
            }
            val lastNode = list[list.lastIndex]             // get the last node in the list
            if (removeNode!!.index != lastNode.index) {     // if not last node, swap it with last node
                lastNode.index = removeNode.index
                list[removeNode.index] = lastNode
            }
            list.removeAt(list.lastIndex)                   // remove last node in the list
            true
        }
    }

    fun getRandom(): Int {
        val randomIdx = random.nextInt(list.size)
        return list[randomIdx].value
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