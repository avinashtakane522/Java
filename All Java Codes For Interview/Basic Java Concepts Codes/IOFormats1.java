import java.util.Scanner;
import java.io.*;

public class IOFormats1 {
    public static void main(String[] args) throws IOException, NumberFormatException{

        //Scanner(belongs to Util class) - input type--------------------------------------------------------

        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        int numint; float numfloat; double numdouble; boolean numboolean;

        System.out.println("Hi my name is "+name);
        System.out.println("Enter int, float, double, boolean sequentially : ");
        numint = sc.nextInt();
        numfloat = sc.nextFloat();
        numdouble = sc.nextDouble();
        numboolean = sc.nextBoolean();

        System.out.println("Int : "+numint+", Float : "+numfloat+", Double : "+numdouble+", Boolean : "+numboolean);

        //BufferedReader(belongs to IO class) - input type---------------------------------------------------------

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("My name is");
        name = br.readLine();
        System.out.println("/n Enter int, float, double, boolean sequentially : ");
        numint = Integer.parseInt(br.readLine()); 
        numfloat = Float.parseFloat(br.readLine());
        numdouble = Double.parseDouble(br.readLine());
        numboolean = Boolean.parseBoolean(br.readLine());

        System.out.println("Int : "+numint+", Float : "+numfloat+", Double : "+numdouble+", Boolean : "+numboolean);
    }
}
