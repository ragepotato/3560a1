abstract class Question {
    private String[] answerChoices;



    public Question() {

    }

    abstract String[] getAnswerChoices();

    abstract void setAnswerChoices(String[] answerChoices);
     abstract String[] pickAnswer();




}
