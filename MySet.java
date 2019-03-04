import java.util.*;
import java.util.Set;
/**
 * This class is wrapper to the Set class which holds elements of set and performs intersection.
 * 
 * @author Zohaib Tarar
 * @version 1.0
 */
public class MySet
{
    //Defining fields for MySet Class
    private Set<Integer> setdata;
    private Iterator iterator;
    /**
     * Constructor for objects of class MySet.
     */
    public MySet()
    {
        setdata = new HashSet<Integer>(); // To Create the Set object
    }

    /**
     * Second construtor for MySet Class.
     * takes a Set parameters and uses this to define setdata. 
     */
    public MySet(Set<Integer> data)
    {
        this.setdata = data; 
    }

    /**
     * This method adds the specified element to the set
     *
     * @param num A parameter
     * @return The result value
     */
    public boolean addToSet(int num)
    {
        Integer nextNumber = new Integer(num); // Create an Integer object 
        boolean result = setdata.add(nextNumber); //Add the Integer object to our Set  
        // Returns the result. if the Integer already exists it will be false
        return result; 
    }

    /**
     * Method to get cardinality/Size of Set
     *
     * @return the number of elements in this set
     */
    public int getCardinality()
    {
        return setdata.size();
    }

    /**
     * Method to check if set is empty
     *
     * @return True if this set contains no elements
     */
    public boolean isSetEmpty()
    {
        return true;
    }

    /**
     * This method check if set contains the specified element.
     *
     * @param value A parameter
     * @return True if this set contains the specified element.
     */
    public boolean isInSet(int value)
    {
        return true;
    }

    /**
     * method to get elements of set.
     *
     * @return The the setdata value.
     */
    public Set<Integer> getSetData()
    {
        return setdata;
    }

    /**
     * Method to display the elements of set.
     *
     */
    public void printSet()
    {
        Iterator iterator = setdata.iterator();
        while (iterator.hasNext())
        {
            System.out.println("This set contains:" + iterator.next());            
        }
        System.out.print("\n");
    }

    /**
     * This method performs the intersection
     *
     * @param secondSet A parameter
     * @param userInput A parameter
     * @return value of intersect - True if this set changed as a result of the call
     */
    public MySet intersection(MySet SetB, MySet userInput)
    {
        Set<Integer> copySet = new HashSet<Integer>(userInput.getSetData()); //create instance of Set object 
        copySet.retainAll(SetB.getSetData()); //perform intersection 
        //Create a new MySet object to store the intersection result in
        MySet intersect = new MySet(copySet); 
        return intersect;
    }  
}
