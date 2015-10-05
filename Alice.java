package AliceInWonderLand;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *@author Mal
 * Issues : Sort the hashmap, by key values. 
 * look for ansi codes while processing each line.
 * Processing each line could be done recursively aswell?
 */
public class Alice {
    public final String dir = "C:/Users/Mal/documents/Aliceinwonderland.txt";
    File f;
    Scanner n;
    HashMap map;
    char[] characters;
    int[] count;
    public int sumOfChars;
    
    public Alice() {
        this.f= new File(dir);
        try {
            this.n = new Scanner(this.f);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Alice.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.map = new HashMap<Character, Integer>();
        
        //add alphabet and Integer count to the hashMap
        for(char c = 'a'; c <='z'; c++) {
            this.map.put(c, 0);
        }
        countAll(this.n, 0);
        calcSum();
    }
        //recursive approach
    public void countAll(Scanner s, int stackCount) {
       
       if(s.hasNextLine()) {
           processLine(s.nextLine());
           //System.out.println(s.nextLine() +" "+stackCount);
           stackCount++; //stackCount used for debugging, not req.
           countAll(s, stackCount);
        } 
    }
    public void processLine(String line) {
        //loop over all chars in each string (called by countAll
        for(int i = 0; i <= line.length()-1; i++) {
            char c = line.charAt(i);
            Character g = c;
            
            //if the char (in the line being processed) is a key in the hashmap, count one up
            if(this.map.containsKey(c)) {  
                Integer val = (Integer) map.get(g)+1;
                this.map.put(c, val);
            }  
            
        }
    }
    public void calcSum() {
        List<Character> keys = new ArrayList<Character>(this.map.keySet());
        for (Character key: keys) {
            //System.out.println(key + ": appeared " + map.get(key)+" times");
            int i = (int) this.map.get(key);
            this.sumOfChars += i;
        }
    }
    public void getCount() {
        List<Character> keys = new ArrayList<Character>(this.map.keySet());
    
    //int sumofChars = 0;
    double percentSum = 0;
    for (Character key: keys) {
        int x = (int) this.map.get(key);
        double percentage = ((double)x*100.0/(double)this.sumOfChars);
        
        System.out.println(key + ": appeared " + map.get(key)+" times " +round(percentage, 2)+ "%");
        
        int i = (int) this.map.get(key);
        percentSum +=percentage;
    //sumofChars += i;
    
    }
    System.out.println("Number of characters toal : " + this.sumOfChars);
    System.out.println("Percent sum = "+percentSum);
    }
    // round metoden lånt fra http://stackoverflow.com/questions/2808535/round-a-double-to-2-decimal-places
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
