package com.performance.dto;

@SuppressWarnings("serial")
public class MarksDtoSubjectwise extends SubjectDto {

	private String roll;
	private int sem;
	private String subjectCode;
	private int subjectCredit;
	private int points;
	private int creditPoints;
	private String letterGrade;

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
	 * @return the subjectCredit
	 */
	public int getSubjectCredit() {
		return subjectCredit;
	}

	/**
	 * @param subjectCredit
	 *            the subjectCredit to set
	 */
	public void setSubjectCredit(int subjectCredit) {
		this.subjectCredit = subjectCredit;
	}

	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * @param points
	 *            the points to set
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * @return the creditPoints
	 */
	public int getCreditPoints() {
		return creditPoints;
	}

	/**
	 * @param creditPoints
	 *            the creditPoints to set
	 */
	public void setCreditPoints(int creditPoints) {
		this.creditPoints = creditPoints;
	}

	/**
	 * @return the letterGrade
	 */
	public String getLetterGrade() {
		return letterGrade;
	}

	/**
	 * @param letterGrade
	 *            the letterGrade to set
	 */
	public void setLetterGrade(String letterGrade) {
		this.letterGrade = letterGrade;
	}

}
