
package py.com.jtorres.entidades;

/**
 *
 * @author jonathan.torres
 */
public class Student {
    private String name;
	private String stuClass;
	private String rollNo;
	private int age;	
 
	public Student(String name, 
			String stuClass, String rollNo, int age) {
		this.age = age;
		this.name = name;
		this.rollNo = rollNo;
		this.stuClass = stuClass;
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
