
package py.com.jtorres.managed_beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import py.com.jtorres.entidades.Student;

/**
 *
 * @author jonathan.torres
 */
@Named(value = "test")
@SessionScoped
public class Test implements Serializable {
private String name;
	private String stuClass;
	private String rollNo;
	private int age;
 
	private static final List<Student> studentList = 
		new ArrayList<Student>(Arrays.asList(
			new Student("Vivek","MCA 3rd","MCA/07/40",29),
			new Student("Sunil","MCA 3rd","MCA/07/41",33),
			new Student("Bharat","MCA 3rd","MCA/07/42",27),
			new Student("Richi","MCA 3rd","MCA/07/43",28),
			new Student("Sahdev","MCA 3rd","MCA/07/44",28)));	
 
 
	public List<Student> getStudents(){
		return studentList;
	}
 
	public String addStudent(){
		studentList.add(new 
				Student(name, stuClass, rollNo, age));
		return null;
	}
        public String deleteAction(Student stud) {
	    
		studentList.remove(stud);
		return null;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStuClass() {
		return stuClass;
	}
	public void setStuClass(String stuClass) {
		this.stuClass = stuClass;
	}
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
    
}
