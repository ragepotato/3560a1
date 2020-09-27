import java.util.Random;

public class SingleChoiceQuestion extends Question {
    private String[] answerChoices;

    public SingleChoiceQuestion(String[] answerChoices) {
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

        return new String[]{answerChoices[r.nextInt(answerChoices.length)]};
    }

}
