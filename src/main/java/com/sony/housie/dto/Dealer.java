package com.sony.housie.dto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import com.sony.housie.util.WinningCombinations;

public class Dealer {

	private String dealerId;

	private List<Player> players;

	private int maxRange;

	private List<Integer> numberPool;

	private int pickedNumberCount;

	private Set<WinningCombinations> availableWinningCombinations;

	private Set<WinningCombinations> currentWinningCombinations;

	public Dealer(List<Player> players, int maxRange, List<Integer> numberPool) {
		this.dealerId = UUID.randomUUID().toString();
		this.players = players;
		this.maxRange = maxRange;
		this.numberPool = numberPool;
		this.availableWinningCombinations = Arrays.stream(WinningCombinations.values()).collect(Collectors.toSet());
		this.currentWinningCombinations = new HashSet<>();
	}

	public int getPickedNumberCount() {
		return pickedNumberCount;
	}

	public void setPickedNumberCount(int pickedNumberCount) {
		this.pickedNumberCount = pickedNumberCount;
	}

	public int getMaxRange() {
		return maxRange;
	}

	public void setMaxRange(int maxRange) {
		this.maxRange = maxRange;
	}

	public List<Integer> getNumberPool() {
		return numberPool;
	}

	public void setNumberPool(List<Integer> numberPool) {
		this.numberPool = numberPool;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public String getDealerId() {
		return dealerId;
	}

	public void setDealerId(String dealerId) {
		this.dealerId = dealerId;
	}

	public Set<WinningCombinations> getWinningCombinations() {
		return availableWinningCombinations;
	}

	public void setWinningCombinations(Set<WinningCombinations> winningCombinations) {
		this.availableWinningCombinations = winningCombinations;
	}

	public void deal(GameRequest gameRequest) {
		if (numberPool.size() > 0) {
			int randomIndex = new Random().ints(0, numberPool.size()).findFirst().getAsInt();
			int pickedNumber = numberPool.remove(randomIndex);
			System.out.println("Next number is: " + pickedNumber);
			notifyPlayers(this.players, pickedNumber, this.pickedNumberCount++, gameRequest);
		} else {
			System.out.println("**GAME OVER**");
			System.exit(0);
		}
	}

	public void notifyPlayers(List<Player> players, int pickedNumber, int count, GameRequest gameRequest) {
		players.forEach(player -> {
			// waits for player feedback, use completable Future and proceed once all
			// futures are resolved
			player.updateNumber(pickedNumber, count, gameRequest, this.availableWinningCombinations);
		});
	}

	public void updateState(int playerId, WinningCombinations winningCombination, Ticket ticket) {

		if (!currentWinningCombinations.contains(winningCombination)) {
			currentWinningCombinations.add(winningCombination);
			availableWinningCombinations.remove(winningCombination);
			if (winningCombination.equals(WinningCombinations.EARLY_FIVE)) {
				System.out.println(
						"We have a winner: Player with id: " + playerId + " has won 'Early Five' winning combination");
			} else if (winningCombination.equals(WinningCombinations.TOP_LINE)) {
				System.out.println(
						"We have a winner: Player with id: " + playerId + " has won 'Top Line' winning combination");
			} else if (winningCombination.equals(WinningCombinations.FULL_HOUSE)) {
				System.out.println(
						"We have a winner: Player with id: " + playerId + " has won 'Full House' winning combination");
				// Assumption to exit game here if a full house combination is found
				System.out.println("***GAME OVER***");
				System.out.println("=====================");
				System.out.println("Summary:");
				this.players.forEach(player -> {
					System.out.println("Player#" + player.getPlayerId() + ":" + player.getWinningStates());
				});
				System.exit(0);
			} else {
				System.out.println("Invalid winning combination");
			}
		}
	}

}
