package management_on_school.pojos.student_info_management;

import java.io.Serializable;

public class PutObjectPojo implements Serializable {
	private int id;
	private Object midtermExam;
	private Object finalExam;
	private int absentee;
	private String infoNote;
	private String lessonName;
	private int lessonId;
	private int creditScore;
	private int educationTermId;
	private Object average;
	private PutStudentResponsePojo studentResponse;
	private boolean compulsory;
	private String note;

	public PutObjectPojo(int id) {
		this.id = id;
	}

	public PutObjectPojo(int id, Object midtermExam, Object finalExam, int absentee, String infoNote, String lessonName, int lessonId, int creditScore, int educationTermId, Object average, PutStudentResponsePojo studentResponse, boolean compulsory, String note) {
		this.id = id;
		this.midtermExam = midtermExam;
		this.finalExam = finalExam;
		this.absentee = absentee;
		this.infoNote = infoNote;
		this.lessonName = lessonName;
		this.lessonId = lessonId;
		this.creditScore = creditScore;
		this.educationTermId = educationTermId;
		this.average = average;
		this.studentResponse = studentResponse;
		this.compulsory = compulsory;
		this.note = note;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setMidtermExam(Object midtermExam){
		this.midtermExam = midtermExam;
	}

	public Object getMidtermExam(){
		return midtermExam;
	}

	public void setFinalExam(Object finalExam){
		this.finalExam = finalExam;
	}

	public Object getFinalExam(){
		return finalExam;
	}

	public void setAbsentee(int absentee){
		this.absentee = absentee;
	}

	public int getAbsentee(){
		return absentee;
	}

	public void setInfoNote(String infoNote){
		this.infoNote = infoNote;
	}

	public String getInfoNote(){
		return infoNote;
	}

	public void setLessonName(String lessonName){
		this.lessonName = lessonName;
	}

	public String getLessonName(){
		return lessonName;
	}

	public void setLessonId(int lessonId){
		this.lessonId = lessonId;
	}

	public int getLessonId(){
		return lessonId;
	}

	public void setCreditScore(int creditScore){
		this.creditScore = creditScore;
	}

	public int getCreditScore(){
		return creditScore;
	}

	public void setEducationTermId(int educationTermId){
		this.educationTermId = educationTermId;
	}

	public int getEducationTermId(){
		return educationTermId;
	}

	public void setAverage(Object average){
		this.average = average;
	}

	public Object getAverage(){
		return average;
	}

	public void setStudentResponse(PutStudentResponsePojo studentResponse){
		this.studentResponse = studentResponse;
	}

	public PutStudentResponsePojo getStudentResponse(){
		return studentResponse;
	}

	public void setCompulsory(boolean compulsory){
		this.compulsory = compulsory;
	}

	public boolean isCompulsory(){
		return compulsory;
	}

	public void setNote(String note){
		this.note = note;
	}

	public String getNote(){
		return note;
	}

	@Override
 	public String toString(){
		return 
			"ObjectPojo{" + 
			"id = '" + id + '\'' + 
			",midtermExam = '" + midtermExam + '\'' + 
			",finalExam = '" + finalExam + '\'' + 
			",absentee = '" + absentee + '\'' + 
			",infoNote = '" + infoNote + '\'' + 
			",lessonName = '" + lessonName + '\'' + 
			",lessonId = '" + lessonId + '\'' + 
			",creditScore = '" + creditScore + '\'' + 
			",educationTermId = '" + educationTermId + '\'' + 
			",average = '" + average + '\'' + 
			",studentResponse = '" + studentResponse + '\'' + 
			",compulsory = '" + compulsory + '\'' + 
			",note = '" + note + '\'' + 
			"}";
		}
}