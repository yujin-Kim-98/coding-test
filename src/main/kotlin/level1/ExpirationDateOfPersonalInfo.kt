package level1

import java.time.DateTimeException
import java.time.LocalDate
import java.time.format.DateTimeFormatter

// 프로그래머스 Level1 - 개인정보 수집 유효기간
fun main() = with(System.`in`.bufferedReader()) {

    val today = "2022.05.19"
    val terms = arrayOf("A 6", "B 12", "C 3")
    val privacies = arrayOf("2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C")

    val result = solution(today, terms, privacies)

    println("result : ${result.map { it }}")

}

fun solution(
    today: String,
    terms: Array<String>,
    privacies: Array<String>
): IntArray {

    val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd")
    val todayDate = LocalDate.parse(today, dateTimeFormatter)

    val termMaps = terms.map {
        Pair(it.split(" ")[0], it.split(" ")[1].toLong())
    }

    val privacyMaps = privacies.map {
        val date = LocalDate.parse(it.split(" ")[0], dateTimeFormatter)
        Pair(date, it.split(" ")[1])
    }

    val result = mutableListOf<Int>()

    for ((index, privacy) in privacyMaps.withIndex()) {
        val collectionDate = privacy.first
        val term = privacy.second

        termMaps.find { it.first == term }?.let { term ->
            val expirationMonth = term.second
            val expirationDate = collectionDate.plusMonths(expirationMonth)

            when {
                expirationDate.isBefore(todayDate) -> result.add(index + 1)
                expirationDate.isEqual(todayDate) -> result.add(index + 1)
                else -> { /**/ }
            }
        }
    }

    return result.toIntArray()
}