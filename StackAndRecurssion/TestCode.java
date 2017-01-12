import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestCode {

	public static void main(String args[]) {
		// MyStack stack = new MyStack(10);
		// for(int i = 0; i< 11 ; i++)
		// stack.push(i);
		//
		// for(int i = 0; i< 11 ; i++)
		// System.out.println(stack.pop());

//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String expr = "";
//		String result = "";
//		try {
//			expr = br.readLine();
//			result = (new InfixToPostfix2()).covertToPostfix(expr);
//			System.out.println("result = " + result);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		TwoStacksInOneArray s = new TwoStacksInOneArray(10);
		System.out.println(s.popStack1());
		System.out.println(s.popStack2());
		
		s.pushStack1(0);
		s.pushStack1(1);
		s.pushStack1(2);
		s.pushStack1(3);
		s.pushStack1(4);
		s.pushStack1(5);
		s.displayStack1();
		
		s.pushStack2(10);
		s.pushStack2(9);
		s.pushStack2(8);
		s.displayStack2();
		
		s.pushStack2(7);
		s.pushStack2(6);
		s.displayStack2();
		

	}
}
