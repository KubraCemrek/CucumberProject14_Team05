package management_on_school.pojos.student_info_management;

import java.io.Serializable;

public class PutBodyResponsePojo implements Serializable {
	private String absentee;
	private String educationTermId;
	private String finalExam;
	private String infoNote;
	private String lessonId;
	private String midtermExam;

	public PutBodyResponsePojo() {
	}

	public PutBodyResponsePojo(String absentee, String educationTermId, String finalExam, String infoNote, String lessonId, String midtermExam) {
		this.absentee = absentee;
		this.educationTermId = educationTermId;
		this.finalExam = finalExam;
		this.infoNote = infoNote;
		this.lessonId = lessonId;
		this.midtermExam = midtermExam;
	}

	public void setAbsentee(String absentee){
		this.absentee = absentee;
	}

	public String getAbsentee(){
		return absentee;
	}

	public void setEducationTermId(String educationTermId){
		this.educationTermId = educationTermId;
	}

	public String getEducationTermId(){
		return educationTermId;
	}

	public void setFinalExam(String finalExam){
		this.finalExam = finalExam;
	}

	public String getFinalExam(){
		return finalExam;
	}

	public void setInfoNote(String infoNote){
		this.infoNote = infoNote;
	}

	public String getInfoNote(){
		return infoNote;
	}

	public void setLessonId(String lessonId){
		this.lessonId = lessonId;
	}

	public String getLessonId(){
		return lessonId;
	}

	public void setMidtermExam(String midtermExam){
		this.midtermExam = midtermExam;
	}

	public String getMidtermExam(){
		return midtermExam;
	}

	@Override
 	public String toString(){
		return 
			"PutResponsePojo{" + 
			"absentee = '" + absentee + '\'' + 
			",educationTermId = '" + educationTermId + '\'' + 
			",finalExam = '" + finalExam + '\'' + 
			",infoNote = '" + infoNote + '\'' + 
			",lessonId = '" + lessonId + '\'' + 
			",midtermExam = '" + midtermExam + '\'' + 
			"}";
		}
}