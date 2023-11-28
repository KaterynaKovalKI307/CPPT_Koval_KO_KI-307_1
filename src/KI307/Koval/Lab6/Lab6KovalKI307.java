package KI307.Koval.Lab6;
import java.util.*;


/**
 * Class Lab6KovalKI307 realize example program to lab6
 * @author Koval Kateryna
 * @version 1.2
 * @since version 1.0
 */

public class Lab6KovalKI307 {
    public static void main(String[] args) throws Exception {
        Truck <? super Data> truck = new Truck <Data> ();
        truck.AddData(new Sofa("Beige" , "Velvet", 120));
        truck.AddData(new Chair("Green" , 18));
        truck.AddData(new Bookcase(5 , 30));
        truck.AddData(new Sofa("Brown" , "Leather", 85));
        truck.AddData(new Chair("Black" , 12));
        truck.AddData(new Bookcase(3 , 22));
        truck.DeleteData(4);
        Data res1 = truck.findMin();
        System.out.println("The least by weight: ");
        res1.print();

    }
}
/**
 * Parameterized class <code>Truck</code> implements truck
 */
class Truck<T extends Data>{
    private ArrayList<T> arr;
    public Truck() {
        arr = new ArrayList<T>();
    }
    /**
     * method finds the smallest element by weight
     * @return min
     */
    public T findMin()
    {
if(!arr.isEmpty()){
    T min = arr.get(0);
    for (int i = 1;i<arr.size();i++){
        if(arr.get(i).compareTo(min)<0)
        min = arr.get(i);
    }
    return min;
}
return null;
    }

public void AddData(T data){
    arr.add(data);
    System.out.println("Element added: ");
    data.print();
}
public void DeleteData(int i){
	arr.remove(i);
	System.out.println("Element #" + i + " is deleted."); 
}  
}
/**
 * Interface <code>Data</code> implements data
 */
interface Data extends Comparable<Data>
{
public int getWeight();
public void print();
}
/**
 * Class <code>Sofa</code> implements sofa
 */
class Sofa implements Data{
    private String color;
    private String material;
    private int weight;
    /**
     * Constructor
     * @param <code>color_t</code> the color of sofa
     * @param <code>material_t</code> material of sofa
     * @param <code>weight_t</code> the weight of sofa
     */
    public Sofa(String color_t, String material_t, int weight_t){
color = color_t;
material = material_t;
weight = weight_t;
    }
    /**
     * Method return color of sofa
     * @return color
     */
    public String getColor(){
        return color;
    }
    /**
     * Method set color for sofa
     * @param <code>color_s</code> color of sofa
     */
    public void setColor(String color_t){
color=color_t;
    }
/**
 * Method return material of sofa
 * @return material
 */
public String getMaterial(){
    return material;
}
/**
 * Method set material for sofa
 * @param <code>material_t</code> material for sofa
 */
public void setMaterial(String material_t){
    material = material_t;
}
/**
 * Method return weight of sofa
 * @return weight
 */
public int getWeight(){
return weight;
}
/**
 * Method compare objects type Data
 * @param <code>p</code> the weight of object
 */
public int compareTo(Data p){
    Integer h = weight;
    return h.compareTo(p.getWeight());
}
/**
 * Method print information about sofa
 */
public void print(){
    System.out.println("Type: Sofa, Color: " + color + ", Material: " + material + ", Weight: " + weight + " kg\n"); 

    
}
}
/**
 * class <code>Chair</code> implements Chair
 */
class Chair implements Data{
    private String chairColor;
    private int chairWeight;
    /**
     * Constructor
     * @param <code>chairColor_t</code> chair color
     * @param <code>chairWeight_t</code> chair weight
     */
    public Chair(String chairColor_t,int chairWeight_t){
        chairColor = chairColor_t;
        chairWeight=chairWeight_t;
    }
/**
 * Method return color of Chair
 * @return chairColor
 */
    public String getChairColor(){
        return chairColor;
    }
    /**
     * Method set Chair color
     * @param <code>chairColor_t</code> the color of Chair
     */
    public void setChairColor(String chairColor_t){
chairColor=chairColor_t;
    }
    /**
     * Method return weight of Chair
     * @return chairWeight
     */
    public int getWeight(){
return chairWeight;
    }
    /**
     * Method set Chair weight
     * @param <code>chairWeight_t</code> the Chair weight
     */
    public void setWeight(int chairWeight_t){
        chairWeight = chairWeight_t;
    }
    /**
     * Method compare objects type Data
     * @param <code>p</code> the weight of object
     */
public int compareTo(Data p){
    Integer h = chairWeight;
    return h.compareTo(p.getWeight());
}
/**
 * Method print information about Chair
 */
public void print(){
    System.out.println("Type: Chair, Color: " + chairColor + ", Weight: " + chairWeight + " kg\n"); 
}
/**
 * class <code>Chair</code> implements Chair
 */
}
class Bookcase implements Data{
    private int shelves;
    private int weight;
    /**
     * Constructor
     * @param <code>shelves_t</code> number of shelves
     * @param <code>weight_t</code> Bookcase weight
     */
    public Bookcase(int shelves_t,int weight_t){
        shelves = shelves_t;
        weight= weight_t;
    }
/**
 * Method return number of Bookcase shelves
 * @return shelves
 */
    public int getShelves(){
        return shelves;
    }
    /**
     * Method set number of Bookcase shelves
     * @param <code>shelves_t</code> the number of Bookcase shelves
     */
    public void setShelves(int shelves_t){
    	shelves=shelves_t;
    }
    /**
     * Method return weight of Bookcase
     * @return Weight
     */
    public int getWeight(){
return weight;
    }
    /**
     * Method set Bookcase weight
     * @param <code>weight_t</code> the Bookcase weight
     */
    public void setWeight(int weight_t){
        weight = weight_t;
    }
    /**
     * Method compare objects type Data
     * @param <code>p</code> the weight of object
     */
public int compareTo(Data p){
    Integer h = weight;
    return h.compareTo(p.getWeight());
}
/**
 * Method print information about Bookcase
 */
public void print(){
    System.out.println("Type: Bookcase, Shelves: " + shelves + ", Weight: " + weight + " kg\n"); 
}
}


