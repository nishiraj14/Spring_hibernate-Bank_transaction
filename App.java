package bank.com;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		 ApplicationContext ct= new ClassPathXmlApplicationContext("Config.xml");
	       account_details_Impl acd=ct.getBean("as",account_details_Impl.class);
	       BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	       boolean go=true;
	       while(go)
	       {
	    	   System.out.println("Press 1 For Create New Account");
	    	   System.out.println("Press 2 For To Get All Bank Details");
	    	   System.out.println("Press 3 For To Withdrwal Amount");
	    	   System.out.println("Press 4 For To Deposit Amount");
	    	   System.out.println("Press 5 For To Money Transfer ");
	    	   System.out.println("Press 6 For Exit");
	    	   try
	    	   {
	    		int input = Integer.parseInt(br.readLine());
	    		switch(input)
	    		{
	    		case 1:
	    			System.out.println("Enter The Contact Number");
	    			int aAccount_no=Integer.parseInt(br.readLine());
	    			
	    			System.out.println("Enter The Name");
	    			String aName=br.readLine();
	    			
	    			System.out.println("Enter The Address");
	    			String aAddress=br.readLine();
	    			
	    			System.out.println("Enter The Branch Name");
	    			String aBranch_namae=br.readLine();
	    			
	    			System.out.println("Enter Amount To Deposite");
	    			int aDepo=Integer.parseInt(br.readLine());
	    			
	    			int aTotal=+aDepo;
	    			account_details a=new account_details();
	    			a.setAccount_no(aAccount_no);
	    			a.setName(aName);
	    			a.setAddress(aAddress);
	    			a.setBranch_namae(aBranch_namae);
	    			a.setDepo(aDepo);
	    			a.setTotal(aTotal);

	    			
	    			int j = acd.insert(a);
	    			System.out.println(j+"The Account Is Created");
	    			System.out.println("***************************");
	            	System.out.println();
	            	break;
	            	
	    		case 2:
	    			System.out.println("***************************");
	    			List<account_details>allaccount_details=acd.getAllaccount_details();
	    			for(account_details de:allaccount_details)
	            	{
	            		System.out.println("Account Number: "+de.getAccount_no());
	            		System.out.println("Address: "+de.getAddress());
	            		System.out.println("Name: "+de.getName());
	            		System.out.println("Branch Name: "+de.getBranch_namae());
	            		System.out.println("Total balance: "+de.getTotal());
	            		
	            		
	            		System.out.println("---------------------------------");
	            	}
	    
	            	System.out.println("***************************");
	            	break;
	            	
	    		case 3:    			
	            	
	    			System.out.println("Enter Account Number ");
	            	int accno=Integer.parseInt(br.readLine());	
	            	
	            	account_details ad = acd.getAccount_no(accno);
	            	System.out.println("Account Number: "+ad.getAccount_no());
            		System.out.println("Address: "+ad.getAddress());
            		System.out.println("Name: "+ad.getName());
            		System.out.println("Branch Name: "+ad.getBranch_namae());
            		System.out.println("Total balance: "+ad.getTotal());
            		//------------------------------------
            		System.out.println("Enter account no: ");
	            	int acno=Integer.parseInt(br.readLine());
	            	int balance=ad.getTotal();
	            	if(accno==acno && balance>=1000) 
	            	{
	            		System.out.println("Enter withdrwal amount");
	            		int wi=Integer.parseInt(br.readLine());
	            		balance-=wi;
	            		ad.setTotal(balance);
	            		ad.setWithdrwal(wi);
	            		acd.update(ad);
	            		System.out.println("updated");
	            	}
	            	break; 
	            	
                case 4:    			
	            	
	    			System.out.println("Enter Account Number ");
	            	int accno1=Integer.parseInt(br.readLine());	
	            	
	            	account_details ad1 = acd.getAccount_no(accno1);
	            	System.out.println("Account Number: "+ad1.getAccount_no());
            		System.out.println("Address: "+ad1.getAddress());
            		System.out.println("Name: "+ad1.getName());
            		System.out.println("Branch Name: "+ad1.getBranch_namae());
            		System.out.println("Total balance: "+ad1.getTotal());
            		//------------------------------------
            		System.out.println("Enter account no: ");
	            	int acno1=Integer.parseInt(br.readLine());
	            	int balance1=ad1.getTotal();
	            	if(accno1==acno1) 
	            	{
	            		System.out.println("Enter deposit amount");
	            		int di=Integer.parseInt(br.readLine());
	            		balance1+=di;
	            		ad1.setTotal(balance1);
	            		ad1.setDepo(di);;
	            		acd.update(ad1);
	            		System.out.println("updated");
	            	}
	            	break; 
                case 5:
                	System.out.println("Enter your Account Number ");
	            	int accno2=Integer.parseInt(br.readLine());	
	            	
	            	account_details ad2 = acd.getAccount_no(accno2);
	            	System.out.println("Account Number: "+ad2.getAccount_no());
	            	//----------------------------------
	            	System.out.println("Enter trasfer Account Number ");
	            	int accno3=Integer.parseInt(br.readLine());	
	            	
	            	account_details ad3 = acd.getAccount_no(accno3);
	            	System.out.println("Account Number: "+ad3.getAccount_no());	
	            	//------------------------------------------
            		int bal=ad3.getTotal();
            		System.out.println(bal);
            		System.out.println("Enter trasfer amount");
            		int tamt=Integer.parseInt(br.readLine());
            		bal+=tamt;
            		ad3.setTotal(bal);
            		acd.update(ad3);
            		System.out.println("Transfered amount to "+ad3.getAccount_no());
            		int bal1=ad2.getTotal();
            		System.out.println(bal1);
                	ad2.setTotal(bal1);
                	bal1-=tamt;
                	ad2.setTotal(bal1);
                	acd.update(ad2);
                	break;
	    		}
	    	   }catch(Exception e)
	    	   {
	      System.out.println("Invalid input Try with another one !!");
	      System.out.println(e.getMessage());
	    	   }
	       }

	}

}
