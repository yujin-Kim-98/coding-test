package leetcode

// LeetCode - 2423. Remove Letter To Equalize Frequency
fun main() {

    val word = "abcc"

//    val word = "aazz"

    val result = Solution().equalFrequency(word)

    println("result : $result")

}

class Solution {
    fun equalFrequency(
        word: String
    ): Boolean {

        val wordCountMap = word.groupingBy { it }
            .eachCount()
            .toMutableMap()

        for ((ch, count) in wordCountMap.toMap()) {
            wordCountMap[ch] = count - 1

            if (wordCountMap[ch] == 0) {
                wordCountMap.remove(ch)
            }

            if (wordCountMap.values.toSet().size == 1) {
                return true
            }

            wordCountMap[ch] = count
        }

        return false

    }
}