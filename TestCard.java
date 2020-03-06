/*

   Authors:
      Marshall Borham
      Joey Ross

*/
import java.util.*;
import java.io.*;

public class TestCard{
   public static void main(String args[]){
      Card d2 = new Card("2", "diamonds", 2);
      Card d3 = new Card("3", "diamonds", 3);
      Card h3 = new Card("3", "hearts", 3);
      Card s3 = new Card("3", "spades", 3);
      Card c3 = new Card("3", "clubs", 3);
      Card d2_d = new Card("2", "diamonds", 2);
      System.out.println(d2 + ".equals(" + d2_d + ") is " + d2.equals(d2_d));
      System.out.println(d2 + ".equals(" + d3 + ") is " + d2.equals(d3));
      System.out.println(d3 + ".compareTo(" + h3 + ") is " + d3.compareTo(h3));
      System.out.println(d3 + ".compareTo(" + s3 + ") is " + d3.compareTo(s3));
      System.out.println(d3 + ".compareTo(" + c3 + ") is " + d3.compareTo(s3));
      System.out.println(h3 + ".compareTo(" + d3 + ") is " + h3.compareTo(d3));
      System.out.println(h3 + ".compareTo(" + s3 + ") is " + h3.compareTo(s3));
      System.out.println(h3 + ".compareTo(" + c3 + ") is " + h3.compareTo(c3));
      System.out.println(s3 + ".compareTo(" + h3 + ") is " + s3.compareTo(h3));
      System.out.println(s3 + ".compareTo(" + d3 + ") is " + s3.compareTo(d3));
      System.out.println(s3 + ".compareTo(" + c3 + ") is " + s3.compareTo(c3));
      System.out.println(c3 + ".compareTo(" + h3 + ") is " + c3.compareTo(h3));
      System.out.println(c3 + ".compareTo(" + s3 + ") is " + c3.compareTo(s3));
      System.out.println(c3 + ".compareTo(" + d3 + ") is " + c3.compareTo(d3));
   }
}
