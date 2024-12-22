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
			Vector<Course> courses1 = new Vector<>();
			News news1 = new News();
			Course c1 = new Course("Irina Vasylevna", "Tch1A", "Calculus2", CourseTypes.Elective );
			Course c2 = new Course("Usukin Nikita", "Tch2A", "PP2", CourseTypes.Elective);
			Course c3 = new Course("Zhuldyzbek Abylhozhin","Tch3A", "Kazakh History", CourseTypes.Elective );
			courses1.add(c1); courses1.add(c2); courses1.add(c3);

			

			
			// default users
			Admin admin1 = new Admin(Languages.English, "Adm1A", "TheBestAdmin99", "Sutubaeva Alexandra", 34, 450000, new Date());
			Dean dean1 = new Dean(Languages.English,"Dn1A", "DeanRules1","Kalimulin Emil", 53,  400000, new Date());
			Manager manager1 = new Manager(Languages.English,"Mng1A", "TopSorter94", "Sagitov Temirlan", 25, 350000, new Date(), Faculties.ISE);
			Teacher teacher1 = new Teacher(Languages.English,"Tch1A", "Math is life", "Irina Vasylevna", 67, 600000, new Date(), Faculties.ISE, true, TeacherType.Lecturer);
			ResearcherDecorator researchertch1 = new ResearcherDecorator(teacher1, ResearcherType.Supervisor);
			Teacher teacher2 = new Teacher(Languages.English,"Tch2A", "IT_Rules_the_World", "Usukin Nikita", 32, 500000, new Date(), Faculties.SITE, false, TeacherType.Practicioner);
			Teacher teacher3 = new Teacher(Languages.English,"Tch3A", "History never forgoten", "Zhuldyzbek Abylhozhin", 80,  700000, new Date(), Faculties.SCE, true, TeacherType.Lecturer);
			ResearcherDecorator researchertch3 = new ResearcherDecorator(teacher3, ResearcherType.Supervisor);
			TechSupport techsupport1 = new TechSupport(Languages.English, "Tsp1A", "chinila100", "Muminov Ibragim", 30,  300000, new Date());
			TechSupport techsupport2 = new TechSupport(Languages.English,"Tsp2A", "Bob the builder", "Shakeyev Sardar", 29,  300000, new Date());
			Student student1 = new Student(Languages.English, "Std2301", "Anime4love", "Dagurov Erik", 20, Faculties.SITE, Courses.SecondCourse, courses1);
			Student student2 = new Student(Languages.English,"Std2401", "RainyDay2003", "Hegai Nicole", 19, Faculties.ISE, Courses.FirstCourse, courses1);
			Student student3 = new Student(Languages.English,"Std2303", "Apples", "Shakeyev Aibar", 20, Faculties.SITE, Courses.SecondCourse, courses1);

			GraduateStudent gradstudent1 = new GraduateStudent(Languages.English,"Std2001", "qwerty123", "Temirbayev Nurzhan", 22, Faculties.SCE, Courses.ForthCourse, journal1, teacher3, "Natural Sciences", ResearcherType.Participant);
			GraduateStudent gradstudent2 = new GraduateStudent(Languages.English,"Std2002", "BestDayEver", "Martynovski Robert", 22,  Faculties.SCE, Courses.ForthCourse, journal1, teacher3, "Natural Sciences", ResearcherType.Participant);
			GraduateStudent gradstudent3 = new GraduateStudent(Languages.English,"Std2003", "Try_Catch_Logic", "Idris Diyar", 23, Faculties.SITE, Courses.ForthCourse, journal1, teacher1, "Information Systems",  ResearcherType.Participant);

			
			
			
			admin1.addToDatabase(database1, admin1);
			admin1.addToDatabase(database1, dean1);
			admin1.addToDatabase(database1, teacher1);
			admin1.addToDatabase(database1, teacher2);
			admin1.addToDatabase(database1, teacher3);
			admin1.addToDatabase(database1, techsupport1);
			admin1.addToDatabase(database1, techsupport2);
			admin1.addToDatabase(database1, student1);
			admin1.addToDatabase(database1, student2);
			admin1.addToDatabase(database1, student3);
			admin1.addToDatabase(database1, gradstudent1);
			admin1.addToDatabase(database1, gradstudent2);
			admin1.addToDatabase(database1, gradstudent3);

			InputUtil input1 = new InputUtil();
			User accessUser = null;
		    	boolean running1 = true;	
		
			System.out.println("\n===== Console-based demo: Research university platform =====\n");
			
			while(running1) {
				System.out.println("=====            Enter your credentials:               =====\n");
			
	
				String userID = input1.getStringInput("Your user ID: ");
				String password = input1.getStringInput("Your password: ");
				accessUser = admin1.findInDatabase(database1, userID, password);
				
				if(accessUser != null) {
		
					System.out.println("\n=====        Credentials entered successfully          =====\n");
					System.out.println("============================================================");
					System.out.println("| Welcome " + accessUser.getName() + " |");
					running1 = false;
				}
				else {
					System.out.println("\n=====           Wrong credentials, try again           =====\n");
					System.out.println("============================================================");
					
				}
			}
			
			accessUser.console(news1, journal1, appeals1);
			

			
				
		}
			
			
}	


