package management_on_school.pojos.teacher_management;

import java.util.List;

public class ChooseLessonPojo {
    private List<Integer> lessonProgramId;
    private int teacherId;

    public ChooseLessonPojo() {
    }


    public ChooseLessonPojo(List<Integer> lessonProgramId, int teacherId) {
        this.lessonProgramId = lessonProgramId;
        this.teacherId = teacherId;
    }


    public void setLessonProgramId(List<Integer> lessonProgramId){
        this.lessonProgramId = lessonProgramId;
    }

    public List<Integer> getLessonProgramId(){
        return lessonProgramId;
    }

    public void setTeacherId(int teacherId){
        this.teacherId = teacherId;
    }

    public int getTeacherId(){
        return teacherId;
    }

    @Override
    public String toString(){
        return
                "ChooseLessonPojoTurgay{" +
                        "lessonProgramId = '" + lessonProgramId + '\'' +
                        ",teacherId = '" + teacherId + '\'' +
                        "}";
    }
}
