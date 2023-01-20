/**
@author Nathan Wang
@date 1/20/23
File name: Company.java
Purpose: Includes the company object constructor and variables like the name of the company and number as seen in the cList arrayList of Company objects. Also includes getter methods to access a company number and name in the main method. A toString is included to return the name of the company as a string and not a the position in the array. 
*/

/*
Company Class
*/
public class Company {
  private int companyNum;
  private String company;

  /*
  company constructor that constructs a company with arguments of the company number and name of a company
  */
  public Company(int pCompanyNum, String pCompany) { 
    companyNum = pCompanyNum;
    company = pCompany;
  }
  
  /*
  method to return the company number of a person
  */
  public int getCompanyNum(){
    return companyNum;
  }

  /*
  getter method to return the company
  */
  public String getCompany(){
    return company;
  }

  /*
  toString method to return the company name as a string
  */
  public String toString(){
    return company;
  }
  
}//close class