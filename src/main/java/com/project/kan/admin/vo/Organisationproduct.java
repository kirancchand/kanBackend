package com.project.kan.admin.vo;

public class Organisationproduct {
	
	private int organisation_product_id;
	private int f_organisation_id;
	private int f_product_id;
	private int product_price;
	private int product_qty;
	private String product_desc;
	
	public int getOrganisation_product_id() {
		return organisation_product_id;
	}
	public void setOrganisation_product_id(int organisation_product_id) {
		this.organisation_product_id = organisation_product_id;
	}
	public int getF_organisation_id() {
		return f_organisation_id;
	}
	public void setF_organisation_id(int f_organisation_id) {
		this.f_organisation_id = f_organisation_id;
	}
	public int getF_product_id() {
		return f_product_id;
	}
	public void setF_product_id(int f_product_id) {
		this.f_product_id = f_product_id;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public int getProduct_qty() {
		return product_qty;
	}
	public void setProduct_qty(int product_qty) {
		this.product_qty = product_qty;
	}
	public String getProduct_desc() {
		return product_desc;
	}
	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}
	

}
