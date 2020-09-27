import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class SimulationDriver {



    public static void main(String[] args) {

        VotingService votingService = new VotingService(questionType());
        getClassAnswers(votingService);
        votingService.getResults();


    }

    public static Question questionType(){ //determines question type, either multiple choice or single choice
        Random r = new Random();
        int questionNumber = r.nextInt(2) + 1;
        System.out.println(questionNumber);

        if (questionNumber == 1){
            Question question = new SingleChoiceQuestion(new String[]{"True", "False"});  //change to whatever, you can only pick one answer
            return question;
//            votingService.setSingleChoice(true);
//            studentAnswered(question, votingService);
        } else {
            Question question = new MultiChoiceQuestion(new String[]{"A", "B", "C", "D"}); //change to whatever, you can pick multiple answers
            return question;
//            studentAnswered(question, votingService);
        }
    }



    public static void getClassAnswers(VotingService votingService) { //generates number of students and answers
        int numberOfStudents = 15; //how many students, CAN CHANGE
        for (int i = 0; i < numberOfStudents; i++) {
            Student student1 = new Student(votingService.getVotingAnswers());
            String[] studentAnswer = student1.getStudentAnswer(); //generates student answers
            String studentID = student1.getUniqueID();

            System.out.println(studentID + ": Student " + (i + 1) + " chose " + Arrays.toString(studentAnswer));

            votingService.setiVote(studentID, studentAnswer);


            if(i % 3 == 0){ //some students change their answers
                Student student2 = new Student(votingService.getVotingAnswers());

                String[] studentAnswer2 = student2.getStudentAnswer();
                votingService.setiVote(studentID, studentAnswer2);
                System.out.println(studentID + ": Student " + (i + 1) + " changed answer to " + Arrays.toString(studentAnswer2));
                System.out.println("-----------Student " + (i+1) + " FINAL ANSWER IS " + Arrays.toString(studentAnswer2));
            }
            else{
                System.out.println("-----------Student " + (i+1) + " FINAL ANSWER IS " + Arrays.toString(studentAnswer));
            }

        }



    }



}
