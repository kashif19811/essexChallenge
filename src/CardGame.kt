import java.util.Scanner
import java.util.InputMismatchException

/**
 * Essex Management Interview Challenge: Initial MVP that covers the following requirements:
 * Create a card game which supports 3 of the operations below.
 * 1.  Shuffle cards in the deck: randomly mix the cards in the card deck, and return a whole deck of cards with a
 *     mixed order
 * 2.  Get a card from the top of the deck: get one card from top of the card deck, return a card, and if there is
 *     no card left in the deck return error or exception. 
 *
 * Testing: Create test cases to test the above operations.
 * Please put the code in an online repository and provide the link before the interview: github, gitlab, etc.
 *
 * @author Kashif Malik 3/8/2020
 */

/**
 * Card Game MAIN function. Driver Code for the overall game which:
 * 1. Prints the Main Menu.
 * 2. Asks for user input.
 * 3. Makes a selection.
 */
fun main() {
    // Create a list of cards from 1 to 52.
    val listOfCards = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
            16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34,
            35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52)

    var inputNum = 0
    do {
        // Print Main Menu
        printMenu()

        // Get User Input.
        // Kotlin allows Assignments expressions in try/catch. It uses the last row in either the try or catch
        inputNum = try {
            val scanner  = Scanner(System.`in`)
            scanner.nextInt()
        } catch (e: InputMismatchException) { // Handle Non Integer inputs
            println("$e: Please enter a Integer from 0-3.")

            // Reset the input value so last input does not re-trigger
            -1
        }

        // When statement (like java-switch) to determine what to do. Uses -> arrows to assign statements for each input
        when (inputNum) {
            1 -> printCardList(listOfCards)
            2 -> { // Shuffle cards
                listOfCards.shuffle()
                printCardList(listOfCards)
            }
            3 -> { // Deal a card and throw Error if deck is empty
                try {
                    println("Card dealt: ${dealCard(listOfCards)}")
                } catch (e: IllegalArgumentException) {
                    println("Cannot deal card due to exception:\n$e\n")
                } finally {
                    printCardList(listOfCards)
                }
            }
        }
    } while (inputNum != 0)

    println("Exiting game...")
}

/**
 * Print Main Menu for the Card game.
 */
fun printMenu() {
    println("\n**************** Card Game ***************\n" +
            "*               -Main Menu-              *\n" +
            "* Please make a selection to play:       *\n" +
            "*                                        *\n" +
            "* 1. Show contents of Deck               *\n" +
            "* 2. Shuffle Deck and show updated Deck  *\n" +
            "* 3. Deal a card and show updated Deck   *\n" +
            "* 0. Exit game                           *\n" +
            "******************************************")
}

/**
 * Prints all elements of cards list.
 * @param listOfCards ArrayList of cards
 */
fun printCardList(listOfCards: ArrayList<Int>) {
    print("Deck Contents: ")

    // Kotlin forEach can be used to repeat a set of statements for each element in an iterable
    listOfCards.forEach { print("$it ") }
    println()
}

/**
 * Get one card from top of the card deck. If no cards in deck, throw exception.
 * @param listOfCards ArrayList of cards
 * @return The card that is dealt (top card of the deck)
 * @throws IllegalArgumentException if there are no cards left in deck to deal.
 */
fun dealCard(listOfCards: ArrayList<Int>): Int {
    if (listOfCards.isEmpty()) {
        throw IllegalArgumentException("Deck Empty: No card left in deck to deal.")
    }
    // Get Top Card and remove it from list
    return listOfCards.removeAt(0)
}
