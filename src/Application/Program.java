package Application;

import java.util.Locale;
import java.util.Scanner;

import Entities.Account;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("enter account details");
		System.out.print("Number:");
		Integer number = sc.nextInt();
		System.out.print("holder:");
		String holder = sc.next();
		System.out.print("Initial balance:");
		Double balance = sc.nextDouble();
		System.out.print("With draw limit:");
		Double withDrawLimit = sc.nextDouble();

		Account acc1 = new Account(number, holder, balance, withDrawLimit);

		System.out.println("enter an amount to withdraw:");
		Double amount = sc.nextDouble();

		try {
			acc1.withdraw(amount);
			System.out.println("New balance: $" + String.format("%.2f", acc1.getBalance()));
		} catch (DomainExceptions e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}
}
