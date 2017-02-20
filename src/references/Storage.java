package references;

public class Storage {
	int[] num;

	public Storage(int arg0, int arg1) {
		num = new int[2];
		num[0] = arg0;
		num[1] = arg1;
	}

	public int getNum1() {
		return num[0];
	}

	public void setNum1(int num) {
		this.num[0] = num;
	}

	public int getNum2() {
		return num[1];
	}

	public void setNum2(int num) {
		this.num[1] = num;
	}
}
