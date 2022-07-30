import java.util.Scanner;

public class password {	
	public static void main(String[] args) {
		passwordcheck logincheck = new passwordcheck();
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
					final String secretKey = "iloveeeejava";
				    String encryptedString = password2.encrypt(stuPassword, secretKey);
					System.out.println(encryptedString);
					checkk=logincheck.checkStudentLogin(stuUsername, encryptedString);
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
				    final String secretKey = "iloveeeejava";
				    String encryptedString = password2.encrypt(adminPassword, secretKey);
					System.out.println(encryptedString);
					checkk=logincheck.checkAdminLogin(adminUsername, encryptedString);
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