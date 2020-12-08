package com.sony.housie.dto;

public class GameRequest {

	private int numberOfPlayers;

	private int rangeMax;

	private int rows;

	private int columns;

	private int numbersPerRow;

	public GameRequest(int numberOfPlayers, int rangeMax, int rows, int columns, int numbersPerRow) {
		//set default values here, implement validation
		this.numberOfPlayers = numberOfPlayers;
		this.rangeMax = rangeMax;
		this.rows = rows;
		this.columns = columns;
		this.numbersPerRow = numbersPerRow;
	}

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

	public int getRangeMax() {
		return rangeMax;
	}

	public void setRangeMax(int rangeMax) {
		this.rangeMax = rangeMax;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public int getNumbersPerRow() {
		return numbersPerRow;
	}

	public void setNumbersPerRow(int numbersPerRow) {
		this.numbersPerRow = numbersPerRow;
	}

}
