package com.performance.dto;

public class EmailDto {

	private int slNo;
	private String firstName;
	private String lastName;
	private String email;
	private String subject;
	private String messege;
	private boolean tag;
	
	/**
	 * @return the slNo
	 */
	public int getSlNo() {
		return slNo;
	}
	/**
	 * @param slNo the slNo to set
	 */
	public void setSlNo(int slNo) {
		this.slNo = slNo;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * @return the messege
	 */
	public String getMessege() {
		return messege;
	}
	/**
	 * @param messege the messege to set
	 */
	public void setMessege(String messege) {
		this.messege = messege;
	}
	/**
	 * @return the tag
	 */
	public boolean isTag() {
		return tag;
	}
	/**
	 * @param tag the tag to set
	 */
	public void setTag(boolean tag) {
		this.tag = tag;
	}
	

}
