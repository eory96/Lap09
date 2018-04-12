package edu.handong.csee.java.lab09;//package name

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;//use for keyboard input
/**
 * This project show Sales report. Input a number of people and report there sales result
 * @author samsung
 *
 */
public class SalesReporter {
	private double highestSales=0;//use for select highest sales result
	private double averageSales=0;//use for calculating average
	ArrayList<SalesAssociate> team = new ArrayList<SalesAssociate>();;
	int topNum=0;
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
		
		Scanner keyboard = new Scanner(System.in);//this is for using keyboard
		//team = new ArrayList<SalesAssociate>();
		
		
		boolean done = false;
		int a=0;
		
		while(!done) {
			SalesAssociate result = new SalesAssociate();
			System.out.println("Enter data for associate number"+(a+1));
			a++;
			System.out.println("Enter name of sales associate : ");
			String name = keyboard.nextLine();
			
			System.out.println("Enter associate's sales : ");
			double sales = keyboard.nextDouble();
			result.setName(name);
			result.setSales(sales);
			team.add(result);
			keyboard.nextLine();
			
			System.out.println("Do you want to add another salesman?");
			String ans = keyboard.nextLine();
			if(!ans.equalsIgnoreCase("yes"))
				done = true;
		}
	}
	
	/**
	 * this method calculate average sales and highest performance salesman
	 */
	public void computeStats() {//this is computeSatas method
		double sum=0;//use for calculating average
		for(int i=0;i<team.size();i++) {//loop for sum all sales (team.length = number of salesman)
			sum=sum + team.get(i).getSales();//sum all sales performance
		}
		averageSales = sum/team.size();//calculate average
		System.out.println("Average sales per associate is " + averageSales);//printout Average sales per associate is and average
		
		for(int a=0;a<team.size();a++) {//loop for choosing highest performer
			if(highestSales < team.get(a).getSales()) {//Compared with a larger number.
				highestSales = team.get(a).getSales();// if highestSales is less than change highestSales comparison target
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
		System.out.println("Name : " + (team.get(topNum)).getName());//printout "Name : (the highest performer)"
		System.out.println("Sales : " + (team.get(topNum)).getSales());//printout "Sales : (the highest performer's sales)"
		System.out.println("$"+((team.get(topNum)).getSales()-averageSales) +" above the average.");//printout "$ (difference of average and sales) above the average."
		System.out.print("\n");//printout blank line
		System.out.println("The rest performed as follows :");//printout "The rest performed as follows :"
		
		for(int i=0;i<team.size();i++) {//loop for printout another salesman
			if(i==topNum) continue;//don't printout highest performer data
			
			System.out.println("Name : "+(team.get(i)).getName());//printout "Name : (salesman that is not highest performer)"
			System.out.println("Sales : "+(team.get(i)).getSales());//printout "Sales : (sales that is not highest performer)"
			if(averageSales>=(team.get(i)).getSales())//if averageSales is larger than team[i].getSales() action below sentence
				System.out.println("$" + (averageSales-(team.get(i)).getSales())+"below the average");//printout "$ (difference of average and sales) below the average"
			else System.out.println("$" + ((team.get(i)).getSales()-averageSales)+"above the average");//if averageSales is less than team[i].getSales() printout "$ (difference of average and sales) above the average"
		}
	}
}
