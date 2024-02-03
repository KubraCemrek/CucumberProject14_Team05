package management_on_school.pojos.contact_management;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetContactMessagePojo implements Serializable {
    private List<ContentPojo> content;

    public GetContactMessagePojo() {
    }

    public GetContactMessagePojo(List<ContentPojo> content) {
        this.content = content;
    }

    public void setContent(List<ContentPojo> content){
        this.content = content;
    }

    public List<ContentPojo> getContent(){
        return content;
    }

    @Override
    public String toString(){
        return
                "GetContactMessagePojo{" +
                        "content = '" + content + '\'' +
                        "}";
    }
}
