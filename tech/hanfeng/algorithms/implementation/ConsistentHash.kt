package tech.hanfeng.algorithms.implementation

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*

class ConsistentHash<T> {
    private val hashFunction : HashFunction
    private val numberOfReplicas : Int
    private val circle = TreeMap<Long, T>()

    constructor( nodes : Collection<T>, numberOfReplicas : Int) : this(nodes, numberOfReplicas, MD5Hash())

    constructor(nodes : Collection<T>, numberOfReplicas : Int, hashFunction: HashFunction) {
        this.hashFunction = hashFunction
        this.numberOfReplicas = numberOfReplicas

        nodes.forEach {
            add(it)
        }
    }

    fun add(node : T) {
        for (i in 0 until numberOfReplicas) {
            circle[hashFunction.hash(node.toString() + i)] = node
        }
    }

    fun remove(node : T) {
        for (i in 0 until numberOfReplicas) {
            circle.remove(hashFunction.hash(node.toString() + i))
        }
    }

    fun get(key : String) : T? {
        if (circle.isEmpty())
            return null

        var hash = hashFunction.hash(key)
        if (!circle.containsKey(hash)) {
            var tailMap = circle.tailMap(hash)
            hash = if (tailMap.isEmpty()) circle.firstKey() else tailMap.firstKey()
        }
        return circle[hash]
    }

    private class MD5Hash : HashFunction {

        lateinit var instance : MessageDigest

        constructor() {
            try {
                this.instance = MessageDigest.getInstance("MD5")
            } catch (e : NoSuchAlgorithmException) {
                e.printStackTrace()
            }
        }


        override fun hash(key: String): Long {
            instance.reset()
            instance.update(key.toByte())
            val digest = instance.digest()

            var h = 0L
            for (i in 0 until 4) {
                h = h shl 8
                val tmp = digest[i].toInt() and 0xFF
                h = h or tmp.toLong()
            }

            return h
        }
    }
}

interface HashFunction {
    fun hash(key : String) : Long
}

