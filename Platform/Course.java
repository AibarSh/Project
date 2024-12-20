package Platform;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Course {
	private String teacherName;
	private String courseId;
	private String subjectName;

	private Map<String, String> students;
	private Vector<String> instructorNames;
	private Vector<String> prerequisites;

	public CourseTypes courseType;


	public Course(String teacherName, String courseId, String subjectName, CourseTypes courseType) {
		this.teacherName = teacherName;
		this.courseId = courseId;
		this.subjectName = subjectName;
		this.courseType = courseType;

		this.students = new HashMap<>();
		this.instructorNames = new Vector<>();
		this.prerequisites = new Vector<>();
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {this.teacherName = teacherName;}

	public String getCourseId() {
		return courseId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public Map<String, String> getStudents() {
		return students;
	}

	public Vector<String> getInstructorNames() {
		return instructorNames;
	}

	public Vector<String> getPrerequisites() {
		return prerequisites;
	}

	public void addStudent(String studentId, String studentName) {
		students.put(studentId, studentName);
	}

	public void removeStudent(String studentId) {
		students.remove(studentId);
	}

	public void addInstructor(String instructorName) {
		instructorNames.add(instructorName);
	}

	public void addPrerequisite(String prerequisite) {
		prerequisites.add(prerequisite);
	}

	@Override
	public String toString() {
		return "Course Details:" +
				"\nTeacher: " + teacherName +
				"\nCourse ID: " + courseId +
				"\nSubject Name: " + subjectName +
				"\nCourse Type: " + courseType +
				"\nStudents: " + students +
				"\nInstructors: " + instructorNames +
				"\nPrerequisites: " + prerequisites;
	}
}
