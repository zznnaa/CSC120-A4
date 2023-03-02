# CSC120-A5: Bringing it All Together

## Outline
In this assignment, we'll explore Association by building a virtual Train!


As before, all the files necessary for this assignment are contained within this repository. When you submit, please remember to include:

 - all files necessary to compile your program
 - `reflection.md` containing your reflections and notes
 - `rubric.md` where you document which elements of the assignment you have attempted and/or completed.
 
##  Program files
For this assignment, you'll be writing four interrelated classes:

 - The `Passenger` class (`Passenger.java`) will store information about an individual passenger
 - The `Engine` class (`Engine.java`) will represent the locomotive engine, storing information about its fuel type, level, etc.
 - The `Car` class (`Car.java`) will be used as a container for `Passenger` objects
 - and the `Train` (`Train.java`) class will tie them all together
 
 You'll also notice a 5th file in the repository (`FuelType.java`), which contains something that looks like a super simple class:
 ```
public enum FuelType {
    STEAM, INTERNAL_COMBUSTION, ELECTRIC, OTHER;
}
```
In Java, we can use the keyword `enum` to establish simple type that must take as its value one of a set of predefined constant values. We'll use this in the `Engine` class instead of a `String` to keep track of what kind of fuel the `Engine` uses. You don't need to change this file, but you can use the values it contains like this:

```
FuelType f = FuelType.ELECTRIC;
```

## Relationships between the Classes
 
Let's pause a moment to think about the different kinds of relationships we'll want to establish:

 - The `Train` class should have a **composition** relationship with the `Engine` class (if you remove the `Engine`, it ceases to be a `Train`, and if you destroy the `Train`, you get rid of the `Engine` as well).
 - The `Train` class has an **aggregation** relationship with the `Car` class (the `Train` has a collection of `Cars` associated with it at any given time, but you can add / remove `Cars` without destroying either the `Train` or the `Cars` themselves).
 - The `Passenger` class has **association** relationships with the `Car` class (`Passenger`s board `Car`s as their means of using the `Train` to move around more efficiently).
 
 ## Step 1: The `Engine` class
 We recommend you start by implementing the `Engine` class. Your `Engine` class will need:
 
  - a private `FuelType` attribute to indicate what type of fuel it uses, and `double`s to store the current and maximum fuel levels (along with an approproate accessors for each)
  - a method `public void refuel()` which will reset the `Engine`'s current fuel level to the maximum
  - a method `public void go()` which will decrease the current fuel level and print some useful information (e.g. remaining fuel level) provided the fuel level is above 0 (otherwise it should throw a `RuntimeException` containing an informative message)
 
You can use the `main` method defined below as a starting point for testing:
 ```
    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0);
        try {
            while (true) {
                myEngine.go();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage()); // Out of fuel
        }
    }
```

## Step 2: The `Passenger` class
 
  
