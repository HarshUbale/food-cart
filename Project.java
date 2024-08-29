package project.dto;

public class Project {
   private String name;
   private String email;
   private String password;
   private int wallet;
   private String address;
   private long phone;
   private int age;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getWallet() {
	return wallet;
}
public void setWallet(int wallet) {
	this.wallet = wallet;
}

@Override
public String toString() {
	return "Project [name=" + name + ", email=" + email + ", password=" + password + ", wallet=" + wallet + ", address="
			+ address + ", phone=" + phone + ", age=" + age + "]";
}
public Project(String email, String password) {
	super();
	this.email = email;
	this.password = password;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public Project(String name, String email, String password, int wallet, String address, long phone, int age) {
	super();
	this.name = name;
	this.email = email;
	this.password = password;
	this.wallet = wallet;
	this.address = address;
	this.phone = phone;
	this.age = age;
}

}
