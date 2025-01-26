package algorithm.binarySearch

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.StringTokenizer

// 백준 10815 - 숫자 카드
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    var st = StringTokenizer(readLine())

    val N = st.nextToken().toInt()
    val takeCards = IntArray(N)

    st = StringTokenizer(readLine())
    for (i in 0 until N) {
        takeCards[i] = st.nextToken().toInt()
    }
    takeCards.sort()

    st = StringTokenizer(readLine())

    val M = st.nextToken().toInt()
    val findCards = IntArray(M)

    st = StringTokenizer(readLine())
    for (i in 0 until M) {
        findCards[i] = st.nextToken().toInt()
    }

    result(takeCards, findCards)

}

fun result(
    takeCards: IntArray,
    findCards: IntArray
) {

    findCards.map { findCard ->
        when (takeCards.binarySearch(findCard) < 0) {
            true -> print("0 ")
            false -> print("1 ")
        }
    }


    // 시간초과 멸망
//    findCards.map { findCard ->
//        when (takeCards.any { it == findCard }) {
//            true -> print("1 ")
//            false -> print("0 ")
//        }
//        print("${takeCards.count { it == findCard }} ")
//    }
}