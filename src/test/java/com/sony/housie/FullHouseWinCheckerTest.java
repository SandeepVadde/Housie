package com.sony.housie;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.sony.housie.dto.GameRequest;
import com.sony.housie.dto.Ticket;
import com.sony.housie.dto.TicketEntry;
import com.sony.housie.service.HousieGameService;
import com.sony.housie.util.FullHouseWinChecker;

@RunWith(MockitoJUnitRunner.class)
public class FullHouseWinCheckerTest {
	
	@InjectMocks
	private FullHouseWinChecker fullHouseWinChecker;

	@Mock
	private HousieGameService housieGameServiceMock;

	@Test
	public void testFirstFiveWinCheck() {

		GameRequest gameRequest = MockUtil.getGameRequest();
		Ticket ticket = MockUtil.createTicket(gameRequest);
		assertNotEquals(true, fullHouseWinChecker.checkWinner(ticket, gameRequest));
		TicketEntry[][] ticketEntry = ticket.getTicketEntries();
		for (int i = 0; i < ticketEntry.length; i++) {
			for (int j = 0; j < ticketEntry[i].length; j++) {
				ticketEntry[i][j].setCalled(true);				
			}
		}
		assertEquals(true, fullHouseWinChecker.checkWinner(ticket, gameRequest));
	}

}
