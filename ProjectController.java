package project.controller;


import java.sql.SQLException;
import java.util.Scanner;

import project.dao.ProjectOperation;
import project.dto.Project;

public class ProjectController {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		Project project= new Project();
		ProjectOperation crud= new ProjectOperation();
//		crud.createtable();
		boolean check=true;
		do {
			Scanner sc= new Scanner(System.in);
			System.out.println("Choice \n 1.Register \n 2.LogIn \n 3.Wallet \n 4.Exit");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:{
				System.out.println("enter name");
				String name=sc.next();
				System.out.println("enter email");
				String email=sc.next();
				System.out.println("enter password");
				String password=sc.next();
				System.out.println("enter your wallet amount");
				int wallet=sc.nextInt();
				System.out.println("enter address");
				String address=sc.next();
				System.out.println("enter phone number");
				long phone=sc.nextLong();
				System.out.println("enter age");
				int age=sc.nextInt();
				Project project=new Project(name, email, password, wallet, address, phone, age);
				crud.insertdata(project);
			}break;
			case 2:{
				System.out.println("enter your email");
				String email=sc.next();
				System.out.println("enter your password");
				String passwords=sc.next();
				if(crud.logintable(email,passwords)) {
					System.out.println("login successful...");
					crud.foodmenu();
					boolean check1=true;
					int price = 0;
					while(check1) {
						System.out.println("enter sno of food you want");
						int sno=sc.nextInt();
						crud.fetchfood(sno);
					   price = price + crud.fetchprice(sno);
					   System.out.println("you want more food \n 1.yes \n 2.no");
					   int more=sc.nextInt();
					   if(more!=1) {
						   break;
					   }
					}
					System.out.println("Remaining balance :"+(crud.fetchwallet(passwords)-price));
					crud.addwallet(passwords, crud.fetchwallet(passwords)-price);
					
				}	
				
			}break;
			case 3:{
				System.out.println("enter your password");
				String passwords=sc.next();
				System.out.println("enter the amount you want to add");
				int amt=sc.nextInt();
				crud.addwallet(passwords, amt+crud.fetchwallet(passwords));
				System.out.println("Amount added succesfully..");
			}break;
			case 4:{
				check=false;
				System.out.println("exited");
			}break;
			}
			
		}while(check);

	}

}
