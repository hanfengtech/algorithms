package tech.hanfeng.algorithms.implementation

import java.util.*

class KeyValueStore<K , V> {
    private data class Node<K, V>(var key : K, var value : V, var index: Int)    // data class to store key, value, and index
    private var map = HashMap<K, Node<K,V>>()
    private var list = ArrayList<Node<K,V>>()
    private var random = Random()

    fun get(key : K) : V? {                             // O(1)
        return map[key]?.value                          // return the value in Node data class with given key if not null
    }

    fun put(key: K, value: V) {                         // O(1)
        val newNode = Node(key, value, list.size)       // creates the node with all values
        list.add(newNode)                               // add new node to list
        map[key] = newNode                              // put the new node
    }

    fun remove(key: K) {                                // O(1)
        val removeNode = map[key] ?: return             // get the node,  if null just return and do nothing
        map.remove(key)                                 // remove from the map
        val lastNode = list[list.lastIndex]             // get the last node in the list
        if (removeNode.index != lastNode.index) {       // if not last node, swap it with last node
            lastNode.index = removeNode.index
            list[removeNode.index] = lastNode
        }
        list.removeAt(list.lastIndex)                   // remove last node in the list
    }

    fun getRandom(): Pair<K, V>? {                      // O(1)
        if (list.isEmpty()) return null
        val randomIdx = random.nextInt(list.size)       // get random index
        val node = list[randomIdx]
        return Pair(node.key, node.value)
    }
}

fun main() {
    val kv = KeyValueStore<Int, String>()

    var pair = kv.getRandom()                             // empty key value store returns null
    pair?.run {
        println("Key: $first  Value: $second")            // this should not execute
    }

    kv.put(1, "Hello")
    kv.put(2, "Thrive")
    kv.put(3, "Global")

    pair = kv.getRandom()
    pair?.run {
        println("Key: $first  Value: $second")
    }

    pair = kv.getRandom()
    pair?.run {
        println("Key: $first  Value: $second")
    }

    var a = kv.get(1)
    println("Value: $a")
    kv.remove(1)
    kv.remove(1)                                                //  should not cause any issue

    a = kv.get(1)                                                    //  no longer there
    a?.run { println("Already deleted Value: $a") }                  //  should not execute

    val b = kv.get(2)
    b?.run { println("Value: $b") }

    kv.put(4, "Rocks!")

    pair = kv.getRandom()
    pair?.run {
        println("Key: $first  Value: $second")
    }

    pair = kv.getRandom()
    pair?.run {
        println("Key: $first  Value: $second")
    }
}

/*

Sample Output

Key: 2  Value: Thrive
Key: 1  Value: Hello
Value: Hello
Value: Thrive
Key: 2  Value: Thrive
Key: 4  Value: Rocks!

*/