# HtmlParserJava
This program was a HTML parser, it can do four basic tasks such as <b>append, prepend, after, before</b>.
### How to use this program
<b>Step 1 :</b> Download the HtmlParser.java file.<br>
<b>Step 2 :</b> Add the downloaded program into your project.<br>
<b>Step 3 :</b> Read the code from TestClass.java.<br>
<b>Note :</b> The four <b>append, prepend, after, before</b> methods are static methods so, there is no need for creating object for HtmlParser class.
### Example
```java
String givenString = new String(Files.readAllBytes(Paths.get("htmlFile.html")));
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

```
