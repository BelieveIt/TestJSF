package test;

import java.util.List;

import dao.Student;
import dao.StudentDaoImpl;

public class TestDao {
public static void main(String[] args){
	StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
	Student student = new Student();
	student.setAge("67");
	student.setName("Tom");
	Student student2 = new Student();
	student2.setAge("11");
	student2.setName("Jim");
	/**
	studentDaoImpl.insertStudent(student2);
	long insertIndex = student2.getStudentId();
	System.out.println(insertIndex);
	studentDaoImpl.insertStudent(student);
	long insertIndex = student.getStudentId();
	System.out.println(insertIndex);
	**/
	
	/**
	System.out.println(studentDaoImpl.queryStudentByStudentId(1));

	List<Student> students = studentDaoImpl.queryAllStudents();
	for (Student student3 : students) {
		System.out.println(student3);
	}
		
	System.out.println(studentDaoImpl.queryCountOfAllStudents());
	
	List<Student> students = studentDaoImpl.queryStudentsByNameOfStudent(student2);
	for (Student student3 : students) {
		System.out.println(student3);
	}	
	
	System.out.println(studentDaoImpl.queryCountOfStudentsByNameOfStudent(student2));

	List<Student> students = studentDaoImpl.queryStudentsByNameAndAgeOfStudent(student2);
	for (Student student3 : students) {
		System.out.println(student3);
	}	
	
	Student studentSelected = studentDaoImpl.queryStudentByStudentId(new Long(2));
	studentSelected.setAge("100");
	studentDaoImpl.updateStudentByStudentId(studentSelected);
	
	Student studentModel = new Student();
	studentModel.setName("Jim");
	studentModel.setAge("3");
	studentDaoImpl.updateAgeOfStudentToAgeOfStudentByNameofStudent(studentModel);
	**/
	
	
}
}
