import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String args[]) throws IOException {
        Settings a = new Settings();
        Settings b = new Settings();
        Settings c = new Settings();
        b.put("dafa",1);
        b.put("rep",34);
        b.put("daf",14);
        b.saveToBinaryFile("output");
        a.loadFromBinaryFile("output");
        b.saveToTextFile("toutput");
        c.loadFromTextFile("toutput");
//        a.put("dafa",1);
//        a.put("rep",34);
//        a.saveToBinaryFile("o");
//        a.saveToTextFile("toutput");
//        a.loadFromBinaryFile("output-onlinefiletools");
//        a.saveToBinaryFile("output2");
//        a.loadFromBinaryFile("output2");
//        b.loadFromBinaryFile("o");
        c.saveToTextFile("cwc");
        System.out.println(c);

        a.saveToTextFile("toutput");

    }
}