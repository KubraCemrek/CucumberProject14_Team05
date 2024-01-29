package management_on_school.pojos.lesson_management;

import java.util.List;
import java.io.Serializable;

public class Object_10Pojo implements Serializable {
	private int lessonProgramId;
	private String startTime;
	private String stopTime;
	private List<LessonName_10Pojo> lessonName;
	private String day;

	public Object_10Pojo() {
	}

	public Object_10Pojo(int lessonProgramId, String startTime, String stopTime, List<LessonName_10Pojo> lessonName, String day) {
		this.lessonProgramId = lessonProgramId;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.lessonName = lessonName;
		this.day = day;
	}

	public void setLessonProgramId(int lessonProgramId){
		this.lessonProgramId = lessonProgramId;
	}

	public int getLessonProgramId(){
		return lessonProgramId;
	}

	public void setStartTime(String startTime){
		this.startTime = startTime;
	}

	public String getStartTime(){
		return startTime;
	}

	public void setStopTime(String stopTime){
		this.stopTime = stopTime;
	}

	public String getStopTime(){
		return stopTime;
	}

	public void setLessonName(List<LessonName_10Pojo> lessonName){
		this.lessonName = lessonName;
	}

	public List<LessonName_10Pojo> getLessonName(){
		return lessonName;
	}

	public void setDay(String day){
		this.day = day;
	}

	public String getDay(){
		return day;
	}

	@Override
 	public String toString(){
		return 
			"ObjectPojo{" + 
			"lessonProgramId = '" + lessonProgramId + '\'' + 
			",startTime = '" + startTime + '\'' + 
			",stopTime = '" + stopTime + '\'' + 
			",lessonName = '" + lessonName + '\'' + 
			",day = '" + day + '\'' + 
			"}";
		}
}