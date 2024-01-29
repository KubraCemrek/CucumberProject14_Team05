package management_on_school.pojos.student_management.vicedean_student_management;

import java.io.Serializable;

public class StudentDeleteResponseVDPojo implements Serializable {
	private String message;
	private String httpStatus;

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

	public StudentDeleteResponseVDPojo() {
	}

	public StudentDeleteResponseVDPojo(String message, String httpStatus) {
		this.message = message;
		this.httpStatus = httpStatus;
	}

	@Override
 	public String toString(){
		return 
			"StudentDeleteResponsePojo{" + 
			"message = '" + message + '\'' + 
			",httpStatus = '" + httpStatus + '\'' + 
			"}";
		}
}