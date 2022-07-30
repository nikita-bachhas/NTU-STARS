import java.util.Scanner;

public class login {	
	public static void main(String[] args) {
		csvreader_logindetails logincheck = new csvreader_logindetails();
		String choice;
		boolean checkk;
		do {
			while (true) {
				System.out.println("Please enter student for student login or admin for admin login:");
				Scanner sc = new Scanner(System.in);
				choice = sc.nextLine();
				if (choice.equals("student")) {
					String stuUsername,stuPassword;
					System.out.println("Please enter student username:");
					stuUsername = sc.nextLine();
					System.out.println("Please enter student password:");
					stuPassword = sc.nextLine();
					checkk=logincheck.checkStudentLogin(stuUsername, stuPassword);
					if (checkk==true) {
						break;
					}
					else {
						continue;
					}
				}
				else if (choice.equals("admin")) {
					String adminUsername,adminPassword;
					System.out.println("Please enter admin username:");
					adminUsername = sc.nextLine();
					System.out.println("Please enter admin password:");
				    adminPassword = sc.nextLine();
					checkk=logincheck.checkAdminLogin(adminUsername, adminPassword);
					if (checkk==true) {
						break;
					}
					else {
						continue;
					}
					}
				else {
					System.out.println("Invalid input, please try again!");}}
		break;
		}
		while (choice != "student" && choice != "admin");		
		
}
}