package management_on_school.pojos.lesson_program_management;

public class CurriculumDeletionResponsePojo {
    private String message;
    private String httpStatus;

    public CurriculumDeletionResponsePojo() {
    }

    public CurriculumDeletionResponsePojo(String message, String httpStatus) {
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
                "DersProgramiSilmeResponsePojoTurgay{" +
                        "message = '" + message + '\'' +
                        ",httpStatus = '" + httpStatus + '\'' +
                        "}";
    }
}
