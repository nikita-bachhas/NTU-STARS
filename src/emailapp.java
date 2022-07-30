
public class emailapp {

	public static void main(String[] args) {
		Email email = new Email();
		String index = "cz2002";
		String course = "1234";
		String username = "ahan002";
		email.send_email(course, index, username);
			}

}
public void printStudentListByCourse() {
	System.out.println("Enter CourseCode");

 	Scanner scanner13 = new Scanner(System.in);
	String courseCode = scanner13.nextLine();
	
	for (Student i : studentList) {
		for (Index x: i.getStudentCourse()) {
			
			if(x.getCourseCode().equals(courseCode)) {
				System.out.println(i.getUsername()); 

			}
			}
	}
}