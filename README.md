# Essex Management Interview Challenge
Card game Repo for Essex Management Challenge

*Work with the programing language you are most familiar with.* 

## Create a card game which supports 3 of the operations below. 

1.  Shuffle cards in the deck: randomly mix the cards in the card deck, and return a whole deck of cards with a mixed order 

2.  Get a card from the top of the deck: get one card from top of the card deck, return a card, and if there is no card left in the deck return error or exception.  

3.  Sort cards: take a list of color as parameter and sort the card in that color order. Numbers should be in ascending order.  

    i.e. If the deck has a card with following order:
    ```(red, 1), (green, 5), (red, 0), (yellow, 3), (green, 2)```

    Sort cards(```[yellow, green, red]```) will return the cards with following order:
    ```(yellow, 3), (green, 0), (green, 5), (red, 0), (red, 1)``` 

4.  Determine winners: 2 players play the game. They will draw 3 cards by taking turns. 
    Whoever has the high score wins the game. (color point calculation, red = 3, yellow =2, green = 1) the point is calculated by color point * number in the card.   

## Testing: Create test cases to test the above operations. 

Please put the code in an online repository and provide the link before the interview: github, gitlab, etc.

---
### Assignment due date: 3/9/2020

---
## MVP Solution Notes
1.  Due to time constraints, the initial MVP will include #1 and #2 from the Requirements above.
2.  Solution is completed with Kotlin using a static class and methods. See `src/CardGame.kt`.
3.  Unit Tests with 100% Coverage are located in `test/CardGameTest.kt`.
3.  Kotlin provides many benefits over Java:
    Null Safety,
    Expression assignments,
    Iterate over a list all methods on each element in one-line,
    Extension functions,
    Data classes,
    Operator overloading and many more.
    
