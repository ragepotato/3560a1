import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class MultiChoiceQuestion implements Question{ //implements methods in Question but for multiple answers
    //methods have to be public
    private String[] answerChoices;

    MultiChoiceQuestion(String[] answerChoices) {
        this.answerChoices = answerChoices;
    }

    public String[] getAnswerChoices(){
        return answerChoices;
    }

    public void setAnswerChoices(String[] answerChoices){
        this.answerChoices = answerChoices;
    }

    public ArrayList pickAnswer(){
        Random r = new Random();
        ArrayList<String> pickedAnswer = new ArrayList<String>();
        int howMany = r.nextInt(answerChoices.length) + 1; //multiple choice- how many answers?
        for (int i = 0; i< howMany; i++){
            String temp = answerChoices[r.nextInt(answerChoices.length)]; //pick a random string
            if (!pickedAnswer.contains(temp)){//if not one of student's answers already, make it one

                pickedAnswer.add(temp);
            }
        }
        return pickedAnswer;
    }




}
