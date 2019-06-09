package ueb19;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class DoppelVerkListe<E> implements List<E> {

	protected int size;
	protected DoppelVerkListElement<E> first;
	protected DoppelVerkListElement<E> last;

	/** Leere Liste erzeugen */

	public DoppelVerkListe()
	{
		first = last = null;
		size  = 0;
	}

	public class DoppelVerkListElement<E> 
	{
		protected E                       data;
		protected DoppelVerkListElement<E> next;
		protected DoppelVerkListElement<E> previous;

		DoppelVerkListElement( E newElement, DoppelVerkListElement<E> before, DoppelVerkListElement<E> after )
		{
			data     = newElement;
			previous = before;
			next     = after;
		}
	}
	
	public int size() 
	{
		return size;
	}

	public boolean  isEmpty()
	{
		return size == 0;
	}

	public boolean  contains( Object o )
	{
		return ( indexOf(o) > -1 ) ;
	}

	public <T> T[]  toArray( T[] a )
	{
		int index  = 0;

		if ( isEmpty() )

			throw new RuntimeException( "Die Liste ist leer !!!" );

		DoppelVerkListElement<E> listElement = first ;

		while ( listElement != null )
		{
			a[index++] = (T)listElement.data ;
			listElement = listElement.next;
		}
		return a;
	}
	
	public boolean  add( E newElement )
    {
      DoppelVerkListElement<E> newListElement = new DoppelVerkListElement<E> ( newElement, null, null );
      
      if ( first == null )
      {
          first = last = newListElement;
          size  = 1;
      }
      else 
      {
          last.next = newListElement;
          newListElement.next = last;
          size++;
      }
      return true ;
    }
	
	

}
