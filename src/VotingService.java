import java.util.*;

public class VotingService {
    private Question votingAnswers;
    private boolean isSingleChoice;
    private HashMap iVote;



    public VotingService(Question votingAnswers) {
        this.votingAnswers = votingAnswers;
        this.isSingleChoice = false;
        this.iVote = new HashMap<String, String[]>();
    }


    public Question getVotingAnswers() {
        return votingAnswers;
    }

    public void setVotingAnswers(Question votingAnswers) {
        this.votingAnswers = votingAnswers;
    }


    public HashMap getiVote() {
        return iVote;
    }

    public void setiVote(String studentID, String[] studentAnswer) {
       // System.out.println(studentID + " --- " + Arrays.toString(studentAnswer));
       iVote.put(studentID, studentAnswer);
    }


    public int getIVoteSize(){
        return iVote.size();
    }

    public void getResults(){
        System.out.println("IVote size: " + getIVoteSize());

        for (int i = 0; i < votingAnswers.getAnswerChoices().length; i++){

            String answerChoice = votingAnswers.getAnswerChoices()[i];

            Iterator voteIterator = iVote.entrySet().iterator();
            int count = 0;
            while (voteIterator.hasNext()) {

                Map.Entry mapElement = (Map.Entry)voteIterator.next();
                /////////////////////
                List<?> list = new ArrayList<>();
                if (mapElement.getValue().getClass().isArray()) {
                    list = Arrays.asList((Object[])mapElement.getValue());
                } else if (mapElement.getValue() instanceof Collection) {
                    list = new ArrayList<>((Collection<?>)mapElement.getValue());
                }
                /////////////////////

//                String[] studentAnswer = (String[])mapElement.getValue();
//                System.out.println(Arrays.toString(studentAnswer));
                count += Collections.frequency(list, answerChoice);

        }
            System.out.println(answerChoice + ": " + count);

//            for (int j = 0; j < studentAnswer.length; j++){
//                count += Collections.frequency(iVote)
//            }

        }

//        System.out.println(iVote.values());
//            System.out.println("True: " + Collections.frequency(iVote.values(), "True"));
//            System.out.println("False: " + Collections.frequency(iVote.values(), "False"));
//            System.out.println("A. " + Collections.frequency(iVote.values(), "A"));
//            System.out.println("B. " + Collections.frequency(iVote.values(), "B"));
//            System.out.println("C. " + Collections.frequency(iVote.values(), "C"));
//            System.out.println("D. " + Collections.frequency(iVote.values(), "D"));



    }


    public boolean isSingleChoice() {
        return isSingleChoice;
    }

    public void setSingleChoice(boolean singleChoice) {
        isSingleChoice = singleChoice;
    }
}
