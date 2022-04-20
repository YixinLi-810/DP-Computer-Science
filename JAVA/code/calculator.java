/*
 * @Description: 0810
 * @Author: Yixin Li
 * @Date: 2022-03-21 08:17:09
 * @LastEditors: Yixin Li
 * @LastEditTime: 2022-03-21 08:25:52
 */
import java.util.Scanner;
import java.util.*;
import java.lang.Math;

public class calculator {
public static void main(String[] args) {
    // System.out.println("input from user");
    Scanner myObj = new Scanner(System.in); // Create a Scanner object
    // System.out.println("Enter username");
    Integer inputNum = myObj.nextLine(); // Read user input
    int num = Integer.valueOf(inputNum).intValue();
    System.out.println(10*num); // Output user input
}
}