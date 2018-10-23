package com.company.hellospring.emp;

public class EmpDTO {

private String employeeId;
private String firstName;
private String lastName;
private	String email;
private	String	phoneNumber;
private	String	hireDate;
private	String	jobId;
private	String	salary;
private	String	commissionPct;
private	String	managerId;
private	String	departmentId;

public EmpDTO() {} //디폴트 생성자

public EmpDTO(String employeeId, String lastName, String email, String hireDate, String jobId) {
	super();
	this.employeeId = employeeId;
	this.lastName = lastName;
	this.email = email;
	this.hireDate = hireDate;
	this.jobId = jobId;
}
public String getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(String employeeId) {
	this.employeeId = employeeId;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getHireDate() {
	return hireDate;
}
public void setHireDate(String hireDate) {
	this.hireDate = hireDate;
}
public String getJobId() {
	return jobId;
}
public void setJobId(String jobId) {
	this.jobId = jobId;
}
public String getSalary() {
	return salary;
}
public void setSalary(String salary) {
	this.salary = salary;
}
public String getCommissionPct() {
	return commissionPct;
}
public void setCommissionPct(String commissionPct) {
	this.commissionPct = commissionPct;
}
public String getManagerId() {
	return managerId;
}
public void setManagerId(String managerId) {
	this.managerId = managerId;
}
public String getDepartmentId() {
	return departmentId;
}
public void setDepartmentId(String departmentId) {
	this.departmentId = departmentId;
}
@Override
public String toString() {
	return "EmpDTO [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
			+ email + ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate + ", jobId=" + jobId + ", salary="
			+ salary + ", commissionPct=" + commissionPct + ", managerId=" + managerId + ", departmentId="
			+ departmentId + "]";
}


}
