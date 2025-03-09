package level1

fun main() {

    val friends = arrayOf(
        "muzi",
        "ryan",
        "frodo",
        "neo"
    )

    val gifts = arrayOf(
        "muzi frodo",
        "muzi frodo",
        "ryan muzi",
        "ryan muzi",
        "ryan muzi",
        "frodo muzi",
        "frodo ryan",
        "neo muzi"
    )

    val result = Solution().solution(friends, gifts)

    println("result : $result")

}

class Solution {

    fun solution(
        friends: Array<String>,
        gifts: Array<String>
    ): Int {

        val giftCountMap = gifts.groupingBy { it }.eachCount()

        val sendCount = gifts.groupingBy {
            it.split(" ")[0]
        }.eachCount()

        val receiveCount = gifts.groupingBy {
            it.split(" ")[1]
        }.eachCount()

        // 지수
        val indices = friends.associateWith { (sendCount[it] ?: 0) - (receiveCount[it] ?: 0) }

        val resultMap = mutableMapOf<String, Int>()


        for (i in 0 until friends.size) {

            val sender = friends[i]

            var count = 0

            for (j in 0 until friends.size) {

                val receiver = friends[j]

                val senderCount = giftCountMap["$sender $receiver"] ?: 0
                val receiverCount = giftCountMap["$receiver $sender"] ?: 0


                if (senderCount == 0 && receiverCount == 0 || senderCount == receiverCount) {
                    // 선물 주고 받은 기록 없음
                    // 선물 지수가 더 큰 경우에 선물 받음
                    val senderIndices = indices[sender] ?: 0
                    val receiverIndices = indices[receiver] ?: 0
                    if (senderIndices > receiverIndices) {
                        count++
                    }

                } else if (senderCount > receiverCount) {
                    // 선물 주고 받은 기록이 있고 더 많이 보냈다
                    count++
                }

            }

            resultMap.put(sender, count)

        }

        return resultMap.values.maxOf { it }
    }

}
