import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.util.*

/**
 * JUnit tests for Card Game
 */
class CardGameTest {

    private var listOfCards = ArrayList<Int>()
    private val outContent = ByteArrayOutputStream()
    private var inContent: ByteArrayInputStream? = null
    private val originalDeckContentString = "Deck Contents: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 " +
            "22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52"

    @Before
    fun setUp() {
        listOfCards = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
                16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34,
                35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52)

        // Set PrintStream to capture Console Printing
        System.setOut(PrintStream(outContent))
    }

    @Test
    fun mainTest() {
        provideInput("0")
        main()
        val exitText = "Exiting game..."
        assertTrue("If Input is 0, then exit text should be shown", outContent.toString().contains(exitText))
    }

    @Test
    fun printMenuTest() {
        printMenu()

        val menuContent = "Card Game"
        assertTrue("Print Menu function should contain Title", outContent.toString().contains(menuContent))
    }

    @Test
    fun getUserInputTest() {
        provideInput("2")
        assertEquals("User Input should be 2", 2, getUserInput())
    }

    @Test
    fun getUserInputInvalidExceptionTest() {
        provideInput("P")
        assertEquals("User Input should be -1", -1, getUserInput())

    }

    private fun provideInput(data: String) {
        inContent = ByteArrayInputStream(data.toByteArray())
        System.setIn(inContent)
    }

    @Test
    fun performOptionest() {
        // Verify Deck contains all 52 cards in ascending order
        performOption(1, listOfCards)
        assertEquals("Deck Content should be all 52 cards", originalDeckContentString, outContent.toString().trim())

        outContent.reset()

        // Verify Deck Randomization works correctly
        performOption(2, listOfCards)
        assertNotEquals("Deck Content should be all 52 RANDOM cards", originalDeckContentString, outContent.toString().trim())

        outContent.reset()

        // Verify Top Card is Dealt and deck contents updated properly
        val topCardBeforeDealing = listOfCards[0]
        performOption(3, listOfCards)
        val topCardAfterDealing = listOfCards[0]

        val cardDealtText = "Card dealt: $topCardBeforeDealing"
        val deckContentText = "Deck Contents: $topCardAfterDealing"
        assertTrue("Deal Card option should contain 'Card dealt' Text", outContent.toString().contains(cardDealtText))
        assertTrue("Deal Card option should contain 'Deck Contents' Text", outContent.toString().contains(deckContentText))

        outContent.reset()

        // Verify Error occurs if trying to Deal from an empty Deck
        val emptyDeck = ArrayList<Int>()
        performOption(3, emptyDeck)
        val errorMsg = "Deck Empty: No card left in deck to deal"
        assertTrue("Verify Exception is caught and message printed", outContent.toString().contains(errorMsg))
    }

    @Test
    fun printCardListTest() {
        printCardList(listOfCards)
        assertEquals("Deck Content should be all 52 cards", originalDeckContentString, outContent.toString().trim())
    }

    @Test
    fun dealCardTest() {
        val topCard = listOfCards[0]
        assertEquals("Card dealt should be the very top card", topCard, dealCard(listOfCards))
    }

    @Test(expected = IllegalArgumentException::class)
    fun dealCardTestEmptyDeckException() {
        val emptyDeck = ArrayList<Int>()
        dealCard(emptyDeck)
    }
}