import java.util.Arrays;
import java.util.Random;

public class MultiChoiceQuestion extends Question{
    private String[] answerChoices;

    public MultiChoiceQuestion(String[] answerChoices) {

        this.answerChoices = answerChoices;
    }

    public String[] getAnswerChoices() {
        return answerChoices;
    }

    public void setAnswerChoices(String[] answerChoices) {
        this.answerChoices = answerChoices;
    }

    public String[] pickAnswer(){
        Random r = new Random();
        String[] pickedAnswer = new String[]{answerChoices[r.nextInt(answerChoices.length)]};



        return  pickedAnswer;
    }




}
