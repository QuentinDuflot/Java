
/**
 * implementierung eine PersonQueue durch unsere OberklasseQueue
 *
 * @author Quentin Duflot/ Marie-Lou Wechsler
 * @version 05/05/2019
 */
public class PersonQueue extends OberklasseQueue
{

    /**
     * fuegt ein Objekt am Ende
     * unsere Queue
     * 
     * Array ist nicht komplett
     * 
     * @param o Das Objekt, das man hinzufuegen moechtet
     */
    public void addLast (Object o)
    {

        super.addLast(o);

    }

    /**
     * entferne das erste Element und gebe eine
     * Referenz darauf zurueck
     * 
     * Array ist nicht leer
     * 
     * @return gibt das entfernte Element zuruck
     */
    public Person removeFirst()
    {
        return (Person)super.removeFirst();
    }

    /**
     * Das i-te Element zurueckgeben
     * 
     * Array ist nicht leer
     * 
     * @param i Index des Objekts
     * @return i-te Element des Queues
     */
    public Person get(int i)
    {
        return (Person)super.get(i);
    }

    public void print() {

        super.print();
    }

    public String smallest() {

        String save;
        PersonIterator iterator = this.new Iterator();
        String actualSmallest = iterator.next().getVorname();
        
        while (iterator.hasNext()){
            save = iterator.next().getVorname();
            if(save.length() < actualSmallest.length())
            {
                actualSmallest = save;
            }
        }
        return actualSmallest;
    }

    /**
    * Inner class implements the PersonIterator interface,
     * which extends the Iterator<Person> interface
    */
    interface PersonIterator extends java.util.Iterator<Person>{}

    private class Iterator implements PersonIterator
    {
        // Start stepping through the array from the beginning
        private int nextIndex = 0;

        public boolean hasNext() {

            // Check if the current element is the last in the array
            return (nextIndex <= getStandardLaenge() - 1);
        }

        public Person next() {

            // Record a value of an even index of the array
            Person retValue = get(nextIndex);

            // Get the next element
            nextIndex ++;
            return retValue;
        }
    }
}
