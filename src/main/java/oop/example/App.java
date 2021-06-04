package oop.example;

import java.util.Scanner;

/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Ashley Mojica
 */

/*
Exercise 9 - Paint Calculator
Sometimes you have to round up to the next number rather than follow standard
rounding rules.

Calculate gallons of paint needed to paint the ceiling of a room. Prompt for
the length and width, and assume one gallon covers 350 square feet. Display
the number of gallons needed to paint the ceiling as a whole number.

Example Output:
You will need to purchase 2 gallons of paint to cover 360 square feet.
Remember, you can’t buy a partial gallon of paint. You must
round up to the next whole gallon.

Constraints:
Use a constant to hold the conversion rate.
Ensure that you round up to the next whole number.

Challenges:
-Revise the program to ensure that inputs are entered as numeric values.
 Don’t allow the user to proceed if the value entered is not numeric.
-Implement support for a round room.
-Implement support for an L-shaped room.
-Implement a mobile version of this app so it can be used at the hardware store.
 */

public class App 
{
    static Scanner input = new Scanner(System.in);
    public static void main( String[] args )
    {
        App myApp = new App();
        double coverage = 350.0;
        String lengthString = myApp.getLength();
        String widthString = myApp.getWidth();

        double length = myApp.convertStringToDouble(lengthString);
        double width = myApp.convertStringToDouble(widthString);

        double area = myApp.getArea(length, width);
        double gallonsNeeded = myApp.getGallons(area, coverage);
        String gallonsNeededString = String.format("%.0f", gallonsNeeded);
        String areaString = String.format("%.0f", area);

        String message = myApp.generateMessage(gallonsNeededString, areaString);
        System.out.print(message);

    }

    public String getLength(){
        System.out.print("What is the length of the room in feet? ");
        String len = input.nextLine();
        return len;
    }
    public String getWidth(){
        System.out.print("What is the width of the room in feet? ");
        String wid = input.nextLine();
        return wid;
    }

    public double convertStringToDouble(String word){
        return Double.parseDouble(word);
    }

    public double getArea(double length, double width){
        return (length * width);
    }
    public double getGallons(double area, double cover){
        double gallons = area / cover;
        double leftover = gallons % 1.0;

        if (leftover != 0.0){
            gallons -= leftover;
            gallons++;
        }

        return gallons;
    }

    public String generateMessage(String gallons, String area){
        return "You will need to purchase " + gallons + " gallons of paint to cover " + area + " square feet.";
    }
}
