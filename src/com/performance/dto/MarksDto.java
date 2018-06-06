package com.performance.dto;

@SuppressWarnings("serial")
public class MarksDto extends AssinmentDto{
	private String roll;
	private int sem;
	private String subjectCode;
	private int totalClasses;
	private int attendedClass;
	private double attendence;
	private int internal1;
	private int internal2;
	private boolean tag;

	/**
	 * @return the roll
	 */
	public String getRoll() {
		return roll;
	}

	/**
	 * @param roll
	 *            the roll to set
	 */
	public void setRoll(String roll) {
		this.roll = roll;
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
	 * @return the attendence
	 */
	public double getAttendence() {
		return attendence;
	}

	/**
	 * @param attendence
	 *            the attendence to set
	 */
	public void setAttendence(double attendence) {
		this.attendence = attendence;
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
	 * @return the totalClasses
	 */
	public int getTotalClasses() {
		return totalClasses;
	}

	/**
	 * @param totalClasses
	 *            the totalClasses to set
	 */
	public void setTotalClasses(int totalClasses) {
		this.totalClasses = totalClasses;
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

}
