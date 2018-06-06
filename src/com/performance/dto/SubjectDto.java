package com.performance.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SubjectDto implements Serializable {
	private String subjectCode;
	private String subjectName;
	private int departmentId;
	private int type;
	private int creditPoint;
	private int sem;
	private boolean tag;

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
	 * @return the subjectName
	 */
	public String getSubjectName() {
		return subjectName;
	}

	/**
	 * @param subjectName
	 *            the subjectName to set
	 */
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	/**
	 * @return the departmentId
	 */
	public int getDepartmentId() {
		return departmentId;
	}

	/**
	 * @param departmentId
	 *            the departmentId to set
	 */
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the creditPoint
	 */
	public int getCreditPoint() {
		return creditPoint;
	}

	/**
	 * @param creditPoint
	 *            the creditPoint to set
	 */
	public void setCreditPoint(int creditPoint) {
		this.creditPoint = creditPoint;
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

}