package management_on_school.pojos.teacher_management;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeacherResponsePojo_hu implements Serializable {


	private TeacherObjectPojo_hu object;
	private String message;
	private String httpStatus;



	public TeacherResponsePojo_hu() {
	}

	public TeacherResponsePojo_hu(TeacherObjectPojo_hu object, String message, String httpStatus) {
		this.object = object;
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public void setObject(TeacherObjectPojo_hu object){
		this.object = object;
	}

	public TeacherObjectPojo_hu getObject(){
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
			"ViceDeanPostResponsePojo{" + 
			"object = '" + object + '\'' + 
			",message = '" + message + '\'' + 
			",httpStatus = '" + httpStatus + '\'' + 
			"}";
		}
}