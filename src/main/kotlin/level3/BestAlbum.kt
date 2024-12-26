package level3

// 프로그래머스 Level3 - 베스트 앨범
fun main() = with(System.`in`.bufferedReader()) {

//    val genres = arrayOf("classic", "pop", "classic", "classic", "pop")
//    val plays = intArrayOf(500, 600, 150, 800, 2500)

    val genres = arrayOf("classic", "pop", "classic", "classic")
    val plays = intArrayOf(500, 3100, 500, 500)

    val result = solution(genres, plays)

    println(result.map { it })

}

fun solution(
    genres: Array<String>,
    plays: IntArray
): IntArray {

    val result = mutableListOf<Int>()

    val genresMap = genres.mapIndexed { index, genre ->
        Triple(genre, plays[index], index)
    }

    val total = genres.distinct().map { type ->
        type to genresMap.filter { it.first == type }.sumOf { it.second }
    }.sortedByDescending { it.second }

    total.map {
        val genre = it.first
        genresMap.filter { it.first == genre }.sortedByDescending { it.second }.chunked(2).first().map {
            for (i in genresMap.indices) {
                if (genresMap[i].first == it.first && genresMap[i].second == it.second && genresMap[i].third == it.third) {
                    result.add(i)
                    break
                }
            }
        }
    }

    return result.toIntArray()
}