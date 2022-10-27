package com.gdstruc.midterm;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int turn = 1;
        int cardNum;
        int command;

        //Create the different stacks
        CardStack stackOnHand = new CardStack(); //Cards that the player is currently holding
        CardStack playerDeck = new CardStack();
        CardStack discardedPile = new CardStack();

        //Populate player deck
        playerDeck.push(new Card("Five of Diamonds"));
        playerDeck.push(new Card("Two of Hearts"));
        playerDeck.push(new Card("Ace of Spades"));
        playerDeck.push(new Card("Eight of Clubs"));
        playerDeck.push(new Card("Four of Clubs"));
        playerDeck.push(new Card("King of Spades"));
        playerDeck.push(new Card("Queen of Hearts"));
        playerDeck.push(new Card("Two of Hearts"));
        playerDeck.push(new Card("Seven of Diamonds"));
        playerDeck.push(new Card("Three of Diamonds"));
        playerDeck.push(new Card("Jack of Clubs"));
        playerDeck.push(new Card("Eight of Hearts"));
        playerDeck.push(new Card("Five of Hearts"));
        playerDeck.push(new Card("Six of Spades"));
        playerDeck.push(new Card("Ace of Clubs"));
        playerDeck.push(new Card("Seven of Diamonds"));
        playerDeck.push(new Card("Ten of Hearts"));
        playerDeck.push(new Card("Queen of Spades"));
        playerDeck.push(new Card("Seven of Diamonds"));
        playerDeck.push(new Card("Nine of Clubs"));
        playerDeck.push(new Card("Ace of Hearts"));
        playerDeck.push(new Card("Jack of Clubs"));
        playerDeck.push(new Card("Eight of Diamonds"));
        playerDeck.push(new Card("Nine of Spades"));
        playerDeck.push(new Card("Ace of Spades"));
        playerDeck.push(new Card("King of Diamonds"));
        playerDeck.push(new Card("Three of Clubs"));
        playerDeck.push(new Card("Five of Hearts"));
        playerDeck.push(new Card("Jack of Diamonds"));
        playerDeck.push(new Card("Two of Spades"));

        while (!playerDeck.isEmpty()) {
            System.out.println("\n=====> TURN " + turn + " <=====");

            //Randomize command and number of cards
            Random rand = new Random();
            command = rand.nextInt(3) + 1;
            cardNum = rand.nextInt(5) + 1;

            //Draw x cards
            if (command == 1) {
                System.out.println("Command: Draw " + cardNum + " card/s\n");

                for (int i = 1; i <= cardNum; i++) {
                    stackOnHand.push(playerDeck.peek());
                    playerDeck.pop();

                    if (playerDeck.isEmpty()) break;
                }
            }

            //Discard x cards
            else if (command == 2) {
                System.out.println("Command: Discard " + cardNum + " card/s\n");

                if (!stackOnHand.isEmpty()) {
                    for (int i = 1; i <= cardNum; i++) {
                        discardedPile.push(stackOnHand.peek());
                        stackOnHand.pop();

                        if (stackOnHand.isEmpty()) break;
                    }
                }
            }

            //Get x cards from the discarded pile
            else {
                System.out.println("Command: Get " + cardNum + " card/s from the discarded pile\n");

                if (!discardedPile.isEmpty()) {
                    for (int i = 1; i <= cardNum; i++) {
                        stackOnHand.push(discardedPile.peek());
                        discardedPile.pop();

                        if (discardedPile.isEmpty()) break;
                    }
                }
            }

            //Display relevant after-round information
            System.out.println("Cards Currently Holding: ");
            stackOnHand.printStack();
            System.out.println("\nNumber of Remaining Cards in Player Deck: " + playerDeck.size() +
                    "\nNumber of Cards in Discarded Pile: " + discardedPile.size());

            turn++;
        }
    }
}