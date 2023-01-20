/**
@author Nathan Wang
@date 1/20/23
File name: Search.java
Purpose: This file codes for the search process, the user can input a name and be given the guests information such as company and chair. The find person method checks for a person matching the one the user looks for, then returns the persons information. 
*/

import java.util.ArrayList; 

/*
search class
*/
public class Search {
  
  /*
  find person method checks for a person matching the one the user looks for. Then returns the persons information
  */
  public static String findPerson(ArrayList<People> pList, String fName, String lName) {
    for (People people: pList) {
      if (fName.equals(people.getFirstName()) && lName.equals(people.getLastName())) { //check for person
        return people.getFirstName() + " " + people.getLastName() + " from " + people.getCompName() + " in chair " + people.getChairNum() + " at table " + people.getTableNum(); 
      } 
    }
    return "Person not found"; //error handling
  } //close method
  
}//close class