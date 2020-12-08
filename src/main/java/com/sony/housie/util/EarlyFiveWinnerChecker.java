package com.sony.housie.util;

import com.sony.housie.dto.GameRequest;
import com.sony.housie.dto.Ticket;

public class EarlyFiveWinnerChecker implements WinnerChecker {

	@Override
	public boolean checkWinner(Ticket ticket, GameRequest gameRequest) {
		if (ticket.getMarkedCount() == 5) {
			return true;
		}
		return false;
	}

}
