/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AliceInWonderLand;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mal
 */
public class AliceTwo {
    public final String dir = "C:/Users/Mal/documents/Aliceinwonderland.txt";
    File f;
    Scanner n;
    HashMap map;
    char[] characters;
    int[] count;
    public AliceTwo() {
        this.f= new File(dir);
        try {
            this.n = new Scanner(this.f);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AliceTwo.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.map = new HashMap<Character, Integer>();
        //this.characters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
        //add alphabet and Integer count to the hashMap
        for(char c = 'a'; c <='z'; c++) {
            this.map.put(c, 0);
        }
        countAll(this.n, 0);
        
    }
        //recursive approach
    public void countAll(Scanner s, int stackCount) {
       
       if(s.hasNextLine()) {
           processLine(s.nextLine());
           //System.out.println(s.nextLine() +" "+stackCount);
           stackCount++;
           countAll(s, stackCount);
           
       } 
       else {
           
           //s.next();
           
       }
    }
    public void processLine(String line) {
        //loop over all chars in each string
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
    public void getCount() {
        List<Character> keys = new ArrayList<Character>(this.map.keySet());
    //Collections.sort(keys, someComparator);
    int sumofChars = 0;
    for (Character key: keys) {
    System.out.println(key + ": " + map.get(key));
    int i = (int) this.map.get(key);
    sumofChars += i;
    
    }
    System.out.println("Number of characters toal : " + sumofChars );
    }
}
