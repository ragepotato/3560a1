import java.util.ArrayList;

abstract class Question { //this class must be abstract because we use an abstract method
    //split question into two: those that have one answer (SingleChoiceQuestion) and those where you can choose multiple (MultipleChoiceQuestion)
    private String[] answerChoices;

    String[] getAnswerChoices(){
        return answerChoices;
    }

    void setAnswerChoices(String[] answerChoices){
        this.answerChoices = answerChoices;
    }

    abstract ArrayList pickAnswer(); //no need to implement this in parent class because both child classes have different implementations




}
