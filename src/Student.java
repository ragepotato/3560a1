import java.util.Random;
import java.util.UUID;

public class Student {
    private String uniqueID;
    private String[] studentAnswer;
    private Question whichQuestion;


    public Student(Question whichQuestion) {
        this.uniqueID = UUID.randomUUID().toString().replace("-", "");
        this.whichQuestion = whichQuestion;

        setStudentAnswer(whichQuestion);
    }


    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String[] getStudentAnswer() {
        return studentAnswer;
    }

    public void setStudentAnswer(Question question) {

        this.studentAnswer = question.pickAnswer();
    }





}
