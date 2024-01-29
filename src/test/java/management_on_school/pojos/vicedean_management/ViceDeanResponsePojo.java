package management_on_school.pojos.vicedean_management;

import java.io.Serializable;

public class ViceDeanResponsePojo implements Serializable {
	private ViceDeanObjectPojo object;
	private String message;
	private String httpStatus;

	public ViceDeanResponsePojo() {
	}

	public ViceDeanResponsePojo(ViceDeanObjectPojo object, String message, String httpStatus) {
		this.object = object;
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public void setObject(ViceDeanObjectPojo object){
		this.object = object;
	}

	public ViceDeanObjectPojo getObject(){
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
			"ResponseViceDeanTPojo{" + 
			"object = '" + object + '\'' + 
			",message = '" + message + '\'' + 
			",httpStatus = '" + httpStatus + '\'' + 
			"}";
		}
}