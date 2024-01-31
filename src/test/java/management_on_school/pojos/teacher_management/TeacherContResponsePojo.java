package management_on_school.pojos.teacher_management;

import java.io.Serializable;

public class TeacherContResponsePojo implements Serializable {
    private TeacherContObjectPojo object;
    private String message;
    private String httpStatus;

    public TeacherContResponsePojo() {
    }

    public TeacherContResponsePojo(TeacherContObjectPojo object, String message, String httpStatus) {
        this.object = object;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public void setObject(TeacherContObjectPojo object){
        this.object = object;
    }

    public TeacherContObjectPojo getObject(){
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
                "TeacherContResponsePojoTurgay{" +
                        "object = '" + object + '\'' +
                        ",message = '" + message + '\'' +
                        ",httpStatus = '" + httpStatus + '\'' +
                        "}";
    }
}
