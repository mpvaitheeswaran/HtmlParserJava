import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestClass {

public static void main(String[] args) throws IOException {
    	
    	String givenString = new String(Files.readAllBytes(Paths.get("htmlFile.txt")));
        givenString = givenString.replaceAll("\\t","");
        givenString = givenString.replaceAll("\\r","");
        givenString = givenString.replaceAll("\\n","");
        
        System.out.println("Given String Test htmlFileMixed.:");
        System.out.println(givenString);

        System.out.println("\nOutput for append:");
        System.out.println(HtmlParser.append(givenString, "6", "<img id=\"appendSample2\" />"));

        System.out.println("\nOutput for prepend:");
        System.out.println(HtmlParser.prepend(givenString, "10", "<br id=\"prependSample2\" />"));

        System.out.println("\nOutput for after:");
        System.out.println(HtmlParser.after(givenString, "7", "<div id=\"afterSample2\"></div>"));

        System.out.println("\nOutput for before:");
        System.out.println(HtmlParser.before(givenString, "13", "<span id=\"beforeSample2\"></span>"));
        System.out.println("-------------------------------------------------------------------\n");
        
        
        String givenString1 = new String(Files.readAllBytes(Paths.get("htmlFileDiv.txt")));
        givenString1 = givenString1.replaceAll("\\t","");
        givenString1 = givenString1.replaceAll("\\r","");
        givenString1 = givenString1.replaceAll("\\n","");
        
        System.out.println("Given String Test htmlFileDiv.:");
        System.out.println(givenString1);

        System.out.println("\nOutput for append:");
        System.out.println(HtmlParser.append(givenString1, "2", "<img id=\"appendSample2\" />"));

        System.out.println("\nOutput for prepend:");
        System.out.println(HtmlParser.prepend(givenString1, "1", "<br id=\"prependSample2\" />"));

        System.out.println("\nOutput for after:");
        System.out.println(HtmlParser.after(givenString1, "1", "<div id=\"afterSample2\"></div>"));

        System.out.println("\nOutput for before:");
        System.out.println(HtmlParser.before(givenString1, "1", "<span id=\"beforeSample2\"></span>"));
        System.out.println("-------------------------------------------------------------------\n");
        
        String givenString2 = new String(Files.readAllBytes(Paths.get("htmlFileSpan.txt")));
        givenString2 = givenString2.replaceAll("\\t","");
        givenString2 = givenString2.replaceAll("\\r","");
        givenString2 = givenString2.replaceAll("\\n","");
        
        System.out.println("Given String Test htmlFileSpan.:");
        System.out.println(givenString2);

        System.out.println("\nOutput for append:");
        System.out.println(HtmlParser.append(givenString2, "3", "<img id=\"appendSample2\" />"));

        System.out.println("\nOutput for prepend:");
        System.out.println(HtmlParser.prepend(givenString2, "2", "<br id=\"prependSample2\" />"));

        System.out.println("\nOutput for after:");
        System.out.println(HtmlParser.after(givenString2, "2", "<div id=\"afterSample2\"></div>"));

        System.out.println("\nOutput for before:");
        System.out.println(HtmlParser.before(givenString2, "1", "<span id=\"beforeSample2\"></span>"));
        System.out.println("-------------------------------------------------------------------\n");

    
    }
}
