package com.ticketbooking.ticketBooking.entity;


public class TicketRequest {
    private String from;
    private String to;
    private String userName;
    
	public TicketRequest(String string, String string2, String string3, String string4) {
		// TODO Auto-generated constructor stub
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	private String userEmail;

}

