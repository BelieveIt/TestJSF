package dao;

import java.util.List;

public interface StudentDao {
public void insertStudent(Student student);

public Student queryStudentByStudentId(Long studentId);
public List<Student> queryAllStudents();
public Long queryCountOfAllStudents();
public List<Student> queryStudentsByNameOfStudent(Student student);
public Long queryCountOfStudentsByNameOfStudent(Student student);
public List<Student> queryStudentsByNameAndAgeOfStudent(Student student);

public void updateStudentByStudentId(Student student);
public int updateAgeOfStudentToAgeOfStudentByNameofStudent(Student student);
}
