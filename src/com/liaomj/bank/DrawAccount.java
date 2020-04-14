package com.liaomj.bank;

public class DrawAccount implements Runnable{
	Bank bank;
	public DrawAccount(Bank bank) {
		this.bank = bank;
	}
	
	public void run() {
		bank.drawAccount();
	}
}
