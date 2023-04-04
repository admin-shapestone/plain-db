package com.shapestone.plaindb;

import java.util.Scanner;

/**
 * App is a class for starting point for performing some DB operations like CRUD
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello :) Select an option to perform operation on DB");
		System.out.println("1). Retreive records from DB");
		Scanner scanner = new Scanner(System.in);
		int option = scanner.nextInt();

		switch (option) {
		case 1: {
			RetreiveExample retreiveExample = new RetreiveExample();
			retreiveExample.displayData();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + option);
		}

	}
}
