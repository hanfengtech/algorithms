package tech.hanfeng.algorithms.tree

import java.util.*
import kotlin.collections.ArrayList

class NAryTreeCodec {
    data class Node(var `val` : Int, var children : ArrayList<Node> = ArrayList())
    private val NULL: String? = "#"
    private val DELIMITER = ","
    fun serialize(root: Node?): String {       // Encodes a tree to a single string.
        var sb = StringBuilder()
        fun buildString(node : Node?) {
            if (node == null) {
                sb.append(NULL).append(DELIMITER)
            } else {
                sb.append(node.`val`).append(DELIMITER)
                sb.append(node.children.size).append(DELIMITER)
                for (child in node.children)
                    buildString(child)
            }
        }
        buildString(root)
        return sb.toString()
    }

    fun deserialize(data: String): Node? {     // Decodes your encoded data to tree.
        if (data.isEmpty()) return null
        val q = LinkedList<String>(data.split(DELIMITER))
        fun buildTree() : Node? {
            val s = q.poll()
            if (s == NULL) return null
            val value = s.toInt()
            val numOfChildren = q.poll().toInt()
            val node = Node(value, ArrayList(numOfChildren))
            for (i in 0 until numOfChildren) {
                val child = buildTree()
                if (child != null)
                    node.children.add(child)
            }
            return node
        }
        return buildTree()
    }
}

fun main() {
    val decoder = NAryTreeCodec()

    val n1 = NAryTreeCodec.Node(1)
    val n2 = NAryTreeCodec.Node(2)
    val n3 = NAryTreeCodec.Node(3)
    val n4 = NAryTreeCodec.Node(4)
    val n5 = NAryTreeCodec.Node(5)
    val n6 = NAryTreeCodec.Node(6)

    n1.children.add(n3)
    n1.children.add(n2)
    n1.children.add(n4)

    n3.children.add(n5)
    n3.children.add(n6)

    val str = decoder.serialize(n1)

    println(str)

    val root = decoder.deserialize(str)
    println(root!!.children[2].`val`)
    println(root!!.children[0].children[1].`val`)
}
