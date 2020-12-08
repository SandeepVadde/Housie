package com.sony.housie.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.sony.housie.dto.Dealer;
import com.sony.housie.dto.Game;
import com.sony.housie.dto.GameRequest;
import com.sony.housie.dto.Player;
import com.sony.housie.dto.Ticket;
import com.sony.housie.dto.TicketEntry;

public class HousieGameService extends GameService {

	@Override
	public Game createGame(List<Player> players, Dealer dealer) {
		Game game = new Game(dealer, players);
		return game;
	}

	@Override
	public Dealer createDealer(List<Player> players, GameRequest gameRequest, List<Integer> numberPool) {

		Dealer dealer = new Dealer(players, gameRequest.getRangeMax(), numberPool);
		dealer.setPickedNumberCount(0);
		return dealer;
	}

	@Override
	public Ticket createTicket(GameRequest gameRequest) {
		TicketEntry[][] ticketEntries = new TicketEntry[gameRequest.getRows()][gameRequest.getColumns()];
		List<Integer> randomIntegers = IntStream.range(1, gameRequest.getRangeMax()).boxed()
				.collect(Collectors.toList());
		Collections.shuffle(randomIntegers);
		for (int i = 0; i < gameRequest.getRows(); i++) {
			for (int j = 0; j < gameRequest.getNumbersPerRow(); j++) {
				TicketEntry ticketEntry = new TicketEntry(randomIntegers.get(i), false);
				ticketEntries[i][j] = ticketEntry;
				randomIntegers.remove(randomIntegers.get(i));
			}
			List<TicketEntry> list = Arrays.asList(ticketEntries[i]);
			Collections.shuffle(list);
			ticketEntries[i] = (TicketEntry[]) list.toArray();
		}
		System.out.println(Arrays.deepToString(ticketEntries));
		Ticket ticket = new Ticket(gameRequest.getRows(), gameRequest.getColumns(), gameRequest.getRangeMax(),
				ticketEntries);
		// System.out.println(Arrays.deepToString(ticket.getTicketEntries()));
		return ticket;
	}

	@Override
	public List<Player> createPlayers(int numberOfPlayers) {

		List<Player> players = new ArrayList<>();
		// Assuming minimum one player per game
		for (int i = 0; i < numberOfPlayers; i++) {
			Player player = new Player();
			player.setPlayerId(i + 1);
			players.add(player);
		}
		return players;
	}

}
