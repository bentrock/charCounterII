/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package charcounterii;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;


/**
 *
 * @author bendev
 */
public class CharCompute {

    /**
     * @param args the command line arguments
     */
  
    static void Reads (String fileName){
        
       System.out.println("filename =" + fileName)
               ;
        Path filePath = Paths.get("src/",fileName);
        //sets path as location of file and the file name eg src + test.txt 
        try {
            List<String> blockOfText = Files.readAllLines(filePath);
             System.out.println("reading file");
             Count(blockOfText);
             //sends block of text to Count Method 
        } catch (IOException ex) {
            Logger.getLogger(CharCompute.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
    }
    
    private static void  Count(List<String> blockOfText){
        
       int size = blockOfText.size();
       //determines size of block of text
       int [] charCount = new int [26];
       for(int i=0; i<charCount.length;i++){
           charCount[i]=0;
       }
       //creates an array that hold the integer value for each time A-Z occurs and sets each value as 0 initaily 
       int charSize =0;
       //integer that determines the total number of charecters 
  
        
       for(int i=65; i<=90;i++){
          //loops through all chars A-B
           for(int j=0; j<=size-1; j++){
               //loops through size of list
               for(int k=0; k<blockOfText.get(j).length();k++){
               //loops through each char in each line
               
               
               if(blockOfText.get(j).charAt(k) == (char) i){
                   charCount[i-65]=charCount[i-65]+1;
                   //finds each instance of a charecter per line and adds it together 
               }
              
               }
               
           } 
              
               
           }
               
                
                
                 int sum = IntStream.of(charCount).sum();
                 //adds all the chars from charCount
                System.out.println("there are " + sum + " charecters to read in the file");
                 DisplayPrep(charCount,sum);
       }
    
    
        public static void DisplayPrep(int []charCount,int sum){
            
            String [] display = new String [26];
            for(int i=0; i<charCount.length; i++){
                
                Double percent = ((double)charCount[i]/(double)sum)*100;
                //System.out.println("percent=" + percent );
                
                //determines percentage 
                double percentRound = (double) Math.round(percent * 100) / 100;
                //rounds to 2 places 
                String tally="";
                int numberOfTallies = charCount[i]%50 ;
               
                for(int j=1; j<numberOfTallies; j++){
                    tally=tally+"*";
                    if(( j%10)==0 && j!=0){
                        //adds a line every 10 chars and excludes 0
                        
                        tally = tally +"|";
                    }
                }
                
                String countFormat =String.format("%-4s", charCount[i]);
                String tallyFormat=String.format("%-20s", tally);
                String percentFormat=String.format("%5s", percentRound);
                String letterFormat=Character.toString((char) (i+65));
                //formating is all done here
                
                display[i]= letterFormat + "[" + countFormat + "] " +percentFormat +"% " + tallyFormat;
               //A [ 30]  5.41% **********|***** 
                //all values are combined into one entry in a 26 long string array
            }
           
           Display(display);
        
            //passed to the display method 
            
             FXMLDocumentController.getChars(charCount);
             //passes number of chars to be graphed
        }
    
    
    private static void Display(String [] display ){
        for(int i=0; i< display.length;i++){
            System.out.println(display[i]);
        }
        
        
    }
    
    public void setChars(int charCount[]){
          
        
            
        }
    
    
    
}

       
         
         
       

    

    

    
    
    

