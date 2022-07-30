public class index {
	
	private student waitlist[];
	private Lesson lessonlist[];//
	public String CourseCode;
	public int IndexNumber;//
	public int slotsVacancy;
	public int slotsTotalsize;//

	//constructor
	public index(int IndexNumber, int slotsTotalsize, Lesson lessonlist[]) {
		this.IndexNumber = IndexNumber;
		this.slotsTotalsize = slotsTotalsize;
	}
	
	boolean checkWaitlist (){
		if (waitlist.length ==0) {	
			return false;
	}
		else {
			return true;
		}
	}
	public int getIndexNumber() {
		return IndexNumber;}
	public int getslotsVacancy() {
		return slotsVacancy;
	}
	public int getslotsTotalsize() {
		return slotsTotalsize;
	}
}
