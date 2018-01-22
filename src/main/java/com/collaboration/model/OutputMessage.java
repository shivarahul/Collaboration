package com.collaboration.model;

import java.util.Date;

public class OutputMessage {

	
	
	private Date time;

	public OutputMessage(Message original, Date time) {
		super();
		this.time = time;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
}
