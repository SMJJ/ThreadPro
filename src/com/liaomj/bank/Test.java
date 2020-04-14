package com.liaomj.bank;

public class Test {
	public static void main(String[] args) {
		Bank bank = new Bank("1001", 1000);
		SaveAccount save = new SaveAccount(bank);
		DrawAccount draw = new DrawAccount(bank);
		Thread sa = new Thread(save);
		Thread da = new Thread(draw);
		sa.start();
		da.start();
		try {
			da.join();
			sa.join();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(bank);
	}
}
