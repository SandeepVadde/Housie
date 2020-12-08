package com.sony.housie;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.sony.housie.dto.Dealer;
import com.sony.housie.dto.Game;
import com.sony.housie.dto.GameRequest;
import com.sony.housie.dto.Player;
import com.sony.housie.dto.Ticket;
import com.sony.housie.service.HousieGameService;
import com.sony.housie.util.WinningCombinations;

@RunWith(MockitoJUnitRunner.class)
public class HousieGameServiceTest {
	
	@InjectMocks
	private HousieGameService housieGameServiceMock;
	
	@Test
	public void testHousieCreatePlayerMethod() {
		
		List<Player> players = housieGameServiceMock.createPlayers(2);
		assertEquals("Expetcted to create 2 players ", 2, players.size());
	}
	
	@Test
	public void testCreateTicketMethod() {
		
		GameRequest gameRequest = MockUtil.getGameRequest();
		Ticket ticket = housieGameServiceMock.createTicket(gameRequest);
		assertEquals(0, ticket.getMarkedCount());
		assertEquals(3, ticket.getRows());
		assertEquals(7, ticket.getColumns());
		assertEquals(40, ticket.getRangeMax());
		assertEquals(3, ticket.getTicketEntries().length);
	}
	
	@Test
	public void testCreateDealerMethod() {
		
		GameRequest gameRequest = MockUtil.getGameRequest();
		List<Player> players = housieGameServiceMock.createPlayers(2);
		List<Integer> mockNumberPool = MockUtil.getNumberPool();
		Set<WinningCombinations> mockAvailableComb = Arrays.stream(WinningCombinations.values()).collect(Collectors.toSet());
		Dealer dealer = housieGameServiceMock.createDealer(players, gameRequest, mockNumberPool);
		assertNotEquals(0, dealer.getPlayers().size());
		assertEquals(2, dealer.getPlayers().size());
		assertEquals(40, dealer.getNumberPool().size());
		assertEquals(40, dealer.getMaxRange());
		assertEquals(0, dealer.getPickedNumberCount());
		assertEquals(mockAvailableComb, dealer.getWinningCombinations());
	}
	
	@Test
	public void testCreateGameMethod() {
		GameRequest gameRequest = MockUtil.getGameRequest();
		List<Player> players = housieGameServiceMock.createPlayers(2);
		List<Integer> mockNumberPool = MockUtil.getNumberPool();
		Dealer dealer = housieGameServiceMock.createDealer(players, gameRequest, mockNumberPool);
		Game game = housieGameServiceMock.createGame(players, dealer);
		assertEquals(2, game.getPlayers().size());
		assertEquals(40, game.getDealer().getNumberPool().size());
	}

}
