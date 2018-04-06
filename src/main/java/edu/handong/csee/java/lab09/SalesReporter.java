package edu.handong.csee.java.lab09;//package name

import java.util.Scanner;//use for keyboard input
/**
 * This project show Sales report. Input a number of people and report there sales result
 * @author samsung
 *
 */
public class SalesReporter {
	private double highestSales=0;//use for select highest sales result
	private double averageSales=0;//use for calculating average
	private SalesAssociate[] team;//declare array
	private int topNum ;//use for classify highest result performance
	
	/**
	 * main method call other method and show result
	 * SalesReporter is instantiation to callData and call there method
	 * @param args
	 */
	public static void main(String[] args) {//this is main method
		SalesReporter callData = new SalesReporter();//instantiation SaleseReporter to callData
		callData.getData();//call getData method
		callData.computeStats();//call compteStats method
		callData.displayResults();//call displayResult method
	}
	
	/**
	 * getData method get a data about salesman 
	 * input number of salesmen and input there data as using array
	 */
	public void getData() {//method name is getData
		System.out.println("Enter number of sales associates : ");//printout Enter number of sales associates : 
		Scanner keyboard = new Scanner(System.in);//this is for using keyboard
		int numberOfAssociates = keyboard.nextInt();//declare numberOfAssociate because input number of salesmen
		team = new SalesAssociate[numberOfAssociates];//declaration team array
		
		for(int i=0;i<numberOfAssociates;i++) {//loop for input data about salesmen
			System.out.println("Enter data for associate number "+(i+1));//printout Enter data for associate number  
			System.out.println("Enter name of sales associate : ");//printout Enter name of sales associate :  
			keyboard.nextLine();//when enter the numberOfAssociate enter is not delete. so, this command delete enter from memory
			String name=keyboard.nextLine();//input name of salesman
			
			System.out.println("Enter associate's sales : ");//print out Enter associate's sales : 
			double sales=keyboard.nextDouble();//input sales of salesman
			team[i]= new SalesAssociate();//instantiation  team array
			team[i].setName(name);//save name to team array
			team[i].setSales(sales);//save sales to team array
		}
	}
	
	/**
	 * this method calculate average sales and highest performance salesman
	 */
	public void computeStats() {//this is computeSatas method
		int sum=0;//use for calculating average
		for(int i=0;i<team.length;i++) {//loop for sum all sales (team.length = number of salesman)
			sum+=team[i].getSales();//sum all sales performance
		}
		averageSales = sum/team.length;//calculate average
		System.out.println("Average sales per associate is " + averageSales);//printout Average sales per associate is and average
		
		for(int a=0;a<team.length;a++) {//loop for choosing highest performer
			if(highestSales<team[a].getSales()) {//Compared with a larger number.
				highestSales = team[a].getSales();// if highestSales is less than change highestSales comparison target
				topNum =a;//this is for Distinguishing highest number in array
			}
		}
		System.out.println("The highest sales figure is " + highestSales);//print out "The highest sales figure is (highestSales)" 
	}
	
	/**
	 * this method display another salesmen performance
	 */
	public void displayResults() {//this is displayResults method
		System.out.println("The following had the highest sales : ");//printout "The following had the highest sales : "
		System.out.println("Name : " + team[topNum].getName());//printout "Name : (the highest performer)"
		System.out.println("Sales : " + team[topNum].getSales());//printout "Sales : (the highest performer's sales)"
		System.out.println("$"+(team[topNum].getSales()-averageSales) +" above the average.");//printout "$ (difference of average and sales) above the average."
		System.out.print("\n");//printout blank line
		System.out.println("The rest performed as follows :");//printout "The rest performed as follows :"
		
		for(int i=0;i<team.length;i++) {//loop for printout another salesman
			if(i==topNum) continue;//don't printout highest performer data
			
			System.out.println("Name : "+team[i].getName());//printout "Name : (salesman that is not highest performer)"
			System.out.println("Sales : "+team[i].getSales());//printout "Sales : (sales that is not highest performer)"
			if(averageSales>=team[i].getSales())//if averageSales is larger than team[i].getSales() action below sentence
				System.out.println("$" + (averageSales-team[i].getSales())+"below the average");//printout "$ (difference of average and sales) below the average"
			else System.out.println("$" + (team[i].getSales()-averageSales)+"above the average");//if averageSales is less than team[i].getSales() printout "$ (difference of average and sales) above the average"
		}
	}
}
