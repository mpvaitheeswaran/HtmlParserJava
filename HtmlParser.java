import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;



public class HtmlParser {

   
    public static String append(String givenString, String id, String stringToAdd) {
        String outputString = "";
        String targetString;
        String startTag=getStartTag(givenString, id);;
        String endTag;
        String innerElements;
        
                
        if(!isSingletonTag(startTag)){
           
           endTag=getEndTag(startTag);
           innerElements=getInnerElement(givenString, startTag, endTag);
           targetString=startTag+innerElements+endTag;
           outputString=startTag+innerElements+stringToAdd+endTag;
           return givenString.replace(targetString, outputString);
        }
        else{
        	return "";  
        }

    }

    public static String prepend(String givenString, String id, String stringToAdd) {

    	String outputString = "";
    	String targetString;
        String startTag=getStartTag(givenString, id);;
        String endTag;
        String innerElements;
                
        if(!isSingletonTag(startTag)){
        	
            endTag=getEndTag(startTag);
            innerElements=getInnerElement(givenString, startTag, endTag);
            targetString=startTag+innerElements+endTag;
            outputString=startTag+stringToAdd+innerElements+endTag;
            return givenString.replace(targetString, outputString);
          
        }
        else{
        	return "";  
        }
    }

    public static String after(String givenString, String id, String stringToAdd) {
    	String outputString = "";
    	String targetString;
        String startTag;
        String endTag;
        String innerElements;
        
        startTag=getStartTag(givenString, id);
        endTag=getEndTag(startTag);
        innerElements=getInnerElement(givenString, startTag, endTag);
        targetString=startTag+innerElements+endTag;
        outputString=startTag+innerElements+endTag+stringToAdd;
        return givenString.replace(targetString, outputString);
    }

    public static String before(String givenString, String id, String stringToAdd) {
        String outputString = "";
        String targetString;
        String startTag;
        String endTag;
        String innerElements;
        
        startTag=getStartTag(givenString, id);
        endTag=getEndTag(startTag);
        innerElements=getInnerElement(givenString, startTag, endTag);
        targetString=startTag+innerElements+endTag;
        outputString=stringToAdd+startTag+innerElements+endTag;
        return givenString.replace(targetString, outputString);
    }
    
    private static boolean isSingletonTag(String tag){
    	/*
    	 * This menthod return ture if the html tag is singleton.
    	 * otherwise return false
    	 */
        int startTag =tag.indexOf("<");
        int endTag = tag.indexOf("/>",startTag);
            if (endTag>=0){return true;}else{return false;} 
    }

    private static String getStartTag(String givenString,String id) {
    	/*
    	 * This method return a startTag you want.
    	 * fetching startTag using id in givenString.
    	 */
    	int start =givenString.indexOf("\""+id+"\"");
    	int end = 0;
    	while(true) {
    		if(givenString.charAt(start)=='<') {break;}
    		else {start-=1;}
    	}
    	end = givenString.indexOf(">",start);
    	return givenString.substring(start,end+1);
    }
    
    private static String getEndTag(String startTag) {
    	/*
    	 * This method fetch suitable endTag using startTag.
    	 * and return endTag as String.
    	 */
    	int start = startTag.indexOf("<")+1;
    	int end = start;
    	
    	if(isSingletonTag(startTag))return "";
    	
    	while(true) {
    		if(startTag.charAt(end)==' '||startTag.charAt(end)=='>') {break;}
    		else {end+=1;}
    	}
    	return "</"+startTag.substring(start,end)+">";
    }
    private static String getInnerElement(String givenString, String startTag, String endTag) {
    	/*
    	 * This method return all innerElements or subTags between starTag and endTag in givenString
    	 */
    	String tempString = givenString;
    	String startTagNoAtr=splitStartTagWithNoAtr(startTag);
    	String startTagTemp="";
    	int startIndex = tempString.indexOf(startTag)+startTag.length();
    	int endIndex=startIndex;
    	while(true) {
    		
    		endIndex=tempString.indexOf(endTag,endIndex);
    		int index = endIndex;
    		String isStartTag="";
    		
    		//reverse the index to find sub tag.
    		while(true) {
    			index--;
    			
    			isStartTag=tempString.substring(index,index+startTagNoAtr.length());
    			if(isStartTag.equals(startTagNoAtr)) {
    				break;
    			}
    			isStartTag="";
    		}
    		startTagTemp=getFullTag(index,tempString);
    		if(startTagTemp.equals(startTag)) {
    			break;
    		}else {
    			//Replace
    			String temp="";
    			for(int i=0;i<startTagTemp.length();i++) {
    				temp+="a";
    			}
    			tempString=tempString.replace(startTagTemp,temp);
    			endIndex+=1;
    		}
    	}
    	return givenString.substring(startIndex,endIndex);
    }
    private static String splitStartTagWithNoAtr(String startTag) {
    	/*
    	 * returns a Start tag without attributes.
    	 */
    	int start =0;
    	int end = start;
    	while(true) {
    		if(startTag.charAt(end)==' '||startTag.charAt(end)=='>') {break;}
    		else {end+=1;}
    	}
    	return startTag.substring(start,end);
    	
    }
    
    private static String getFullTag(int index,String givenString) {
    	/*
    	 * returns a Start tag with attributes.
    	 */
    	int end=givenString.indexOf(">",index);
    	return givenString.substring(index,end+1);
    }
}