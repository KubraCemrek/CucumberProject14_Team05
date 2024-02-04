package management_on_school.pojos.student_info_management;

import java.io.Serializable;

public class DeleteResponsePojo implements Serializable {
	private String message;
	private String httpStatus;

	public DeleteResponsePojo() {
	}

	public DeleteResponsePojo(String message, String httpStatus) {
		this.message = message;
		this.httpStatus = httpStatus;
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
			"DeleteResponsePojo{" + 
			"message = '" + message + '\'' + 
			",httpStatus = '" + httpStatus + '\'' + 
			"}";
		}
}