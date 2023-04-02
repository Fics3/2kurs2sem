import java.nio.charset.*;
import java.io.*;
public class EncodingConverter {
    public static void convert(String inFile, String outFile, String charsetA, String charsetB) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(inFile), charsetA));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), charsetB));
        String line;
        while ((line = in.readLine()) != null) {
            out.write(line);
            out.newLine();
        }
        in.close();
        out.close();
    }
    public static void main(String args[]) throws IOException {
        convert(
                "C:\\Users\\zxggx\\IdeaProjects\\laba6\\src\\input.txt",
                "C:\\Users\\zxggx\\IdeaProjects\\laba6\\src\\output.txt",
                "UnicodeLittle",
                "ASCII"
        );
    }
}
