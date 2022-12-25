package com.project.kan.admin.vo;

public class Migrations {
	
	private int id;
	private String migration;
	private int batch;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMigration() {
		return migration;
	}
	public void setMigration(String migration) {
		this.migration = migration;
	}
	public int getBatch() {
		return batch;
	}
	public void setBatch(int batch) {
		this.batch = batch;
	}

}
