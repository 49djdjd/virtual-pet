public class PetClass{
    private String name;
    private int hunger;
    private int energy;
    private int happiness;
    private boolean alive;
    public PetClass(String a){
        name = a;
        hunger = 100;
        energy = 100;
        happiness = 100;
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
        hunger += 1;
    }

    public void playTime(){
        happiness += 20;
        energy -= 10;
    }
    public void restPet(){
        energy += 25;
    }
    public boolean petAlive(){
        if (happiness <=0 && hunger <=0){
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
        if (energy > 100){
            energy = 100;
        }
        if (hunger > 100){
            hunger = 100;
        }
        if (happiness < 0){
            happiness = 100;
        }
    }
    public void passTime(){
        hunger -= 5;
        energy -= 1;
        happiness -= 5;
        System.out.println("Happiness now: " + happiness);
    }
}