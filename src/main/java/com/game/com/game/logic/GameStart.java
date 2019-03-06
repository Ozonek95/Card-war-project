package com.game.com.game.logic;

import com.game.cards.CardDeckGenerator;
import com.game.player.Player;
import com.game.player.PlayerDeckGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Kacper Staszek
 */
public class GameStart {
    private Player player1;
    private Player player2;
    private PlayerDeckGenerator playerDeckGenerator;
    private Scanner scanner;
    private Game game;

    public GameStart() {
        this.scanner=new Scanner(System.in);
        CardDeckGenerator cardDeckGenerator = new CardDeckGenerator();
        this.player1 = new Player();
        this.player2= new Player();
        List<Player> playerList = Arrays.asList(player1, player2);
        this.playerDeckGenerator= new PlayerDeckGenerator(cardDeckGenerator.generateCards(1), playerList);
        this.game= new Game(playerList);
    }

    public void play(){
        initialize();
        while (player1.getDeck().getSize()!=0||player2.getDeck().getSize()!=0){
            game.round();//TODO Aga: jezli to lub to- czyli jak jeden z dwoch graczy bedzie nie mial kart to gramy dalej? - pod warunkiem ze dobrze rozumiem
        }
        scanner.close();
    }

    private void initialize(){
        System.out.println("Player 1, provide name, please:)"); //TODO:: Wiktor - Jak zrobiles podawanie imion, mozna byloby dodac sprawdzenie czy podane imiona nie sa identyczne. Jezeli tak to na przyklad generowac jakis rozroznik  typu (1), (2) po imieniu. Jakas obsluga np. koniecznosc podania jakichs znakow - teraz moge po prostu dac enter i nie bedzie imion graczy.
        player1.setName(scanner.nextLine());
        System.out.println("Player 2, you too, please:)");
        player2.setName(scanner.nextLine());
        playerDeckGenerator.giveCardsToPlayers();
    }

}
