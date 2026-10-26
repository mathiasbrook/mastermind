# Mastermind

A Java console version of the code-breaking game Mastermind. The computer picks a secret 4 letter code and you try to guess it.

## Features
- Random 4 character code from the letters A-G (the constructor can take any set of characters)
- Easy mode: feedback for every position, `$` for a correct letter in the correct spot and `*` for a wrong one
- Hard mode: only shows a `$` for each correct spot, so you don't know which positions are right
- Pick a guess limit, or `-1` for unlimited guesses
- Shows the answer if you run out of guesses
- Play again prompt after each game

## How to run
```
javac Mastermind.java && java Mastermind
```

To run the `checkGuess` tests from class:
```
java Mastermind test
```

## Sample output
Real output (lines starting with `>` are what I typed). An easy game with unlimited guesses, using one letter at a time to find each position:

```
Select your difficulty. Type 'easy' for easy mode and 'hard' for hard mode
> easy
Enter your guess limit. Type a number of at least 1 for the preferred amount of guesses and -1 for unlimited guesses
> -1
Enter your guess. Your possible characters are: ABCDEFG
> AAAA
$***
Enter your guess
> BBBB
***$
Enter your guess
> CCCC
**$*
Enter your guess
> DDDD
****
Enter your guess
> EEEE
*$**
Enter your guess
> AECB
$$$$
Congratulations, you're right.
Do you want to play again? Type Yes or No
> no
```

Running out of guesses on easy, then a round of hard mode:

```
Select your difficulty. Type 'easy' for easy mode and 'hard' for hard mode
> easy
Enter your guess limit. Type a number of at least 1 for the preferred amount of guesses and -1 for unlimited guesses
> 5
Enter your guess. Your possible characters are: ABCDEFG
> ABCD
*$**
4 tries left!
Enter your guess
> AB
Your guess has to be 4 characters long
4 tries left!
Enter your guess
> EFGA
****
3 tries left!
Enter your guess
> BBBB
*$$*
2 tries left!
Enter your guess
> CDEF
$***
1 tries left!
Enter your guess
> GGGG
****
0 tries left!
Out of guesses! The answer was CBBC
Do you want to play again? Type Yes or No
> yes
Select your difficulty. Type 'easy' for easy mode and 'hard' for hard mode
> hard
Enter your guess limit. Type a number of at least 1 for the preferred amount of guesses and -1 for unlimited guesses
> 3
Enter your guess. Your possible characters are: ABCDEFG
> AAAA
$$
2 tries left!
Enter your guess
> BBBB

1 tries left!
Enter your guess
> CCCC

0 tries left!
Out of guesses! The answer was FFAA
Do you want to play again? Type Yes or No
> no
```

## Concepts used
- String methods (`charAt`, `length`, building a feedback string)
- Method overloading (four `play` methods for easy/hard and limited/unlimited)
- Constructors and private helper methods
- Loops with input validation using `Scanner`
- Random numbers with `Math.random()`

## What I'd add next
- Accept lowercase guesses
- Real Mastermind feedback (right letter but wrong spot)
- Combine the four `play` methods into one with parameters
- Print something clearer than a blank line when a hard mode guess has no matches
