package level1

import java.util.LinkedList

// 프로그래머스 Level1 - 카드 뭉치
fun main() = with(System.`in`.bufferedReader()) {

    val cards1: Array<String> = arrayOf("a", "b", "c")
    val cards2: Array<String> = arrayOf("d", "e", "f")
    val goal: Array<String> = arrayOf("a", "d", "f")

    val result = solution(cards1, cards2, goal)

    println("result: $result")

}

// LinkedList는 Q 구조를 가지고 있음
fun solution(
    cards1: Array<String>,
    cards2: Array<String>,
    goals: Array<String>
): String {

    val cardList1 = LinkedList(cards1.toList())
    val cardList2 = LinkedList(cards2.toList())

    goals.map { goal ->
        when (goal) {
            cardList1.peek() -> cardList1.poll()
            cardList2.peek() -> cardList2.poll()
            else -> return "No"
        }
    }
    return "Yes"
}