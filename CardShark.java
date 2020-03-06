
import java.util.*;
import java.io.*;

public class CardShark extends CardGame{
    public CardShark(String name, int players, String[]names, int current){
        super(name, players, names, current);
    }
    public void setPlayers(String[] names){
        for(int s=0; s<names.length; s++){
            if(s%2==0){
                this.addPlayer(names[s], false);
            }else{
                this.addPlayer(names[s], true);
            }
        }
    }
}