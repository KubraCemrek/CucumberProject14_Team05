package management_on_school.pojos.student_management.admin_student_management;

import java.io.Serializable;

public class StudentPostResponseAdminPojo implements Serializable {
	private ObjectAdminPojo object;
	private String message;

	public StudentPostResponseAdminPojo() {
	}

	public StudentPostResponseAdminPojo(ObjectAdminPojo object, String message) {
		this.object = object;
		this.message = message;
	}

	public void setObject(ObjectAdminPojo object){
		this.object = object;
	}

	public ObjectAdminPojo getObject(){
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