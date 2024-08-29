package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project.dto.Project;

public class ProjectOperation {
 
	public void createtable() throws ClassNotFoundException, SQLException {
		//load and register
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Establish the connection
		String url="jdbc:mysql://localhost:3306/project?createDatabaseIfNotExist=true";
		String user="root";
		String password="root@123";
		Connection con = DriverManager.getConnection(url, user, password);
		//creating the statement
		PreparedStatement ps = con.prepareStatement("create table project1(name varchar(45),email varchar(45),password varchar(45),wallet int,address varchar(45),phone int primary key,age int)");
		ps.execute();
		con.close();
		ps.close();
		System.out.println("Table created.....");
	}
	
	public void insertdata(Project project) throws ClassNotFoundException, SQLException {
		//load and register
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Establish the connection
		String url="jdbc:mysql://localhost:3306/project?createDatabaseIfNotExist=true";
		String user="root";
		String password="root@123";
		Connection con = DriverManager.getConnection(url, user, password);
		//creating statement
		PreparedStatement ps = con.prepareStatement("insert into project1 values(?,?,?,?,?,?,?)");
		ps.setString(1, project.getName());;
		ps.setString(2, project.getEmail());
		ps.setString(3, project.getPassword());
		ps.setInt(4,project.getWallet());
		ps.setString(5, project.getAddress());
		ps.setLong(6, project.getPhone());
		ps.setInt(7, project.getAge());
		ps.execute();
		con.close();
		ps.close();
		System.out.println("Registration succesful.....");
	}

	public boolean logintable(String email, String passwords) throws ClassNotFoundException, SQLException {
		//load and register
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Establish the connection
		String url="jdbc:mysql://localhost:3306/project?createDatabaseIfNotExist=true";
		String user="root";
		String password="root@123";
		Connection con = DriverManager.getConnection(url, user, password);
		//creating statement
		PreparedStatement ps = con.prepareStatement("select * from project1 where email=? and passwords=?");
		ps.setString(1, email);
		ps.setString(2, passwords);
		ResultSet res = ps.executeQuery();
	
	    if(res.next()) {
	    	return true;
	    }else {
	    	System.out.println("login failed");
	    	con.close();
	    	ps.close();
	    	return false;
	    }
		
	}

	public void foodmenu() throws ClassNotFoundException, SQLException {
		//load and register
				Class.forName("com.mysql.cj.jdbc.Driver");
				//Establish the connection
				String url="jdbc:mysql://localhost:3306/project?createDatabaseIfNotExist=true";
				String user="root";
				String password="root@123";
				Connection con = DriverManager.getConnection(url, user, password);
				//creating statement
				PreparedStatement ps = con.prepareStatement("select * from food_menu");
				ResultSet res = ps.executeQuery();
				while(res.next()) {
					System.out.println(res.getInt(1) +" "+ res.getString(2) +" "+ res.getInt(3));
					
				}
		
	}

	public void fetchfood(int sno) throws ClassNotFoundException, SQLException {
		//load and register
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Establish the connection
		String url="jdbc:mysql://localhost:3306/project?createDatabaseIfNotExist=true";
		String user="root";
		String password="root@123";
		Connection con = DriverManager.getConnection(url, user, password);
		//creating statement
		PreparedStatement ps = con.prepareStatement("select * from food_menu where sno=?");
		ps.setInt(1, sno);
		ResultSet res = ps.executeQuery();
		while(res.next()) {
			System.out.println(res.getInt(1) +" "+ res.getString(2) +" "+ res.getInt(3));
			
		}
		
	}

	public int fetchprice(int sno) throws ClassNotFoundException, SQLException {
		//load and register
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Establish the connection
		String url="jdbc:mysql://localhost:3306/project?createDatabaseIfNotExist=true";
		String user="root";
		String password="root@123";
		Connection con = DriverManager.getConnection(url, user, password);
		//creating statement
		PreparedStatement ps = con.prepareStatement("select * from food_menu where sno=?");
		ps.setInt(1, sno);
		ResultSet res = ps.executeQuery();
		int prices=0;
		while(res.next()) {
		 prices= res.getInt(3);
//			System.out.println(price);	
		}
		ps.close();
		con.close();
		return prices;
		
		
	}

	public int fetchwallet(String passwords) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//load and register
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Establish the connection
		String url="jdbc:mysql://localhost:3306/project?createDatabaseIfNotExist=true";
		String user="root";
		String password="root@123";
		Connection con = DriverManager.getConnection(url, user, password);
		//creating statement
		PreparedStatement ps = con.prepareStatement("select * from project1 where passwords=?");
		ps.setString(1, passwords);
		ResultSet res = ps.executeQuery();
		int prices=0;
		while(res.next()) {
		 prices= res.getInt(4);
//			System.out.println(price);	
		}
		ps.close();
		con.close();
		return prices;
		
	}

	public void addwallet(String passwords, int amt) throws ClassNotFoundException, SQLException {
				//load and register
				Class.forName("com.mysql.cj.jdbc.Driver");
				//Establish the connection
				String url="jdbc:mysql://localhost:3306/project?createDatabaseIfNotExist=true";
				String user="root";
				String password="root@123";
				Connection con = DriverManager.getConnection(url, user, password);
				//creating statement
				PreparedStatement ps = con.prepareStatement("update project1 set wallet=? where passwords=?");
				ps.setInt(1, amt);
				ps.setString(2,passwords);
				ps.execute();
				ps.close();
				con.close();
	}

	

	
}
