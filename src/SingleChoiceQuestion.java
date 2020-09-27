import java.util.ArrayList;
import java.util.Random;

class SingleChoiceQuestion extends Question { //hierarchy, inherited by Question
    private String[] answerChoices;

    SingleChoiceQuestion(String[] answerChoices) {
        this.answerChoices = answerChoices;
    }

    String[] getAnswerChoices(){
        return answerChoices;
    }

    void setAnswerChoices(String[] answerChoices){
        this.answerChoices = answerChoices;
    }



    ArrayList pickAnswer() {
        Random r = new Random();
        ArrayList<String> pickedAnswer = new ArrayList<String>();
        pickedAnswer.add(answerChoices[r.nextInt(answerChoices.length)]);
        return pickedAnswer;
    }

}
