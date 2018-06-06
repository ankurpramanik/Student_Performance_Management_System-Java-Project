package com.performance.dto;

public class MarksDtoTotal {
	private String roll;
	private int sem;
	private int totalCredit;
	private int totalCreditPoints;
	private double sgpa;

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
	 * @return the totalCredit
	 */
	public int getTotalCredit() {
		return totalCredit;
	}

	/**
	 * @param totalCredit
	 *            the totalCredit to set
	 */
	public void setTotalCredit(int totalCredit) {
		this.totalCredit = totalCredit;
	}

	/**
	 * @return the totalCreditPoints
	 */
	public int getTotalCreditPoints() {
		return totalCreditPoints;
	}

	/**
	 * @param totalCreditPoints
	 *            the totalCreditPoints to set
	 */
	public void setTotalCreditPoints(int totalCreditPoints) {
		this.totalCreditPoints = totalCreditPoints;
	}

	/**
	 * @return the sgpa
	 */
	public double getSgpa() {
		return sgpa;
	}

	/**
	 * @param sgpa
	 *            the sgpa to set
	 */
	public void setSgpa(double sgpa) {
		this.sgpa = sgpa;
	}

}
