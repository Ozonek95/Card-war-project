package com.game.com.game.logic;

import com.game.cards.Card;
import com.game.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Kacper Staszek
 */
public class Game {
    private List<Player> players;
    private List<Card> table;
    private Scanner scanner;
    private Player p1;
    private Player p2;

    Game(List<Player> players) {
        this.players = players;
        this.table = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.p1=players.get(0);
        this.p2 = players.get(1);
    }

    void round(){ //TODO Patryk I'm pretty sure this method could be divided into few smaller ones for sake of understanding and clean code
        boolean haveAWinner = false;
        while (!haveAWinner) {
            Card playerOneCard = askForCard(p1);
            Card playerTwoCard = askForCard(p2);
            putCardOnTable(playerOneCard);
            putCardOnTable(playerTwoCard);
            System.out.println("Cards on table: "); //TODO: Wiktor - Mozna byloby dodac czyja jest ktora karta. Wypisanie kilku kart jedna pod druga nie daje mozliwosci zgadniecia kto i jaka karta wygral.
            table.forEach(System.out::println);
            if (playerOneCard.getValue() > playerTwoCard.getValue()) {
                System.out.println(p1.getName() + " won this round");
                System.out.println();
                p1.getDeck().addCards(table);
                table.clear();
                checkIfAnyoneLose();
                haveAWinner=true;
            } else if (playerOneCard.getValue() < playerTwoCard.getValue()) {
                System.out.println(p2.getName() + " won this round");
                System.out.println();
                p2.getDeck().addCards(table);
                table.clear();
                checkIfAnyoneLose();
                haveAWinner=true;
            }
            else {
                System.out.println("Draw! Give me cards please! "+p1.getName());
                scanner.nextLine();
                putCardOnTable(getCardFromPlayer(p1));
                System.out.println("Now "+p2.getName());
                scanner.nextLine();
                putCardOnTable(getCardFromPlayer(p2));
                checkIfAnyoneLose();
            }
        }
    }

    private Card askForCard(Player p1) {
        System.out.println(p1.getName() + " press any key to give card"); //TODO:: Wiktor - jaki przycisk powinienem wcisnac zeby wylozyc karte? "key"?
        scanner.nextLine();
        return getCardFromPlayer(p1);
    }

    private void putCardOnTable(Card p1Card) {
        table.add(p1Card);
    }

    private Card getCardFromPlayer(Player p) {
        return p.getDeck().useCard();
    }

    private void checkIfAnyoneLose(){
        for (Player player:players) {
            if(player.getDeck().getCards().size()==0){
                System.out.println(player.getName()+" You loose");
                System.out.println("You guys want to play more?");
                if(scanner.nextLine().equals("Y")){
                    new GameStart().play();
                }
                System.out.println("Thanks for play :)");
                scanner.close();
                return;
            }
        }
    }

}

//TO DO FUTURE FUNCTIONALITY
//    private void winRound(Move winner) {
//        System.out.println("This round is to player "+winner.getPlayer().getName());
//        winner.getPlayer().getDeck().addCards(table);
//        table.clear();
//    }

//assert that there is only two players in round
//    public void round() {
//        List<Move> moves = new ArrayList<>();
//        for (Player player : players) {
//            System.out.println(player.getName() + " press key to play");
//            scanner.nextLine();
//            Card cardUsed = player.getDeck().useCard();
//            moves.add(new Move(player, cardUsed));
//            table.add(cardUsed);
//            System.out.println("Table: ");
//            for (Card cardsOnTable : table) {
//                System.out.println(cardsOnTable);
//            }
//            Move winner = moves.get(0);
//            for (Move move:moves) {
//
//                if(move.getCard().getValue().getValue()>winner.getCard().getValue().getValue()){
//                    winner = move;
//                }
//            }
//            winRound(winner);
//        }
//        checkIfAnyoneLose();
//
//    }
//
