/*
 * EECS 2500 - Linear Data Structures
 * 
 * Dr. Gerald Heuring
 * 
 * Paulo D. Nadal
 * 
 * Project 0
 * 
 * 20 September 2023
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// child class of Institution
public class ProjectZeroList extends Institution
{

	// making the array list hehe
	static ArrayList<Institution> institutions = new ArrayList<>();
			
	public static void main(String[] args) 
	{
		// make-a da scanner to take in da input
		Scanner scanner = new Scanner(System.in);
		
		// sets running to true
		boolean running = true;
		
		// prompt the user or something
		System.out.println("Hello there! What would you like to do? (type 'help' for a list of commands)");
		
		// so that it keeps going after a user chooses a command
		while (running)
		{
			
			// assign scanner.nextLine() to a command or something
			String command = scanner.nextLine();
			
			// make-a da if loop to process the command hehe
			// checks if user used the "help" command
			if (command.equalsIgnoreCase("help"))
			{
				// here we process the help command
				System.out.println("here is a list of commands that could be of use... \n");
				System.out.println("add: Add a institution."); 
				System.out.println("list: List off the institutions in the list.");
				System.out.println("search: Search the list for a institution.");
				System.out.println("save: Save the list to a file.");
				System.out.println("delete: Delete a institution from the list");
				System.out.println("exit: Exit the program. \n");
				
			}
			
			// checks if the user used the "add" command
			else if (command.equalsIgnoreCase("add"))
			{
				System.out.println("\nPlease fill these out! \n");
				
				System.out.println("Name: ");
				String name = scanner.nextLine();
				
				System.out.println("Nickname: ");
				String nickname = scanner.nextLine();
				
				System.out.println("Year: ");
				int year = scanner.nextInt();
				scanner.nextLine();
				
				System.out.println("City: ");
				String city = scanner.next();
				
				System.out.print("State: \n");
				String state = scanner.next();
				
				System.out.println("Approximate number of students: ");
				int studentbody = scanner.nextInt();
								
				addCommand(institutions, name, nickname, year, city, state, studentbody);
			}
			
			// checks if the user used the "list" command
			else if (command.equalsIgnoreCase("list"))
			{
			    		listCommand(institutions);
			}
			
			// checks if the user used the "search" command
			else if (command.equalsIgnoreCase("search"))
			{
				System.out.println("\nWhat institution were you looking for?\n");	
				String nameLookup = scanner.nextLine();
				
				searchCommand(institutions, nameLookup);
				
			}
			
			// checks if the user used the "save" command
			else if (command.equalsIgnoreCase("save"))
			{
				// here we process the save command
				saveCommand("saved.txt");
				
			}
			
			// checks if the user userd the "delete" command
			else if (command.equalsIgnoreCase("delete"))
			{
				// here we process the delete command
				System.out.println("\nWhich institution would you like to delete?");
				String nameToDelete = scanner.nextLine();
				
				deleteCommand(institutions, nameToDelete);
			}
			
			// checks if the user used the "exit" command
			else if (command.equalsIgnoreCase("exit"))
			{
				running = false;
				
			}
			else
			{
				System.out.println(" ");
			}
		}
		
		scanner.close();
	}
	
	// method to handle adding an instituiton to the list
	public static void addCommand(ArrayList<Institution> institutions, String name, String nickname, int year, String city, String state, int studentbody)
	{	
		for (Institution existing : institutions)
		{
			if (existing.getName().equals(name) || existing.getName().equals(nickname))
			{
				System.out.println("\nThis school already exists!\n");
				return;
			}
		}
		Institution institution = new Institution(name, nickname, year, city, state, studentbody);
		
		institutions.add(institution);
		
		System.out.print("\nInstitution added!\n");
	}
	
	// method to handle printing out the list of institutions to the console
	public static void listCommand(ArrayList<Institution> institutions)
	{	
			if (institutions.isEmpty()) // checks if list is empty
			{
				System.out.print("\nThere are no institutions in the list.\n");
			}
			else // prints out the list of institutions
			{
				System.out.println("\nHere's the list of institutions: \n");
				
				for (Institution institution : institutions)
					{
					System.out.println(institution.toString());
					}
			}
	}
	
	// method to search through the list and print out the institution the user is asking for
	private static void searchCommand(ArrayList<Institution> institutions, String nameLookup)
	{
		// leafs thru the institution
		for (Institution institution : institutions)
		{
			// uses the getName() method to check against the user input
			if (institution.getName().equalsIgnoreCase(nameLookup))
			{
				System.out.println(institution);
				
				
			}
			// uses the getNickname() method to check against the user input
			else if (institution.getNickname().equalsIgnoreCase(nameLookup))
			{
				System.out.println(institution);
			}
		}
	}
	
	// method to save the list to a file named "saved.txt"
	private static void saveCommand(String fileName)
	{
		try (FileWriter fileWriter = new FileWriter(fileName)) 
		{
		
			for (Institution institution : institutions)
			{
				fileWriter.write(institution.toString());
				fileWriter.write("\n");
			}
		
			System.out.println("Records saved to " + fileName);
		}
		catch (IOException e)
		{
			System.err.println("Error while saving records" + e.getMessage());
		}
		
	}
	
	// method to delete an institution from the list
	private static void deleteCommand(ArrayList<Institution> institutions, String nameToDelete)
	{	
		// checks if the list is empty
		if (institutions.isEmpty())
		{
			// prints this out when there is nothing to delete
			System.out.println("\nThere is nothing to delete!\n");
			return;
		}
		
		// creates an iterator of type institution so that the program can leaf through the institutions list
		Iterator<Institution> iterator = institutions.iterator();
		
		while (iterator.hasNext())
		{
			Institution institution = iterator.next();
				
			if (institution.getName().equalsIgnoreCase(nameToDelete))
			{
				iterator.remove();
				System.out.println("\nInstitution removed!\n");
			}
			else if (institution.getNickname().equalsIgnoreCase(nameToDelete))
			{
				iterator.remove();
				System.out.println("\nInstitution removed!\n");
			}
		}
	}
}
