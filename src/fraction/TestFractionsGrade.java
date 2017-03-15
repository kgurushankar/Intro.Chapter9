package fraction;

public class TestFractionsGrade {
	public static void testConstructors() {
		Fraction f1 = new Fraction();
		Fraction f2 = new Fraction(7);
		Fraction f3 = new Fraction(12, -20);
		Fraction f4 = new Fraction(f3);

		Fraction f5 = new Fraction(0.25);
		Fraction f6 = new Fraction(0.125);
		Fraction f7 = new Fraction(1.5);
		Fraction f8 = new Fraction(1.0 / 3.0);

		System.out.println("f1 = " + f1);
		System.out.println("f2 = " + f2);
		System.out.println("f3 = " + f3);
		System.out.println("f4 = " + f4);

		System.out.println("f5 = " + f5);
		System.out.println("f5 = " + f6);
		System.out.println("f5 = " + f7);
		System.out.println("f5 = " + f8);

		System.out.println();
	}

	public static void testArithmetic() {
		Fraction f1 = new Fraction(1, 2);
		Fraction f2 = new Fraction(1, 3);

		Fraction sum = f1.add(f2);
		System.out.println(f1 + " + " + f2 + " = " + sum);

		Fraction product = f1.multiply(f2);
		System.out.println(f1 + " * " + f2 + " = " + product);

		Fraction difference = f1.subtract(f2);
		Fraction difference2 = f1.subtract(2);
		System.out.println(f1 + " - " + f2 + " = " + difference);
		System.out.println(f1 + " - " + 2 + " = " + difference2);

		Fraction quotient = f1.divide(f2);
		Fraction quotient2 = f1.divide(2);
		System.out.println(f1 + " / " + f2 + " = " + quotient);
		System.out.println(f1 + " / " + 2 + " = " + quotient2);

		System.out.println();
	}

	public static void testValues() {
		Fraction f = new Fraction(2, 3);
		System.out.println(f + " = " + f.getValue());
		System.out.println();
	}

	public static void main(String[] args) {
		testConstructors();
		testArithmetic();
		testValues();
	}
}
