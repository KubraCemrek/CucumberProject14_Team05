package management_on_school.pojos.lesson_management;

import java.io.Serializable;

public class LessonSaveMeResponsePojo implements Serializable {
	private Object8_9Pojo object;
	private String message;
	private String httpStatus;

	public LessonSaveMeResponsePojo() {
	}

	public LessonSaveMeResponsePojo(Object8_9Pojo object, String message, String httpStatus) {
		this.object = object;
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public void setObject(Object8_9Pojo object){
		this.object = object;
	}

	public Object8_9Pojo getObject(){
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
			"LessonSaveMePojo{" + 
			"object = '" + object + '\'' + 
			",message = '" + message + '\'' + 
			",httpStatus = '" + httpStatus + '\'' + 
			"}";
		}
}