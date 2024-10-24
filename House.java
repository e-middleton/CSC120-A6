/* This is a stub for the House class */

import java.util.ArrayList;

public class House extends Building{ //inherits from Building class (subclass)
  private ArrayList<String> residents; //who lives in this house?
  private Boolean hasDiningRoom;

  public House(String name, String address, int nFloors) {
    super(name, address, nFloors); //set up house using building constructor
    System.out.println("You have built a house: 🏠");
    residents = new ArrayList<String>();
    hasDiningRoom = false;
  }

  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  public int getNResidents(){
    return this.residents.size();
  }

  public void moveIn(String name){
    //make sure they're not already living there first
    residents.add(name);
  }

  public boolean isResident(String person){
    if (residents.contains(person)) {
      return true;
    } else {
      return false;
    }
  }


  public static void main(String[] args) {
    House Morrow = new House ("Morrow", "Paradise Road", 5);
  }

}