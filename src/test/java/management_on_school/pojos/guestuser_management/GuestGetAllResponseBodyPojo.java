package management_on_school.pojos.guestuser_management;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GuestGetAllResponseBodyPojo implements Serializable {
	private List<GuestGetAllContentListPojo> content;

	public GuestGetAllResponseBodyPojo() {
	}

	public GuestGetAllResponseBodyPojo(List<GuestGetAllContentListPojo> content) {
		this.content = content;
	}

	public void setContent(List<GuestGetAllContentListPojo> content){
		this.content = content;
	}

	public List<GuestGetAllContentListPojo> getContent(){
		return content;
	}

	@Override
 	public String toString(){
		return 
			"GuestResponseBodyPojo{" + 
			"content = '" + content + '\'' + 
			"}";
		}
}