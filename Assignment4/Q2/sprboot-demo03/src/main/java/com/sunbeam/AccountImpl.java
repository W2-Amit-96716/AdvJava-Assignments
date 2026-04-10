package com.sunbeam;


public class AccountImpl implements Account{
	private int id;
	private String type;
	private double balance;
	private Logger logger;
	
	public AccountImpl() {
		
	}

	public AccountImpl(int id, String type, double balance, Logger logger) {
		super();
		this.id = id;
		this.type = type;
		this.balance = balance;
		this.logger = logger;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	@Override
	public String toString() {
		return "AccountImpl [id=" + id + ", type=" + type + ", balance=" + balance + ", logger=" + logger + "]";
	}
	
	@Override
	public void deposit(double amount) {
		this.balance=this.balance + amount;
		if(logger != null)
			logger.log("Deposit amount rs "+amount+" in amount "+ this.id+" & new balance is rs "+ this.balance);
		
	}
	@Override
	public void whithdraw(double amount) {
		this.balance=this.balance - amount;
		if(logger != null)
			logger.log("Deposit amount rs "+amount+" in amount "+ this.id+" & new balance is rs "+ this.balance);
		
		
	}
}
