package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.populate123Tree
import tech.hanfeng.algorithms.tree.utils.preorderPretty
import java.util.*

class Codec {
    fun serialize(root: TreeNode?): String {
        if (root == null)
            return ""

        val resultList = arrayListOf<Int?>()
        val result = StringBuilder()
        val queue = LinkedList<TreeNode?>()
        queue.offer(root)

        while (queue.isNotEmpty()) {
            val n = queue.size
            for (i in 0 until n) {
                val node = queue.remove()
                if (node == null) {
                    resultList.add(null)
                    continue
                }
                resultList.add(node.value)
                queue.add(node.left)
                queue.add(node.right)
            }
        }

        while (resultList[resultList.lastIndex] == null) {
            resultList.removeAt(resultList.lastIndex)
        }


        for (i in 0 until resultList.size) {
            result.append(resultList[i])
            if (i < resultList.size - 1) {
                result.append(',')
            }
        }

        return result.toString()
    }

    fun deserialize(data : String) : TreeNode? {
        val dataList = data.split(',')
        
        if (dataList.isEmpty() || data == "") {
            return null
        }

        var i = 0
        val root = TreeNode( dataList[i++].toInt())
        val queue = LinkedList<TreeNode?>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val n = queue.size
            for (j in 0 until n) {
                val node = queue.remove()
                if (i < dataList.size) {
                    if (dataList[i] != "null") {  //  handle left
                        node!!.left = TreeNode(dataList[i].toInt())
                        queue.add(node.left)
                    }
                    i++
                    if (i < dataList.size) {
                        if (dataList[i] != "null") {  // handle right
                            node!!.right = TreeNode(dataList[i].toInt())
                            queue.add(node.right)
                        }
                        i++
                    }
                }
            }
        }

        return root
    }
}

fun main() {
    val codec = Codec()
    val tree = populate123Tree()
    tree.right!!.left = TreeNode(4)
    tree.right!!.right = TreeNode(5)

    val data = codec.serialize(tree)

    println(data)

    val root = codec.deserialize(data)
    preorderPretty(root)
}

