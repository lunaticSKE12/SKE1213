package SKE13;
import java.util.*;
/**
 * Stack encryption code
 * @author Lunatic's PC
 */

/* HINT A TO Z is 1 - 26 */

public class Stack {
	private static Scanner in;
	public static final int MAX = 6;
	private static int[] stack = new int[MAX];
	private static int top = 0;
	/**
	 * push method use for push data into element in stack
	 * if stack overflow it can't push data into stack
	 */
	public void push(){
		if(top == MAX){
			System.out.println("Overflow\n");
		}else{
			int element;
			System.out.println("Enter Element: ");
			element = in.nextInt();
			System.out.println("Element " + element + " has been push at index " + top + "\n");
			stack[top++] = element;

		}
	}

	/**
	 * pop method use for pull data in stack out and delete
	 * if underflow can't pop data in stack
	 */
	public void pop(){
		if(top == 0){
			System.out.println("Underflow\n");
		}else{
			stack[--top] = 0;
			System.out.println("Element has been popped out");
			System.out.println();
		}

	}

	/**
	 * display method use to display all stack element 
	 */
	public void display(){

		if(top == 0){
			System.out.println("Stack is Empty!!\n");
		}else{
			int i;
			for(i = MAX - 1 ; i >= 0 ; i--){
				System.out.println("|\t" + stack[i] + "\t|");
				System.out.println("-----------------");
			}
		}

	}

	public static void main(String[] args) {
		int choice;
		Stack s = new Stack();
		/* choice to select for run program */
		while(true){
			System.out.println("1.Push element to stack");
			System.out.println("2.Pop element from stack");
			System.out.println("3.Display all element of stack");
			System.out.println("4.Quit");
			System.out.println("Enter your choice : ");
			in = new Scanner(System.in);
			choice = in.nextInt();
			switch(choice){
			case 1:
				s.push();
				break;
			case 2:
				s.pop();
				break;
			case 3:
				s.display();
				break;
			case 4:
				System.out.println("OUTPUT IS!!");
				for(int i = 0 ; i < MAX ; i++){
					System.out.print(stack[i] + " ");
				}
				System.exit(1);
			default:
				System.out.println("Enter a valid choice!!\n");
			}
		}

	}
}
