import javax.management.ObjectName;
import java.util.Scanner;

public class FormattedInput {
    private static final  String[] F = {"%d","%c","%f","%s","%a"};

    public static Object    [] scanf(String format){
        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                return sscanf(format, scanner.nextLine());
            }
            catch (Exception e) {
                System.out.println("Invalid Input");
            }
        }
    }
    public static Object[] sscanf(String iFormat, String in) throws RuntimeException {
        String[] formats = iFormat.split(" ");
        String[] inp = in.split(" ");
            if(formats.length>inp.length) throw new RuntimeException(" Different length of format and input");
        Object[] res = new Object[inp.length];
        int pos=0;
        for (int i = 0; pos<formats.length;i++){
            try {
                if (formats[pos].equals(F[0])) {
                    res[i] = Integer.parseInt(inp[i]);
                } else if (formats[pos].equals(F[1])) {
                    res[pos] = inp[i].charAt(0);
                } else if (formats[pos].equals(F[2])) {
                    res[pos] = Float.parseFloat(inp[i]);
                } else if (formats[pos].equals(F[3])) {
                    res[pos] = inp[i];
                } else if (formats[pos].equals(F[4])) {
                    char a;
                    boolean flag = false;
                    StringBuilder b = new StringBuilder();
                    while (i < inp.length) {
                        for (int j = 0; j < inp[i].length(); j++) {
                            a = inp[i].charAt(j);
                            if (Character.isDigit(a)) {
                                b.append(a);
                                continue;
                            }
                            flag = true;
                            break;
                        }
                        b.append(" ");
                        if (flag) {
                            break;
                        }
                        i++;
                    }
                    res[pos] = b.toString();
                } else throw new RuntimeException("not valid format" + formats[pos] + " for input" + inp[i]);
                pos++;
            }
            catch(Exception e){
                    throw new RuntimeException("not valid format " + formats[pos] + " for input " + inp[i]);
            }
        }
        return res;
        }
    public static void main(String[] args){
     //   Object[] c = sscanf("%f %c %s %f", "efd df 43 43.43");
        Object[] t = sscanf("%d %c %s %f", "32 df gsdpg 43.43");

        Object[] a = sscanf("%a %a %c","323a 43");
  //      Object[] b = scanf("%a");
        for (Object i : a) {
            if(i!=null) {
                System.out.print(i + " ");
            }
        }
    }
}
