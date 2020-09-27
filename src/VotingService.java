import java.util.*;

public class VotingService {
    private Question votingAnswers;
    private HashMap iVote;


    VotingService(Question votingAnswers) {
        this.votingAnswers = votingAnswers;
        this.iVote = new HashMap<String, String[]>();
    }


    Question getVotingAnswers() {
        return votingAnswers;
    }

    void setVotingAnswers(Question votingAnswers) {
        this.votingAnswers = votingAnswers;
    }


    HashMap getiVote() {
        return iVote;
    }

    void setiVote(String studentID, ArrayList studentAnswer) {
        // System.out.println(studentID + " --- " + Arrays.toString(studentAnswer));
        iVote.put(studentID, studentAnswer);
    }


    int getIVoteSize() {
        return iVote.size();
    }

    void getResults() {
        System.out.println("IVote size: " + getIVoteSize());

        for (int i = 0; i < votingAnswers.getAnswerChoices().length; i++) {

            String answerChoice = votingAnswers.getAnswerChoices()[i];

            Iterator voteIterator = iVote.entrySet().iterator();
            int count = 0;
            while (voteIterator.hasNext()) {

                Map.Entry mapElement = (Map.Entry) voteIterator.next();

                count += Collections.frequency((Collection<?>) mapElement.getValue(), answerChoice);

            }

            System.out.println(answerChoice + ": " + count);

        }


    }

}
