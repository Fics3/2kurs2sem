import java.util.HashMap;
import java.io.*;
import java.util.Map;
import java.util.Objects;

public class Settings {
     protected HashMap<String, Integer> set;
     //искать все книги заданного автора, найти всех авторов которые выпускали книги после заданного года

    public Settings(){
        set=new HashMap<>();
    }
    public final String toString(){
        return set.toString();
    }
    public void put(String a, int b){
        set.put(a,b);
    }
    public Object get(String a) {
        if (set.get(a) == null) return null;
        return set.get(a);
    }
    public void delete(String a){
        set.remove(a);
    }
    public final void loadFromBinaryFile(String filename) throws FileNotFoundException, RuntimeException {
        try {
            String src = "C:\\Users\\zxggx\\IdeaProjects\\laba7\\src\\";
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(src + filename + ".bin")));
            String line = in.readLine();
            while (line != null) {
                String[] b = line.split(":");
                this.put(b[0], Integer.parseInt(b[1]));
                line = in.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public final void saveToBinaryFile(String filename) throws IOException {
        String src = "C:\\Users\\zxggx\\IdeaProjects\\laba7\\src\\";
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(src+filename+".bin")));
        for (Map.Entry<String,Integer> entry : set.entrySet() ){
            out.write(entry.getKey()+":"+entry.getValue()+"\n");
        }
        out.close();
    }
    public final void loadFromTextFile(String filename) throws FileNotFoundException, RuntimeException {
        try {
            String src = "C:\\Users\\zxggx\\IdeaProjects\\laba7\\src\\";
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(src+filename+".txt")));
            String line = in.readLine();
            while (line!=null) {
                String[] b = line.split(":");
                this.put(b[0], Integer.parseInt(b[1]));
                line = in.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public final void saveToTextFile(String filename) throws IOException {
        String src = "C:\\Users\\zxggx\\IdeaProjects\\laba7\\src\\";
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(src+filename+".txt")));
        for (Map.Entry<String,Integer> entry : set.entrySet() ){
            out.write(entry.getKey()+":"+entry.getValue()+"\n");
        }
        out.close();
    }

    public final boolean equals(Settings a) {
        return this.set.equals(a.set);
    }
}