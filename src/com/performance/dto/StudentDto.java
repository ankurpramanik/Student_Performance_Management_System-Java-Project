package com.performance.dto;

@SuppressWarnings("serial")
public class StudentDto extends DepartmentDto {
	private String rollNumber;
	private String firstName;
	private String lastName;
	private String guardianName;
	private String addLine1;
	private String addLine2;
	private String city;
	private String state;
	private String zipcode;
	private String country;
	private String phoneNumber;
	private String guardianPhoneNumber;
	private String email;
	private int department;
	private int sem;
	private String extraCurricular;
	private boolean tag;

	/**
	 * @return the rollNumber
	 */
	public String getRollNumber() {
		return rollNumber;
	}

	/**
	 * @param rollNumber
	 *            the rollNumber to set
	 */
	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
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
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the guardianName
	 */
	public String getGuardianName() {
		return guardianName;
	}

	/**
	 * @param guardianName
	 *            the guardianName to set
	 */
	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}

	/**
	 * @return the addLine1
	 */
	public String getAddLine1() {
		return addLine1;
	}

	/**
	 * @param addLine1
	 *            the addLine1 to set
	 */
	public void setAddLine1(String addLine1) {
		this.addLine1 = addLine1;
	}

	/**
	 * @return the addLine2
	 */
	public String getAddLine2() {
		return addLine2;
	}

	/**
	 * @param addLine2
	 *            the addLine2 to set
	 */
	public void setAddLine2(String addLine2) {
		this.addLine2 = addLine2;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}

	/**
	 * @param zipcode
	 *            the zipcode to set
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the guardianPhoneNumber
	 */
	public String getGuardianPhoneNumber() {
		return guardianPhoneNumber;
	}

	/**
	 * @param guardianPhoneNumber
	 *            the guardianPhoneNumber to set
	 */
	public void setGuardianPhoneNumber(String guardianPhoneNumber) {
		this.guardianPhoneNumber = guardianPhoneNumber;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the department
	 */
	public int getDepartment() {
		return department;
	}

	/**
	 * @param i
	 *            the department to set
	 */
	public void setDepartment(int i) {
		this.department = i;
	}

	/**
	 * @return the extraCurricular
	 */
	public String getExtraCurricular() {
		return extraCurricular;
	}

	/**
	 * @param extraCurricular
	 *            the extraCurricular to set
	 */
	public void setExtraCurricular(String extraCurricular) {
		this.extraCurricular = extraCurricular;
	}

	/**
	 * @return the tag
	 */
	public boolean isTag() {
		return tag;
	}

	/**
	 * @param tag
	 *            the tag to set
	 */
	public void setTag(boolean tag) {
		this.tag = tag;
	}

	/**
	 * @return the sem
	 */
	public int getSem() {
		return sem;
	}

	/**
	 * @param sem
	 *            the sem to set
	 */
	public void setSem(int sem) {
		this.sem = sem;
	}

}
