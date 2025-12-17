package level1

// 프로그래머스 Level1 - 부족한 금액 계산하기
fun main() {
    val price = 2500
    val money = 1
    val count = 2500

    val result = solution2(price, money, count)
    println("result: $result")
}

fun solution(
    price: Int,
    money: Int,
    count: Int
): Long {
    var totalMoney = 0L
    for (i in 1..count) {
        totalMoney += (i * price)
    }

    return when (money >= totalMoney) {
        true -> 0L
        false -> (totalMoney - money).toLong()
    }
}