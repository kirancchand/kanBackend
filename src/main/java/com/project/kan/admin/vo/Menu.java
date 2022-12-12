package com.project.kan.admin.vo;

public class Menu {
	
	private int menu_id;
	private String menu;
	private int parent_id;
	private String controller_name;
	private String icon;
	private int position;
	private int f_status_id;
	private int f_menutype_id;
	
	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public String getController_name() {
		return controller_name;
	}
	public void setController_name(String controller_name) {
		this.controller_name = controller_name;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public int getF_status_id() {
		return f_status_id;
	}
	public void setF_status_id(int f_status_id) {
		this.f_status_id = f_status_id;
	}
	public int getF_menutype_id() {
		return f_menutype_id;
	}
	public void setF_menutype_id(int f_menutype_id) {
		this.f_menutype_id = f_menutype_id;
	}
	
}
