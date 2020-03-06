/*

   Authors:
      Marshall Borham
      Joey Ross

*/
import java.util.*;
import java.io.*;

public class Player{
   private String name;
   private int score;
   
   public Player(String name, int score){
      this.name = name;
      this.score = score;
   }
   
   public int getScore(){
      return this.score;
   }
   
   public String getName(){
      return this.name;
   }
   
   public void setScore(int score){
      this.score = score;
   }
   
   public void setName(String name){
      this.name = name;
   }
   
   public void updateScore(int score){
      this.score += score;
   }
   
   public String toString(){
      return "" + name + " " + score;
   }
}