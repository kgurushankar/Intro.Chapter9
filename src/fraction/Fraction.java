package fraction;
// Represents a fraction with an int numerator and int denominator

// and provides methods for adding and multiplying fractions.

public class Fraction {
	// *** instance variables ***
	private int num;
	private int denom;

	// *** Constructors ***
	/** @return 0/1 */
	public Fraction() // no-args constructor
	{
		num = 0;
		denom = 1;
	}

	/** @return n/1 */
	public Fraction(int n) {
		num = n;
		denom = 1;
	}

	/**
	 * @param n
	 *            numerator
	 * @param d
	 *            denominator
	 * @return n/d
	 */
	public Fraction(int n, int d) {
		if (d != 0) {
			num = n;
			denom = d;
			reduce();
		} else {
			throw new IllegalArgumentException("Fraction construction error: denominator is 0");
		}
	}

	public Fraction(double d) {
		long num = (int) (d * Integer.MAX_VALUE);
		long denom = Integer.MAX_VALUE;

		if (num == 0) {
			denom = 1;
			return;
		}

		if (denom < 0) {
			num = -num;
			denom = -denom;
		}

		long q = gcf(Math.abs(num), denom);
		num /= q;
		denom /= q;

		this.num = (int) num;
		this.denom = (int) denom;

	}

	/**
	 * @param other
	 *            the
	 * @return a fraction equivalent to other
	 */
	public Fraction(Fraction other) // copy constructor
	{
		this.num = other.num;
		this.denom = other.denom;
	}

	// *** public methods ***

	/**
	 * @param other
	 *            another fraction to be added to this fraction
	 * @return sum of fraction and other
	 */
	public Fraction add(Fraction other) {
		return new Fraction(this.num * other.denom + this.denom * other.num, this.denom * other.denom);
	}

	/**
	 * @param m
	 *            an integer to be added to this fraction
	 * @return sum of fraction and m
	 */
	public Fraction add(int m) {
		return new Fraction(num + m * denom, denom);
	}

	/**
	 * @param other
	 *            another fraction to be added to this fraction
	 * @return sum of fraction and other
	 */
	public Fraction subtract(Fraction other) {
		return new Fraction(this.num * other.denom - this.denom * other.num, this.denom * other.denom);
	}

	/**
	 * @param m
	 *            an integer to be added to this fraction
	 * @return sum of fraction and m
	 */
	public Fraction subtract(int m) {
		return new Fraction(num + m * denom, denom);
	}

	/**
	 * @param other
	 *            another fraction to be another factor
	 * @return product of fraction and other
	 */
	public Fraction multiply(Fraction other) {
		return new Fraction(this.num * other.num, this.denom * other.denom);
	}

	/**
	 * @param m
	 *            an integer to be another factor
	 * @return product of fraction and other
	 */
	public Fraction multiply(int m) {
		return new Fraction(num * m, denom);
	}

	/**
	 * @param other
	 *            another fraction to be the divisor
	 * @return quotient of fraction and other
	 */
	public Fraction divide(Fraction other) {
		return new Fraction(this.num * other.denom, this.denom * other.num);
	}

	/**
	 * @param m
	 *            an integer to be the divisor
	 * @return quotient of fraction and m
	 */
	public Fraction divide(int m) {
		return new Fraction(num, denom * m);
	}

	/** @return the reciprocal of the fraction */
	public Fraction reciprocal() {
		return new Fraction(this.num, this.denom);
	}

	/**
	 * @param m
	 *            the exponent
	 * @return the fraction to the M th power
	 */
	public Fraction power(int m) {
		if (m == 0) {
			return new Fraction(1);
		} else if (m > 0) {
			Fraction out = new Fraction(this);
			for (int i = 0; i < m; i++) {
				this.multiply(this);
			}
			return out;
		} else {
			Fraction out = this.reciprocal();
			for (int i = 0; i < m; i++) {
				this.multiply(this);
			}
			return out;
		}
	}

	/**
	 * @param other
	 *            the fraction that this is being compared to
	 * @param mode
	 *            the operator to use
	 * @param mode
	 *            valid input — = , == , > , >= , < , <=
	 * @return this (mode) other
	 */
	public boolean compare(Fraction other, String mode) throws IllegalArgumentException {
		if (mode.equals("=") || mode.equals("==")) {
			return this.equals(other);
		} else if (mode.equals(">")) {
			return (this.num * other.denom > other.denom * this.num);
		} else if (mode.equals(">=")) {
			return (this.num * other.denom >= other.denom * this.num);
		} else if (mode.equals("<")) {
			return (this.num * other.denom < other.denom * this.num);
		} else if (mode.equals("<=")) {
			return (this.num * other.denom <= other.denom * this.num);
		} else {
			throw new IllegalArgumentException("Please enter valid input for mode: = , == , > , >= , < , <=");
		}
	}

	/**
	 * @param other
	 *            the fraction to compare this to
	 * @return this is the same as other
	 */
	public boolean equals(Fraction other) {
		return (this.num == other.num && this.denom == other.denom);
	}

	/** @return value of fraction as double */
	public double getValue() {
		return (double) num / (double) denom;
	}

	/** @return fraction represented as a String */
	@Override
	public String toString() {
		return num + "/" + denom;
	}

	// *** private methods ***

	// Reduces this fraction by the gcf and makes denom > 0
	private void reduce() {
		if (num == 0) {
			denom = 1;
			return;
		}

		if (denom < 0) {
			num = -num;
			denom = -denom;
		}

		int q = gcf(Math.abs(num), denom);
		num /= q;
		denom /= q;
	}

	// Returns the greatest common factor of two positive integers
	private int gcf(int n, int d) {
		if (n <= 0 || d <= 0) {
			throw new IllegalArgumentException("gcf precondition failed: " + n + ", " + d);
		}

		if (n % d == 0)
			return d;
		else if (d % n == 0)
			return n;
		else
			return gcf(n % d, d % n);
	}

	private long gcf(long n, long d) {
		if (n <= 0 || d <= 0) {
			throw new IllegalArgumentException("gcf precondition failed: " + n + ", " + d);
		}

		if (n % d == 0)
			return d;
		else if (d % n == 0)
			return n;
		else
			return gcf(n % d, d % n);
	}
}