/* This is a stub for the House class */

import java.util.ArrayList;

public class House extends Building{ //inherits from Building class (subclass)
  private ArrayList<String> residents; //who lives in this house?
  private Boolean hasDiningRoom;

  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors); //set up house using building constructor
    System.out.println("You have built a house: 🏠");
    residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
  }

  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  public int nResidents(){
    return this.residents.size();
  }

  public void moveIn(String name){
    try { 
      if(!(this.isResident(name))){
        residents.add(name);
        System.out.println("Welcome to Morrow, " + name + "!");
      } else {
        throw new RuntimeException("This person is already resident");
      }
    } catch (RuntimeException e){
      System.out.println(e + ", cannot move in.");
    }
  }

  public String moveOut(String name){
    residents.remove(name);
    return name;
  }

  public boolean isResident(String person){
    if (residents.contains(person)) {
      return true;
    } else {
      return false;
    }
  }


  public static void main(String[] args) {
    House Morrow = new House ("Morrow", "Paradise Road", 5, false);
    String student = "Jenny";
    Morrow.moveIn(student);
    int ppl = Morrow.nResidents();
    System.out.println(ppl);
    System.out.println(Morrow.isResident("Jenny"));


  }

}