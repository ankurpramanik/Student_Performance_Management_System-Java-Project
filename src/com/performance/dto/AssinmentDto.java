package com.performance.dto;

@SuppressWarnings("serial")
public class AssinmentDto extends SubjectDto {

	private int classTest;
	private int assignment;
	private int mcq;

	/**
	 * @return the classTest
	 */
	public int getClassTest() {
		return classTest;
	}

	/**
	 * @param classTest
	 *            the classTest to set
	 */
	public void setClassTest(int classTest) {
		this.classTest = classTest;
	}

	/**
	 * @return the assignment
	 */
	public int getAssignment() {
		return assignment;
	}

	/**
	 * @param assignment
	 *            the assignment to set
	 */
	public void setAssignment(int assignment) {
		this.assignment = assignment;
	}

	/**
	 * @return the mcq
	 */
	public int getMcq() {
		return mcq;
	}

	/**
	 * @param mcq
	 *            the mcq to set
	 */
	public void setMcq(int mcq) {
		this.mcq = mcq;
	}
}