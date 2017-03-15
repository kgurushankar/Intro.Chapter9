package burger;

public class BurgerChoice {

	public static void main(String[] args) {
		// order a burger with 2 patties medium cooked with cheese
		Burger juicyCheesyDoubleDecker = new Burger(Burger.MEDIUM, 2, true);
		// order a burger with 1 patty well done cooked without cheese;
		Burger justTheWayILikeIt = new Burger(Burger.WELLDONE, 1);

		Burger xtraTopingTrippleDeckerRare = new Burger(Burger.RARE, 3, "bacon");
		// has 2 patty Medium cooked, cheese, and mushroom
		Burger houseSpecial = new Burger();

		System.out.println("houseSpecial burger:  " + houseSpecial);
		System.out.println("juicyDoubleDecker:  " + juicyCheesyDoubleDecker);
		System.out.println("xtraTopingTrippleDecker burger:  " + xtraTopingTrippleDeckerRare);
		System.out.println("justTheWayILikeIt:  " + justTheWayILikeIt);
		// comparing the cook time. less cook time means juicier
		if (juicyCheesyDoubleDecker.isJuicierThan(justTheWayILikeIt))

			System.out.println("juicyCheesyDoubleDecker is juicier!");
		else
			System.out.println("justTheWayILikeIt is juicier!");

		// 1 patty = $2.00, 50 cents for cheese, $1 for each topping
		// How would you implement encapsulation in the this project?

		// comparing the cost.
		if (xtraTopingTrippleDeckerRare.getTotalCost() > houseSpecial.getTotalCost())

			System.out.println("It worths the money!");
		else
			System.out.println("That cheaps!");
	}

}
