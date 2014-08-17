package dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class StudentDaoImpl implements StudentDao{
private JdbcTemplate jdbcTemplate;
private SimpleJdbcInsert simpleJdbcInsert;
private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
public StudentDaoImpl(){
	jdbcTemplate = new JdbcTemplate(DaoUtil.getDataSource());
	simpleJdbcInsert = new SimpleJdbcInsert(DaoUtil.getDataSource())
	.withTableName("student")
	.usingGeneratedKeyColumns("student_id");
	namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(DaoUtil.getDataSource());
}
@Override
public void insertStudent(Student student) {
	Map<String, Object> parameters = new HashMap<String, Object>();
	parameters.put("name", student.getName());
	parameters.put("age", student.getAge());
	Number newId = simpleJdbcInsert.executeAndReturnKey(parameters);
	student.setStudentId(newId.longValue());
}
@Override
public Student queryStudentByStudentId(Long studentId){
	String sql = "select student_id, name, age from student where student_id = :student_id";
	SqlParameterSource sqlParameterSource = new MapSqlParameterSource("student_id", studentId);
	return namedParameterJdbcTemplate.queryForObject(sql, sqlParameterSource, new StudentMapper());
}
@Override
public List<Student> queryAllStudents(){
	String sql = "select student_id, name, age from student";
	return jdbcTemplate.query(sql, new StudentMapper());
}
@Override
public Long queryCountOfAllStudents() {
	String sql = "select count(*) from student";
	return jdbcTemplate.queryForObject(sql, Long.class);
}
@Override
public List<Student> queryStudentsByNameOfStudent(Student student){
	String sql = "select student_id, name, age from student where name = :name";
	SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(student);
	return namedParameterJdbcTemplate.query(sql, sqlParameterSource, new StudentMapper());
}
@Override
public Long queryCountOfStudentsByNameOfStudent(Student student) {
	String sql = "select count(*) from student where name = :name";
	SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(student);
	return namedParameterJdbcTemplate.queryForObject(sql, sqlParameterSource, Long.class);
}
@Override
public List<Student> queryStudentsByNameAndAgeOfStudent(Student student){
	String sql = "select student_id, name, age from student where name = :name and age = :age";
	SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(student);
	return namedParameterJdbcTemplate.query(sql, sqlParameterSource, new StudentMapper());
}
@Override
public void updateStudentByStudentId(Student student){
	String sql = "update student set name = :name, age = :age where student_id = :studentId";
	SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(student);
	namedParameterJdbcTemplate.update(sql, sqlParameterSource);
	return;
}
@Override 
public int updateAgeOfStudentToAgeOfStudentByNameofStudent(Student student){
	String sql = "update student set age = :age where name = :name";
	SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(student);
	return namedParameterJdbcTemplate.update(sql, sqlParameterSource);
}
private static final class StudentMapper implements RowMapper<Student> {
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setStudentId(rs.getLong("student_id"));
        student.setName(rs.getString("name"));
        student.setAge(rs.getString("age"));
        return student;
    }
}
}
