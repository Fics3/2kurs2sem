import java.util.HashMap;
import java.io.*;
import java.util.Map;

public class Settings {
     private HashMap<String, Integer> set;

    public Settings(){
        set=new HashMap<>();
    }
    public boolean equals(Settings a){
        return this.equals(a);
    }
    @Override
    public String toString(){
        return set.toString();
    }
    public void put(String a, int b){
        set.put(a,b);
    }
    public int get(String a){
        return this.get(a);
    }
    public void delete(String a){
        this.delete(a);
    }
    public void loadFromBinaryFile(String filename) throws FileNotFoundException, RuntimeException {
        try {
            String src = "C:\\Users\\zxggx\\IdeaProjects\\laba7\\src\\";
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(src+filename+".bin")));
            String a = in.readLine();
            String[] c = a.split(" ");
            for (int i = 0;i<c.length;i++) {
                String[] b = c[i].split(":");
                this.put(b[0], Integer.parseInt(b[1]));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void saveToBinaryFile(String filename) throws IOException {
        String src = "C:\\Users\\zxggx\\IdeaProjects\\laba7\\src\\";
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(src+filename+".bin")));
        for (Map.Entry<String,Integer> entry : set.entrySet() ){
            out.write(entry.getKey()+":"+entry.getValue()+" ");
        }
        out.close();
    }
    public void loadFromTextFile(String filename) throws FileNotFoundException, RuntimeException {
        try {
            String src = "C:\\Users\\zxggx\\IdeaProjects\\laba7\\src\\";
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(src+filename+".txt")));
            String a = in.readLine();
            String[] c = a.split(" ");
            for (String s : c) {
                String[] b = s.split(":");
                this.put(b[0], Integer.parseInt(b[1]));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void saveToTextFile(String filename) throws IOException {
        String src = "C:\\Users\\zxggx\\IdeaProjects\\laba7\\src\\";
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(src+filename+".txt")));
        for (Map.Entry<String,Integer> entry : set.entrySet() ){
            out.write(entry.getKey()+":"+entry.getValue()+" ");
        }
        out.close();
    }
}