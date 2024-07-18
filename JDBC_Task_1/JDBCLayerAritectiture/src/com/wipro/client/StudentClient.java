package com.wipro.client;

import java.sql.SQLException;
import java.util.Scanner;

import com.wipro.model.Student;
import com.wipro.service.StudentService;
import com.wipro.service.StudentServiceImpl;

public class StudentClient {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		StudentService ss=new StudentServiceImpl();
		
		
		
		
//		ss.addStudent(new Student(101,"Rajesh","Pune","rajesh@gmail.com"));
//		ss.addStudent(new Student(102,"Aman","Mumbai","aman@gmail.com"));
//		ss.addStudent(new Student(103,"Praveen","Kanpur","praveen@gmail.com"));
//		ss.addStudent(new Student(104,"Alok","Lucknow","alok@gmail.com"));
		
		
		ss.getAllStudents().stream().forEach(s->System.out.println(s));
		System.out.println("Data inserted successfully...");
		
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("\n"+"1. Insert Student :"+"\n"+"2. Update  Student :"+"\n"+"3. Delete Student : "+"\n"+"4. View All Student :"+"\n"+"5. View a Student : "+"\n"+"6. Exit : ");

			
			System.out.print("Enter Your Choice (1..6) :");
			int choice =sc.nextInt();
			sc.nextLine();
			switch(choice) {
			
			
				case 1:
					
					System.out.println("Enter the student Id: ");
					int studentId=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter the student name: ");
					String stu_name=sc.next();
					System.out.println("Enter the Address: ");
					String stu_address=sc.next();
					System.out.println("Enter the email: ");
					String stu_email=sc.next();
					Student s1=new Student();
					s1.setId(studentId);
					s1.setName(stu_name);
					s1.setAddress(stu_address);
					s1.setEmail(stu_email);
					ss.addStudent(s1);
					
					System.out.println("Student inserted successfully...");
					System.out.println("Students list:-------------------");
					ss.getAllStudents().forEach(s->System.out.println(s));
					break;
					
				case 2:
					System.out.println("Enter the student id to update: ");
					int stuId=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter new name: ");
					String name=sc.next();
					System.out.println("Enter new address: ");
					String address=sc.next();
					System.out.println("Enter new email");
					String email=sc.next();
					
					Student s=new Student();
					s.setId(stuId);
					s.setName(name);
					s.setAddress(address);
					s.setEmail(email);
					ss.updateStudent(stuId, s);
					System.out.println("Student updated successfully...");
					
				
					System.out.println("Students list:------------------");
					
					ss.getAllStudents().stream().forEach(d->System.out.println(d));
					break;
				
				case 3:
					System.out.println("Enter the student id to be deleted: ");
					int deleteId=sc.nextInt();
					ss.deleteStudent(deleteId);
					
					System.out.println("Students list:-----------------------");
					ss.getAllStudents().stream().forEach(d->System.out.println(d));
					break;
				
				case 4:
					System.out.println("Students list:------------------------");
					ss.getAllStudents().stream().forEach(d->System.out.println(d));
					break;
					
				case 5:
					
					System.out.println("Enter the student id to be view: ");
					int proId=sc.nextInt();
					Student stu=ss.getStudent(proId);
					System.out.println(stu.toString());
					break;
				case 6:
					
					System.out.println("Exiting.....");
					
					sc.close();
					return;
				default:
					System.out.println("Invalid choice. Try again!");
					
				
			}
		}
		
		
		

	}

}
