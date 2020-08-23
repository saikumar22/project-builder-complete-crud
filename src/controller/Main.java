package controller;

import java.util.Scanner;

import dao.CrudDAO;
import dao.UserDAO;
import model.Skill;
import model.User;

public class Main {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		User user = new User();
		Skill skill = new Skill();
		CrudDAO dao = new CrudDAO();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		UserDAO dao1 = new UserDAO();
		int choice =1;
		boolean flag = true;
		while(flag) {
			System.out.println("1: SINGUP 2. LOGIN");
		int choice1 = sc.nextInt();
		switch(choice) {
		case 1:	
				System.out.println("Enter Email ID");
				String email = sc.next();
				System.out.println("Enter Password");
				String password = sc.next();
				User user1 = new User();
				int success = dao1.signUp(user1);
				if(success==1) {
					System.out.println("Login Success");
				}
				else {
					System.out.println("check your Email and Password!");
				}
				break;
		case 2:System.out.println("please provide your credentials");
			String email1 = sc.next();
			String password1 = sc.next();
			User user2 = new User();
			boolean status = dao1.loginUser(user2);
			boolean flag1 =true;
			
			if(status) {
				System.out.println("1.ADD 2.DELETE,3 UPDATE 4.DISPLAY");
				int choice2 = sc.nextInt();
				while(flag1) {
				switch(choice2) {
				case 1: 
					System.out.println("Add Skills");
					System.out.println("Enter Id");
					int id = sc.nextInt();
					System.out.println("Enter Name");
					String name = sc.next();
					Skill skill1 = new Skill(id, name);
					dao.addSkill(skill1);
					break;
				case 2:
					System.out.println("Delete by id");
					System.out.println("Enter id");
					int id1 = sc.nextInt();
					dao.delete(id1);
					break;
				case 3:System.out.println("Update the skill");
						System.out.println("Enter id");
						int id2 = sc.nextInt();
						System.out.println("Enter skill");
						String name1 = sc.next();
						Skill skill3 = new Skill(id2, name1);
						dao.update(skill3);
						break;
				case 4:System.out.println("Display");
						dao.display();
						break;
				case 5: flag=false;
						break;
				default: System.out.println("Wrong choice");
						}
					}
				}
				break;
		case 3: flag = false;
				break;
		default: System.out.println("wrong choice");
		}
		}
	}
}
