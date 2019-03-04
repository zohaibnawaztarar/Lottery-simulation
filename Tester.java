import java.util.HashSet;
import java.util.Iterator;
/**
 * This is a Tester class of program containing data to test Myset class
 * 
 * @author Zohaib Tarar
 * @version 1.0
 */
public class Tester
{
    // declare a number of fields to contain Sets 
    private MySet s1;
    private MySet s2;
    private MySet s3;
    private MySet s4;
    private MySet s5;
    private MySet s6;
    private MySet s7;   
    /**
     * Default constructor. Initialise fields.
     */
    public Tester() 
    {
        // create instances of various sets                
        MySet setA = new MySet();
        MySet setB = new MySet();
        setA.addToSet(1);
        setA.addToSet(2);
        setA.addToSet(4);
        setA.addToSet(2);
        setA.addToSet(7);

        setB.addToSet(1);
        setB.addToSet(1);
        setB.addToSet(3);
        setB.addToSet(5);
        setB.addToSet(6);
        setB.addToSet(8);
        
        setA.printSet();
        setB.printSet();    
    }

    /**
     * A main() method.
     */
    public static void main(String[] args) 
    {
        // create instance of Tester object
        Tester testerObj = new Tester();

        // call method to perform Set-related tasks.
        testerObj.doSetOperations();
    }

    /**
     * Perform various example operations with a (Hash)Set.
     */
    public void doSetOperations()
    {
        // create three separate Sets containing a different selection of Person objects in them
        HashSet<MySet> ac = createSet1();
        HashSet<MySet> it = createSet2();
        HashSet<MySet> sci = createSet3();

        // display the contents of each set
        System.out.println("\n\nUsing HashSet to demonstrate some set operations");
        System.out.print("Set ac: ");
        printSet(ac);
        System.out.print("Set it: ");
        printSet(it);
        System.out.print("Set sci: ");
        printSet(sci);

        // use the retainAll method to implement an intersection as below:

        // create a temporary set to store the result of the intersection
        HashSet<MySet> temp = new HashSet<MySet>();

        // add / copy the entire contents of one set to the temporary set
        temp.addAll(ac);

        // apply the retainAll method to the contents of the temporary set, intersecting it
        // with the contents of another set
        temp.retainAll(it);

        // display the contents of the temporary set - it should now contain the result
        // of the intersection
        System.out.println("INTERSECTION: ac and it");
        printSet(temp);

        // use the addAll method to implement a union
        // clear the contents of the temporary set
        temp.clear();

        // add the contents of two sets to it (their contents will be unioned)
        temp.addAll(ac);
        temp.addAll(it);

        // display the content of the Union
        System.out.println("UNION");
        printSet(temp);

        // use the containsAll method to determine if a set is a subset of another
        // clear the temporary set
        temp.clear();

        // add contents of one set to it
        temp.addAll(sci);   

        // if the tempoary set contains the contents of another given set
        if (temp.containsAll(ac)) 
        {
            // the given set is a subset of the contents of the temporary set
            System.out.println("AC IS A SUBSET OF SCI.");
        }
        else
        {
            // not a subset
            System.out.println("AC IS NOT A SUBSET OF SCI.");
        }   

        // try with another set
        temp.clear();
        temp.addAll(sci);
        if (temp.containsAll(it)) 
        {
            System.out.println("IT IS SUBSET OF SCI");
        }
        else
        {
            System.out.println("IT IS NOT A SUBSET OF SCI.");
        }   
    }

    /**
     * Create and return a new (Hash)Set which contains a selection of Person objects
     * 
     * @return A new HashSet object with Person objects as its content
     */
    public HashSet<MySet> createSet1() 
    {       
        // create an instance of a HashSet object which is capable of containing Person objects
        HashSet<MySet> hs = new HashSet<MySet>();

        // add a selection of Person objects to the set (these are references to the Person objects 
        // which are contained as fields in this class)
        hs.add(s1);
        hs.add(s2);
        hs.add(s3);
        hs.add(s4);

        // return a reference to the newly created set
        return hs;

    }

    /**
     * Create and return a new (Hash)Set which contains a different selection of Person objects
     * 
     * @return A new HashSet object with Person objects as its content
     */
    public HashSet<MySet> createSet2() 
    {      
        // create an instance of a HashSet object which is capable of containing Person objects
        HashSet<MySet> hs = new HashSet<MySet>();

        // add a selection of Person objects to the set (these are references to the Person objects 
        // which are contained as fields in this class)
        hs.add(s3);
        hs.add(s5);
        hs.add(s1);
        hs.add(s2);
        hs.add(s6);

        // return a reference to the newly created set
        return hs;

    }

    /**
     * Create and return a new (Hash)Set which contains a different selection of Person objects
     * 
     * @return A new HashSet object with Person objects as its content
     */
    public HashSet<MySet> createSet3() 
    {     
        // create an instance of a HashSet object which is capable of containing Person objects
        HashSet<MySet> hs = new HashSet<MySet>();

        // add a selection of Person objects to the set (these are references to the Person objects 
        // which are contained as fields in this class)
        hs.add(s2);
        hs.add(s3);
        hs.add(s4);
        hs.add(s7);
        hs.add(s6);
        hs.add(s1);

        // return a reference to the newly created set
        return hs;
    }

    /**
     * Display the contents of a given set
     * 
     * @param personSet A reference to a HashSet object which contains a selection of Person objects as it contents
     */
    public void printSet(HashSet<MySet> personSet)
    {
        // create a String in which the information to display will be gradually added to
        String output = "{";

        // get an Iterator for the set
        Iterator<MySet> iterator = personSet.iterator();

        // while there is another item in the set to iterate over
        while (iterator.hasNext())
        {
            // get the next Person in the set
            MySet s = iterator.next();

            // add details of this person to the String which is gradually being built           
            output = output + s.getSetData() + ",";
        }

        // NOTE: alternative to the above Iterator is to use a 'for each' loop in Java as below:
        //        
        // for (Person p : personSet) 
        // {
        //     output = output + p.getName() + ",";
        // }

        // add final character to output string
        output += "}";  

        // display the output string
        System.out.println(output);
    }
}
