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
import com.sony.housie.service.HousieGameService;
import com.sony.housie.util.FirstFiveWinnerChecker;

@RunWith(MockitoJUnitRunner.class)
public class FirstFiveWinnerCheckerTest {

	@InjectMocks
	private FirstFiveWinnerChecker firstFiveWinnerChecker;

	@Mock
	private HousieGameService housieGameServiceMock;

	@Test
	public void testFirstFiveWinCheck() {

		GameRequest gameRequest = MockUtil.getGameRequest();
		Ticket ticket = MockUtil.createTicket(gameRequest);
		ticket.setMarkedCount(4);
		assertNotEquals(true, firstFiveWinnerChecker.checkWinner(ticket, gameRequest));
		ticket.setMarkedCount(5);
		assertEquals(true, firstFiveWinnerChecker.checkWinner(ticket, gameRequest));
	}
}
