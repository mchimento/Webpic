package webpic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.net.*;

public class PermanentLink {
	
    public static String run(String url,int width,int height) {
	    try{    
	    	 String output  = getUrlContents(url,width,height);  
	    	 return output;   
	    } catch(Exception e) {  
	    	return "Failure";
	    }
    }	
	
	private static String getUrlContents(String theUrl,int width,int height) {  
	    StringBuilder content = new StringBuilder();
	    String output = "";
	    String urlRegex = "(https:((//)|(\\\\))+lh3\\.googleusercontent\\.com\\/+[a-zA-Z0-9\\-_=.&~#@+?()]*)";
	    Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
	    
	    if (!theUrl.contains("photos.app.goo.gl"))
	    	return "NoGP";
	    
	    try  
	    {  
	      URL url = new URL(theUrl);  
	      URLConnection urlConnection = url.openConnection();    
	      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));	      
	      String line;  
	      
	      while ((line = bufferedReader.readLine()) != null) {  
	          content.append(line + "\n");	          
	      }  
	      
	      bufferedReader.close();
	      Matcher urlMatcher = pattern.matcher(content);
	      
	      while (urlMatcher.find()) {
	    	  String[] xs = content.substring(urlMatcher.start(0),urlMatcher.end(0)).split("=");
	          if (xs.length > 1) { 
	        	  output = xs[0] + "=w" + Integer.toString(width) + "-h" + Integer.toString(height);
	        	  break;
	          }
	      }	      
	      return output;	      
	    }  
	    catch(Exception e)  
	    {  
	      return "Failure";
	    } 
	  } 

}
