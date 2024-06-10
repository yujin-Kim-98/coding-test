package algorithm.greedy

// 백준 11399
fun main() = with(System.`in`.bufferedReader()) {

    val count = readLine().toInt()
    val times = readLine().split(" ").map { it.toInt() }.sorted()

    var sum = 0
    val sumTimes = mutableListOf<Int>()
    for (time in times) {
        sum += time
        sumTimes.add(sum)
    }

    println(sumTimes.sum())

}