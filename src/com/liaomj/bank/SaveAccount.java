package com.liaomj.bank;

public class SaveAccount implements Runnable{
	Bank bank;
	public SaveAccount(Bank bank) {
		this.bank = bank;
	}
	
	public void run() {
		bank.SaveAccount();
	} 
}
