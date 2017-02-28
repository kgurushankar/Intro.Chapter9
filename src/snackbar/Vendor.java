package snackbar;

/**
 * This class implements a vendor that sells one kind of items. A vendor carries
 * out sales transactions.
 */

public class Vendor {
	private int price;
	private int stock;
	private int moneyInserted;
	private int change;
	private static double totalSales;

	public Vendor(int price, int stock) {
		this.price = price;
		this.stock = stock;
		this.moneyInserted = 0;
		Vendor.totalSales = 0;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getStock() {
		return stock;
	}

	public void addMoney(int cents) {
		this.moneyInserted += cents;
	}

	public int getDeposit() {
		return this.moneyInserted;
	}

	public boolean makeSale() {
		if (this.moneyInserted >= this.price && stock > 0) {
			this.stock--;
			Vendor.totalSales += this.price / 100.;
			this.change = this.moneyInserted - this.price;
			return true;
		} else {
			this.change = this.moneyInserted;
			return false;
		}
	}

	public int getChange() {
		this.moneyInserted = 0;
		return this.change;
	}

	public static double getTotalSales() {
		return Vendor.totalSales;
	}
}
