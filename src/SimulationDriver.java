import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class SimulationDriver {



    public static void main(String[] args) {

        VotingService votingService = new VotingService(questionType());
        getClassAnswers(votingService);
        votingService.getResults();


    }

    private static Question questionType(){ //determines question type, either multiple choice or single choice
        Random r = new Random();
        int questionNumber = r.nextInt(2) + 1; //question type random: 1 makes the question single choice, 2 makes it multiple

        if (questionNumber == 1){
            Question question = new SingleChoiceQuestion(new String[]{"True", "False"});  //change to whatever, you can only pick one answer
            return question;

        } else {
            Question question = new MultiChoiceQuestion(new String[]{"A", "B", "C", "D"}); //change to whatever, you can pick multiple answers
            return question;

        }
    }



    private static void getClassAnswers(VotingService votingService) { //generates number of students and answers
        int numberOfStudents = 7; //how many students, CAN CHANGE
        for (int i = 0; i < numberOfStudents; i++) {
            Student student1 = new Student(votingService.getVotingAnswers());
            ArrayList<String> studentAnswer = student1.getStudentAnswer(); //generates student answers
            String studentID = student1.getUniqueID();

            System.out.println(studentID + ": Student " + (i + 1) + " chose " + studentAnswer.toString());

            votingService.setiVote(studentID, studentAnswer);


            if(i % 3 == 0){ //testing for some students change their answers
                Student student2 = new Student(votingService.getVotingAnswers());

                ArrayList<String> studentAnswer2 = student2.getStudentAnswer();
                votingService.setiVote(studentID, studentAnswer2);
                System.out.println(studentID + ": Student " + (i + 1) + " changed answer to " + studentAnswer2.toString());
                System.out.println("-----------Student " + (i+1) + " FINAL ANSWER IS " + studentAnswer2.toString());
            }
            else{
                System.out.println("-----------Student " + (i+1) + " FINAL ANSWER IS " + studentAnswer.toString());
            }

        }



    }



}
