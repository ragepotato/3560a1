import java.util.*;

public class VotingService {
    private Question votingAnswers;
    private HashMap iVote;


    VotingService(Question votingAnswers) { //configured by question type
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
        //student id's are key in hashmap, arraylist of that student's answer(s) is value
        //because hashmap, only last student answer is in here
        iVote.put(studentID, studentAnswer);
    }


    int getIVoteSize() {
        return iVote.size();
    }

    void getResults() {
        System.out.println("Number of students voted size: " + getIVoteSize());

        for (int i = 0; i < votingAnswers.getAnswerChoices().length; i++) { //for each of the possible answers

            String answerChoice = votingAnswers.getAnswerChoices()[i];

            Iterator voteIterator = iVote.entrySet().iterator();
            int count = 0;
            while (voteIterator.hasNext()) {  //iterate through hashmap

                Map.Entry mapElement = (Map.Entry) voteIterator.next(); //for each arraylist in the hashmap

                count += Collections.frequency((Collection<?>) mapElement.getValue(), answerChoice);
                //find the frequency of that specific answer, add them together

            }

            System.out.println(answerChoice + ": " + count); //total number of times that answer appears

        }


    }

}
