package level1

import kotlin.time.Duration.Companion.seconds

// 프로그래머스 Level1 - 성격 유형 검사하기
fun main() = with(System.`in`.bufferedReader()) {

    val survey = arrayOf(
        "AN",
        "CF",
        "MJ",
        "RT",
        "NA"
    )

    val choices = intArrayOf(5, 3, 2, 7, 5)

    val result = solution(survey, choices)

    println("result : $result")

}

fun solution(
    survey: Array<String>,
    choices: IntArray
): String {

    val typePairs = arrayOf(
        Pair("R", "T"),
        Pair("C", "F"),
        Pair("J", "M"),
        Pair("A", "N")
    )

    // First : choice value, Second : score, Third : (Agree -> true, Disagree -> false)
    val choiceScores = arrayOf(
        Triple(1, 3, false), // 매우 비동의
        Triple(2, 2, false), // 비동의
        Triple(3, 1, false), // 약간 비동의
        Triple(4, 0, false), // 모르겠음
        Triple(5, 1, true), // 약간 동의
        Triple(6, 2, true), // 동의
        Triple(7, 3, true) // 매우 동의
    )

    val scoreMap = mutableMapOf<String, Int>()

    for ((index, choice) in choices.withIndex()) {

        val choiceScore = choiceScores.find { it.first == choice }
        val surveyCharArray = survey[index].toCharArray()

        choiceScore?.let {
            val type = when (it.third) {
                true -> surveyCharArray[1].toString()
                false -> surveyCharArray[0].toString()
            }

            val newScore = scoreMap[type]?.let { score ->
                score + it.second
            } ?: it.second

            scoreMap.put(type, newScore)
        }

    }

    val type = typePairs.map { typePair ->

        val firstCount = scoreMap[typePair.first] ?: 0
        val secondCount = scoreMap[typePair.second] ?: 0

        when (firstCount >= secondCount) {
            true -> typePair.first
            false -> typePair.second
        }

    }

    return type.joinToString("")
}