package management_on_school.pojos.student_management.vicedean_student_management;

import java.io.Serializable;

public class StudentPostResponseVDPojo implements Serializable {
	private ObjectVDPojo object;
	private String message;

	public StudentPostResponseVDPojo() {
	}

	public StudentPostResponseVDPojo(ObjectVDPojo object, String message) {
		this.object = object;
		this.message = message;
	}

	public void setObject(ObjectVDPojo object){
		this.object = object;
	}

	public ObjectVDPojo getObject(){
		return object;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"StudentPostResponseVDPojo{" + 
			"object = '" + object + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}