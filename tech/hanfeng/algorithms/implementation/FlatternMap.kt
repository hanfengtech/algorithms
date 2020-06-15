package tech.hanfeng.algorithms.implementation

fun flattenDictionary(dict : HashMap<String, Any>) : HashMap<String, Any> {
    var res = HashMap<String, Any>()
    if (dict.isEmpty()) return res
    helper(dict, "", res)
    return res
}

// retKey = "key2"
// newKey = "key2.a"

// res = ""
// res[key1] = "1"
// res[key2.a] = "2"
// res[key2.b] = "3"
// res[key2.c.d] = "3"
// res[key2.c.e] = "1"

fun helper(dict : HashMap<String, Any>, retKey : String, res : HashMap<String, Any>) {
    dict.forEach { (k, v) ->
        val newKey = if (retKey == "") {
            k
        } else {
            if (k != "")
                "$retKey.$k"
            else
                retKey
        }
        if (v is String) {
            res[newKey] = v.toString()
        } else {
            helper(v as HashMap<String, Any>, newKey, res)
        }
    }
}

/*
input:  dict = {
            "Key1" : "1",
            "Key2" : {
                "a" : "2",
                "b" : "3",
                "c" : {
                    "d" : "3",
                    "e" : {
                        "" : "1"
                    }
                }
            }
        }
 */

fun main() {
    val dicte = HashMap<String, Any>()
    dicte[""] = "1"
    val dictc = HashMap<String, Any>()
    dictc["d"] = "3"
    dictc["e"] = dicte

    val dictkey2 = HashMap<String, Any>()
    dictkey2["a"] = "2"
    dictkey2["b"] = "3"
    dictkey2["c"] = dictc

    val dict = HashMap<String, Any>()
    dict["key1"] = "1"
    dict["key2"] = dictkey2

    var res = flattenDictionary(dict)
    res.forEach { (t, u) ->
        println("$t  :  $u")
    }
}