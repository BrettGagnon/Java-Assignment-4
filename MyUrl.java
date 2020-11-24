/*
 * Intro to Java Assignment 4
 * Brett Gagnon
 * 10/6/2018
 * Source Code
 */
package MyUrlDemo;

/**
 *
 * @author brett
 */
public class MyUrl {
    
    //set private instance variable for string mUrl and string status
  
    private String mUrl;
    
    //used to check if an argument has been passed
    private String status = "f";
    
    //constructor to initialize the base URL to the URL parameter value.
    public MyUrl(String url)
    {
   
    //if the string entered starts with 'www', concatenate http:// to the beggining    
    if (url.charAt(0) == 'w' && url.charAt(1) == 'w' && url.charAt(2) == 'w')
    {
    mUrl = "http://" + url;
    }
    
    //else if the string starts with 'http://www', change nothing
    else if (url.charAt(0) == 'h' && url.charAt(1) == 't' && url.charAt(2) == 't'
            && url.charAt(3) == 'p'  && url.charAt(4) == ':'
            && url.charAt(5) == '/' && url.charAt(6) == '/'  
            && url.charAt(7) == 'w' && url.charAt(8) == 'w' && url.charAt(9) == 'w')
            {
                mUrl = url;
            }
    // else if the string starts with neither of these char sequences, concatenate
    // 'http://www.' to the beginning of the string and save in mUrl
    else
    {
    mUrl =  "http://www." + url;
            }
    }
    
     public static String urlEncode(String text)
    {
    //initialize string line 2 for encoded string
    String line2 = "";
    
    
    //Assign variable Ascii to contain all ASCII characters
    String ascii = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ012345"
            + "6789_-.*";
    

    //Begin for loop to go through each individual character in string line1
    for (int n=0; n < text.length(); ++n)
    {
    
   //initialize a char to get single characters from the input string
    char c = text.charAt(n);
   
    //initialize a string to store hex values of any given character
    String hex = Integer.toHexString(c);
    
    //Final encoded string
    String encoded = "";
    
    // set variable to check if the character needs to be changed (ascii or not)
    int index;
    index = ascii.indexOf(text.charAt(n));
    
    
    //if the character is a blank
    if (text.charAt(n) == ' ')
    {
       //concatenate a plus symbol
       encoded += "+"; 
    }
    
    // if the character needs to be changed (index value = -1)
    else if (index != -1)
    {
        //concatenate the character
        encoded += text.charAt(n);
    }
         else
    {
             //concatenate the hex value after an ampersand
              encoded += '%' + hex;
    }
             
    //add the encoded character to the string line2 at the end of every loop
    line2 = line2 + encoded;
    //System.out.println(line2);
    } 
    
     return line2;
   
   
    }
 
    public void addArgument(String name, String value)
    {
        //if else to determine if an argument has been passed
        // if no, then concatenate a ? followed by encoded strings
        if (status == "f")
        {
            mUrl += "?" + urlEncode(name) +
             "=" + urlEncode(value);
            
            //change status to show argument has passed
            status = "t";
        }
        
        else
        {
       //else concatenate with a "&"    
       // concatenate url encoded strings name, + '=', + value
      
    mUrl += "&" + urlEncode(name) +
             "=" + urlEncode(value);
        }
    }
    
    public void addArgument(String name, int ivalue)
    {
      //Initialize String Variable value
        
      String value;
      
      //assign the string variable value with the integer value from ivalue
      
      value = Integer.toString(ivalue);
     
      //if there have been no arguments passed yet
      if (status == "f")
          
        {
            //concatenate with a ? followed by the encoded name, "=", and then value
            mUrl += "?" + urlEncode(name) +
             "=" + urlEncode(value);
            
            //change status to show argument has passed
            status = "t";
        }
        
        else
        {
       //else concatenate with a "&"    
       // concatenate url encoded strings name, + '=', + value
      
    mUrl += "&" + urlEncode(name) +
             "=" + urlEncode(value);
        }
    }
    
    public void addArgument(String name, double dvalue)
    {
    // initialize string value
    String value;
    
    //convert the double to string representation
    value = Double.toString(dvalue);
    
    //if there have been no arguments passed yet
    if (status == "f")
        {
            //concatenate with a ? followed by the encoded name, "=", and then value
            mUrl += "?" + urlEncode(name) +
             "=" + urlEncode(value);
            
            //change status to show argument has passed
            status = "t";
        }
        
        else
        {
       //else concatenate with a "&"    
       // concatenate url encoded strings name, + '=', + value
      
    mUrl += "&" + urlEncode(name) +
             "=" + urlEncode(value);
        }
    }
    
    
    public String toString()
    {
    //retturn string mUrl
        return mUrl;
    }
    
   
       
}
