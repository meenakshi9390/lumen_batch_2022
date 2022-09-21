package com.training.model;



// Comparable type ka bana rahe hain so we need a comparator inc



public class Student implements Comparable<Student> {
       private String studentName;
       private String studentRollNumber;
       private int studentAge;
       private double studentPhoneNumber;
       private String studentcity;
	

 
    public Student() {
		super();
		// TODO Auto-generated constructor stub
	}







	public Student(String studentName, String studentRollNumber, int studentAge, double studentPhoneNumber, String city) {
		super();
		this.studentName = studentName;
		this.studentRollNumber = studentRollNumber;
		this.studentAge = studentAge;
		this.studentPhoneNumber = studentPhoneNumber;
		this.studentcity = city;
	}







	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", studentRollNumber=" + studentRollNumber + ", studentAge="
				+ studentAge + ", studentPhoneNumber=" + studentPhoneNumber + ", city=" + studentcity + "]";
	}







	public String getStudentName() {
		return studentName;
	}







	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}







	public String getStudentRollNumber() {
		return studentRollNumber;
	}







	public void setStudentRollNumber(String studentRollNumber) {
		this.studentRollNumber = studentRollNumber;
	}







	public int getStudentAge() {
		return studentAge;
	}







	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}







	public double getStudentPhoneNumber() {
		return studentPhoneNumber;
	}







	public void setStudentPhoneNumber(double studentPhoneNumber) {
		this.studentPhoneNumber = studentPhoneNumber;
	}







	public String getCity() {
		return studentcity;
	}







	public void setCity(String city) {
		this.studentcity = city;
	}







	







@Override
public int compareTo(Student o) {
	// TODO Auto-generated method stub
	return 0;
}







public String getStudentCity() {
	// TODO Auto-generated method stub
	return null;
}



}