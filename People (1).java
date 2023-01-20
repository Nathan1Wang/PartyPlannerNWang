/**
@author Nathan Wang
@date 1/20/23
File name: People.java
Purpose: Includes constructor for People object and includes variables for each person in party txt (such as name, company) as seen in the pList arrayList of People objects. Also has getter and setter methods for each variable for use in the main method. A toString is included to return a person's information as a string.
*/

/*
People Class
*/
public class People {
  private String lastName;
  private String firstName;
  private int companyNum;
  private int tableNum;
  private int chairNum; 
  private String[] compNames = {"", "Wal-mart", "Kroger", "Amazon", "Lowes", "Best Western", "KMart", "Fusian", "Heinz", "Gucci", "Prada", "Nike", "Dodge", "Maserati", "Razor", "AMD", "Razer"};

  /*
  People constructor for people object that takes in arguments of Last Name, First Name, and company number
  */
  public People (String pLastName, String pFirstName, int pCompanyNum) {
    lastName = pLastName;
    firstName =  pFirstName;
    companyNum =  pCompanyNum;
  }// close people
  
  /*
  getter method to get a persons last name (string)
  */
  public String getLastName() {
    return lastName;
  }

  /*
  getter method to get a persons first name (string)
  */
  public String getFirstName() {
    return firstName;
  }

  /*
  getter method to get a persons company num (int)
  */
  public int getCompany() {
    return companyNum;
  }

  /*
  getter method to get a persons company name (string)
  */
  public String getCompName() {
    return compNames[companyNum];
  }

  /*
  getter method to get a persons table num (int)
  */
  public int getTableNum() {
    return tableNum;
  }

  /*
  getter method to get a persons chair num (int)
  */
  public int getChairNum() {
    return chairNum;
  }

  /*
  setter method to set a persons chair num, takes in the chair num
  */
  public void setChairNum(int chairNum) {
    this.chairNum = chairNum;
  }

  /*
  setter method to set a persons table num, takes in the table num
  */
  public void setTableNum(int tableNum) {
    this.tableNum = tableNum;
  }

  /*
  to string method to return a persons information as a string 
  */
  public String toString() {
    return firstName + " " + lastName + " is from " + companyNum; 
  }
  

  
}//close class