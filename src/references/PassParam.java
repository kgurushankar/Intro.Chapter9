package references;

public class PassParam {
	public static void main(String args[]) {
		int num1 = 5;
		int num2 = num1;

		System.out.println("Num1 is: " + num1);
		System.out.println("Num2 is: " + num2);

		Storage f1 = new Storage(5, 9);
		Storage f2 = f1;

		System.out.println("The value in f1 " + f1);
		System.out.println("The value in f2 " + f2);

		f1.setNum1(100);
		f1.setNum2(500);

		System.out.println("The values of f1 are :" + f1.getNum1() + " and " + f1.getNum2());
		System.out.println("The values of f2 are :" + f2.getNum1() + " and " + f2.getNum2());

		f2 = new Storage(13, 7);

		System.out.println("The values of f1 are :" + f1.getNum1() + " and " + f1.getNum2());
		System.out.println("The values of f2 are :" + f2.getNum1() + " and " + f2.getNum2());

	}
}
