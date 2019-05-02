
/**
 * Eine einfache Klasse Person
 *
 * @author Quentin/Raymonde/Arnold
 * @version 24.01.2019
 */
public class Person{
    //Attribute
    
    private String name;
    private String vorname;

    //Konstrukor
    public Person(String name, String vorname)
    {
        this.name = name;
        this.vorname = vorname;
    }
    //set-Methoden
    /**
     * set der name einer Person
     * 
     * @param name eine Zeichenkette 
     */
    public void setName(String name) 
    {
        this.name = name;
    }
    
    /**
     * set der vorname einer Person
     * 
     * @param vorname eine Zeichenkette 
     */
    public void setVorname(String vorname) 
    {
        this.vorname = vorname;
    }

    //get-Methoden
    
    /**
     * gibt der name einer Person zuruck
     * 
     * @return name eine Zeichenkette
     */
    public String getName() 
    {
        return name;
    }
    
    /**
     * gibt der vorname einer Person zuruck
     * 
     * @return vorname eine Zeichenkette
     */
    public String getVorname() 
    {
        return vorname;
    }

    //andere Methoden
    
    /**
     * Person auf die Standardausgabe ausgeben
     *
     */
    public void ausgeben() 
    {
        System.out.print(name + ", " + vorname);
    }

    /**
     * eine einfache toString-Methode
     * 
     * @return name, vorname als Zeichenkette 
     */
    @Override
    public String toString() 
    {
        return name + ", " + vorname;
    }
}
