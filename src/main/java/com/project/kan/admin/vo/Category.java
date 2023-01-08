package com.project.kan.admin.vo;

public class Category {
	private String category;
	private int category_id;
	private String categorytheme;
	private int parent_id;
	private String category_image;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getCategorytheme() {
		return categorytheme;
	}
	public void setCategorytheme(String categorytheme) {
		this.categorytheme = categorytheme;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public String getCategory_image() {
		return category_image;
	}
	public void setCategory_image(String category_image) {
		this.category_image = category_image;
	}
}
