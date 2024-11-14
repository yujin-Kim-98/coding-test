package level2

// 프로그래머스 Level2 - 의상
fun main() = with(System.`in`.bufferedReader()) {

    val clothes: Array<Array<String>> = arrayOf(
        arrayOf("yellow_hat", "headgear"),
        arrayOf("blue_sunglasses", "eyewear"),
        arrayOf("green_turban", "headgear"),
    )

//    val clothes: Array<Array<String>> = arrayOf(
//        arrayOf("crow_mask", "face"),
//        arrayOf("blue_sunglasses", "face"),
//        arrayOf("smoky_makeup", "face"),
//    )

    val result = solution(clothes)

    println("result : $result")

}

fun solution(
    clothes: Array<Array<String>>
): Int {

    return clothes.groupBy { it[1] }.values.fold(1) { acc, v -> acc * (v.size + 1) } - 1

}