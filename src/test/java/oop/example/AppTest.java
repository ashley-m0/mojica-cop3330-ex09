package oop.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest 
{
    @Test
    public void includes_correct_calc(){
        App myApp = new App();
        double coverage = 350.0;
        String lengthString = "15";
        String widthString = "24";

        double length = myApp.convertStringToDouble(lengthString);
        double width = myApp.convertStringToDouble(widthString);

        double area = myApp.getArea(length, width);
        double gallonsNeeded = myApp.getGallons(area, coverage);
        String gallonsNeededString = String.format("%.0f", gallonsNeeded);
        String areaString = String.format("%.0f", area);

        String actualMessage = myApp.generateMessage(gallonsNeededString, areaString);
        String expectedMessage = "You will need to purchase 2 gallons of paint to cover 360 square feet.";

        assertEquals(expectedMessage, actualMessage);
    }
}
