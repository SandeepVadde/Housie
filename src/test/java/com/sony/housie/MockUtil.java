package com.sony.housie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.sony.housie.dto.Dealer;
import com.sony.housie.dto.GameRequest;
import com.sony.housie.dto.Player;
import com.sony.housie.dto.Ticket;
import com.sony.housie.dto.TicketEntry;

public class MockUtil {

	public static GameRequest getGameRequest() {
		return new GameRequest(5, 40, 3, 7, 5);
	}

	public static List<Player> createPlayers(int numberOfPlayers) {

		List<Player> players = new ArrayList<>();
		for (int i = 0; i < numberOfPlayers; i++) {
			Player player = new Player();
			player.setPlayerId(i + 1);
			players.add(player);
		}
		return players;
	}

	public static List<Integer> getNumberPool() {
		return IntStream.range(1, 40 + 1).boxed().collect(Collectors.toList());
	}

	public static Dealer createDealerMock(List<Player> players, GameRequest gameRequest, List<Integer> numberPool) {
		Dealer dealer = new Dealer(players, gameRequest.getRangeMax(), numberPool);
		dealer.setPickedNumberCount(0);
		return dealer;
	}

	public static Ticket createTicket(GameRequest gameRequest) {
		TicketEntry[][] ticketEntries = new TicketEntry[gameRequest.getRows()][gameRequest.getColumns()];
		List<Integer> randomIntegers = IntStream.range(1, gameRequest.getRangeMax()).boxed()
				.collect(Collectors.toCollection(ArrayList::new));
		Collections.shuffle(randomIntegers);
		List<Integer> subList = randomIntegers.subList(0, gameRequest.getRows() * gameRequest.getColumns());
		for (int i = 0; i < subList.size(); i++) {
			int rowIdx = i / gameRequest.getColumns();
			int colIdx = i % gameRequest.getColumns();
			TicketEntry ticketEntry = new TicketEntry(subList.get(i), false);
			ticketEntries[rowIdx][colIdx] = ticketEntry;
		}
		Ticket ticket = new Ticket(gameRequest.getRows(), gameRequest.getColumns(), gameRequest.getRangeMax(),
				ticketEntries);
		return ticket;
	}

}
