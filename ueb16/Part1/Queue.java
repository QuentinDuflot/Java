
/**
 * Eine Interface, die eine Queue beschreibt
 *
 * @author Quentin Duflot/ Marie-Lou Wechsler
 * @version 05/05/2019
 */
public interface Queue {
    
    /**
     * fuegt ein Objekt am Ende
     * unsere Queue
     * 
     * @param o Das Objekt, das man hinzufuegen moechtet
     */
    void addLast(Object o);
    
    /**
     * entferne das erste Element und gebe eine
     * Referenz darauf zurueck
     * 
     * @return gibt das entfernte Element zuruck
     */
    Object removeFirst(); 
    
    /**
     * Das i-te Element zurueckgeben
     * 
     * @param i Index des Objekts
     * @return i-te Element des Queues
     */
    Object get(int i);
    
    /**
     * Testen, ob schon Elemente eingefuegt wurden
     * 
     * @return true wenn es leer ist, sonst false
     */
    boolean empty(); 
    
    /**
     * Testen, ob noch Elemente einfuegbar sind,
     * d. h. ob das letzte Element schon einen Wert != null hat
     * 
     * @return true wenn es voll ist, sonst false
     */
    boolean full(); 
    
    /**
     * Anzahl eingefuegter Elemente
     * 
     * @return Anzahl der Elemente in unsere Queue
     */
    int size(); 
    
    void print();
    
}
