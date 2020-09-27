import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

//Stephen Tayag
//CS 3560
public class SimulationDriver {
//all variables are private within their respective classes, use getters/setters
// methods are mostly default so they work with other classes in package
    public static void main(String[] args) {

        VotingService votingService = new VotingService(questionType());
        //1) create a question type and configure the answers (questionType)
       // 2) configure the question for iVote Service; (votingService)
        getClassAnswers(votingService);
        //3) randomly generate a number students and the answers (getClassAnswers)
        // 4) submit all the students’ answers to iVote Service (getClassAnswers)
        votingService.getResults();
        //5) call the iVote Service output function to display the result. (getResults)

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
        int numberOfStudents = 15; //how many students, CAN CHANGE
        for (int i = 0; i < numberOfStudents; i++) {
            Student student1 = new Student(votingService.getVotingAnswers());
            ArrayList<String> studentAnswer = student1.getStudentAnswer(); //generates student answers
            String studentID = student1.getUniqueID();

            System.out.println(studentID + ": Student " + (i + 1) + " chose " + studentAnswer.toString());

            votingService.setiVote(studentID, studentAnswer);


            if(i % 3 == 0){ //testing for some students change their answers
                Student studentChange = new Student(votingService.getVotingAnswers());
                ArrayList<String> studentAnswerChange = studentChange.getStudentAnswer();
                votingService.setiVote(studentID, studentAnswerChange);
                System.out.println(studentID + ": Student " + (i + 1) + " changed answer to " + studentAnswerChange.toString());
                System.out.println("FINAL ANSWER: Student " + (i+1) + " chose " + studentAnswerChange.toString());
            }
            else{
                System.out.println("FINAL ANSWER: Student " + (i+1) + " chose " + studentAnswer.toString());
            }
            System.out.println();
        }



    }



}
