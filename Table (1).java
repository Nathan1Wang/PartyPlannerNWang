/**
@author Nathan Wang
@date 1/20/23
File name: Table.java
Purpose: Table.java makes an arrayList for the guests at each table which is used in the main method. Also includes methods that return the size of a table as an int, adds a person to a table, and a boolean method that checks for another person from the same company at the same table. A toString method is included to return a logical string of a guests name, chair and company, to be used when printing table rosters. 
*/

import java.util.ArrayList;

/*
Table class
*/
public class Table {
  ArrayList<People> pList;
  String[] compNames = {"", "Wal-mart", "Kroger", "Amazon", "Lowes", "Best Western", "KMart", "Fusian", "Heinz", "Gucci", "Prada", "Nike", "Dodge", "Maserati", "Razor", "AMD", "Razer"};

  public Table() {
    pList = new ArrayList<>();
  }

  /*
  method that returns the number of people (size of array) at a table as an integer
  */
  public int getNumPeople() {
    return pList.size();
  }
  
  /*
  method to add a person to a table, adds a person from the people object to the arrayList of people at the table
  */
  public void addPerson(People people) {
    pList.add(people);
  }

  /* 
  method that returns true when there are no other people from the same company, if true, person will be added to the table
  */
  public boolean hasCompany(int companyNum) {
    for (People person: pList) {
      if (person.getCompany() == companyNum) {
        return false;
      }
    }
    return true;
  }//close hasCompany bool

  /*
  toString method that returns the roster of a table including the chair number and company as a string 
  */
  public String toString() {
    String ret = "";
    for (People person : pList) {
      ret = ret + person.getFirstName() + " " + person.getLastName() + "(chair " + person.getChairNum() + ")" + " (" + person.getCompName() + ") " + "\n";
    }
    return ret;
  }
  
} //close table clas