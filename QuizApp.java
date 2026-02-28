package Ass;
import java.util.Scanner ;
class Question{
	Scanner Input = new Scanner(System.in) ;
	
	private String userName = "unKonwn";
	
	private int score = 0 ;
	
	private String[][] questions = 
		{
				{" (1) What is the size of int in Java?", "8 bits", "16 bits", "32 bits", "64 bits"} ,
				{" (2) Which keyword creates an object?", "class", "new", "void", "int"},
				{" (3) What does OOP stand for?", "Open Oriented Program", "Object Oriented Programming", "Old Old Program", "None"} ,
				{" (4) Which loop checks condition after executing?", "for", "while", "do-while", "if"} ,
				{" (5) What is the default value of int in Java?", "null", "1", "0", "-1"} 
		}; 
	
	private String[][] answers = 
		{
				{"Q1", "false", "false", "true", "false"},
				{"Q2", "false", "true", "false", "false"},
				{"Q3", "false", "true", "false", "false"},
				{"Q4", "false", "false", "true", "false"},
				{"Q5", "false", "false", "true", "false"},
		}; 
	
	public Question() {
		System.out.println("Welcome In Quiz App With Java Programming");
		System.out.print("Enter Your Name : ");
		String name = Input.nextLine() ;
		this.userName = name ;
	}
	
	public void startQuestion() {
		System.out.println("Welcome " + this.userName +" We Have " + this.questions.length + " Question In Our App ");
		
		for (int i = 0 ; i < this.questions.length ; i++) {
			
			System.out.println(this.questions[i][0]); // display the question
			
			for (int j = 1 ; j <= this.answers.length -1; j ++) {
				System.out.println("(" + j + ") "+ this.questions[i][j]); // display the options
			}
			
			System.out.print("Your Answer is : ");
			
			int ans = Input.nextInt() ;
			
			if (this.answers[i][ans].equals("true")) {  // check if the answer is correct
			    ++score; 
			}
			
		}// end of main loop Block
	} // end of startQuestion Function Block 
	
	public void showScore() {
		System.out.println("Your Score From " + this.questions.length + " Questions is " + this.score);
	}
	
}// end of Question Class 

public class QuizApp {
	public static void main(String[] args) {
		
		Question q = new Question() ;
		q.startQuestion();
		q.showScore();
	}

}
