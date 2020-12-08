package com.sony.housie.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.sony.housie.dto.Dealer;
import com.sony.housie.dto.Game;
import com.sony.housie.dto.GameRequest;
import com.sony.housie.dto.Player;
import com.sony.housie.dto.Ticket;

public abstract class GameService {

	public abstract Game createGame(List<Player> players, Dealer dealer);

	public abstract Dealer createDealer(List<Player> players, GameRequest gameRequest, List<Integer> numberPool);

	public abstract Ticket createTicket(GameRequest gameRequest);

	public abstract List<Player> createPlayers(int numberOfPlayers);

	public final void initializeGame(GameRequest gameRequest) {

		List<Player> players = createPlayers(gameRequest.getNumberOfPlayers());
		List<Integer> numberPool = IntStream.range(1, gameRequest.getRangeMax() + 1).boxed()
				.collect(Collectors.toList());
		Dealer dealer = createDealer(players, gameRequest, numberPool);
		players.forEach(player -> {
			player.setTicket(createTicket(gameRequest));
			player.setDealer(dealer);
		});
		Game game = createGame(players, dealer);
		game.start(gameRequest);
	}
}
