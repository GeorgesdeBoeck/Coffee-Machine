package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private static int waterNeeded = 200;
    private static int milkNeeded = 50;
    private static int coffeeBeansNeeded = 15;
    
    private static int waterLeft = 400;
    private static int milkLeft = 540;
    private static int coffeeLeft = 120;
    private static int cupsLeft = 9;
    private static int money = 550;
    
    public static int getWaterNeeded() {return waterNeeded;}
    public static int getMilkNeeded() {return milkNeeded;}
    public static int getCoffeeBeansNeeded() {return coffeeBeansNeeded;}
    
    public static int getWaterLeft() {return waterLeft;}
    public static void setWaterLeft(int change) {
        waterLeft = waterLeft + change;
    }
    
    public static int getMilkLeft() {return milkLeft;}
    public static void setMilkLeft(int change) {
        milkLeft = milkLeft + change;
    }
    
    public static int getCoffeeLeft() {return coffeeLeft;}
    public static void setCoffeeLeft(int change) {
        coffeeLeft = coffeeLeft + change;
    }
    
    public static int getCupsLeft() {return cupsLeft;}
    public static void setCupsLeft(int change) {
        cupsLeft = cupsLeft + change;
    }
    
    public static int getMoney() {return money;}
    public static void takeMoney() {money = 0;}
    public static void setMoney(int change) {money = money + change;}
    
    public static int calculateCups (int water, int milk, int coffee, int cups) {
        int waterNeeded = getWaterNeeded();
        int milkNeeded = getMilkNeeded();
        int coffeeBeansNeeded = getCoffeeBeansNeeded();
        
        int waterCups = (int) Math.floor(water/waterNeeded);
        int milkCups = (int) Math.floor(milk/milkNeeded);
        int coffeeCups = (int) Math.floor(coffee/coffeeBeansNeeded);
        
        int possibleCups = Math.min(waterCups, Math.min(milkCups, coffeeCups));
        
        return possibleCups;
    }
    
    public static void possibleCups(int calculatedCups, int neededCups) {
        int excessCups = calculatedCups - neededCups;
        
        if (excessCups > 0) {
            System.out.println("Yes, I can make that amount of coffee (and even " + excessCups + " more than that)");
        } else if (excessCups == 0) {
            System.out.println("Yes, I can make that amount of coffee");
        } else {
            System.out.println("No, I can only make " + calculatedCups + " cup(s) of coffee");
        }
    }
    
    public static void statusReport() {
        System.out.println("The coffee machine has:");
        System.out.println(getWaterLeft() + " ml of water");
        System.out.println(getMilkLeft() + " ml of milk");
        System.out.println(getCoffeeLeft() + " g of coffee beans");
        System.out.println(getCupsLeft() + " disposable cups");
        System.out.println("$" + getMoney() + " of money");
    }
    
    public static void buyEspresso() {
        setWaterLeft(-250);
        setCoffeeLeft(-16);
        setCupsLeft(-1);
        setMoney(4);
    }
    
    public static boolean checkEspresso() {
        boolean enough = false;
        if(getWaterLeft() < 250) {
            System.out.println("Sorry, not enough water!");
        } else if (getCoffeeLeft() <16) {
            System.out.println("Sorry, not enough coffee!");
        } else if (getCupsLeft() <1) {
            System.out.println("Sorry, not enough cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            enough = true;
        }
        
        return enough;
    }
    
    public static void buyLatte() {
        setWaterLeft(-350);
        setMilkLeft(-75);
        setCoffeeLeft(-20);
        setCupsLeft(-1);
        setMoney(7);
    }
    
    public static boolean checkLatte() {
        boolean enough = false;
        if(getWaterLeft() < 350) {
            System.out.println("Sorry, not enough water!");
        } else if (getMilkLeft() < 75 ){
            System.out.println("Sorry, not enough milk!");
        } else if (getCoffeeLeft() <20) {
            System.out.println("Sorry, not enough coffee!");
        } else if (getCupsLeft() <1) {
            System.out.println("Sorry, not enough cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            enough = true;
        }
        
        return enough;
    }
    
    public static void buyCappuccino() {
        setWaterLeft(-200);
        setMilkLeft(-100);
        setCoffeeLeft(-12);
        setCupsLeft(-1);
        setMoney(6);
    }
    
    public static boolean checkCappuccino() {
        boolean enough = false;
        if(getWaterLeft() < 200) {
            System.out.println("Sorry, not enough water!");
        } else if (getMilkLeft() < 100 ){
            System.out.println("Sorry, not enough milk!");
        } else if (getCoffeeLeft() <12) {
            System.out.println("Sorry, not enough coffee!");
        } else if (getCupsLeft() <1) {
            System.out.println("Sorry, not enough cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            enough = true;
        }
        
        return enough;
    }
    
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    boolean coffeeMachineLoopBreaker = false;
    while (!coffeeMachineLoopBreaker) {
    System.out.println("Write action (buy, fill, take, remaining, exit):");
    String action = scanner.next();
    if ("buy".equalsIgnoreCase(action)) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String decision = scanner.next();
        if ("1".equalsIgnoreCase(decision)) {
            boolean make = checkEspresso();
            if (make) {
                buyEspresso();
            }
        } else if ("2".equalsIgnoreCase(decision)) {
            boolean make = checkLatte();
            if (make) {
                buyLatte();
            }
        } else if ("3".equalsIgnoreCase(decision)) {
            boolean make = checkCappuccino();
            if (make) {
                buyCappuccino();
            }
        } else if ("back".equalsIgnoreCase(decision)) {
            
        }
    } else if ("fill".equalsIgnoreCase(action)) {
        System.out.println("Write how many ml of water you want to add:");
        int water = scanner.nextInt();
        setWaterLeft(water);
        System.out.println("Write how many ml of milk you want to add:");
        int milk = scanner.nextInt();
        setMilkLeft(milk);
        System.out.println("Write how many grams of coffee beans you want to add:");
        int coffee = scanner.nextInt();
        setCoffeeLeft(coffee);
        System.out.println("Write how many disposable cups of coffee you want to add:");
        int cups = scanner.nextInt();
        setCupsLeft(cups);
    } else if ("take".equalsIgnoreCase(action)) {
        System.out.println("I gave you $" + getMoney());
        takeMoney();
    } else if ("remaining".equalsIgnoreCase(action)) {
        statusReport();
    } else if ("exit".equalsIgnoreCase(action)) {
        coffeeMachineLoopBreaker = true;
    }
    }
    }

}
