package com.performance.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.performance.dto.AllocationDto;
import com.performance.dto.EditMarksDto;
import com.performance.dto.MarksDto;
import com.performance.dto.MarksDtoSubjectwise;
import com.performance.dto.MarksDtoTotal;
import com.performance.dto.StudentDto;
import com.performance.dto.SubjectDto;
import com.performance.dto.UserDto;

import dbUtil.DbUtil;

public class StudentDao {

	public static boolean addStudent(StudentDto studentDetails) {
		boolean result = false;
		DbUtil dbUtil = DbUtil.getInstance();

		try {
			Connection connection = (Connection) dbUtil.getDbConnection();
			String sql = "INSERT INTO student (\r\n" + "  rollNumber,\r\n" + "  firstName,\r\n" + "  lastName,\r\n"
					+ "  guardianName,\r\n" + "  addLine1,\r\n" + "  addLine2,\r\n" + "  city,\r\n" + "  state,\r\n"
					+ "  zipcode,\r\n" + "  country,\r\n" + "  phoneNumber,\r\n" + "  guardianPhoneNumber,\r\n"
					+ "  email,\r\n" + "  department,\r\n" + "sem," + "  extraCurricular,\r\n" + "  tag\r\n" + ")\r\n"
					+ "VALUES\r\n" + "  (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, studentDetails.getRollNumber());
			statement.setString(2, studentDetails.getFirstName());
			statement.setString(3, studentDetails.getLastName());
			statement.setString(4, studentDetails.getGuardianName());
			statement.setString(5, studentDetails.getAddLine1());
			statement.setString(6, studentDetails.getAddLine2());
			statement.setString(7, studentDetails.getCity());
			statement.setString(8, studentDetails.getState());
			statement.setString(9, studentDetails.getZipcode());
			statement.setString(10, studentDetails.getCountry());
			statement.setString(11, studentDetails.getPhoneNumber());
			statement.setString(12, studentDetails.getGuardianPhoneNumber());
			statement.setString(13, studentDetails.getEmail());
			statement.setInt(14, studentDetails.getDepartment());
			statement.setInt(15, studentDetails.getSem());
			statement.setString(16, studentDetails.getExtraCurricular());
			statement.setBoolean(17, true);

			int row = statement.executeUpdate();
			if (row > 0) {
				result = true;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return result;
	}

	public static List<StudentDto> getStudents(int sem, int departmentId) {

		List<StudentDto> studentsList = new ArrayList<>();

		DbUtil dbUtil = DbUtil.getInstance();

		try {
			Connection connection = (Connection) dbUtil.getDbConnection();
			String sql = "SELECT\r\n" + "  rollNumber,\r\n" + "  firstName,\r\n" + "  lastName,\r\n"
					+ "  guardianName,\r\n" + "  addLine1,\r\n" + "  addLine2,\r\n" + "  city,\r\n" + "  state,\r\n"
					+ "  zipcode,\r\n" + "  country,\r\n" + "  phoneNumber,\r\n" + "  guardianPhoneNumber,\r\n"
					+ "  email,\r\n" + "  department,\r\n" + "  sem,\r\n" + "  extraCurricular,\r\n" + "  tag\r\n"
					+ " FROM student WHERE sem=? AND department=? AND tag =1 ORDER BY rollNumber;";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, sem);
			statement.setInt(2, departmentId);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				StudentDto studentDto = new StudentDto();

				studentDto.setRollNumber(resultSet.getString("rollNumber"));
				studentDto.setFirstName(resultSet.getString("firstName"));
				studentDto.setLastName(resultSet.getString("lastName"));
				studentDto.setSem(resultSet.getInt("sem"));

				studentsList.add(studentDto);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return studentsList;
	}

	public static boolean updateStudent(StudentDto studentDetails) {
		boolean result = false;
		DbUtil dbUtil = DbUtil.getInstance();

		try {
			Connection connection = (Connection) dbUtil.getDbConnection();
			String sql = "UPDATE\r\n" + "  student\r\n" + "SET\r\n" + "  firstName = ?,\r\n" + "  lastName = ?,\r\n"
					+ "  guardianName = ?,\r\n" + "  addLine1 = ?,\r\n" + "  addLine2 = ?,\r\n" + "  city = ?,\r\n"
					+ "  state = ?,\r\n" + "  zipcode = ?,\r\n" + "  country = ?,\r\n" + "  phoneNumber = ?,\r\n"
					+ "  guardianPhoneNumber = ?,\r\n" + "  email = ?,\r\n" + "  department = ?,\r\n" + "sem=?,"
					+ "  extraCurricular = ?\r\n" + "WHERE rollNumber = ?";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, studentDetails.getFirstName());
			statement.setString(2, studentDetails.getLastName());
			statement.setString(3, studentDetails.getGuardianName());
			statement.setString(4, studentDetails.getAddLine1());
			statement.setString(5, studentDetails.getAddLine2());
			statement.setString(6, studentDetails.getCity());
			statement.setString(7, studentDetails.getState());
			statement.setString(8, studentDetails.getZipcode());
			statement.setString(9, studentDetails.getCountry());
			statement.setString(10, studentDetails.getPhoneNumber());
			statement.setString(11, studentDetails.getGuardianPhoneNumber());
			statement.setString(12, studentDetails.getEmail());
			statement.setInt(13, studentDetails.getDepartment());
			statement.setInt(14, studentDetails.getSem());
			statement.setString(15, studentDetails.getExtraCurricular());
			statement.setString(16, studentDetails.getRollNumber());

			int row = statement.executeUpdate();
			if (row > 0) {
				result = true;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		System.out.println("Update student Execution");

		return result;

	}

	public static List<SubjectDto> getSubject(int sem, int departmentId) {
		List<SubjectDto> subjectList = new ArrayList<>();

		DbUtil dbUtil = DbUtil.getInstance();

		try {
			Connection connection = (Connection) dbUtil.getDbConnection();

			String sql = "SELECT subjectCode,  subjectName FROM subjects s WHERE sem=? AND departmentId=? AND TYPE=1 ORDER BY s.serialNo;";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, sem);
			statement.setInt(2, departmentId);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				SubjectDto subjects = new SubjectDto();
				subjects.setSubjectCode(resultSet.getString("subjectCode"));
				subjects.setSubjectName(resultSet.getString("subjectName"));

				subjectList.add(subjects);

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return subjectList;
	}

	public static List<UserDto> getFaculty() {
		List<UserDto> facultyList = new ArrayList<>();

		DbUtil dbUtil = DbUtil.getInstance();

		try {
			Connection connection = (Connection) dbUtil.getDbConnection();

			String sql = "SELECT\r\n" + "  userId,\r\n" + "  firstName,\r\n" + "  lastName\r\n" + "FROM\r\n"
					+ "  users WHERE roleId=4 OR roleId=6 or roleId=3 AND tag=1;";

			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				UserDto faculty = new UserDto();

				faculty.setUserId(resultSet.getString("userId"));
				faculty.setFirstName(resultSet.getString("firstName"));
				faculty.setLastName(resultSet.getString("lastName"));

				facultyList.add(faculty);

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return facultyList;
	}

	public static boolean allocateSubject(SubjectDto subjectDto, UserDto userDto, int departmentId) {
		boolean result = false;

		DbUtil dbUtil = DbUtil.getInstance();

		try {
			Connection connection = (Connection) dbUtil.getDbConnection();
			String sql = "INSERT INTO subjectalocated (\r\n" + "  subjectCode,\r\n" + "  teacherId,\r\n"
					+ "  departmentId\r\n" + ")\r\n" + "VALUES (?,?,?);";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, subjectDto.getSubjectCode());
			statement.setString(2, userDto.getUserId());
			statement.setInt(3, departmentId);

			int row = statement.executeUpdate();
			if (row > 0) {
				result = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public static List<SubjectDto> getAllocatedSubject(String userId, int departmentId, int sem) {
		List<SubjectDto> subjectAllocated = new ArrayList<>();

		DbUtil dbUtil = DbUtil.getInstance();

		try {
			Connection connection = (Connection) dbUtil.getDbConnection();

			String sql = "SELECT   s.subjectCode,   s.subjectName FROM subjectalocated a, \r\n"
					+ "					 subjects s WHERE s.subjectCode=a.subjectCode AND s.type=1 AND "
					+ "  a.teacherId=?" + "AND s.departmentId=? AND s.sem=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userId);
			statement.setInt(2, departmentId);
			statement.setInt(3, sem);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				SubjectDto subject = new SubjectDto();

				subject.setSubjectCode(resultSet.getString("subjectCode"));
				subject.setSubjectName(resultSet.getString("subjectName"));

				subjectAllocated.add(subject);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subjectAllocated;
	}

	public static List<AllocationDto> viewAllocatedSubjects() {
		List<AllocationDto> allocatedSubjectList = new ArrayList<>();

		DbUtil dbUtil = DbUtil.getInstance();

		try {
			Connection connection = (Connection) dbUtil.getDbConnection();

			String sql = "SELECT    a.subjectCode,    s.subjectName,    u.firstName,\r\n"
					+ "u.lastName,a.departmentId, a.teacherId,    d.departmentName  FROM\r\n"
					+ "subjectalocated a, subjects s,users u,department d \r\n"
					+ "WHERE d.departmentId=a.departmentId AND d.departmentId=s.departmentId \r\n"
					+ "AND a.subjectCode=s.subjectCode AND u.userId=a.teacherId ORDER BY a.serialNo DESC";

			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				AllocationDto allocationDto = new AllocationDto();

				allocationDto.setSubjectCode(resultSet.getString("subjectCode"));
				allocationDto.setSubjectName(resultSet.getString("subjectName"));
				allocationDto.setFirstName(resultSet.getString("firstName"));
				allocationDto.setLastName(resultSet.getString("lastName"));
				allocationDto.setDepartmentName(resultSet.getString("departmentName"));
				allocationDto.setDepartmentId(resultSet.getInt("departmentId"));
				allocationDto.setTeacherId(resultSet.getString("teacherId"));

				allocatedSubjectList.add(allocationDto);

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return allocatedSubjectList;
	}

	public static boolean addMarks(MarksDto marks) {
		boolean result = false;
		DbUtil dbUtil = DbUtil.getInstance();

		try {
			Connection connection = (Connection) dbUtil.getDbConnection();
			String sql = "INSERT INTO marks (\r\n" + "  roll,\r\n" + "  sem,\r\n" + "  subjectCode,\r\n"
					+ "  internal1,\r\n" + "  internal2,\r\n" + "  classTest,\r\n" + "  assignment,\r\n" + "  mcq,\r\n"
					+ "  attendedClass,\r\n" + "  totalClass,\r\n" + "  attendencePercentage,\r\n" + "  tag\r\n"
					+ ")\r\n" + "VALUES\r\n" + "  (?,?,?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, marks.getRoll());
			statement.setInt(2, marks.getSem());
			statement.setString(3, marks.getSubjectCode());
			statement.setDouble(4, marks.getInternal1());
			statement.setDouble(5, marks.getInternal2());
			statement.setDouble(6, marks.getClassTest());
			statement.setDouble(7, marks.getAssignment());
			statement.setDouble(8, marks.getMcq());
			statement.setInt(9, marks.getAttendedClass());
			statement.setInt(10, marks.getTotalClasses());
			statement.setDouble(11, marks.getAttendence());
			statement.setBoolean(12, true);

			int row = statement.executeUpdate();
			if (row > 0) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public static List<SubjectDto> getAllocatedSubjectForEditMarks(String userId) {
		List<SubjectDto> subjectAllocated = new ArrayList<>();

		DbUtil dbUtil = DbUtil.getInstance();

		try {
			Connection connection = (Connection) dbUtil.getDbConnection();

			String sql = "SELECT s.subjectCode,s.subjectName FROM subjectalocated a,subjects s \r\n"
					+ "WHERE s.subjectCode=a.subjectCode AND s.type=1 AND a.teacherId=?;";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, userId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				SubjectDto subject = new SubjectDto();

				subject.setSubjectCode(resultSet.getString("subjectCode"));
				subject.setSubjectName(resultSet.getString("subjectName"));

				subjectAllocated.add(subject);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subjectAllocated;
	}

	public static EditMarksDto getMark(String rollNumber, String subjectCode) {

		EditMarksDto editMarksDto = new EditMarksDto();

		DbUtil dbUtil = DbUtil.getInstance();

		try {
			Connection connection = (Connection) dbUtil.getDbConnection();
			String sql = "SELECT\r\n" + "  m.roll,\r\n" + "  s.firstName,\r\n" + "  s.lastName,\r\n"
					+ "  d.departmentName,\r\n" + "  m.sem,\r\n" + "  subjectCode,\r\n" + "  internal1,\r\n"
					+ "  internal2,\r\n" + "classTest,\r\n" + "  assignment,\r\n" + "  mcq," + "  attendedClass,\r\n"
					+ "  totalClass,\r\n" + "  attendencePercentage\r\n" + "FROM\r\n"
					+ "  marks m, student s, department d WHERE m.roll=s.rollNumber AND s.department=d.departmentId AND m.roll=? AND subjectCode=?;";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, rollNumber);
			statement.setString(2, subjectCode);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				editMarksDto.setRollNumber(rs.getString("roll"));
				editMarksDto.setFirstName(rs.getString("firstName"));
				editMarksDto.setLastName(rs.getString("lastName"));
				editMarksDto.setDepartmentName(rs.getString("departmentName"));
				editMarksDto.setSem(rs.getInt("sem"));
				editMarksDto.setSubjectCode(rs.getString("subjectCode"));
				editMarksDto.setInternal1(rs.getInt("internal1"));
				editMarksDto.setInternal2(rs.getInt("internal2"));
				editMarksDto.setClassTest(rs.getInt("classTest"));
				editMarksDto.setAssignment(rs.getInt("assignment"));
				editMarksDto.setMcq(rs.getInt("mcq"));
				editMarksDto.setAttendedClass(rs.getInt("attendedClass"));
				editMarksDto.setTotalClass(rs.getInt("totalClass"));
				editMarksDto.setAttendencePercentage(rs.getDouble("attendencePercentage"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return editMarksDto;
	}

	public static boolean updateMarks(MarksDto markList) {

		boolean result = false;

		DbUtil dbUtil = DbUtil.getInstance();

		try {
			Connection connection = (Connection) dbUtil.getDbConnection();
			String sql = "UPDATE marks \r\n" + "	SET\r\n" + "	internal1 = ?, \r\n" + "	internal2 = ?, \r\n"
					+ "	classTest = ?, \r\n" + "	assignment = ?, \r\n" + "	mcq = ?, \r\n"
					+ "	attendedClass = ?, \r\n" + "	totalClass = ?, \r\n" + "	attendencePercentage = ?\r\n"
					+ "	WHERE\r\n" + "	roll = ? AND sem = ? AND subjectCode = ? ;";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setInt(1, markList.getInternal1());
			statement.setInt(2, markList.getInternal2());
			statement.setInt(3, markList.getClassTest());
			statement.setInt(4, markList.getAssignment());
			statement.setInt(5, markList.getMcq());
			statement.setInt(6, markList.getAttendedClass());
			statement.setInt(7, markList.getTotalClasses());
			statement.setDouble(8, markList.getAttendence());

			statement.setString(9, markList.getRoll());
			statement.setInt(10, markList.getSem());
			statement.setString(11, markList.getSubjectCode());

			int row = statement.executeUpdate();
			if (row > 0) {
				result = true;
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return result;
	}

	public static StudentDto getInformation(String rollNumber) {
		StudentDto studentDto = new StudentDto();
		DbUtil dbUtil = DbUtil.getInstance();

		try {
			Connection connection = (Connection) dbUtil.getDbConnection();
			String sql = "SELECT\r\n rollNumber," + "  firstName,\r\n" + "  lastName,\r\n" + "  guardianName,\r\n"
					+ "  addLine1,\r\n" + "  addLine2,\r\n" + "  city,\r\n" + "  state,\r\n" + "  zipcode,\r\n"
					+ "  country,\r\n" + "  phoneNumber,\r\n" + "  guardianPhoneNumber,\r\n" + "  email,\r\n"
					+ "  s.department,\r\n" + "sem," + "departmentName," + "  extraCurricular\r\n" + "FROM\r\n"
					+ "  student s, department d WHERE rollNumber=? and s.department=d.departmentId and tag=1;";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, rollNumber);

			System.out.println("roll number >>" + rollNumber);

			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				studentDto.setRollNumber(rs.getString("rollNumber"));
				studentDto.setFirstName(rs.getString("firstName"));
				studentDto.setLastName(rs.getString("lastName"));
				studentDto.setGuardianName(rs.getString("guardianName"));
				studentDto.setAddLine1(rs.getString("addLine1"));
				studentDto.setAddLine2(rs.getString("addLine2"));
				studentDto.setCity(rs.getString("city"));
				studentDto.setState(rs.getString("state"));
				studentDto.setZipcode(rs.getString("zipcode"));
				studentDto.setCountry(rs.getString("country"));
				studentDto.setPhoneNumber(rs.getString("phoneNumber"));
				studentDto.setGuardianPhoneNumber(rs.getString("guardianPhoneNumber"));
				studentDto.setEmail(rs.getString("email"));
				studentDto.setDepartment(rs.getInt("department"));
				studentDto.setSem(rs.getInt("sem"));
				studentDto.setExtraCurricular(rs.getString("extraCurricular"));

				studentDto.setDepartmentName(rs.getString("departmentName"));

				System.out.println("Fname: " + rs.getString("firstName"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentDto;
	}

	public static List<SubjectDto> getSubjects(int semester, int departmentId) {

		List<SubjectDto> subjectList = new ArrayList<>();

		DbUtil dbUtil = DbUtil.getInstance();

		try {
			Connection connection = (Connection) dbUtil.getDbConnection();

			String sql = "SELECT\r\n" + "  subjectCode,\r\n" + "  subjectName,\r\n" + "  departmentId,\r\n"
					+ "  TYPE,\r\n" + "  creditPoint,\r\n" + "  sem,\r\n" + "  tag\r\n" + "FROM\r\n"
					+ "  subjects s WHERE sem=? AND departmentId=? ORDER BY s.serialNo;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, semester);
			statement.setInt(2, departmentId);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				SubjectDto subject = new SubjectDto();

				subject.setSubjectCode(resultSet.getString("subjectCode"));
				subject.setSubjectName(resultSet.getString("subjectName"));
				subject.setDepartmentId(resultSet.getInt("departmentId"));
				subject.setType(resultSet.getInt("TYPE"));
				subject.setCreditPoint(resultSet.getInt("creditPoint"));
				subject.setSem(resultSet.getInt("sem"));

				subjectList.add(subject);

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return subjectList;
	}

	public static int getCredit(String subCode) {
		int credit = 0;

		DbUtil dbUtil = DbUtil.getInstance();

		try {
			Connection connection = (Connection) dbUtil.getDbConnection();
			String sql = "SELECT\r\n" + "  creditPoint\r\n" + "FROM\r\n" + "  subjects WHERE subjectCode=?;";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, subCode);

			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				credit = rs.getInt("creditPoint");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return credit;
	}

	public static boolean addFinalMarksSubjectWise(MarksDtoSubjectwise subjectwiseMarks) {
		boolean result = false;

		DbUtil dbUtil = DbUtil.getInstance();

		try {
			Connection connection = (Connection) dbUtil.getDbConnection();
			String sql = "INSERT INTO marks_subjectwise (\r\n" + "  roll,\r\n" + "  sem,\r\n" + "  subjectCode,\r\n"
					+ "  pointsGot,\r\n" + "  subjectCredit,\r\n" + "  creditPoints,\r\n" + "  letterGrade\r\n"
					+ ")\r\n" + "VALUES\r\n" + "  (?,?,?,?,?,?,?);";
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, subjectwiseMarks.getRoll());
			statement.setInt(2, subjectwiseMarks.getSem());
			statement.setString(3, subjectwiseMarks.getSubjectCode());
			statement.setInt(4, subjectwiseMarks.getPoints());
			statement.setInt(5, subjectwiseMarks.getSubjectCredit());
			statement.setInt(6, subjectwiseMarks.getCreditPoints());
			statement.setString(7, subjectwiseMarks.getLetterGrade());

			int row = statement.executeUpdate();
			if (row > 0) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public static MarksDtoTotal getTotalMarks(String roll, int semester) {
		MarksDtoTotal totalMarks = new MarksDtoTotal();

		DbUtil dbUtil = DbUtil.getInstance();

		try {
			Connection connection = (Connection) dbUtil.getDbConnection();
			String sql = "SELECT\r\n" + "  roll,\r\n" + "  sem,\r\n" + "  totalCredit,\r\n" + "  totalCreditPoints,\r\n"
					+ "  sgpa\r\n" + "FROM\r\n" + "  marks_total WHERE roll=? AND sem=?;";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, roll);
			statement.setInt(2, semester);

			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				totalMarks.setRoll(rs.getString("roll"));
				totalMarks.setSem(rs.getInt("sem"));
				totalMarks.setTotalCredit(rs.getInt("totalCredit"));
				totalMarks.setTotalCreditPoints(rs.getInt("totalCreditPoints"));
				totalMarks.setSgpa((float) rs.getDouble("sgpa"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return totalMarks;
	}

	public static void insertTotalMarks(MarksDtoTotal totalMarks) {

		DbUtil dbUtil = DbUtil.getInstance();

		try {
			Connection connection = (Connection) dbUtil.getDbConnection();
			String sql = "INSERT INTO marks_total (\r\n" + "  roll,\r\n" + "  sem,\r\n" + "  totalCredit,\r\n"
					+ "  totalCreditPoints,\r\n" + "  sgpa\r\n" + ")\r\n" + "VALUES\r\n" + "  (?,?,?,?,?);";
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, totalMarks.getRoll());
			statement.setInt(2, totalMarks.getSem());
			statement.setInt(3, totalMarks.getTotalCredit());
			statement.setInt(4, totalMarks.getTotalCreditPoints());
			statement.setDouble(5, totalMarks.getSgpa());

			statement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void updateFinalMarks(MarksDtoTotal totalMarks) {

		DbUtil dbUtil = DbUtil.getInstance();

		try {
			Connection connection = (Connection) dbUtil.getDbConnection();
			String sql = "UPDATE\r\n" + "  marks_total\r\n" + "SET\r\n" + "  totalCredit = ?,\r\n"
					+ "  totalCreditPoints = ?,\r\n" + "  sgpa = ?\r\n" + "WHERE roll = ?\r\n" + "  AND sem = ?;";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setInt(1, totalMarks.getTotalCredit());
			statement.setInt(2, totalMarks.getTotalCreditPoints());
			statement.setDouble(3, totalMarks.getSgpa());
			statement.setString(4, totalMarks.getRoll());
			statement.setInt(5, totalMarks.getSem());

			statement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public static boolean getTotalMarkList(String roll, int semester) {
		boolean markList = false;

		DbUtil dbUtil = DbUtil.getInstance();

		try {
			Connection connection = (Connection) dbUtil.getDbConnection();
			String sql = "SELECT\r\n" + "  roll,\r\n" + "  sem,\r\n" + "  totalCredit,\r\n" + "  totalCreditPoints,\r\n"
					+ "  sgpa\r\n" + "FROM\r\n" + "  marks_total WHERE roll=? AND sem=?;";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, roll);
			statement.setInt(2, semester);

			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				MarksDtoTotal totalMarks = new MarksDtoTotal();

				totalMarks.setRoll(rs.getString("roll"));
				totalMarks.setSem(rs.getInt("sem"));
				totalMarks.setTotalCredit(rs.getInt("totalCredit"));
				totalMarks.setTotalCreditPoints(rs.getInt("totalCreditPoints"));
				totalMarks.setSgpa(rs.getDouble("sgpa"));

				markList = true;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return markList;
	}

	public static List<MarksDtoTotal> getMarksInformation(String rollNumber) {
		List<MarksDtoTotal> markList = new ArrayList<>();

		DbUtil dbUtil = DbUtil.getInstance();

		try {
			Connection connection = (Connection) dbUtil.getDbConnection();
			String sql = "SELECT\r\n" + "  roll,\r\n" + "  sem,\r\n" + "  totalCredit,\r\n" + "  totalCreditPoints,\r\n"
					+ "  sgpa\r\n" + "FROM\r\n" + "  marks_total WHERE roll=?;";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, rollNumber);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				MarksDtoTotal marks = new MarksDtoTotal();

				marks.setRoll(rs.getString("roll"));
				marks.setSem(rs.getInt("sem"));
				marks.setTotalCredit(rs.getInt("totalCredit"));
				marks.setTotalCreditPoints(rs.getInt("totalCreditPoints"));
				marks.setSgpa(rs.getDouble("sgpa"));

				markList.add(marks);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return markList;
	}

	public static List<StudentDto> getInformations(int department, int sem) {
		List<StudentDto> infoList = new ArrayList<>();
		DbUtil dbUtil = DbUtil.getInstance();

		try {
			Connection connection = (Connection) dbUtil.getDbConnection();
			String sql = "SELECT\r\n rollNumber," + "  firstName,\r\n" + "  lastName,\r\n" + "  guardianName,\r\n"
					+ "  addLine1,\r\n" + "  addLine2,\r\n" + "  city,\r\n" + "  state,\r\n" + "  zipcode,\r\n"
					+ "  country,\r\n" + "  phoneNumber,\r\n" + "  guardianPhoneNumber,\r\n" + "  email,\r\n"
					+ "  s.department,\r\n" + "sem," + "departmentName," + "  extraCurricular\r\n" + "FROM\r\n"
					+ "  student s, department d WHERE department=? and sem=? and s.department=d.departmentId and tag=1;";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, department);
			statement.setInt(2, sem);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				StudentDto studentDto = new StudentDto();

				studentDto.setRollNumber(rs.getString("rollNumber"));
				studentDto.setFirstName(rs.getString("firstName"));
				studentDto.setLastName(rs.getString("lastName"));
				studentDto.setGuardianName(rs.getString("guardianName"));
				studentDto.setAddLine1(rs.getString("addLine1"));
				studentDto.setAddLine2(rs.getString("addLine2"));
				studentDto.setCity(rs.getString("city"));
				studentDto.setState(rs.getString("state"));
				studentDto.setZipcode(rs.getString("zipcode"));
				studentDto.setCountry(rs.getString("country"));
				studentDto.setPhoneNumber(rs.getString("phoneNumber"));
				studentDto.setGuardianPhoneNumber(rs.getString("guardianPhoneNumber"));
				studentDto.setEmail(rs.getString("email"));
				studentDto.setDepartment(rs.getInt("department"));
				studentDto.setSem(rs.getInt("sem"));
				studentDto.setExtraCurricular(rs.getString("extraCurricular"));

				studentDto.setDepartmentName(rs.getString("departmentName"));

				infoList.add(studentDto);

				System.out.println(studentDto.getRollNumber());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return infoList;
	}

	public static List<MarksDtoSubjectwise> getSubjectWiseMark(String rollNumber, int semester) {
		List<MarksDtoSubjectwise> subjectWiseMarkList = new ArrayList<>();

		DbUtil dbUtil = DbUtil.getInstance();

		try {
			Connection connection = (Connection) dbUtil.getDbConnection();
			String sql = "SELECT\r\n" + "  ms.subjectCode,\r\n" + "  s.subjectName,\r\n" + "  ms.pointsGot,\r\n"
					+ "  ms.subjectCredit,\r\n" + "  ms.creditPoints,\r\n" + "  ms.letterGrade\r\n" + "FROM\r\n"
					+ "  marks_subjectwise ms, subjects s, \r\n"
					+ "  student stu WHERE ms.subjectCode=s.subjectCode \r\n"
					+ "  AND stu.department=s.departmentId AND stu.rollNumber=ms.roll \r\n"
					+ "  AND roll=? AND ms.sem=? ORDER BY s.serialNo;;";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, rollNumber);
			statement.setInt(2, semester);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				MarksDtoSubjectwise mark = new MarksDtoSubjectwise();

				mark.setSubjectCode(rs.getString("subjectCode"));
				mark.setSubjectName(rs.getString("subjectName"));
				mark.setPoints(rs.getInt("pointsGot"));
				mark.setSubjectCredit(rs.getInt("subjectCredit"));
				mark.setCreditPoints(rs.getInt("creditPoints"));
				mark.setLetterGrade(rs.getString("letterGrade"));

				subjectWiseMarkList.add(mark);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return subjectWiseMarkList;
	}

	public static List<MarksDto> getInternalMarks(String rollNumber, int semester) {
		List<MarksDto> internalMarkList = new ArrayList<MarksDto>();

		DbUtil dbUtil = DbUtil.getInstance();

		try {
			Connection connection = (Connection) dbUtil.getDbConnection();
			String sql = "SELECT\r\n" + "  m.subjectCode,\r\n" + "  sub.subjectName,\r\n" + "  m.internal1,\r\n"
					+ "  m.internal2,\r\n" + "  m.classTest,\r\n" + "  m.assignment,\r\n" + "  m.mcq,\r\n"
					+ "  m.attendedClass,\r\n" + "  m.totalClass,\r\n" + "  m.attendencePercentage\r\n" + "FROM\r\n"
					+ "  marks m, subjects sub, student stu \r\n" + "  WHERE m.subjectCode=sub.subjectCode \r\n"
					+ "  AND stu.department=sub.departmentId AND stu.rollNumber=m.roll \r\n"
					+ "  AND roll=? AND m.sem=? ORDER BY sub.serialNo;";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, rollNumber);
			statement.setInt(2, semester);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				MarksDto classMarks = new MarksDto();

				classMarks.setSubjectCode(rs.getString("subjectCode"));
				classMarks.setSubjectName(rs.getString("subjectName"));
				classMarks.setInternal1(rs.getInt("internal1"));
				classMarks.setInternal2(rs.getInt("internal2"));
				classMarks.setClassTest(rs.getInt("classTest"));
				classMarks.setAssignment(rs.getInt("assignment"));
				classMarks.setMcq(rs.getInt("mcq"));
				classMarks.setAttendedClass(rs.getInt("attendedClass"));
				classMarks.setTotalClasses(rs.getInt("totalClass"));
				classMarks.setAttendence((int) rs.getDouble("attendencePercentage"));

				internalMarkList.add(classMarks);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return internalMarkList;

	}

}
