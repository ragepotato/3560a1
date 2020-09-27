import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

class Student {
    private String uniqueID;
    private ArrayList studentAnswer;
    private Question whichQuestion;


    Student(Question whichQuestion) {
        this.uniqueID = UUID.randomUUID().toString().replace("-", ""); //each student has unique UUID
        this.whichQuestion = whichQuestion;

        setStudentAnswer(whichQuestion);
    }


    String getUniqueID() {
        return uniqueID;
    }

    void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    ArrayList getStudentAnswer() {
        return studentAnswer;
    }

    void setStudentAnswer(Question question) { //given the TYPE of question, could return a single or multiple types of answers
        //regardless, stores answer(s) in studentAnswer, an ArrayList
        this.studentAnswer = question.pickAnswer();
    }


    Question getWhichQuestion() {
        return whichQuestion;
    }

    void setWhichQuestion(Question whichQuestion) {
        this.whichQuestion = whichQuestion;
    }
}
