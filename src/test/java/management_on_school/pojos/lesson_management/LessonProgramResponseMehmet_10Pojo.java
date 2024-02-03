package management_on_school.pojos.lesson_management;

import java.io.Serializable;

public class LessonProgramResponseMehmet_10Pojo implements Serializable {
	private Object_10Pojo object;
	private String message;
	private String httpStatus;

	public LessonProgramResponseMehmet_10Pojo() {
	}

	public LessonProgramResponseMehmet_10Pojo(Object_10Pojo object, String message, String httpStatus) {
		this.object = object;
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public void setObject(Object_10Pojo object){
		this.object = object;
	}

	public Object_10Pojo getObject(){
		return object;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setHttpStatus(String httpStatus){
		this.httpStatus = httpStatus;
	}

	public String getHttpStatus(){
		return httpStatus;
	}

	@Override
 	public String toString(){
		return 
			"LessonProgramResponseMehmetPojo{" + 
			"object = '" + object + '\'' + 
			",message = '" + message + '\'' + 
			",httpStatus = '" + httpStatus + '\'' + 
			"}";
		}
}