/**
@author Nathan Wang
@date 1/20/23
File name: Main.java
Purpose: The main takes all objects and methods from other files and sorts the guests into tables. It also gives the user the option to load a different file and/or add additional guests. Main also uses the search file to create a process to search for a guest and return their information. The main prints guests by table and by company (including chair position).
*/

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;

/* 
Main class
*/
class Main {
  public static ArrayList<People> pList = new ArrayList<People>();
  public static String[] compNames = {"", "Wal-mart", "Kroger", "Amazon", "Lowes", "Best Western", "KMart", "Fusian", "Heinz", "Gucci", "Prada", "Nike", "Dodge", "Maserati", "Razor", "AMD", "Razer"}; //string array that contains the company names which correspond to company number (to print the company name and not just number)

  /*
  main method
  */
  public static void main(String[] args) {
    ArrayList<Company> cList = new ArrayList<Company>(); //hardcode companies into an arraylist
    cList.add(new Company(1, "Wal-Mart"));
    cList.add(new Company(2, "Kroger"));
    cList.add(new Company(3, "Amazon"));
    cList.add(new Company(4, "Lowes"));
    cList.add(new Company(5, "Best Western"));
    cList.add(new Company(6, "KMart"));
    cList.add(new Company(7, "Fusian"));
    cList.add(new Company(8, "Heinz"));
    cList.add(new Company(9, "Gucci"));
    cList.add(new Company(10, "Prada"));
    cList.add(new Company(11, "Nike"));
    cList.add(new Company(12, "Dodge"));
    cList.add(new Company(13, "Maserati"));
    cList.add(new Company(14, "Razor"));
    cList.add(new Company(15, "AMD"));
    cList.add(new Company(16, "Razer"));
    
    int numTables = 10;
    int tableSize = 10;
    int[] compCount = new int[16]; //int array to make sure there are not more than 10 people from each company 
    
    Scanner scan = new Scanner(System.in);
    System.out.println("Would you like to load partyGuests.txt (y) or (n): "); //ask user which file to load
    String response = scan.nextLine();
    if (response.equals("y")) {
      //File processing from W3 schools
      try {
        File myObj = new File("partyGuests.txt"); //import file
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
         String data = myReader.nextLine();
         String[] arr = data.split(",");
         int[] intArr = new int[1];
         intArr[0] = Integer.parseInt(arr[3]);
         People p1 = new People(arr[1], arr[2], intArr[0]);
         pList.add(p1); //add guests into arrayList
         compCount[intArr[0]] += 1; //add person from a company to array, will check the amount later
        }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    } //close if
   
    //prompting the user to add new guests
    System.out.println("Would you like to add new Guests? (y) or (n): ");
    response = scan.nextLine();
    while (response.equals("y")) {
      System.out.println("Enter guest's first name: "); 
      String fName = scan.nextLine();
      System.out.println("Enter guest's last name: "); 
      String lName = scan.nextLine();
      System.out.println("Enter guest's company num: "); 
      System.out.println("\t 01: Wal-Mart \t 02: Kroger \t 03: Amazon \t 04: Lowes \n 05: Best Western \t 06: KMart \t 07: Fusian \t 08: Heinz \n 09: Gucci \t 10: Prada \t 11: Nike \t 12: Dodge \n 13: Maserati \t 14: Razor \t 15: AMD \t 16: Razer");
      int cName = scan.nextInt();
      String temp = scan.nextLine(); //buffer (cred. Kyler Pang)
      if (compCount[cName-1] < tableSize && pList.size() < (tableSize * numTables)) { //check for less than 10 from each comp, and less than 100 total (cred. Kyler Pang)
        pList.add(new People(lName, fName, cName));
        }
      else {
        System.out.println("Could not add guest");
      }
      System.out.println("Would you like to add new Guests? (y) or (n): ");
      response = scan.nextLine();
    }
    
  
    //make tables (corresponding to numTables)
    ArrayList<Table> tables = new ArrayList<Table>();
    for (int i = 0; i < numTables; i++) {
      tables.add(new Table());
    }
    //sort into tables
   for (int i = 0; i < pList.size(); i++) { 
      for (int x = 0; x < tables.size(); x++) {
        if (tables.get(x).getNumPeople() < tableSize && tables.get(x).hasCompany(pList.get(i).getCompany()) == true) {
          tables.get(x).addPerson(pList.get(i));
          pList.get(i).setTableNum(x+1);
          pList.get(i).setChairNum(tables.get(x).getNumPeople());
          break; //once condition is reached, break out of for loop line 55 (prevents person being put into every table)
        }
          
      }
    }
    
    //print tables
    for (int i = 0; i < 10; i++){
      System.out.println("Table " + (i+1) + ": " + "\n" + tables.get(i));
    }
    
    //print by company
    for (int n = 0; n < 16; n++) {
      System.out.println(compNames[n+1] + ":"); //using the compNames array to print the name of the company and not number
      for (People person: pList) {
        if (person.getCompany() == n+1) {
          System.out.println(person.getFirstName() + " " + person.getLastName() + " (Chair: " + person.getChairNum() + ", Table: " + person.getTableNum() + ")"); 
        }
      }
      System.out.println(); //printing new line for visuals
    } 

    //prompting user to find a guest
    System.out.println("Would you like to find a guest? (y) or (n)");
    response = scan.nextLine();
    while (response.equals("y")) {
      System.out.println("Enter first name: ");
      String fName = scan.nextLine();
      System.out.println("Enter last name: ");
      String lName = scan.nextLine();
      System.out.println(Search.findPerson(pList, fName, lName)); //using findPerson method which includes error handling
      System.out.println("Would you like to find another person? (y) or (n)");
      response = scan.nextLine();
    }

  }//close main method
} //close class main