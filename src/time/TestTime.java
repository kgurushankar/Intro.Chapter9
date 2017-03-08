package time;

import java.util.Scanner;

public class TestTime {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Time 1");
		System.out.print("Enter hours:mins ");
		String input1[] = in.nextLine().split(":");
		int h1 = Integer.parseInt(input1[0]);
		int m1 = Integer.parseInt(input1[1]);
		Time t1 = new Time(h1, m1);

		System.out.println("Time 2");
		System.out.print("Enter hours:mins ");
		String input2[] = in.nextLine().split(":");
		int h2 = Integer.parseInt(input2[0]);
		int m2 = Integer.parseInt(input2[1]);
		Time t2 = new Time(h2, m2);

		in.close();

		System.out.println(t1 + " <= " + t2 + " ? " + t1.lessThan(t2));
		System.out.println(t2.elapsedSince(t1) + " minutes elapsed from t1 to t2.");
	}
}
