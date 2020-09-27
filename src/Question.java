import java.util.ArrayList;

interface Question { //chose to do an interface instead of abstract class because I don't really need to code anything in Question
    //and methods will be overrode by subclasses anyways
    //split question into two: those that have one answer (SingleChoiceQuestion) and those where you can choose multiple (MultipleChoiceQuestion)


    String[] getAnswerChoices();

    void setAnswerChoices(String[] answerChoices);

    ArrayList pickAnswer(); //no need to implement this in parent class because both child classes have different implementations




}
