package tech.hanfeng.algorithms.strings

import java.util.*
import java.net.URL
import java.net.HttpURLConnection
//import com.google.gson.Gson
//import com.google.gson.reflect.TypeToken

data class Repository(val id : String, val name : String)
fun getReposNames(url : String) : List<String> {
    val res = ArrayList<String>()
    val url = URL(url)
    val sb = StringBuilder()
    with(url.openConnection() as HttpURLConnection) {
        requestMethod = "GET"  // optional default is GET
        println("\nSent 'GET' request to URL : $url; Response Code : $responseCode")
        inputStream.bufferedReader().use {
            it.lines().forEach { line ->
                sb.append(line)
            }
        }
    }

    val q = PriorityQueue<Repository> { a, b -> a.name.compareTo(b.name) }

    /*
    val gson = Gson()
    val arrayRepositoryType = object : TypeToken<Array<Repository>>(){}.type
    var repositories: Array<Repository> = gson.fromJson(sb.toString(), arrayRepositoryType)

    for (repo in repositories) {
         res.add(repo.name)
    }
    */

    return res.sorted()
}

fun main() {
    val repos = getReposNames("https://api.github.com/orgs/python/repos")
    repos.forEach {
        println(it)
    }
}

// # API Documentation, please open in your browser:
// # https://developer.github.com/v3/repos/#list-organization-repositories


// URL = "https://api.github.com/orgs/python/repos"


// # Issue a HTTP GET request to the URL endpoint
// # Print the names of the repositories, one per line, in alphabetical order