
/**
 * Write a description of class OberklasseQueue here.
 *
 * @author Quentin/Raymonde/Arnold
 * @version 24.01.2019
 */
import java.util.*;
public class OberklasseQueue implements Queue
{
    //Konstanten
    
    private static final int STANDARD_LAENGE = 20 ;
    private static final String QUEUE_VOLL_MELDUNG = "Die Queue ist voll! Man kann keine Element hinzufuegen!";
    private static final String QUEUE_LEER_MELDUNG = "Die Queue ist leer !";
    
    //Attribute
    private Object[] queue;
    private int laenge;
    
    //Standard Konstruktor
    /**
     * erzeugt ein Queue-Objekt mit eine Standard maximal Laenge
     * und eine Initial-Laenge von 0
     */
    public OberklasseQueue()
    {
        queue = new Object[STANDARD_LAENGE];
        laenge = 0;
    }
    
    /**
     * fuegt ein Objekt am Ende
     * unsere Queue
     * 
     * Array ist nicht komplett
     * 
     * @param o Das Objekt, das man hinzufuegen moechtet
     */
    public void addLast(Object o)
    {
        if( full() )
        {
            throw new RuntimeException(QUEUE_VOLL_MELDUNG);
        }
        else
        {
            queue[laenge] = o;
            laenge++;
        }
    }
    
    /**
     * entferne das erste Element und gebe eine
     * Referenz darauf zurueck
     * 
     * Array ist nicht leer
     * 
     * @return gibt das entfernte Element zuruck
     */
    public Object removeFirst()
    {
        if( empty() )
        {
            throw new RuntimeException(QUEUE_LEER_MELDUNG);
        }
        else
        {
            Object first = queue[0];
            laenge--;
            
            for(int i = 0; i < laenge; i++)
            {
                queue[i] = queue[i+1];
            }
            queue[laenge] = null;
            return first;
        }
    }
    
    /**
     * Das i-te Element zurueckgeben
     * 
     * Array ist nicht leer
     * 
     * @param i Index des Objekts
     * @return i-te Element des Queues
     */
    public Object get(int i)
    {
        if( empty() )
        {
            throw new RuntimeException(QUEUE_LEER_MELDUNG);
        }
        else
        {
            return queue[i];
        }
    }
    
    /**
     * Testen, ob schon Elemente eingefuegt wurden
     * 
     * @return true wenn es leer ist, sonst false
     */
    public boolean full()
    {
        return (queue[laenge] != null);
    }
    
    /**
     * Testen, ob noch Elemente einfuegbar sind,
     * d. h. ob das letzte Element schon einen Wert != null hat
     * 
     * @return true wenn es voll ist, sonst false
     */
    public boolean empty()
    {
        return (queue[0] == null);
    }
    
    /**
     * Anzahl eingefuegter Elemente
     * 
     * @return Anzahl der Elemente in unsere Queue
     */
    public int size()
    {
        return laenge;
    }
    
    public int getStandardLaenge()
    {
        return STANDARD_LAENGE;
    }
    
    /**
     * Eine toString-Methode fuer unsere Queue-Objekt
     */
    public String toString()
    {
        StringBuffer buffer = new StringBuffer();
        
        for(int i = 0; i < laenge; i++)
        {
            buffer.append(queue[i] + " | ");
        }
        return buffer.toString();
    }
    
        public void print() {

        // Print out values of even indices of the array
        ObjectIterator iterator = this.new Iterator();
        while (iterator.hasNext()) {
            System.out.print("\n" + iterator.next());
        }
        System.out.println();
    }

    /**
    * Inner class implements the PersonIterator interface,
     * which extends the Iterator<Person> interface
    */
    interface ObjectIterator extends java.util.Iterator<Object>{}

    private class Iterator implements ObjectIterator
    {
        // Start stepping through the array from the beginning
        private int nextIndex = 0;

        public boolean hasNext() {

            // Check if the current element is the last in the array
            return (nextIndex <= laenge - 1);
        }

        public Object next() {

            // Record a value of an even index of the array
            Object retValue = get(nextIndex);

            // Get the next element
            nextIndex ++;
            return retValue;
        }
    }
}
