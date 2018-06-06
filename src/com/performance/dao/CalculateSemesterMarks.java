package com.performance.dao;

public class CalculateSemesterMarks {

	public static int calculateCreditPoint(int points, int subjectCredit) {
		int creditPoint = 0;

		int point = points;
		int credit = subjectCredit;

		creditPoint = point * credit;

		return creditPoint;
	}

	public static String getLetterGrade(int points) {
		int point = points;

		String grade = "F";

		if (point == 10) {
			grade = "O";
		} else if (point == 9) {
			grade = "E";
		} else if (point == 8) {
			grade = "A";
		} else if (point == 7) {
			grade = "B";
		} else if (point == 6) {
			grade = "C";
		} else if (point == 5) {
			grade = "D";
		}
		return grade;
	}

	public static double calculateSgpa(int subjectCredit, int creditPoint) {
		double credit = (subjectCredit);
		double points = creditPoint;

		System.out.println("sgpa calculate");
		System.out.println(credit + " " + points);
		double sgpa = points / credit;

		return sgpa;
	}

}
