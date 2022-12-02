fun main() {
    val input = readInput("Day02_test")
//    check(processRockPaperScissors(input) == 15)
    println(processRockPaperScissors2(readInput("Day02")))
}

fun processRockPaperScissors(input: List<String>) = input.sumOf { processMatch(it) }
fun processRockPaperScissors2(input: List<String>) = input.sumOf { processMatch2(it) }

fun processMatch(match: String): Int {
    val (opponentHand, myHand) = match.split(" ")
    val matchScore = when(opponentHand) {
        "A" -> when(myHand) {
            "X" -> 3
            "Y" -> 6
            "Z" -> 0
            else -> 0
        }
        "B" -> when(myHand) {
            "X" -> 0
            "Y" -> 3
            "Z" -> 6
            else -> 0
        }
        "C" -> when(myHand) {
            "X" -> 6
            "Y" -> 0
            "Z" -> 3
            else -> 0
        }
        else -> 0
    }

    return matchScore + scoreForHand(myHand)
}

fun scoreForHand(hand: String) = when (hand) {
    "X" -> 1
    "Y" -> 2
    "Z" -> 3
    else -> 0
}

fun processMatch2(match: String): Int {
    val (opponentHand, targetState) = match.split(" ")
    val handScore = when(opponentHand) {
        "A" -> when(targetState) {
            "X" -> 3
            "Y" -> 1
            "Z" -> 2
            else -> 0
        }
        "B" -> when(targetState) {
            "X" -> 1
            "Y" -> 2
            "Z" -> 3
            else -> 0
        }
        "C" -> when(targetState) {
            "X" -> 2
            "Y" -> 3
            "Z" -> 1
            else -> 0
        }
        else -> 0
    }
    return handScore + scoreForTargetState(targetState)
}

fun scoreForTargetState(state: String) = when(state) {
    "X" -> 0
    "Y" -> 3
    "Z" -> 6
    else -> 0
}