fun main() {
    check(getTopNLargestCalorieSum(readInput("Day01_test"), 1) == 24000L)
    check(getTopNLargestCalorieSum(readInput("Day01_test"), 3) == 45000L)

    println("Top 1 is: " + getTopNLargestCalorieSum(readInput("Day01"), 1))
    println("Top 3 are: " + getTopNLargestCalorieSum(readInput("Day01"), 3))

}

fun getTopNLargestCalorieSum(input: List<String>, n: Int): Long {
    val sum = input.fold(mutableListOf<MutableList<Long>>()) { list, item ->
        list.apply {
            if (item.isEmpty()) {
                add(mutableListOf())
            } else if (this.isEmpty()) {
                add(mutableListOf(item.toLong()))
            } else {
                last().add(item.toLong())
            }
        }
    }.map { it.sum() }.sortedDescending().take(n).sum()

    return sum
}
