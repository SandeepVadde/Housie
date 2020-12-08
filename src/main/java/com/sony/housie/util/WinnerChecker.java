package com.sony.housie.util;

import com.sony.housie.dto.GameRequest;
import com.sony.housie.dto.Ticket;

public interface WinnerChecker {

	boolean checkWinner(Ticket ticket, GameRequest gameRequest);

}
