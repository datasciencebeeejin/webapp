package berjinbv;
import java.util.HashMap;
import java.util.Scanner;
class bankAccount{     
	String userName;
	String acname;
	long accountNumber=7824735300002813L;          // initial 16 digit accountNumber
	String accountType;
	int balance=0;                                // initial balance as zero
	Scanner sc=new Scanner(System.in);
	HashMap<Long,String> accountName=new HashMap<Long,String>();        
	HashMap<Long,String> accounttype=new HashMap<Long,String>();        
	HashMap<Long,Integer> accountBalance=new HashMap<Long,Integer>();   
	
	public void setAccountNo() throws InterruptedException {  
		System.out.println("Please provide your Full Name ");
		userName=sc.next();                                             // getting account holder name
		System.out.println("Please provide the Type of Account you want");  
		System.out.println("Enter 1 for Savings Account");
		System.out.println("Enter 2 for Current Account");
		System.out.println("Enter 3 for Salary Account");
		int choice2=sc.nextInt();                                    // using switch case to select account type
		switch(choice2) {
		case 1:
			accountType="Savings";
			break;
		case 2:
			accountType="Current";
			break;
		case 3:
			accountType="Salary";
			break;
		default:
			accountType="Un Known";
		}                               // in order to maintain a unique accountNumber for every creation of accountNumber the account number increases by 5 
		accountNumber+=5;
		accountName.put(accountNumber,userName);    // maintaining the details in hash map to fetch it whenever required
		accounttype.put(accountNumber,accountType);
		accountBalance.put(accountNumber, balance);
		System.out.println("Your "+accountType+" Account Created Successfully.");
		System.out.println("Your account number is "+accountNumber);
	}
	public void deposit() { 
		try {               //nullpointexception get handled here
		    System.out.println("Enter your Account Number");   
		    accountNumber=sc.nextLong();                       
		    balance=accountBalance.get(accountNumber);         // balance is fetched from the hash map
		    System.out.println("Enter the Amount to Deposit which should not be Lesser than 1000 and Greater than 10000");
		    int depositMoney=sc.nextInt();                     // entering the amount to deposit
		    if(depositMoney>=1000 && depositMoney<=10000) {    
			    balance+=depositMoney;	
			    accountBalance.replace(accountNumber,balance);
			    System.out.println("Amount deposited to your Account ");
		    }
		    else {
			    System.out.println("Please Try to Deposit within the Limit");
		    }
		}
		catch (Exception e){   
			System.out.println("Please enter the correct Account Number");
		}
	}
	public void withdraw() {    
		System.out.println("Enter your Account Number");
		accountNumber=sc.nextLong();                 
		if(accountName.containsKey(accountNumber)) { // if the collected accountNumber is available in the hash map then further proceeded 
			System.out.println("Enter the Amount to withdraw");
			System.out.println("The withdraw Amount should be less than 15000  and Greater than 500");
			int withdrawAmount=sc.nextInt();
			balance=accountBalance.get(accountNumber);    // getting balance from the hash map using the key
			if(balance>=withdrawAmount) {                
				balance-=withdrawAmount;
				accountBalance.replace(accountNumber,balance);
				System.out.println("You have withdrawed your money");
				System.out.println("Your Account balance is "+balance);
			}
			else {                                       
				System.out.println("The Balance Amount is less than the Withdraw Amount");
			}
		}
		else {                                          // if the account number given is wrong, it prints the below message
			System.out.println("Please enter the correct Account Number");
		}
		
	}
	public void getAccountDetails() {     
		System.out.println("Please provide your Account Number ");
		accountNumber=sc.nextLong();                            
		if(accountBalance.containsKey(accountNumber)) {
		    System.out.println("Hello! ,"+accountName.get(accountNumber)+"\n"+"Account Number: "+accountNumber+"\n"+"Account Type : "+accounttype.get(accountNumber)+ "\n"+"Balance : Rs. "+accountBalance.get(accountNumber));
	    }                                                  // printing all the details using the key as accountNumber from the HashMap
		else {
			System.out.println("You dont have a Bank Account here please create a new");
		}
	}
}
public class thirteen13 {    // MAIN 
	public static void main(String[] args) throws InterruptedException {     
		int choice=1;                     // setting choice to 1 
		int choice1;                      // choice1 for switch case
		Scanner sc=new Scanner(System.in);
		bankAccount obj=new bankAccount();             
		while(choice==1){                                                    // using while loop to make the work in running state till the user want to Decline
			System.out.println("Enter 1 to Start and other numbers to Decline");
			choice=sc.nextInt();
			if(choice==1) {                                                 
				System.out.println("Processing to next Step.....");
			    Thread.sleep(500);
				System.out.println("Enter 1 to Create Account");
				Thread.sleep(500);
				System.out.println("Enter 2 to Deposit Money");
				Thread.sleep(500);
				System.out.println("Enter 3 to Withdraw Money");
				Thread.sleep(500);
				System.out.println("Enter 4 to view Details");
				choice1=sc.nextInt();
				switch (choice1) {                             // using switch case to call the methods based on the option selected
				case 1:
					obj.setAccountNo();
					break;
				case 2:
					obj.deposit();
					break;
				case 3:
					obj.withdraw();
					break;
				case 4:
					obj.getAccountDetails();
				default:
					break;
				}
			}
			else{                             
				System.out.println("Transaction Declined");
				sc.close();
			}
		}
	}
}