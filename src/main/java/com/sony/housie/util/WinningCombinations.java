package com.sony.housie.util;

public enum WinningCombinations {


	TOP_LINE(new TopLineWinnerChecker()),
	EARLY_FIVE(new EarlyFiveWinnerChecker()),
	FULL_HOUSE(new FullHouseWinChecker());
	
	WinnerChecker winnerChecker;

	WinningCombinations(WinnerChecker winnerChecker) {
		this.winnerChecker = winnerChecker;
	}

	public WinnerChecker getWinnerChecker() {
		return winnerChecker;
	}

}
