public class PetClass{
    private String name;
    private int hunger;
    private int energy;
    private int happiness;
    private boolean alive;
    public PetClass(String a, int b, int c, int d){
        name = a;
        hunger = b;
        energy = c;
        happiness = d;
        alive = true;

    }
    public String getName(){
        return name;
    }
    public int getHunger(){
        return hunger;
    }
    public int getEnergy(){
        return energy;
    }
    public int getHappiness(){
        return happiness;
    }
    public void feedPet(){
        hunger -= 10;
    }

    public void playTime(){
        happiness += 20;
        energy -= 10;
    }
    public void restPet(){
        energy += 25;
    }
    public boolean petAlive(){
        if (happiness <=0 && hunger == 100){
            return false;
        }
        else{
            return true;
        }
    }
    public void statusBar(){
        System.out.println("Pet name: " + name);
        System.out.println("Pet hunger: " + hunger );
        System.out.println("Pet energy: " + energy);
        System.out.println("Pet happiness: " + happiness );
    }
    public void makeEverythingIsPositive(){
        if (happiness<0){
            happiness = 0;
        }
        if (energy<0){
            energy=0;
        }
        if (hunger<0){
            hunger = 0;
        }
    }
    public void passTime(){
        hunger += 5;
        energy -= 2;
        happiness -=5;
    }
}