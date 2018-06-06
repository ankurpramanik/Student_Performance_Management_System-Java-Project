package com.performance.dto;

@SuppressWarnings("serial")
public class EditMarksDto extends AssinmentDto {
	private String rollNumber;
	private String firstName;
	private String lastName;
	private String departmentName;
	private int sem;
	private String subjectCode;
	private int internal1;
	private int internal2;
	private int attendedClass;
	private int totalClass;
	private double attendencePercentage;

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
	 * @return the departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * @param departmentName
	 *            the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
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

	/**
	 * @return the subjectCode
	 */
	public String getSubjectCode() {
		return subjectCode;
	}

	/**
	 * @param subjectCode
	 *            the subjectCode to set
	 */
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	/**
	 * @return the internal1
	 */
	public int getInternal1() {
		return internal1;
	}

	/**
	 * @param internal1
	 *            the internal1 to set
	 */
	public void setInternal1(int internal1) {
		this.internal1 = internal1;
	}

	/**
	 * @return the internal2
	 */
	public int getInternal2() {
		return internal2;
	}

	/**
	 * @param internal2
	 *            the internal2 to set
	 */
	public void setInternal2(int internal2) {
		this.internal2 = internal2;
	}

	/**
	 * @return the attendedClass
	 */
	public int getAttendedClass() {
		return attendedClass;
	}

	/**
	 * @param attendedClass
	 *            the attendedClass to set
	 */
	public void setAttendedClass(int attendedClass) {
		this.attendedClass = attendedClass;
	}

	/**
	 * @return the totalClass
	 */
	public int getTotalClass() {
		return totalClass;
	}

	/**
	 * @param totalClass
	 *            the totalClass to set
	 */
	public void setTotalClass(int totalClass) {
		this.totalClass = totalClass;
	}

	/**
	 * @return the attendencePercentage
	 */
	public double getAttendencePercentage() {
		return attendencePercentage;
	}

	/**
	 * @param attendencePercentage
	 *            the attendencePercentage to set
	 */
	public void setAttendencePercentage(double attendencePercentage) {
		this.attendencePercentage = attendencePercentage;
	}

}
