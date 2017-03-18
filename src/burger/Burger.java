package burger;

public class Burger {

	public static final int UNCOOKED = 0;
	public static final int RARE = 7;
	public static final int MEDIUM_RARE = 12;
	public static final int MEDIUM = 17;
	public static final int DONE = 22;
	public static final int WELLDONE = 27;
	public static final int OVERDONE = 33;

	private int numberOfPatties;
	private int levelOfCooking;
	private boolean cheese;
	private String[] toppings;

	public Burger(int cooked, int patties, boolean cheese) {
		this.levelOfCooking = cooked;
		this.numberOfPatties = patties;
		toppings = new String[0];
		this.cheese = false;

	}

	public Burger(int cooked, int patties) {
		this(cooked, patties, false);

	}

	public Burger(int cooked, int patties, String toppings) {
		this.levelOfCooking = cooked;
		this.numberOfPatties = patties;
		this.toppings = new String[1];
		this.toppings[0] = toppings;
	}

	public Burger(int cooked, int patties, String[] toppings) {
		this.levelOfCooking = cooked;
		this.numberOfPatties = patties;
		this.toppings = toppings;
	}

	/** 2 patty, Medium cooked, cheese, and mushroom */
	public Burger() {
		this.levelOfCooking = Burger.MEDIUM;
		this.numberOfPatties = 2;
		this.toppings = new String[1];
		this.cheese = true;
		this.toppings[0] = "mushroom";
	}

	/** 1 patty = $2.00, 50 cents for cheese, $1 for each topping */
	public double getTotalCost() {
		return this.numberOfPatties * 2.0 + ((cheese) ? .50 : 0) + toppings.length;
	}

	public boolean isJuicierThan(Burger other) {

		return this.levelOfCooking < other.levelOfCooking;
	}

	public String toString() {
		String cooked = (levelOfCooking <=5) ? "uncooked"
				: (levelOfCooking <= 10) ? "rare"
						: (levelOfCooking <= 15) ? "medium rare"
								: (levelOfCooking <= 20) ? "medium"
										: (levelOfCooking <= 25) ? "cooked"
												: (levelOfCooking <= 30) ? "well done" : "overcooked";
		String base = "Burger with " + this.numberOfPatties + " " + cooked + " patt"
				+ ((this.numberOfPatties == 1) ? "y" : "ies");
		String[] items = new String[((cheese) ? 1 : 0) + this.toppings.length];
		if (cheese) {
			items[0] = "cheese";
		}
		for (int i = ((cheese) ? 1 : 0); i < items.length; i++) {
			items[i] = this.toppings[i - ((cheese) ? 1 : 0)];
		}

		if (items.length == 0) {
			return base;
		} else if (items.length == 1) {
			return (base + " and " + items[0]);
		} else {
			StringBuilder out = new StringBuilder(base);
			for (int i = 0; i < items.length - 1; i++) {
				out.append(", ");
				out.append(items[i]);
			}
			out.append(", and ");
			out.append(items[items.length - 1]);
			return out.toString();
		}

	}
}
