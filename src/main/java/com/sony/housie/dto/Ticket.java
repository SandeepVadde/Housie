package com.sony.housie.dto;

import java.util.Arrays;
import java.util.UUID;

public class Ticket {

	private String ticketId;

	private int rows;

	private int columns;

	private int rangeMax;
	
	private int markedCount;
	
	private TicketEntry[][] ticketEntries;

	public Ticket(int rows, int columns, int rangeMax, TicketEntry[][] ticketEntries) {
		this.ticketId = UUID.randomUUID().toString();
		this.rows=rows;
		this.columns =columns;
		this.rangeMax =rangeMax;
		this.ticketEntries  = ticketEntries;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
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

	public int getRangeMax() {
		return rangeMax;
	}

	public void setRangeMax(int rangeMax) {
		this.rangeMax = rangeMax;
	}

	public TicketEntry[][] getTicketEntries() {
		return ticketEntries;
	}

	public void setTicketEntries(TicketEntry[][] ticketEntries) {
		this.ticketEntries = ticketEntries;
	}

	public int getMarkedCount() {
		return markedCount;
	}

	public void setMarkedCount(int markedCount) {
		this.markedCount = markedCount;
	}

	public int incrementMarkedcount() {
		markedCount++;
		return markedCount;
		
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", rows=" + rows + ", columns=" + columns + ", rangeMax=" + rangeMax
				+ ", markedCount=" + markedCount + ", ticketEntries=" + Arrays.toString(ticketEntries) + "]";
	}


	
	
}
