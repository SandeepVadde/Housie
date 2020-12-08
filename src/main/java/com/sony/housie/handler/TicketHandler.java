package com.sony.housie.handler;

import com.sony.housie.dto.GameRequest;
import com.sony.housie.dto.Ticket;
import com.sony.housie.dto.TicketEntry;
import com.sony.housie.util.WinningCombinations;

public class TicketHandler {

	public static void updateTicket(int inputNum, Ticket ticket) {
		TicketEntry[][] ticketEntry = ticket.getTicketEntries();
		for (int i = 0; i < ticketEntry.length; i++) {
			for (int j = 0; j < ticketEntry[i].length; j++) {
				if (ticketEntry[i][j]!=null && ticketEntry[i][j].getNumber() == inputNum) {
					ticketEntry[i][j].setCalled(true);
					ticket.incrementMarkedcount();
				}
			}
		}
	}
	
	public static boolean checkForWinningCombination(Ticket ticket, WinningCombinations currentCombinations, GameRequest gameRequest) {
		return currentCombinations.getWinnerChecker().checkWinner(ticket, gameRequest);
		
	}

}
