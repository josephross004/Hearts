/*

   Authors:
      Marshall Borham
      Joey Ross

*/
import java.util.*;
import java.io.*;

public class TestPlayer{
   public static void main(String[] args){
      Player p1 = new Player("Kara Jones", 0);
      System.out.println("Created Player -> " + p1);
      p1.updateScore(6);
      System.out.println("After scoring 6 points -> " + p1);
      Player p2 = new Player("Bob Smith", 27);
      System.out.println("Created Player -> " + p2);      
      p2.updateScore(27);
      System.out.println("After scoring 27 points -> " + p2);
   }
}