/* This is a stub for the Cafe class */
public class Cafe extends Building{
    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if(this.nCoffeeOunces - size >= 0){
            this.nCoffeeOunces -= size;
        } else {
            this.restock(20, 0, 0, 0);
        }
        if(this.nSugarPackets - nSugarPackets >= 0){
            this.nSugarPackets -= nSugarPackets;
        } else {
            this.restock(0, 10, 0, 0);
        } 
        if(this.nCreams - nCreams >= 0){
            this.nCreams -= nCreams;
        } else{
            this.restock(0, 0, 10, 0);
        }
        if(this.nCups > 0){
            this.nCups -= 1;
        } else{
            this.restock(0, 0, 0, 5);
        }
    }

    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        //is there a way to set it back to the original values from when the instance was initialized?
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }
    
    public static void main(String[] args) {
        new Cafe("Campus Cafe", "Location", 1, 100, 100, 100, 100);
    }
    
}
