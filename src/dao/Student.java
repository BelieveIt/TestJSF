package dao;

public class Student {
private Long studentId;
private String name;
private String age;
public Long getStudentId() {
	return studentId;
}
public void setStudentId(Long studentId) {
	this.studentId = studentId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}
@Override
public String toString(){
	return "studentId:"+studentId+" name:"+name+" age:"+age;
}
}
