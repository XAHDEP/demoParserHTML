package main.java;

public class HtmlParser {
    public static void main(String[] args) throws Exception {
        for(String s: args){
            System.out.println(s);
            try {
                Connection connection = Connection.getInstance().setBufferFromUrl(s);
                String textHtml = Parser.toString(connection.getBuffer());
                Parser.parsing(textHtml);
            }
            catch(Exception e){
            }
        }
    }
}
