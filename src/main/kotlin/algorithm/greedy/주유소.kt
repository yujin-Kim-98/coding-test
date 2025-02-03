package algorithm.greedy

import java.io.BufferedReader
import java.io.InputStreamReader

// 백준 13305
// 58점
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val N = readLine().toInt()
    val roadLength = readLine().split(" ").map { it.toInt() }.toIntArray()
    val cities = readLine().split(" ").map { it.toInt() }.toIntArray()

    var totalCount = 0
    var minPrice = cities[0]

    for (i in 0 until N - 1) {
        minPrice = minOf(minPrice, cities[i])
        totalCount += minPrice * roadLength[i]
    }

    println(totalCount)

}

// 17점
//fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
//
//    val N = readLine().toInt()
//    val roadLength = readLine().split(" ").map { it.toInt() }.toIntArray()
//    val cities = readLine().split(" ").map { it.toInt() }.toIntArray()
//    val visitCities = mutableListOf<Int>()
//
//    var result = 0
//
//    for (i in 0 until N - 1) {
//
//        val city = cities[i]
//
//        visitCities.find { it == city }?: run {
//            var needFuel = roadLength[i]
//
//            for (j in (i + 1) until N - 1) {
//                val nextCity = cities[j]
//
//                if (city < nextCity) {
//                    visitCities.add(nextCity)
//                    needFuel += roadLength[j]
//                }
//            }
//
//            result += city * needFuel
//        }
//
//    }
//    println(result)
//
//}