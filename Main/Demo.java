package Main;
import java.util.Vector; 

import java.util.Date;
import Platform.*;
import ResearchWork.*;
import Users.*;

public class Demo {
	public static void main(String[] args) {
			
			// objects
			UserDatabase database1 = new UserDatabase();
			Appeals appeals1 = new Appeals();
			Journal journal1 = new Journal("Journal1");
			Vector<Courses> courses1 = new Vector<>();
			
			// default users
			Admin admin1 = new Admin(Languages.English, "Adm1A", "TheBestAdmin99", "Sutubaeva Alexandra", 34, HealthStatuses.Healthy, FamilyStatuses.Married, 450000, new Date());
			Dean dean1 = new Dean(Languages.English,"Dn1A", "DeanRules1","Kalimulin Emil", 53, HealthStatuses.Healthy, FamilyStatuses.Married, 400000, new Date());
			Manager manager1 = new Manager(Languages.English,"Mng1A", "TopSorter94", "Sagitov Temirlan", 25, HealthStatuses.Healthy, FamilyStatuses.Married, 350000, new Date(), Faculties.ISE);
			Teacher teacher1 = new Teacher(Languages.English,"Tch1A", "Math is life", "Irina Vasylevna", 67, HealthStatuses.Healthy, FamilyStatuses.Married, 600000, new Date(), Faculties.ISE, true, TeacherType.Lecturer, courses1);
			Teacher teacher2 = new Teacher(Languages.English,"Tch2A", "IT_Rules_the_World", "Usukin Nikita", 32, HealthStatuses.Healthy, FamilyStatuses.Married, 500000, new Date(), Faculties.SITE, false, TeacherType.Practicioner, courses1);
			Teacher teacher3 = new Teacher(Languages.English,"Tch3A", "History never forgoten", "Zhuldyzbek Abylhozhin", 80, HealthStatuses.Disabled, FamilyStatuses.Married, 700000, new Date(), Faculties.SCE, true, TeacherType.Lecturer, courses1);
			TechSupport techsupport1 = new TechSupport(Languages.English, "Tsp1A", "chinila100", "Muminov Ibragim", 30, HealthStatuses.Healthy, FamilyStatuses.Married, 300000, new Date());
			TechSupport techsupport2 = new TechSupport(Languages.English,"Tsp2A", "Bob the builder", "Shakeyev Sardar", 29, HealthStatuses.Healthy, FamilyStatuses.Single, 300000, new Date());
			Student student1 = new Student(Languages.English,"Std2301", "Anime4love", "Dagurov Erik", 20, HealthStatuses.Healthy, FamilyStatuses.Single, Faculties.SITE, Courses.SecondCourse, journal1, Organizations.PARASAT, Position.MEMBER);
			Student student2 = new Student(Languages.English,"Std2401", "RainyDay2003", "Hegai Nicole", 19, HealthStatuses.Healthy, FamilyStatuses.Single, Faculties.ISE, Courses.FirstCourse, journal1,Organizations.ARTHOUSE, Position.MEMBER);
			Student student3 = new Student(Languages.English,"Std2303", "Apples", "Shakeyev Aibar", 20, HealthStatuses.Healthy, FamilyStatuses.Single, Faculties.SITE, Courses.SecondCourse, journal1, Organizations.UNIT, Position.MEMBER);
			//User gradstudent1 = new GraduateStudent(Languages.English,"Std2001", "qwerty123", "Temirbayev Nurzhan", 22, HealthStatuses.Healthy, FamilyStatuses.Single, Faculties.SCE, );
			//User gradstudent2 = new GraduateStudent(Languages.English,"Std2002", "BestDayEver", "Martynovski Robert", 22, HealthStatuses.Healthy, FamilyStatuses.Single, Faculties.SCE, );
			//User gradstudent3 = new GraduateStudent(Languages.English,"Std2003", "Try_Catch_Logic", "Idris Diyar", 23, HealthStatuses.Healthy, FamilyStatuses.Single, Faculties.SITE, );
			
			
			InputUtil input1 = new InputUtil();
		
		
			System.out.println("===== Console-based Demo: Research university platform =====\n");
			System.out.println("=====            Enter your credentials:               =====\n");
		
			String name = input1.getStringInput("Your full name: ");
			String userID = input1.getStringInput("Your user ID: ");
			String password = input1.getStringInput("Your password: ");
			int age = input1.getIntInput("Your age: ");
			
	
			System.out.println("\n=====        Credentials Entered Successfully          =====\n");
		    
		    System.out.println("============================================================");
		    System.out.println("| Welcome " + name + " |");
		    User you = admin1.createUser(userID, password, name, age, null, null, null);
		    admin1.addToDatabase(database1, you);
		    
		
		    boolean running = true;	
			while(running) {
				
				System.out.println(you.showCommands());
				int input = input1.getIntInput("Enter your command: \n");
				
				switch(input) {
					case(1):
							try {
								int inpt = input1.getIntInput("| English - 1 | Russian - 2 | Kazakh - 3 | ");
								if (inpt < 4 && inpt > 0) {
									if (inpt == 1) {
										you.setLanguage(Languages.English);
										
									}
									else if (inpt == 2) {
										you.setLanguage(Languages.Russian);
										
									}
									else {
										you.setLanguage(Languages.Kazakh);
																		
									}
						
								}
								else System.out.println("| Invalid unput, try again | ");
								
							}
							catch(Exception e) {
								System.out.println("| Error occured... | \n");
							}
							
							
					case(2):
							try {
								String contents = input1.getStringInput(" Enter request contents: ");
								Request req = new Request(contents);
								appeals1.addToRequestList(req);
								System.out.println("| Request send | \n");
							}
						
							catch(Exception e) {
								System.out.println("| Error occured... | \n");
							}
					
				}
			}
			
				
		}
			
			
}	


