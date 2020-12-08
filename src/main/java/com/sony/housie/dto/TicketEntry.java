package com.sony.housie.dto;

public class TicketEntry {

	private int number;
	private boolean isCalled;

	public TicketEntry(int number, boolean isCalled) {
		this.number = number;
		this.isCalled = isCalled;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean isCalled() {
		return isCalled;
	}

	public void setCalled(boolean isCalled) {
		this.isCalled = isCalled;
	}

	@Override
	public String toString() {
		return "TicketEntry [number=" + number + ", isCalled=" + isCalled + "]";
	}
	
	

}
