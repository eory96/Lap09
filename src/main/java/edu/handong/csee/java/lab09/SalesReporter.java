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
	ArrayList<SalesAssociate> team = new ArrayList<SalesAssociate>();//make arraylist that type is SalesAssociate and name team

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
		
		boolean done = false;//this mean false
		int a=0;//it just for person number
		
		while(!done) {//if it will loop until done is not true
			SalesAssociate result = new SalesAssociate();//instantiation SalesAssociate class
			System.out.println("Enter data for associate number"+(a+1));//print out "Enter data for associate number"
			a++;//increase salesman number
			System.out.println("Enter name of sales associate : ");//print out "Enter name of sales associate : "
			String name = keyboard.nextLine();//name will be storaged by keyboard
			
			System.out.println("Enter associate's sales : ");//print out "Enter associate's sales : "
			double sales = keyboard.nextDouble();//sales will be storaged by keyboard
			result.setName(name);//set a name  to result name
			result.setSales(sales);//set a sales to result sales
			team.add(result);//add to team array list
			keyboard.nextLine();//this is delete enter string
			
			System.out.println("Do you want to add another salesman?");//print out "Do you want to add another salesman?"
			String ans = keyboard.nextLine();//ans will be storaged by keyboard
			if(!ans.equalsIgnoreCase("yes"))//if ans is yes(not case sensitive) implement done =true
				done = true;//it make done to true
		}
	}
	
	/**
	 * this method calculate average sales and highest performance salesman
	 */

	public void computeStats() {//this is computeSatas method
		double sum=0;//use for calculating average
		for(SalesAssociate a : team) {//loop for sum all sales (team.length = number of salesman)
			double money = a.getSales();
			sum=sum+money;//sum all sales performance
		}
		averageSales = sum/team.size();//calculate average
		System.out.println("Average sales per associate is " + averageSales);//printout Average sales per associate is and average
		
		for(SalesAssociate b : team) {//loop for choosing highest performer
			double tempMoney = b.getSales();//this for calculate highestSales
			if(highestSales < tempMoney) {//Compared with a larger number.
				highestSales = tempMoney;// if highestSales is less than change highestSales comparison target
			}
		}
	}

	/**
	 * this method display another salesmen performance
	 */
	public void displayResults() {//this is displayResults method
		System.out.println("The following had the highest sales : ");//printout "The following had the highest sales : "
		
		for(SalesAssociate b : team)//arraylist type is SalesAssociate and b is for receiver and loop until end of arraylist
		{
			if(b.getSales()==highestSales) {//it is for classify top salesman
				System.out.println("Name : " + b.getName());//print out top salesman name
				System.out.println("Sales : " + highestSales);//printout "Sales : (the highest performer's sales)"
				System.out.println("$"+(highestSales-averageSales) +" above the average.");//printout "$ (difference of average and sales) above the average."
				System.out.print("\n");//printout blank line
			}
		}
		
		System.out.println("The rest performed as follows :");//printout "The rest performed as follows :"
		
		for(SalesAssociate a : team) {//loop for printout another salesman
			if(a.getSales()==highestSales) continue;//don't printout highest performer data
			
			System.out.println("Name : "+a.getName());//printout "Name : (salesman that is not highest performer)"
			System.out.println("Sales : "+ a.getSales());//printout "Sales : (sales that is not highest performer)"
			if(averageSales>=a.getSales())//if averageSales is larger than team[i].getSales() action below sentence
				System.out.println("$" + (averageSales-a.getSales())+"below the average");//printout "$ (difference of average and sales) below the average"
			else System.out.println("$" + (a.getSales()-averageSales)+"above the average");//if averageSales is less than team[i].getSales() printout "$ (difference of average and sales) above the average"
		}
	}
}
