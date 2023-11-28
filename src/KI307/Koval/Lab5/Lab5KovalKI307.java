package KI307.Koval.Lab5;

import java.util.Scanner;
import java.io.*;
import static java.lang.System.out;
/**
 * Class <code>Lab5KovalKI307</code> Implements driver for Equations class
 * @author Koval Kateryna
 * @version 1.2
 */
public class Lab5KovalKI307 {
      /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        try
        {
        CalcWFio obj = new CalcWFio();
        Scanner in = new Scanner(System.in);
        try
        {
        try
        {
        Equations eq = new Equations();
        out.print("Enter X: ");
        double data = eq.calculate(in.nextDouble());
        obj.calculate(data);
        System.out.println("Result is: " + obj.getResult());
        obj.writeResTxt("textRes.txt");
        obj.writeResBin("BinRes.bin");
        obj.readResBin("BinRes.bin");
        System.out.println("Result from bin is: " + obj.getResult());
        obj.readResTxt("textRes.txt");
        System.out.println("Result from text is: " + obj.getResult());

        }
        finally
        {
        // Цей блок виконається за будь-яких обставин
        }
        }
        catch (CalcException ex)
        {
        // Блок перехоплює помилки обчислень виразу
        out.print(ex.getMessage());
        }
        in.close();
        }
        catch (FileNotFoundException ex)
        {
        // Блок перехоплює помилки роботи з файлом навіть якщо вони
        // виникли у блоці finally
        out.print("Exception reason: Perhaps wrong file path");
        }
        }
        

    }
/**
* Class <code>CalcException</code> more precises ArithmeticException
* @author Koval Kateryna
* @version 1.2
*/
class CalcException extends ArithmeticException
{
public CalcException(){}
public CalcException(String cause)
{
super(cause);
}
}
/**
* Class <code>Equations</code> implements method for (sin(x)/tg(4x)) expression calculation
* @author Koval Kateryna
*
* @version 1.2
*/
class Equations
{
/**
* Method calculates the (sin(x)/tg(4x)) expression
* @param <code>x</code> Angle in degrees
* @throws CalcException
*/
public double calculate(double x) throws CalcException
{
double y, rad;
rad = x * Math.PI / 180.0;
try
{
y = Math.sin(rad)/Math.tan(4*rad);
// Якщо результат не є числом, то генеруємо виключення
if (y==Double.NaN || y==Double.NEGATIVE_INFINITY ||
y==Double.POSITIVE_INFINITY || x==90 || x== -90)
throw new ArithmeticException();
}
catch (ArithmeticException ex)
{
// створимо виключення вищого рівня з поясненням причини
// виникнення помилки
if (rad==Math.PI/2.0 || rad==-Math.PI/2.0)
throw new CalcException("Exception reason: Illegal value of X for tangent calculation");
else if (x==0)
throw new CalcException("Exception reason: X = 0");
else
throw new CalcException("Unknown reason of the exception during exception calculation");
}
return y;
}
}

/**
 * Class <code>CalcWFio</code> work with binary and text files expression calculation
 * @author Koval Kateryna
 * @version 1.2
 */
class CalcWFio {
    /**
     * Method write result to text file
     * 
     * @param <code>fName</code> Name of the file
     * @throws 
     */
    public void writeResTxt(String fName) throws FileNotFoundException {
        PrintWriter f = new PrintWriter(fName);
        f.printf("%f ", result);
        f.close();
    }

    /**
     * Method read result from text file
     * 
     * @param <code>fName</code> Name of the file
     * @throws 
     */
    public void readResTxt(String fName) {
        try {
            File f = new File(fName);
            if (f.exists()) {
                Scanner s = new Scanner(f);
                result = s.nextDouble();
                s.close();
            } else
                throw new FileNotFoundException("File " + fName + "not found");
        } catch (FileNotFoundException ex) {
            System.out.print(ex.getMessage());
        }
    }

    /**
     * Method write result to binary file
     * 
     * @param <code>fName</code> Name of the file
     * @throws 
     */
    public void writeResBin(String fName) throws FileNotFoundException, IOException {
        DataOutputStream f = new DataOutputStream(new FileOutputStream(fName));
        f.writeDouble(result);
        f.close();
    }
    /**
     * Method read result from binary file
     * 
     * @param <code>fName</code> Name of the file
     * @throws 
     */
    public void readResBin(String fName) throws FileNotFoundException, IOException {
        DataInputStream f = new DataInputStream(new FileInputStream(fName));
        result = f.readDouble();
        f.close();
    }

    /**
     * Method set x for result
     */
    public void calculate(double x) {
        result = x;
    }

    /**
     * Method return result
     */
    public double getResult() {
        return result;
    }

    private double result;
}
