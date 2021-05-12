package com.customerlogservice.rest.springapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customerlog")
public class CustomerLog {
	@Id
	private String name;
	
	private String logType;
	private String id;
	private String date;
	private String time;
	
	protected CustomerLog() {
		
	}
	
	public CustomerLog(String name, String logType, String id, String date, String time) {
		super();
		this.name = name;
		this.logType = logType;
		this.id = id;
		this.date = date;
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "CustomerLog [name=" + name + ", logType=" + logType + ", id=" + id + ", date=" + date + ", time=" + time
				+ "]";
	}
	
	
	

}
