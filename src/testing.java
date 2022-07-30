import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class testing {

	public static boolean checkVacanciesAvailable(int index) {
		// checks if index is available, look at slotsVacancy;
		String studentloginCSV = "/Users/gorje/Downloads/STARS - Indexes.csv";
		BufferedReader br = null;
	    String line = "";
	    String cvsSplitBy = ",";
	    try {
	        br = new BufferedReader(new FileReader(studentloginCSV));
	        while ((line = br.readLine()) != null) {
	                // use comma as separator
	            int csvindex = Integer.parseInt(line.split(cvsSplitBy)[1]);
	            int vac = Integer.parseInt(line.split(cvsSplitBy)[19]);
	            if (csvindex==index) {
	            	System.out.println("Index is valid.");
	            	if (vac > 0) {
	                	System.out.println("has vacancy");
	                	return true;
	                }
	            	else {
	                	System.out.println("no vacancy");
	                	return false;
	            	}
	            }
	        }
	      
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean helps;
		int indexno=10491;
		helps=checkVacanciesAvailable(indexno);
	}

}
