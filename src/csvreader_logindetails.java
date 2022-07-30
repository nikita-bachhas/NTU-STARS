import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class csvreader_logindetails {
	public boolean checkStudentLogin(String stuUsername, String stuPassword) {
		Scanner sc = new Scanner(System.in);
		String studentloginCSV = "/Users/gorje/Documents/CZ2002 Object Oriented Design & Programming/Java Project/student login details.csv";
		BufferedReader br = null;
	    String line = "";
	    String cvsSplitBy = ",";
	    try {
	        br = new BufferedReader(new FileReader(studentloginCSV));
	        while ((line = br.readLine()) != null) {
	                // use comma as separator
	            String[] hi = line.split(cvsSplitBy);
	            if (hi[0].equals(stuUsername) && hi[1].equals(stuPassword)) {
	            	System.out.println("Login Successful!");
	            	return true;
	            }
	        }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    System.out.println("Login Unsuccessful!");
		return false;
    	}
	public boolean checkAdminLogin(String adminUsername, String adminPassword) {
		Scanner sc = new Scanner(System.in);
		String adminloginCSV = "/Users/gorje/Documents/CZ2002 Object Oriented Design & Programming/Java Project/admin login details.csv";
		BufferedReader br = null;
	    String line = "";
	    String cvsSplitBy = ",";
	    try {
	        br = new BufferedReader(new FileReader(adminloginCSV));
	        while ((line = br.readLine()) != null) {
	                // use comma as separator
	            String[] hi = line.split(cvsSplitBy);
	            if (hi[0].equals(adminUsername) && hi[1].equals(adminPassword)) {
	            	System.out.println("Login Successful!");
	            	return true;
	            }
	        }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    System.out.println("Login Unsuccessful!");
		return false;
    	}
}
