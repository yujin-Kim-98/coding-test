package level1

// 프로그래머스 Level1 - 신고 결과 받기
fun main() = with(System.`in`.bufferedReader()) {

    val id_list = arrayOf("con", "ryan")
    val report = arrayOf("ryan con", "ryan con", "ryan con", "ryan con")
    val k = 2

    val result = solution(id_list, report, k)

    println("result : ${result.map { it }}")

}

fun solution(
    id_list: Array<String>,
    report: Array<String>,
    k: Int
): IntArray {

    val stoppedIds = report.distinct().groupingBy {
        it.split(" ")[1]
    }.eachCount().filter { it.value >= k }.keys

    val reportResultMailMap = mutableMapOf<String, Int>()
    stoppedIds.map { stoppedId ->
        report.distinct().filter { it.split(" ")[1] == stoppedId }.map {
            val reportId = it.split(" ")[0]
            reportResultMailMap[reportId] = reportResultMailMap.getOrDefault(reportId, 0) + 1
        }
    }

    val result = id_list.map { id ->
        reportResultMailMap[id] ?: 0
    }.toIntArray()

    return result
}

// 시간초과 개싀발ㅠㅠ