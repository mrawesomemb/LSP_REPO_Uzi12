package org.howard.edu.lsp.midterm.question2;

public class Main {
    public static void main(String[] args) {

    double circleArea = AreaCalculator.area(3.0);
    System.out.println("Circle radius 3.0 → area = " + circleArea);

    double rectArea = AreaCalculator.area(5.0, 2.0);
    System.out.println("Rectangle 5.0 x 2.0 → area = " + rectArea);

    double triArea = AreaCalculator.area(10, 6);
    System.out.println("Triangle base 10, height 6 → area = " + triArea);

    double sqArea = AreaCalculator.area(4);
    System.out.println("Square side 4 → area = " + sqArea);

    try {
      AreaCalculator.area(0.0); 
    } catch (IllegalArgumentException e) {
      System.out.println("Error: invalid dimension: " + e.getMessage());
    }
    //Yes, this would be considered an example of overloading. 
    //Overloading is when you make multiple methods with the same name but different parameters.
  }
}
