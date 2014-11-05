/**
 * This is my own work: Ben Mabie
 * This program will take input from a file and run an encryption algorithm on
 * each word. 
 * August 28, 2014
 */


import java.io.*;
import java.util.Scanner;

public class FileEncryption
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File file = new File("sample.dat");     //first, create a scanner object, file system and 
        Scanner scan = new Scanner(file);       //a new temperary string array
       
        
     String[] temp = new String[5];             
     int counter = 0;
    
     
     while(scan.hasNext())                  //while loop to scan over file
     {                                          //with built in resize method
         if(counter == temp.length)
         {
         temp = resize(temp);
         }
         else
         {
         String line = scan.next();
         temp[counter] = line;
         counter++;  
         }
        
     }
     scan.close();                              //close the scanner

     int sum = 0;                               
     
     for(int i = 0; i < temp.length; i++)       //create loop to count the number
     {                                          //of lines with entries in them
         if(temp[i] != null)                    //and set to a final variable
         {
         sum++;    
         }
     }
     
     final int size = sum;                      
          
     String[] myArray = new String[size];       //create a new array of the the found size
                                                //and copy the temp array into the new array
     for(int i = 0; i < myArray.length; i++)
     {
         myArray[i] = temp[i];
     }
                                                //start encryption process
        int countChanges = 0;
        int countSame = 0;
         
        for(int i = 0; i < myArray.length; i ++)
            { 
            int index = 0;
            int next = 1;
            char [] characters = myArray[i].toCharArray();
            
            
            for(int j = 0; j < myArray[i].length();j++)     //create 'cases' for each possibilty
                {
               
                if(myArray[i].length() == 1)        //base case if the length of the word is one 
                {                                   //= no encryption needed.
                System.out.printf("%-20s%-20s\n", myArray[i], "UNCHANGED");
                }
                else  
                {

                if(myArray[i].charAt(index)=='A') 
                {   
                   
                    if(myArray[i].charAt(next)!='A')       //case 'A' if both the first value and the next value
                    {                                       //are 'A' and not 'A'
                    char charTemp = characters[index];
                    characters[index] = characters[next];
                    characters[next] = charTemp;
                    index++;
                    next++;
                    }
                    else                                    
                    {       
                    char charTemp = characters[index];      //case 'B' if first value is 'A' and next value is
                    characters[index] = charTemp;           //anything else other than 'A'
                    index++;
                    next++;   
                    }
                }
                else                                        //case 'C' if first value is not 'A'
                {
                    char charTemp = characters[index];
                    characters[index] = charTemp;
                    index++;
                    next++;
                } 
          
                }
                
            
            }
            String swappedString = new String(characters);
            
            if (!myArray[i].equals(swappedString))          //create logical statement to determine
                {                                           //if array has been encrypted and print
                System.out.printf("%-20s%-20s\n", myArray[i], swappedString);
                countChanges++;
                }
            else if (myArray[i].length() != 1)
                {
                System.out.printf("%-20s%-20s\n", myArray[i], "UNCHANGED");
                countSame++;
                }
            
            } 
            System.out.print(countChanges + " words were changed by the encryption ");
            System.out.print(countSame + " words were not changed");        //print out which words
        }                                                                   //were changed
    
 public static String[] resize(String[] temp)                               //resize method
    {
        String[] result = new String[temp.length*2];
        
        for(int i =0; i < temp.length;i++)
        {
            result[i] = temp[i];
        }
        return result;
    }

            
} 
         
        
    
        
    
    
  
    

