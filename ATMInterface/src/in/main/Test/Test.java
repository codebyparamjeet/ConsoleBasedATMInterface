	package in.main.Test;
	
	import in.main.ATM.ATM;
	import in.main.Account.Account;
	import in.main.Bank.Bank;
	
	public class Test {
	
		public static void main(String[] args) {
				
			Bank bank = new Bank();
			Account account1 = new Account("12345678", 5000.00);
			Account account2 = new Account("87654321", 10000.00);
			bank.addAccount(account1);
			bank.addAccount(account2);
			ATM atm = new ATM(bank);
			atm.run();
		}
	
	}
