package time;

/*

****Correct TimeTest output****

Testing Constructors:

Time t1 = 0:00
Time t2 = 13:05

Testing Methods:

0:00 in minutes is 0
20:45 in minutes is 1245
0:00 is less than 20:45? true
20:45 is less than 0:00? false
13:00 is less than 8:30? false
780 minutes have gone between 0:00 and 13:00
735 minutes have gone between 8:30 and 20:45
705 minutes have gone between 20:45 and 8:30

Testing AM/PM Functionality:

24 hour time: 20:45
Switched to AMPM time: 8:45 PM

AMPM time: 8:45 PM
Switched to 24 hour time: 20:45

24 hour time: 0:00
Switched to AMPM time: 12:00 AM

*/

public class TimeTest {

	public static void testConstructors() {
		System.out.println("\nTesting Constructors:\n");

		Time t1 = new Time();
		Time t2 = new Time(13, 5);

		t1.lessThan(t2);

		// Time t3 = new Time(24,0);
		// Time t4 = new Time(-1,30);

		System.out.println("Time t1 = " + t1);
		System.out.println("Time t2 = " + t2);
		// System.out.println("Time t3 = " + t3);
		// System.out.println("Time t4 = " + t4);
	}

	public static void testMethods() {
		System.out.println("\nTesting Methods:\n");

		Time t1 = new Time();
		Time t2 = new Time(8, 30);
		Time t3 = new Time(13, 0);
		Time t4 = new Time(20, 45);

		System.out.println(t1 + " in minutes is " + t1.toMins());
		System.out.println(t4 + " in minutes is " + t4.toMins());
		System.out.println(t1 + " is less than " + t4 + "? " + t1.lessThan(t4));
		System.out.println(t4 + " is less than " + t1 + "? " + t4.lessThan(t1));
		System.out.println(t3 + " is less than " + t2 + "? " + t3.lessThan(t2));
		System.out.println(t3.elapsedSince(t1) + " minutes have gone between " + t1 + " and " + t3);
		System.out.println(t4.elapsedSince(t2) + " minutes have gone between " + t2 + " and " + t4);
		System.out.println(t2.elapsedSince(t4) + " minutes have gone between " + t4 + " and " + t2);
	}

	public static void testAMPM() {
		System.out.println("\nTesting AM/PM Functionality:\n");
		Time t1 = new Time(20, 45);
		Time t2 = new Time(8, 45, false);
		Time t3 = new Time(0, 0);

		System.out.println("24 hour time: " + t1);
		t1.setPrintAMPM(true);
		System.out.println("Switched to AMPM time: " + t1);
		System.out.println();
		System.out.println("AMPM time: " + t2);
		t2.setPrintAMPM(false);
		System.out.println("Switched to 24 hour time: " + t2);
		System.out.println();
		System.out.println("24 hour time: " + t3);
		t3.setPrintAMPM(true);
		System.out.println("Switched to AMPM time: " + t3);
	}

	public static void main(String[] args) {
		testConstructors();
		testMethods();
		testAMPM();
	}

}
