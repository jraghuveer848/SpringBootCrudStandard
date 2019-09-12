package com.raghu.personal.exception;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorDetails {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy hh:mm:ss aaa")
	  private Date timestamp;
	  private String message;
	  private String description;

	public Date getTimestamp() {
	 return timestamp;
	}

	public String getMessage() {
	    return message;
	  }

	public String getDescription() {
	 return description;
	}

	public ErrorDetails(Date timestamp, String message, String description) {
	     super();
	     this.timestamp = timestamp;
	     this.message = message;
	     this.description = description;
	   }

}
