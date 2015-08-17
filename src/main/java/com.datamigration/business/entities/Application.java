package com.datamigration.business.entities;

public class Application {
	private String appName = null;
	private String apiKey = null;

	public Application() {
		super();
	}
	public void setAppName(String appName){
		this.appName=appName;
	}
	public String getAppName(){
		return this.appName;
	}
	public void setApiKey(String apiKey){
		this.apiKey=apiKey;
	}
	public String getApiKey(){
		return this.apiKey;
	}
}