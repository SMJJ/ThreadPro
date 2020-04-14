package com.liaomj.bank;

public class Bank {
	private String account;
	private int balance;
	
	public Bank(String account,int balance) {
		this.account = account;
		this.balance = balance;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public String toString() {
		return "Bank [账号：" + account + "，余额：" + balance + "]";
	}
	
	public synchronized void SaveAccount() {
		int balance = getBalance();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		balance += 100;
		setBalance(balance);
		System.out.println("存款后的账户余额为：" + balance);
	}
	
	public synchronized void drawAccount() {
		int balance = getBalance();
		balance = balance - 200;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		setBalance(balance);
		System.out.println("取款后的账户余额为：" + balance);
	}
	
}
