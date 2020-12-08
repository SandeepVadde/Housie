package com.sony.housie;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.sony.housie.dto.GameRequest;
import com.sony.housie.dto.Ticket;
import com.sony.housie.dto.TicketEntry;
import com.sony.housie.service.HousieGameService;
import com.sony.housie.util.TopLineWinnerChecker;

@RunWith(MockitoJUnitRunner.class)
public class TopLineWinnerCheckerTest {
	
	@InjectMocks
	private TopLineWinnerChecker topLineWinnerChecker;

	@Mock
	private HousieGameService housieGameServiceMock;

	@Test
	public void testFirstFiveWinCheck() {

		GameRequest gameRequest = MockUtil.getGameRequest();
		Ticket ticket = MockUtil.createTicket(gameRequest);
		assertNotEquals(true, topLineWinnerChecker.checkWinner(ticket, gameRequest));
		TicketEntry[] topRow = Arrays.stream(ticket.getTicketEntries()).map(entry -> entry[0])
				.toArray(TicketEntry[]::new);
		for (TicketEntry entry : topRow) {
			entry.setCalled(true);
		}
		assertEquals(true, topLineWinnerChecker.checkWinner(ticket, gameRequest));
	}

}
