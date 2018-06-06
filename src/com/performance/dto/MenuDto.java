package com.performance.dto;

import java.io.Serializable;

public class MenuDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5904978612583545257L;
	private String menuName;
	private String menuUrl;
	private int roleId;

	/**
	 * @return the menuName
	 */
	public String getMenuName() {
		return menuName;
	}

	/**
	 * @param menuName
	 *            the menuName to set
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	/**
	 * @return the menuUrl
	 */
	public String getMenuUrl() {
		return menuUrl;
	}

	/**
	 * @param menuUrl
	 *            the menuUrl to set
	 */
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	/**
	 * @return the roleId
	 */
	public int getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId
	 *            the roleId to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

}
