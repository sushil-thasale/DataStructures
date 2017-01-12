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
		
		CircularQueue q = new CircularQueue(10);
		for(int i =0; i< 11; i++)
			q.insert(""+i);
		
		q.display();
		System.out.println();
		
		for(int i =0; i< 11; i++)
			System.out.println(q.remove());

	}
}
