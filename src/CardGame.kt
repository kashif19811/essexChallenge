import java.util.Random

// Shuffles the array of cards
fun shuffle(cards: IntArray) {
    val rand = Random()
    for (i in cards.indices) { // Shuffles 0 through 51 indices (inclusive)
        // Random for remaining positions
        val r = i + rand.nextInt(52 - i)
        // swap elements
        val temp = cards[r]
        cards[r] = cards[i]
        cards[i] = temp
    }
}

// Prints all elements of cards array
fun printCardArray(arrayOfCards: IntArray) {
    arrayOfCards.forEach { print("$it ") }
}

// Driver code
fun main(args: Array<String>) {
    // Create an array of cards from 1 to 52.
    // We can use intArrayOf here as well but this allows us to specify a range.
    // However it creates a list then converts it an array
    val arrayOfCards: IntArray = (1..52).toList().toIntArray()

    println("Before shuffle:")
    // Printing all shuffled elements of cards
    printCardArray(arrayOfCards)

    // Shuffle cards
    shuffle(arrayOfCards)

    println("\n\nAfter shuffle:")
    // Printing all shuffled elements of cards
    printCardArray(arrayOfCards)
}
