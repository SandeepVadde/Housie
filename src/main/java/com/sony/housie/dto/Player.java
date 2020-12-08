package com.sony.housie.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.sony.housie.handler.TicketHandler;
import com.sony.housie.util.WinningCombinations;

public class Player {

	private int playerId;

	private Ticket ticket;

	private Dealer dealer;
	
	private List<WinningCombinations> winningStates = new ArrayList<>();

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	public List<WinningCombinations> getWinningStates() {
		return winningStates;
	}

	public void setWinningStates(List<WinningCombinations> winningStates) {
		this.winningStates = winningStates;
	}

	public void updateNumber(int inputNum, int pickedNumberCount, GameRequest gameRequest,
			Set<WinningCombinations> winningCombinations) {
		TicketHandler.updateTicket(inputNum, ticket);
		if (ticket.getMarkedCount() >= 5) {
			winningCombinations.forEach(winningCombination -> {
				boolean isWinner = TicketHandler.checkForWinningCombination(ticket, winningCombination, gameRequest);
				if (isWinner) {
					this.getWinningStates().add(winningCombination);
					dealer.updateState(playerId, winningCombination, ticket);
				}

			});
		}
	}

}
