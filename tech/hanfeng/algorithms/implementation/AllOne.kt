package tech.hanfeng.algorithms.implementation

data class Node(var count : Int, var set : MutableSet<String> = LinkedHashSet(), var prev : Node? = null, var next : Node? = null)

class DoubleLinkedList {
    var head = Node(-1)
    var tail = Node(-1)

    init {
        head.next = tail
        tail.prev = head
    }

    fun remove(node : Node) {
        node.prev!!.next = node.next
        node.next!!.prev = node.prev
    }

    fun insert(cur: Node, newNode: Node) {
        newNode.next = cur.next
        newNode.prev = cur
        cur.next = newNode
        newNode.next!!.prev = newNode
    }
}

class AllOne {
    var map = HashMap<String, Node>()
    var list = DoubleLinkedList()

    fun inc(key : String) {
        var count = 1
        var cur : Node? = list.head

        // remove the key from if already exit
        if (map[key] != null) {   // key already exit
            val node = map[key]
            node!!.set.remove(key)   // remove the key from the node set
            count = node.count+1     // update the count
            if (node.set.isEmpty()) {   // if the node set is empty, remove the node from the list
                cur = node.prev
                list.remove(node)
            } else {
                cur = node
            }
        }

        // add the key to the new node
        var right = cur!!.next
        if (right!!.count != count) {   // if the right node count is different from the count
            right = Node(count)         // create new right node
            list.insert(cur, right)     // insert new right node into list
        }

        map[key] = right                // set the key with value equals to the new right node
        right.set.add(key)              // add the key to the new right now key set
    }

    fun dec(key : String) {
        if (map[key] == null) return

        var node = map[key]!!
        node.set.remove(key)             // remove key
        if (node.set.isEmpty()) {
            list.remove(node)            // when set is empty, remove node
        }
        map.remove(key)

        if (node.count != 1) {          // when count greater than 1
            var left = node.prev
            if (node.prev!!.count != node.count - 1) {    // check if the left node has the count equals count - 1
                left = Node(node.count - 1)         // create new left node
                list.insert(node.prev!!, left)            // insert new left node into list
            }

            map[key] = left!!            // set the key with value equals to the new left node
            left.set.add(key)            // add the key to the new left now key set
        }
    }

    fun getMaxKey() : String {
        val set = list.tail.prev!!.set
        return if (set.isEmpty()) "" else set.iterator().next()
    }

    fun getMinKey() : String {
        val set = list.head.next!!.set
        return if (set.isEmpty()) "" else set.iterator().next()
    }
}

fun main() {
    val allone = AllOne()

    allone.inc("hello")
    allone.inc("word")
    allone.inc("hello")
    println(allone.getMaxKey())
    allone.inc("word")
    allone.inc("word")
    allone.inc("hello")
    allone.dec("hello")
    println(allone.getMaxKey())
    println(allone.getMinKey())
    allone.inc("android")
    println(allone.getMinKey())
}