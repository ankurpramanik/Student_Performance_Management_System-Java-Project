package com.performance.dao;

public class CalculateAttendencePercentage {

	public static double calculatePrcentage(int attendedClass, int totalClasses) {

		double a = attendedClass;
		double t = totalClasses;

		double percentage = (a / t) * 100;

		return percentage;
	}

}
