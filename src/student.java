import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class student {
    //attribute
private String Username;
private String Name;
private String MatricNo;
private String Gender; 
private String Nationality;

//constructor
public student(String stuName, String Matric_No, String stuGender) {
	this.Name = stuName;
	this.MatricNo = Matric_No;
	this.Gender = stuGender;
}

//Methods
public String getUsername() {
	return Username;
}
public String[] getStudentCourse(String Username) {
	// prints out the courses student registered --> use studentcourselist;
	for (stuUsername i : StudentCourseList) {
		if(i.getUsername() == Username) { //should i remove getusername
			System.out.println(i.getCourseCode()); 
		}
}} 
public boolean checkStudentCourse(String Username, String coursecode) {
	// checks if student have registered for this course or not;
	for (stuUsername i : StudentCourseList) {
		if(i.getUsername() == Username) { //should i remove getusername
			for (CourseCode x : StudentCourseList) {
				if (x=coursecode) {
					return true;
				}
			}
		}
}
	return false;} 
public boolean checkStudentIndex(String Username, String Index) {
	// checks if student have registered for this index or not; mainly for swap with friend
	for (takenCourses i : StudentCourseList) {
		if(i.getUsername() == Username) { 
			if (i.getIndexNumber()==Index) {
				return true;}
			}
		}
	return false;
}

public void getVacanciesAvailable(String coursecode) {
	// prints out ALL indexes vacancy/totalsize;
	for (CourseCode i : IndexList) {
		if (i == coursecode) {
			System.out.println("These are the indexes for course "+coursecode+" (vacancy/totalsize)");
			for (IndexNumber x : IndexList) {
				System.out.println("Index:"+x+", "+vacancy+"/"+totalsize);
			}
		}
	}}	
public boolean checkIndexInCourse(String coursecode, String index) {
	// checks if index entered is in course
	for (CourseCode i : IndexList) {
		if (i == coursecode) {
			for (IndexNumber x : IndexList) {
				if (x == index) {
						return true;
				}
			}
		}
	}
	return false;
}
public boolean checkVacanciesAvailable(String coursecode, String index) {
	// checks if index is available, look at slotsVacancy, checking from list;
	for (CourseCode i : IndexList) {
		if (i == coursecode) {
			for (IndexNumber x : IndexList) {
				if (x == index) {
					if (slotsVacancy>0)
						return true;
				}
			}
		}
	}
	return false;
}
public boolean checkforScheduleClash(String Username, String index) {
	//compare the day;
	//compare the time;
}
public void UpdateVacancy() {
	//updates CSV
}

public int getAUofStudent(String Username) {
	//count and return number of AUs student currently has
	int count = 0;
	String[] tempIndex;
	for (takenCourses i : StudentCourseList) {
		if (i.getUsername() == Username) {
			count = count + i.getAU();
		}
	}
}
public void StuAddCourse () {
	String Username = getUsername();
	String courseEntered,indexEntered;
	boolean checkcourse, checkindex,checkclash, checkindex2;
	int choiceIndex, AUCount;
	Scanner sc = new Scanner(System.in);
	while(true) { //loop until student input a valid course code
		System.out.println("Please enter course code to be added: ");
		courseEntered = sc.nextLine();
		getStudentCourse(Username); //prints out the courses that are already registered by student; DONE
		checkcourse = checkStudentCourse(Username,courseEntered); //checks if the course code entered is already registered by student; DONE
		if (checkcourse == true) {
			System.out.println("Course is already registered. Please enter another course code.");	
			continue;}
		else
			break;
		//checks AU Count
		for (Courses i : CourseList) {
			if (i.CourseCode() == courseEntered) {
				AUCount = i.getAU();
			}
		}
		AUCount=AUCount + getAUofStudent(Username);
		if (AUCount > 21) {
			System.out.println("Maximum AU reached. Please enter another course code.");	
			continue;}
	}
	System.out.println("Course is not registered yet. ");	
	//checks the indexes available for courseEntered; DONE
	getVacanciesAvailable(courseEntered);
	//student to enter the index they want from the available indexes; DONE
	while(true) { //loop until student input a valid index
		System.out.println("Please enter available course index to be added: ");
		indexEntered = sc.nextLine(); 
		// check if the index is part of course; DONE
		checkindex=checkIndexInCourse(courseEntered, indexEntered);
		// check if index has vacancy; DONE
		if (checkindex==true) {
			checkindex2=checkVacanciesAvailable(courseEntered,indexEntered);
			if (checkindex2 == false) {
				System.out.println("Index is already full. Enter 1 to enter waitlist, enter 2 to reenter index.");	
				choiceIndex = sc.nextInt(); 
				if (choiceIndex == 1) {
					//ADD TO WAITLIST;
					break;
				}
				else if (choiceIndex == 2) {
					continue;
				}}
			else {
				checkclash = checkforScheduleClash(Username, indexEntered);
				if (checkclash==true) {
					System.out.println("Index chosen clashes with current course registered, please reenter index.");	
				}
				else {
					//ADD COURSE;
					
					System.out.println("Index successfully added!");	
				}
			}
		}
		else 
			continue;}		
	//update student course list;
	//update index file --> no of slots;
}

public void StuDropCourse () {
	String Username = getUsername();
	String courseEntered;
	boolean checkcourse;
	Scanner sc = new Scanner(System.in);
	while(true) { //loop until student input a valid course code
		System.out.println("Please enter course code to be dropped: ");
		courseEntered = sc.nextLine();
		getStudentCourse(Username); //prints out the courses that are already registered by student; DONE
		checkcourse = checkStudentCourse(Username,courseEntered); //checks if the course code entered is already registered by student; DONE
		if (checkcourse == true) {
			//DROPCOURSE;
			// remove the course from csv and ADD 1 to noofslots
			
			//WAITLIST THINGY; have another method for wait list
			System.out.println("Course successfully dropped!");	
			break;}
		else {
			System.out.println("Course is not registered. Please input a regiestered course.");	
			continue;
		}
	}
}

public void ChangeCourseIndexNumber() {
	String Username = getUsername();
	String courseEntered, indexEntered;
	boolean checkcourse, checkindex, checkclash;
	Scanner sc = new Scanner(System.in);
	while(true) { //loop until student input a valid course code
		System.out.println("Please enter course code: ");
		courseEntered = sc.nextLine();
		checkcourse = checkStudentCourse(Username,courseEntered); //checks if the course code entered is already registered by student; DONE
		if (checkcourse == true) {
			break;}
		else {
			System.out.println("Course is not registered. Please input a registered course.");	
				continue;
			}
		}
	//checks the indexes available for courseEntered; DONE
	getVacanciesAvailable(courseEntered);
	//student to enter the index they want from the available indexes; DONE
	while(true) { //loop until student input a valid index
		System.out.println("Please enter available course index to be swapped: ");
		indexEntered = sc.nextLine();
		// check if the index is entered correctly; DONE
		checkindex=checkVacanciesAvailable(courseEntered,indexEntered);
		if (checkindex == false) {
			System.out.println("Invalid Index or Index is filled. Please reenter index.");
			continue;
			}
		else {
			checkclash = checkforScheduleClash(Username,indexEntered);
			if (checkclash==true) {
				System.out.println("Index chosen clashes with current course registered, please reenter index.");	
			}
			else {
				//drop index, add new index;				
				System.out.println("Index successfully changed!");	
			}
		}
	}
}
public void swapIndexwithAnotherFriend(){
	String Username = getUsername();//YOUR username
	String storemyIndex, storefriendIndex, friendsUsername, course2swap;
	boolean checkYourCourse, checkFCourse, checkYourIndexinC, checkFIndexinC, checkYourIndex, checkFIndex;
	boolean checkYourClash,checkFClash;
	Scanner sc = new Scanner(System.in);
	while(true) {
		while (true) {
			System.out.println("Please enter friend's username:");	
			friendsUsername = sc.nextLine();
			System.out.println("Please enter course code to be swapped");	
			course2swap = sc.nextLine();
			//checks if you have registered for course2swap
			checkYourCourse=checkStudentCourse(Username,course2swap);
			if (checkYourCourse==false) {
				System.out.println("You are not registered under course "+course2swap+", please re-enter course code to be swapped.");	
				continue;
			}
			//checks if friend have registered for course2swap
			checkFCourse=checkStudentCourse(friendsUsername,course2swap);
			if (checkFCourse==false) {
				System.out.println("Friend not registered under course "+course2swap+", please re-enter friend's username or course code to be swapped.");	
				continue;
			}
			break;
		}
		while (true) {
			System.out.println("Please enter your current index:");	
			storemyIndex = sc.nextLine();
			checkYourIndexinC=checkIndexInCourse(course2swap,storemyIndex);
			checkYourIndex=checkStudentIndex(Username, storemyIndex);
			if (checkYourIndexinC == false) {
				System.out.println("Index "+storemyIndex+" entered is not under course "+course2swap+", please re-enter Index.");	
				continue;
			}
			if (checkYourIndex == false) {
				System.out.println("You are not registered under Index "+storemyIndex+", please re-enter Index.");	
				continue;
			}
			System.out.println("Please enter friend's current index:");	
			storefriendIndex = sc.nextLine();
			checkFIndexinC=checkIndexInCourse(course2swap,storefriendIndex);
			checkFIndex=checkStudentIndex(friendsUsername,storefriendIndex);
			if (checkFIndexinC == false) {
				System.out.println("Index "+storefriendIndex+" entered is not under course "+course2swap+", please re-enter Index.");	
				continue;
			}
			if (checkYourIndex == false) {
				System.out.println("Friend not registered under Index "+storemyIndex+", please re-enter Index.");	
				continue;
			}
			break;
		}
	// check for schedule clash for ME
	checkYourClash = checkforScheduleClash(Username,storefriendIndex);
	if (checkYourClash==true) {
		System.out.println("Friend's Index "+storefriendIndex+"clases with your schedule, please re-renter.");	
		continue;}
	// check for schedule clash for FRIEND
	checkFClash = checkforScheduleClash(friendsUsername,storemyIndex);
	if (checkFClash==true) {
		System.out.println("Your Index "+storemyIndex+"clases with Friend's schedule, please re-renter.");	
		continue;}
	break;
	}
	//
	
	System.out.println("Indexes swapped Successfully!");	
	}
}