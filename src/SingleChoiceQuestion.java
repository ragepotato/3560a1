import java.util.ArrayList;
import java.util.Random;

class SingleChoiceQuestion implements Question { //implements methods in Question but for multiple answers
    //methods have to be public
    private String[] answerChoices;

    SingleChoiceQuestion(String[] answerChoices) {
        this.answerChoices = answerChoices;
    }

    public String[] getAnswerChoices(){
        return answerChoices;
    }

    public void setAnswerChoices(String[] answerChoices){
        this.answerChoices = answerChoices;
    }



    public ArrayList pickAnswer() {
        Random r = new Random();
        ArrayList<String> pickedAnswer = new ArrayList<String>();
        pickedAnswer.add(answerChoices[r.nextInt(answerChoices.length)]);
        return pickedAnswer;
    }

}
