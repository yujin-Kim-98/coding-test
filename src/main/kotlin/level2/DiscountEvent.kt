package level2

fun main() = with(System.`in`.bufferedReader()) {

    val want = arrayOf("banana", "apple", "rice", "pork", "pot")
    val number = intArrayOf(3, 2, 2, 2, 1)
    val discount = arrayOf("chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana")

    val result = solution(want, number, discount)

    println(result)

}

fun solution(
    want: Array<String>,
    number: IntArray,
    discount: Array<String>
): Int {

    var result = 0

    val wants = want.mapIndexed { index, item -> item to number[index] }

    for ((index, item) in discount.withIndex()) {

        val sales = when (index + 9 >= discount.size) {
            true -> discount.sliceArray(index .. discount.lastIndex)
            false -> discount.sliceArray(index .. index + 9)
        }.groupingBy { it }.eachCount()

        var index = 0

        wants.map {
            val wantItem = it.first
            val wantCount = it.second

            if (sales.getOrDefault(wantItem, 0) >= wantCount) {
                index++
            }
        }

        if (index == want.size) result++

    }

    return result
}