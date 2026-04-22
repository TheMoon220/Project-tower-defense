package bloons.utils;


import java.util.Scanner;

/**
 * Une classe utilitaire pour la saisie de chaines ou d'entiers sur l'entree
 * standard.
 */

public class Input {
	private Scanner scanner; 

	public Input() {
	   this.scanner = new Scanner(System.in);
	}
	
	/**
	 * permet la saisie d'une chaîne sur l'entrée standard
	 * 
	 * @return la chaîne saisie
	 */
  public static String readString() {
      return new Input().localReadString();
   }
	private String localReadString() {
		return this.scanner.next();
	}

	
	/**
	 * permet la saisie d'un entier sur l'entrée standard
	 * 
	 * @return l'entier saisi
	 */
	public static int readInt() throws java.io.IOException {
	   return new Input().localReadInt();
	}
	private int localReadInt() throws java.io.IOException {
		try {
			return this.scanner.nextInt();
		} catch (Exception e) {
		   e.printStackTrace();
			this.scanner.skip(".*");
			throw new java.io.IOException();
		}
	}	
	
} // Input
