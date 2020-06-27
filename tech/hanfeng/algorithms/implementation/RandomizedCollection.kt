package tech.hanfeng.algorithms.implementation

import java.util.*

class RandomizedCollection {

    data class Node(var value : Int, var index : Int, var nodes : LinkedList<Node> = LinkedList())

    var map = HashMap<Int, Node>()
    var list = ArrayList<Node>()
    var random = Random()

    fun insert(`val`: Int): Boolean {
        val newNode = Node(`val`, list.size)
        list.add(newNode)
        val node = map[`val`]
        return if (node == null) {
            map[`val`] = newNode
            true
        } else {
            node.nodes.add(newNode)
            false
        }
    }

    fun remove(`val`: Int): Boolean {
        val node = map[`val`]
        return if (node == null) {
            false
        } else {
            var removeNode: Node?
            if (node.nodes.isEmpty()) {
                removeNode = node
                map.remove(removeNode.value)
            } else {
                removeNode = node.nodes.removeLast()
            }
            val lastNode = list[list.lastIndex]
            if (removeNode!!.index != lastNode.index) { // swapping the element with the last element
                lastNode.index = removeNode.index
                list[removeNode.index] = lastNode
            }
            list.removeAt(list.lastIndex)
            true
        }
    }

    fun getRandom(): Int {
        val randomIdx = random!!.nextInt(list.size)
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