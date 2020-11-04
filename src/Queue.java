import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Queue {
	public static void main(String args[]){
		int noOfEmailProcessed[];
		int noOfEmailInQueue = 0;
		int noOfMinute;
		int noOfEmailArrived[];
		int noOfEmailSentPerAttempt[];
		int counter = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of minutes:");
		noOfMinute = sc.nextInt();
		
		noOfEmailArrived = new int[noOfMinute];
		noOfEmailProcessed = new int [noOfMinute];
		noOfEmailSentPerAttempt = new int[noOfMinute];
		
		while (counter < noOfMinute){	
			Random random = new Random();
			noOfEmailArrived[counter] = random.nextInt((60-0)+1)+0; // nextInt((max - min) + 1) + min
			
			if (noOfEmailInQueue < 0) {
				noOfEmailInQueue = 0;
			}
			
			else if (noOfEmailInQueue > 0 ){
				noOfEmailInQueue = noOfEmailInQueue + noOfEmailArrived[counter];
			}
			
			else {
				noOfEmailInQueue = noOfEmailArrived[counter];
			}
			
			noOfEmailProcessed[counter] = random.nextInt((60-0)+1)+0;
			
			noOfEmailInQueue = noOfEmailInQueue - noOfEmailProcessed[counter];
			
			int emailProcessed = noOfEmailProcessed[counter];
			int emailArrived = noOfEmailArrived[counter];
			
			if (emailProcessed > emailArrived){
				noOfEmailSentPerAttempt[counter] = noOfEmailArrived[counter];
			}
			
			else {
				noOfEmailSentPerAttempt[counter] = noOfEmailProcessed[counter];
			}
			counter++;
			
			System.out.println("No Of Email Arrived:" + Arrays.toString(noOfEmailArrived));
			
			if (noOfEmailInQueue > 0 ){
				System.out.println("No Of Email In Queue:" + noOfEmailInQueue);
			}
			
			else {
				System.out.println("No Of Email In Queue:0");
			}
			
			System.out.println("No Of Email Processed:" + Arrays.toString(noOfEmailProcessed));		
			
			System.out.println("No Of Email Sent Per Attempt:" + Arrays.toString(noOfEmailSentPerAttempt));
			
			System.out.println();
		}
	}
}