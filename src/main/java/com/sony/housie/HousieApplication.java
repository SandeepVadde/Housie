package com.sony.housie;

import java.util.Scanner;

import com.sony.housie.dto.GameRequest;
import com.sony.housie.service.GameService;
import com.sony.housie.service.HousieGameService;

public class HousieApplication {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		// 5, 90, 3, 10, 5)
		System.out.println("Enter number of players:");
		int players = scanner.nextInt();
		System.out.println("Enter max range for total numbers:");
		int maxRange = scanner.nextInt();
		System.out.println("Enter rows per ticket:");
		int rows = scanner.nextInt();
		System.out.println("Enter columns players:");
		int columns = scanner.nextInt();
		System.out.println("Enter max numbers per row:");
		int numbersPerRow = scanner.nextInt();
		GameRequest gameRequest = new GameRequest(players, maxRange, rows, columns, numbersPerRow);
		GameService gameService = new HousieGameService();
		gameService.initializeGame(gameRequest);
		scanner.close();
	}

}