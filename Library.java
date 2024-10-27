/* This is a stub for the Library class */
import java.util.Hashtable;

public class Library extends Building{
  private Hashtable<String, Boolean> collection;

    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean>();
      System.out.println("You have built a library: 📖");
    }
  
    public void addTitle(String title){
      //not checking if it's already a book because there may be multiple copies
      this.collection.put(title, true);
    }

    public String removeTitle(String title){
      try{ 
        if(this.containsTitle(title)){
          this.collection.remove(title);
          System.out.println(title + " has been removed from " + this.name + " libaray.");
          return title;
        } 
      } catch (RuntimeException e){
          System.out.println(e);
      }
      return title;
    }

    public void checkOut(String title){
      try{
        if(this.containsTitle(title)){
          if(this.isAvailable(title)){
            this.collection.replace(title, false);
          } else{
            System.out.println("I'm sorry, " + title + " is currently checked out.");
          }
        }
      } catch(RuntimeException e){
        System.out.println(e + " It cannot be checked out.");
      }
    }

    public void returnBook(String title){
      try{
        if(this.containsTitle(title)){
          this.collection.replace(title, true);
        }
      } catch(RuntimeException e){
        System.out.println(e + " It cannot be returned. Please find the library it belongs to.");
      }
    }

    public boolean containsTitle(String title){
      if(this.collection.containsKey(title)){
        return true;
      }
      else{
        throw new RuntimeException(title + " is not a book in " + this.name + " library.");
      }
    }

    public boolean isAvailable(String title){
      try{
        if(this.containsTitle(title)){
          return this.collection.get(title);
        }
      } catch(RuntimeException e){
        System.out.println(e + " It is not available.");
      }
      return false;
    }

    public void printCollection(){
      System.out.println(this.name + " library contains:");
      System.out.println(this.collection.toString());
    }

    public static void main(String[] args) {
      Library nielson = new Library("Nielson", "Nielson rd", 3);
      String book = "wuthering heights";
      nielson.addTitle(book);
      String book2 = "Jane Eyre";
      String book3 = "Harry Potter";
      nielson.addTitle(book2);
      nielson.checkOut(book);
      System.out.println(nielson.isAvailable(book2));
      System.out.println(nielson.isAvailable(book));
      System.out.println(nielson.isAvailable(book3));
      
    }
  
  }