import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Naran Kongpithaksilp #6180233
 */
public class GradeBook {

    // Do not modify these
    private List<Double> assignmentScores;
    private List<Double> quizScores;
    private double midtermScore;
    private double finalScore;
    private Course course;

    // Creates an empty grade book
    public GradeBook() {
        assignmentScores = new ArrayList<>();
        quizScores = new ArrayList<>();
        midtermScore = 0.0;
        finalScore = 0.0;
    }

    // Records the score of a particular assignment
    // Note: First assignment is assignment 1
    public void setAssignmentScore(int assignmentNumber, double score) {
        if (assignmentNumber > assignmentScores.size()) {
            for (int i = assignmentScores.size(); i < assignmentNumber; i++) {
                assignmentScores.add(0.0);
            }
        }
        assignmentScores.set(assignmentNumber-1,score);
    }
    // Records the score of a particular quiz
    // Note: First quiz is quiz 1
    public void setQuizScore(int quizNumber, double score) {
        if (quizNumber > quizScores.size()) {
            for (int i = quizScores.size(); i < quizNumber; i++) {
                quizScores.add(0.0);
            }
        }
        quizScores.set(quizNumber-1,score);
    }

    // Returns average score after dropping <numDrop> lowest scores.
    //
    // You must assume that the total number of assignments/quizzes is the
    // maximum of the assignment ids that has been recorded, and
    // assume scores of 0.0 for unrecorded scores.
    //
    // For example, if only scores of quiz 1 and 3 are recorded,
    // you should assume that there are 3 quizzes and quiz 2 score is 0.0.
    private double getAverageScore(List<Double> scores, int numDrop) {
        if (scores.isEmpty() || numDrop >= scores.size())
            return 0.0;
        int total = scores.size()-numDrop;
        double sum = 0.0;
        List<Double> temp = new ArrayList<Double>(scores);
        Collections.sort(temp);
        for (int i = numDrop;i<scores.size();i++) {
                sum += temp.get(i);
        }
        return sum/total;
    }

    public double getAverageQuizScore(int numDrop) {
        return getAverageScore(quizScores,numDrop);
    }

    public double getAverageAssignmentScore(int numDrop) {
        return getAverageScore(assignmentScores,numDrop);
    }

    // Returns the term weighted average according to the following formula:
    //  term_avg = (avg_assn_score * assn_weight% + avg_quiz_score * quiz_weight%
    //             + midterm_score * midterm_weight% + final_score * final_weight%) / 100
    // If the grading scheme is not define, return -1
    public double getTermAverage(int numAssignmentDrop, int numQuizDrop) {
        double avgAssn = getAverageAssignmentScore(numAssignmentDrop);
        double avgQuiz = getAverageQuizScore(numQuizDrop);
        double assnWeight = course.getAssignmentWeight();
        double quizWeight = course.getQuizWeight();
        double midtermWeight = course.getMidtermWeight();
        double finalWeight = course.getFinalWeight();
        return (avgAssn*assnWeight+avgQuiz*quizWeight+midtermScore*midtermWeight+finalScore*finalWeight)/100;
    }

    public void printRawScores() {
        System.out.println("Assignment Scores:");
        for (int i = 0; i < assignmentScores.size();i++) {
            System.out.println(i+1 + " : "+assignmentScores.get(i));
        }
        System.out.println("Quiz Scores:");
        for (int i = 0; i < quizScores.size();i++) {
            System.out.println(i+1 + " : "+quizScores.get(i));
        }
        System.out.println("Midterm Score:"+midtermScore);
        System.out.println("Final Score:"+finalScore);
    }

    public void setMidtermScore(double score) {
        midtermScore = score;
    }

    public void setFinalScore(double score) {
        finalScore = score;
    }

    public void setCourse(String name, double a, double q, double m, double f) {
        course = new Course(name,a,q,m,f);
    }
    // Do not modify this
    public static void main(String[] args) {
        GradeBook book = new GradeBook();

        book.setAssignmentScore(1, 80);
        book.setAssignmentScore(3, 88);
        book.setAssignmentScore(2, 90);

        book.setQuizScore(1,100);
        book.setQuizScore(2,80);

        book.setMidtermScore(100);
        book.setFinalScore(100);

        book.printRawScores();

        System.out.println("Avg Assignment Score (No drop): " + book.getAverageAssignmentScore(0));
        System.out.println("Avg Assignment Score (drop 1): " + book.getAverageAssignmentScore(1));
        System.out.println("Avg Assignment Score (drop 2): " + book.getAverageAssignmentScore(2));
        System.out.println("Avg Assignment Score (drop 3): " + book.getAverageAssignmentScore(3));
        System.out.println("Avg Assignment Score (drop 4): " + book.getAverageAssignmentScore(4));

        System.out.println("Avg Quiz Score (No drop): " + book.getAverageQuizScore(0));
        System.out.println("Avg Quiz Score (drop 1): " + book.getAverageQuizScore(1));
        System.out.println("Avg Quiz Score (drop 2): " + book.getAverageQuizScore(2));

        book.setAssignmentScore(9, 80);
        book.printRawScores();
        System.out.println("Avg Assignment Score (No drop): " + book.getAverageAssignmentScore(0));

    }


}
