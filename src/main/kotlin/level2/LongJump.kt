package level2

// 프로그래머스 Level2 - 멀리 뛰기
// 피보나치
fun main() = with(System.`in`.bufferedReader()) {

    val n = 1

    val result = solution(n)

    println("result: $result")

}

fun solution(
    n: Int
): Long {

    val dp = LongArray(n + 1)

    dp[0] = 1
    dp[1] = 1

    when (n < 2) {
        true -> return dp[n]
        false -> {
            for (i in 2 .. n) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567
            }
            return dp[n]
        }
    }

}