package com.sony.housie.util;

import com.sony.housie.dto.GameRequest;
import com.sony.housie.dto.Ticket;
import com.sony.housie.dto.TicketEntry;

public class TopLineWinnerChecker implements WinnerChecker {

	@Override
	public boolean checkWinner(Ticket ticket, GameRequest gameRequest) {

		TicketEntry[] topRow = ticket.getTicketEntries()[0];
		for (TicketEntry entry : topRow) {
			if (entry != null && !entry.isCalled()) {
				return false;
			}
		}
		return true;
	}

}
