package Entities;

import model.exceptions.DomainExceptions;

public class Account {
	Integer number; // numero
	String holder; // Titular da conta
	Double balance; // saldo
	Double withDrawLimit; // limite de saque

	public void deposit(Double amount) {
		balance = balance + amount;
	}

	public void withdraw(Double amount) throws DomainExceptions {
		validadeWithdraw(amount);
		balance = balance - amount;
	}

	public void validadeWithdraw(Double amount) throws DomainExceptions {
		if (amount > getWithDrawLimit()) {
			throw new DomainExceptions("Error !! Amount greater than withdrawal limit");
		}
		if (amount > getBalance()) {
			throw new DomainExceptions("insufficient funds");
		}

	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getWithDrawLimit() {
		return withDrawLimit;
	}

	public void setWithDrawLimit(Double withDrawLimit) {
		this.withDrawLimit = withDrawLimit;
	}

	public Account(Integer number, String holder, Double balance, Double withDrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withDrawLimit = withDrawLimit;
	}

	public Account() {
	}
}
