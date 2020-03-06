/*

   Authors:
      Marshall Borham
      Joey Ross

*/
import java.util.*;
import java.io.*;

public class Card implements Comparable<Object>{
   private String name;
   private String suit;
   private int value;
   //J=11, Q=12, K=13, A=14
   
   public Card(){
      name = "default";
      suit = "default";
      value = 0;   
   }
   public Card(String n, String s, int v){
      name = n;
      suit = s;
      value = v;
   }
   public String getName(){
      return this.name;
   }
   public String getSuit(){
      return this.suit;
   }
   public int getValue(){
      return this.value;
   }
   public boolean equals(Object obj){
      Card cardToCompare = (Card) obj;
      if((cardToCompare.getName()==this.getName())&&(cardToCompare.getSuit()==this.getSuit())&&(cardToCompare.getValue()==this.getValue())){
         return true;
      }else{
         return false;
      }
   }
   public int compareTo(Object obj){
      Card cardToCompare = (Card) obj;
      if(cardToCompare.getSuit().equals(this.getSuit())){
         if (cardToCompare.getValue() > this.getValue()){
         return -1;
         }
         else if (cardToCompare.getValue() == this.getValue()){
         return 0;
         }
         else {
         return 1;
         }
         
      }
      else if (cardToCompare.getSuit().equals("clubs")){
         return -1;
         }
      else if (cardToCompare.getSuit().equals("spades") && this.getSuit().equals("clubs")){
         return 1;
         }
      else if (cardToCompare.getSuit().equals("spades") && !(this.getSuit().equals("clubs"))){
         return -1;
         }
      else if (cardToCompare.getSuit().equals("hearts") && this.getSuit().equals("clubs")){
         return 1;
      }
      else if (cardToCompare.getSuit().equals("hearts") && this.getSuit().equals("spades")){
         return 1;
      }
      else if (cardToCompare.getSuit().equals("hearts")){
         return -1;
      }
      else if (cardToCompare.getSuit().equals("diamonds")){
         return 1;
      }
      else if (cardToCompare.getSuit().equals("default")){
         return 1;
      }  
      else{
         return 0;
      }
   }
   public String toString(){
      return this.getSuit().charAt(0) + this.getName()+ "(" + this.getValue() + ")";
   }
}   