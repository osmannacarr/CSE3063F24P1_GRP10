
public abstract class User extends BaseEntity {
String firstName;
String lastName;
String password;
String faculty;
String department;

public User(String firstName,String lastName,String ID,String password,String faculty,String department) {
	super(ID);
	this.firstName = firstName;
	this.lastName = lastName;
	this.password = password;
	this.faculty = faculty;
	this.department = department;
	
}

public String getfirstName() {
	return firstName;
}

public String getSurname() {
	return lastName;
}

public String getPassword() {
	return password;
}

public String getFaculty() {
	return faculty;
}

public String getDepartment() {
	return department;
}


}
