package level2

// 프로그래머스 Level2 - 오픈채팅방
fun main() = with(System.`in`.bufferedReader()) {

    val record = arrayOf<String>(
        "Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"
    )

    val result = solution(record)

    println("result : ${result.map { it }}")

}

fun solution(
    record: Array<String>
): Array<String> {

    val nicknameMap: Map<String, String> = record.reversed().filter {
        it.split(" ")[0] != "Leave"
    }.distinctBy {
        it.split(" ")[1]
    }.associate {
        it.split(" ")[1] to it.split(" ")[2]
    }

    val result = mutableListOf<String>()

    record.map {
        val nickname = nicknameMap[it.split(" ")[1]]
        when (it.split(" ")[0]) {
            "Enter" -> {
                result.add("${nickname}님이 들어왔습니다.")

            }
            "Leave" -> {
                result.add("${nickname}님이 나갔습니다.")
            }
            else -> { /* Do Nothing */ }
        }
    }.toList()

    return result.toTypedArray()
}