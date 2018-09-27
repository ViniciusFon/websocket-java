package br.com.demowebsocket.model;

import java.io.Serializable;

public class WSMessage implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private String action;
	private String type;
	private String value;
	private String params;
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	
	
}
