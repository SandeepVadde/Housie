package com.sony.housie;

import java.util.Scanner;

import com.sony.housie.dto.GameRequest;
import com.sony.housie.service.GameService;
import com.sony.housie.service.HousieGameService;

public class HousieApplication {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of players:");
		int players;
		do {
			System.out.println("Game should have minimum two players");
			while (!scanner.hasNextInt()) {
				System.out.println("Invalid input try again, Players should be a number");
				scanner.next();
			}
			players = scanner.nextInt();
		} while (players <= 1);
		System.out.println("Enter rows per ticket:");
		int rows;
		do {
			System.out.println("Ticket should have one minimum one row");
			while (!scanner.hasNextInt()) {
				System.out.println("Invalid input try again.rows per ticket be a number");
				scanner.next();
			}
			rows = scanner.nextInt();
		} while (rows <= 0);
		System.out.println("Enter columns per ticket:");
		int columns;
		do {
			System.out.println("Ticket should have minimum one column");
			while (!scanner.hasNextInt()) {
				System.out.println("Invalid input try again.columns per ticket be a number");
				scanner.next();
			}
			columns = scanner.nextInt();
		} while (columns <= 0);
		System.out.println("Enter max numbers per row:");
		int numbersPerRow;
		do {
			System.out.println("Numbers per row should be less than columns");
			while (!scanner.hasNextInt()) {
				System.out.println("Invalid input try again. Max numbers per ticket be a number");
				scanner.next();
			}
			numbersPerRow = scanner.nextInt();
		} while (numbersPerRow >= columns);
		System.out.println("Enter max range for creating tickets:");
		int maxRange;
		do {
			System.out.println("Max range for creating tickets should be greater than product of numbers per row and rows");
			while (!scanner.hasNextInt()) {
				System.out.println("Invalid input try again. Max range should be a number");
				scanner.next();
			}
			maxRange = scanner.nextInt();
		} while (maxRange <= rows * numbersPerRow);
		GameRequest gameRequest = new GameRequest(players, maxRange, rows, columns, numbersPerRow);
		GameService gameService = new HousieGameService();
		gameService.initializeGame(gameRequest);
		scanner.close();
	}

}