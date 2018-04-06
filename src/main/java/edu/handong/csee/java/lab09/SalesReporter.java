package edu.handong.csee.java.lab09;

import java.util.Scanner;

public class SalesReporter {
	private double highestSales;
	private double averageSales;
	private SalesAssociate[] team;
	//private int numberOfAssociates;
	private int topNum ;
	
	public static void main(String[] args) {
		SalesReporter callData = new SalesReporter();
		callData.getData();
		callData.computeStats();
		callData.displayResults();
	}
	
	public void getData() {
		System.out.println("Enter number of sales associates : ");
		Scanner keyboard = new Scanner(System.in);
		int numberOfAssociates = keyboard.nextInt();
		//keyboard.nextLine();
		
		team = new SalesAssociate[numberOfAssociates];
		for(int i=0;i<numberOfAssociates;i++) {
			System.out.println("Enter data for associate number "+(i+1));
			System.out.println("Enter name of sales associate : ");
			keyboard.nextLine();
			String name=keyboard.nextLine();
			
			System.out.println("Enter associate's sales : ");
			double sales=keyboard.nextDouble();
			team[i]= new SalesAssociate();
			team[i].setName(name);
			team[i].setSales(sales);
		}
	}
	
	public void computeStats() {
		int sum=0;
		for(int i=0;i<team.length;i++) {
			sum+=team[i].getSales();
		}
		averageSales = sum/team.length;
		System.out.println("Average sales per associate is " + averageSales);
		
		for(int a=0;a<team.length;a++) {
			if(highestSales<team[a].getSales()) {
				highestSales = team[a].getSales();
				topNum =a;
			}
		}
		System.out.println("The highest sales figure is " + highestSales);
	}
	
	public void displayResults() {
		System.out.println("The following had the highest sales : ");
		System.out.println("Name : " + team[topNum].getName());
		System.out.println("Sales : " + team[topNum].getSales());
		System.out.println("$"+(team[topNum].getSales()-averageSales) +" above the average.");
		System.out.print("\n");
		System.out.println("The rest performed as follows :");
		for(int i=0;i<team.length;i++) {
			if(i==topNum) continue;
			
			System.out.println("Name : "+team[i].getName());
			System.out.println("Sales : "+team[i].getSales());
			if(averageSales>=team[i].getSales()) System.out.println("$" + (averageSales-team[i].getSales())+"below the average");
			else System.out.println("$" + (team[i].getSales()-averageSales)+"above the average");
		}
	}
}
