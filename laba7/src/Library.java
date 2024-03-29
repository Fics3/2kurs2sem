import java.io.*;
import java.util.Map;
import java.util.Objects;

public class Library extends Settings{

    public Library(){
        super();
    }
    public void put(String aut, String book, int year){
        this.set.put(aut+"-"+book,year);
    }
    public Object get(String aut, String book){
        if(set.get(aut+"-"+book)==null) return null;
        return set.get(aut+"-"+book);
    }
    public void delete(String aut,String book){
        set.remove(aut+"-"+book);
    }
    public void getAllAutBooks(String aut){
        for (Map.Entry<String,Integer> entry : set.entrySet() ){
            String[] a = entry.getKey().split("-");
            if(Objects.equals(a[0], aut)) System.out.println(a[0]+" - "+a[1]+" "+entry.getValue());
        }
    }
    public void getBookAfterYear(int year){
        for (Map.Entry<String,Integer> entry : set.entrySet() ){
            if(entry.getValue()>year) System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
    public static void main(String args[]) throws IOException {
        Library a = new Library();
        Library b = new Library();
        a.put("Serega Pirat","TP na AMe",2022);
        a.put("Alexander Sergeevich Pushkin","Evgeniy Onegin",1823);
        a.put("AlexDarkStalker98","Devka bez ruki",2010);
        a.put("Serega Pirat","moi bike",1999);
        a.put("AlexDarkStalker98","Pistolet, tushenka, devochki",2010);
        a.put("John Strelecky","The Cafe on the Edge of the World",2011);
        System.out.println(a.get("Serega Pirat","mo bike"));
//        String c =a.toString();
//        System.out.println(a.get("AlexDarkStalker98","Pistolet, tushenka, devochki"));
//        a.getAllAutBooks("AlexDarkStalker98");
//        a.getBookAfterYear(2009);
//        a.saveToTextFile("lib");
//        b.loadFromTextFile("lib");
//        System.out.println(a.equals(b));
//        System.out.println(b);
    }
}
