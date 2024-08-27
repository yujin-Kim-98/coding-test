package level2

import java.time.LocalTime
import java.time.temporal.ChronoUnit
import kotlin.math.*

// 프로그래머스 Level2 - 주차 요금 계산
fun main() = with(System.`in`.bufferedReader()) {

    val fees = intArrayOf(180, 5000, 10, 600)
    val records = arrayOf("05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT")

    val result = solution(fees, records)

    println("result : ${result.map { it }}")

}

fun solution(
    fees: IntArray,
    records: Array<String>
): IntArray {

    val defaultMinute = fees[0]
    val defaultPrice = fees[1]
    val unitMinute = fees[2]
    val unitPrice = fees[3]

    val recordMap = records.groupBy {
        it.split(" ")[1]
    }.map {
        val recordList = it.value.sortedBy { it.split(" ")[0] }.toMutableList()

        if (recordList.size % 2 != 0) {
            recordList.add("23:59 ${it.key} OUT")
        }

        val diff = recordList.chunked(2).sumOf {
            val inTime = LocalTime.parse(it[0].split(" ")[0])
            val outTime = LocalTime.parse(it[1].split(" ")[0])

            ChronoUnit.MINUTES.between(inTime, outTime)
        }

        val price = when (diff <= defaultMinute) {
            true -> defaultPrice
            false -> defaultPrice + ceil((diff - defaultMinute).toDouble() / unitMinute.toDouble()) * unitPrice
        }

        it.key to price.toInt()
    }.toMap().toSortedMap()

    return recordMap.values.toIntArray()
}