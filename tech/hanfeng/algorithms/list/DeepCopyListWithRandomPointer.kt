package tech.hanfeng.algorithms.list


class RandomNode(var `val`: Int) {
    var next: RandomNode? = null
    var random: RandomNode? = null
}

fun printList(node : RandomNode?) {
    if (node == null)
        return

    var cur = node
    if (cur.next !== null) {
        while (cur?.next != null) {
            print("${cur?.`val`} -> ")
            cur = cur?.next
        }
    }
    println(cur?.`val`)
}

fun deepCopy(head : RandomNode?) : RandomNode? {
    if (head == null)
        return null

    val hashMap = HashMap<RandomNode, RandomNode>()
    var cur = head

    while(cur != null) {
        hashMap[cur] = RandomNode(cur.`val`)
        cur = cur.next
    }

    cur = head
    while (cur != null) {
        if (cur.next != null)
            hashMap[cur]?.next = hashMap[cur.next!!]

        if (cur.random != null)
            hashMap[cur]?.random = hashMap[cur.random!!]

        cur = cur.next
    }

    return hashMap[head]
}

fun main() {
    val node = RandomNode(1)
    val node2 = RandomNode(2)
    node.random = node2
    node2.random = node2

    node.next = node2

    val node3 = RandomNode(1)

    printList(deepCopy(node))
    printList(deepCopy(null))
    printList(deepCopy(node3))
}