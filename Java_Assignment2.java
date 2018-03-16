package com.webdriver;

public class Java_Assignment2 {

	public static void countcurrency(int amount){

	    int notes[7] = { 1000, 500, 200,20, 10, 0.50, 0.25 };
	    int noteCounter[7] = { 0 };
	    for (int i = 0; i < 7; i++) {
	        if (amount >= notes[i]) {
	            noteCounter[i] = amount / notes[i];
	            amount = amount - noteCounter[i] * notes[i];
	        }
	    }
	    
	    for(int i=0;i<7;i++)
	    {
	     if(amount>=notes[i])
	     {
	      noteCounter[i] = amount / notes[i];
	      amount = amount-noteCounter[i]*notes[i];
	     }
	      
	    }
	    System.out.println("Currency Note  Count ");
	      for (int i = 0; i < 7; i++) {
	        if (noteCounter[i] != 0) {
	          
	          System.out.println(notes[i]+" "+noteCounter[i]);
	          int total=noteCounter[i]++;
	          System.out.println("Total" +total);
	            
	        }
	    }

	}
	  public static void main(String args[])
	  {
	    int Amount;
	     Scanner s=new Scanner(System.in);
	     Amount=s.nextInt();
	     countCurancy(Amount);

		
		
	}

}
