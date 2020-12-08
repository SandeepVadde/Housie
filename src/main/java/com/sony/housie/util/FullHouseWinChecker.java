package com.sony.housie.util;

import com.sony.housie.dto.GameRequest;
import com.sony.housie.dto.Ticket;
import com.sony.housie.dto.TicketEntry;

public class FullHouseWinChecker implements WinnerChecker {

	@Override
	public boolean checkWinner(Ticket ticket, GameRequest gameRequest) {

		TicketEntry[][] ticketEntries = ticket.getTicketEntries();
		for (int i = 0; i < ticketEntries.length; i++) {
			for (int j = 0; j < ticketEntries[i].length; j++) {
				if(ticketEntries[i][j] != null && !ticketEntries[i][j].isCalled()) {
					return false;
				}
			}
		}
		return true;
	}

}
