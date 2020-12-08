package com.sony.housie.dto;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Game {

	private String gameId;

	private Dealer dealer;

	private List<Player> players;

	public Game(Dealer dealer, List<Player> players) {

		this.gameId = UUID.randomUUID().toString();
		this.dealer = dealer;
		this.players = players;
	}

	public void start(GameRequest gameRequest) {

		Scanner scanner = new Scanner(System.in);
		String input;
		do {
			this.dealer.deal(gameRequest);
			input = scanner.next();
		}
		while(!input.equalsIgnoreCase("Q"));
		scanner.close();
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

}
