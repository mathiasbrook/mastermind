//Name: Mathias Brook

import java.util.Scanner;

public class Mastermind{
   private String possibleCharacters;
   private String answer;
   private static Scanner scan = new Scanner(System.in); //one Scanner for all input

//default list of possible characters
public Mastermind(){
   possibleCharacters = "ABCDEFG"; //default possible characters
}

public Mastermind(String str){
   possibleCharacters = str;
}

//plays the easy version of the game with a limit on guesses
public void play(String easy, int limit){
   generateAnswer(); //Generates a new answer
   System.out.println("Enter your guess. Your possible characters are: " + possibleCharacters);
   String guess = scan.next();
   String result = "";
   while (true) {
      result = checkGuess(guess,false); //checks the player's guess
      if (!(result.equals("null"))) { //if the guess isn't "null" print out the feedback from guess and decrement guess limit
         System.out.println(result);
         limit--;
      }
      System.out.println(limit + " tries left!");
      if (result.equals("$$$$")) { //if the guess is correct stop the game and reference endGame method
         System.out.println("Congratulations, you're right.");
         endGame();
         break;
      }
      if (!(limit > 0)) { //if there are no more guesses left stop the game and reference the endGame method
      endGame();
      break;
      }
      System.out.println("Enter your guess");
      guess = scan.next(); //scans next guess if none of the prior conditions were met
   }
}

//plays the easy version of the game with no limit on guesses
public void play(String easy){
   generateAnswer(); //Generates a new answer
   System.out.println("Enter your guess. Your possible characters are: " + possibleCharacters);
   String guess = scan.next();
   String result = "";
   while (true) {
      result = checkGuess(guess,false); //checks the player's guess
      if (!(result.equals("null"))) System.out.println(result); //if the guess isn't "null" print out the feedback from guess and decrement guess limit
      if (result.equals("$$$$")) { //if the guess is correct stop the game and reference endGame method
         System.out.println("Congratulations, you're right.");
         endGame();
         break;
      }
      System.out.println("Enter your guess");
      guess = scan.next(); //scans next guess if none of the prior conditions were met
   }
}

//plays the hard version of the game with a limit on guesses
public void play(int limit){
   generateAnswer(); //Generates a new answer
   System.out.println("Enter your guess. Your possible characters are: " + possibleCharacters);
   String guess = scan.next();
   String result = "";
   while (true) {
      result = checkGuess(guess,true); //checks the player's guess
      if (!(result.equals("null"))) {//if the guess isn't "null" print out the feedback from guess and decrement guess limit
         System.out.println(result);
         limit--;
      }
      System.out.println(limit + " tries left!");
      if (result.equals("$$$$")) { //if the guess is correct stop the game and reference endGame method
         System.out.println("Congratulations, you're right.");
         endGame();
         break;
      }
      if (!(limit > 0)) { //if there are no more guesses left stop the game and reference the endGame method
         endGame();
         break;
      }
      System.out.println("Enter your guess");
      guess = scan.next(); //scans next guess if none of the prior conditions were met
   }
}

//plays the hard version of the game with no limit on guesses
public void play(){
   generateAnswer(); //Generates a new answer
   System.out.println("Enter your guess. Your possible characters are: " + possibleCharacters);
   String guess = scan.next();
   String result = "";
   while (true) {
      result = checkGuess(guess,true); //checks the player's guess
      if (!(result.equals("null"))) System.out.println(result);//if the guess isn't "null" print out the feedback from guess and decrement guess limit
      if (result.equals("$$$$")) { //if the guess is correct stop the game and reference endGame method
      System.out.println("Congratulations, you're right.");
         endGame();
         break;
      }
      System.out.println("Enter your guess");
      guess = scan.next(); //scans next guess if none of the prior conditions were met
   }
}

//Picks a random 4 character answer
private void generateAnswer(){
   answer = "";
   for (int i = 0; i < 4; i++) {
      answer += possibleCharacters.charAt((int)(Math.random()*possibleCharacters.length())); //Generate random characters from the possible characters list using charAT
   }
}

//Sets the answer to the given String (used for testing)
private void setAnswer(String str){
   answer = str;
   
}

private void selectGame() {
   System.out.println("Select your difficulty. Type 'easy' for easy mode and 'hard' for hard mode");
   String difficulty = scan.next(); //String scan for easy and hard
   while (true) {
      if (difficulty.toLowerCase().equals("easy") || difficulty.toLowerCase().equals("hard")) { //easy and hard are valid
         break;
      }
      difficulty = scan.next(); //waits for another string input if previous string was not "easy" or "hard"
   }
   System.out.println("Enter your guess limit. Type a number of at least 1 for the preferred amount of guesses and -1 for unlimited guesses");
   int limit = scan.nextInt(); //Int scan for guess limit
   while (true) {
      if (limit > 0 || limit == -1) { //Limits that are 1+ and -1 are valid
         break;
      }
      limit = scan.nextInt(); //waits for another int input if previous number was invalid
   }
   if (difficulty.toLowerCase().equals("hard")) { //hard mode uses the play methods without the String
      if (limit == -1) play(); //If limit is -1 play guess game with unlimited guesses
      else play(limit); //If limit is 1+ play guess game with limited guesses
   } else {
      if (limit == -1) play(difficulty); //If limit is -1 play guess game with unlimited guesses
      else play(difficulty,limit); //If limit is 1+ play guess game with limited guesses
   }
   
}

private void endGame(){ //Gives the prompt to play mastermind over again
   System.out.println("Do you want to play again? Type Yes or No");
   String replay = scan.next(); //Scanner for yes or no
   while (true) {
      if (replay.toLowerCase().equals("yes")) {
         selectGame(); //Goes back to select game prompt
         break;
      } else if (replay.toLowerCase().equals("no")) {
         break; //Stops game
      }
      replay = scan.next(); //waits for "yes" or "no" input if previous string was invalid
   }
}

//Checks the answer against the input(str) and returns the appropriate feedback
//flag equals true indicates hard play, flag equals false indicates the easy play
//Returns "null" if the String is the wrong length
private String checkGuess(String str,boolean flag){
   String guess = "";
   if (str.length() > 4 || str.length() < 4) return "null"; //If guess length is less or more than 4 characters then return null
   for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == answer.charAt(i)) { //Add $ for correct characters
         guess += "$";
      } else if (str.charAt(i) != answer.charAt(i) && flag == false) { //If easy mode add * for wrong characters don't add if hard mode
         guess += "*";
      }
   }
   return guess;
   }
   
//checkGuess tests from class (java Mastermind test)
public static void runTests(){
   Mastermind myGame = new Mastermind("ABCDEFG");
   myGame.setAnswer("ACAD");
    System.out.println("Expected null " + myGame.checkGuess("ABCDEFG",true));
    System.out.println("Expected null " + myGame.checkGuess("AA",false));
    System.out.println("Expected $$ " + myGame.checkGuess("AAAA",true));
    System.out.println("Expected $*$* " + myGame.checkGuess("AAAA",false));
    System.out.println("Expected $ " + myGame.checkGuess("ABZZ",true));
    System.out.println("Expected $*** " + myGame.checkGuess("ABZZ",false));
    System.out.println("Expected $ " + myGame.checkGuess("CDAA",true));
    System.out.println("Expected **$* " + myGame.checkGuess("CDAA",false));
    System.out.println("Expected $$$$ " + myGame.checkGuess("ACAD",true));
    System.out.println("Expected $$$$ " + myGame.checkGuess("ACAD",false));
}

public static void main(String[] args){
   if (args.length > 0 && args[0].equals("test")) {
      runTests();
   } else {
      Mastermind game = new Mastermind("ABCDEFG");
      game.selectGame();
   }
}

}   
