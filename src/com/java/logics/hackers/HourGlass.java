package com.java.logics.hackers;

import java.util.Scanner;

public class HourGlass {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		int counter=0;
		
		int max=0;
		while (n>0) {
			int val = n& 1;
			if(val==1){
				counter++;
				
			} else{
				
				if(counter > max){
					max = counter;
				}
				counter=0;
			}
			System.out.print(n & 1);
			n >>= 1;
		}
		if(counter >max){
			max= counter;
		}
		System.out.println();
		System.out.println(max);

	}
}

class Person {
	protected String firstName;
	protected String lastName;
	protected int idNumber;

	// Constructor
	Person(String firstName, String lastName, int identification) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = identification;
	}

	// Print person data
	public void printPerson() {
		System.out.println("Name: " + lastName + ", " + firstName + "\nID: " + idNumber);
	}

}

class Student extends Person {
	private int[] testScores;

	Student(String firstName, String lastName, int identification, int[] scores) {
		super(firstName, lastName, identification);
		this.testScores = scores;
	}

	public char calculate() {
		int avg = testScores[0] + testScores[1] / 2;
		char grade = 0;
		if (avg >= 90 && avg <= 100) {
			grade = 'O';
		} else if (avg >= 80 && avg <= 90) {
			grade = 'E';
		} else if (avg >= 70 && avg <= 80) {
			grade = 'A';
		} else if (avg >= 55 && avg <= 70) {
			grade = 'P';
		} else if (avg >= 40 && avg <= 55) {
			grade = 'D';
		} else {
			grade = 'O';
		}
		return grade;
	}
}