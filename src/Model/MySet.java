package Model;

import java.util.Iterator;
import java.util.Vector;

/**
 * @overview a collection data type that the objects
 * @attribute
 * elements Model.MySet<Object> Vector<Object>
 * @object
 * A typical Model.MySet is Model.MySet = {elements} where
 * elements(elements)
 * @abstract_properties
 * mutable(elements) = true /\ optional(elements) = false
 */
public class MySet<Object>{
    private Vector<Object> elements;

    /**
     * @effects initialise <tt>this</tt> to be empty
     */
    public MySet(){
    	elements = new Vector<>();
    }

    /**
   	 * @modifies <tt>this</tt>
   	 * @effects <pre>
     *   if x is already in this 
     *     do nothing 
     *   else 
     *     add x to this, i.e., this_post = this + {x}
	 *</pre>
     */
  	public void insert(Object x) {
    	if (getIndex(x) < 0)
      		elements.add(x);
  	}

    /**
   	 * @modifies <tt>this</tt>
     * @effects <pre>
     *   if x is not in this 
     *     do nothing 
     *   else 
     *     remove x from this, i.e. 
     *     this_post = this - {x}
	 *</pre>
     */
    public void remove(Object x) {
    	int i = getIndex(x);
    	if (i < 0)
      		return;
    	elements.set(i, elements.lastElement());
    	elements.remove(elements.size() - 1);
  	}

    /**
   	 * @effects <pre>
     *  if x is in this 
     *    return true 
     *  else 
     *    return false</pre>
     */
  	public boolean isIn(Object x) {
	    return (getIndex(x) >= 0);
  	}

	/**
	 * @effects <pre>
	 *  if index < 0 || index >= size()
	 *    throw new NotPossibleException
	 *  else
	 *    return elements.elementsAt(index)</pre>
	 */
  	public Object getElement(int index){
  		if(index < 0 || index >= size()) {
			System.out.println("Index out of range of the Model.MySet!");
		}
  		return elements.elementAt(index);
	}
  
  	/**
     * @effects return the cardinality of <tt>this</tt>
     */
    public int size() {
    	return elements.size();
  	}
  
    /**
     * @effects <pre>
   	 *  if this is empty 
     *    throw an IllegalStateException
     *  else 
     *    return an arbitrary element of this</pre>
     */
  	public Object choose() throws IllegalStateException {
    	if (size() == 0)
      		throw new IllegalStateException("Model.MySet.choose: set is empty");
    	return (Object) elements.lastElement();
  	}

  	/**
   	 * @effects <pre>
     *  if x is in this 
   	 *    return the index where x appears 
     *  else 
     *    return -1</pre>
     */
  	public int getIndex(Object x) {
    	for (int i = 0; i < elements.size(); i++) {
      		if (x == elements.get(i))
        		return i;
    	}

    	return -1;
  	}

	/**
	 * @effects return a generator that iterate through Model.MySet
	 * until there is not any element left
	 */
	public Iterator iterator(){
  		return new MySetGen(this);
	}

	/**
	 * @effects return a string contain elements inside Model.MySet
	 */
  	@Override
  	public String toString() {
    	if (size() == 0)
      		return "Model.MySet:{ }";

    	String s = "Model.MySet:{" + elements.get(0).toString();
    	for (int i = 1; i < size(); i++) {
      		s = s + " , " + elements.elementAt(i).toString();
    	}

    	return s + "}";
  	}
  
  	/**
   	 * @effects <pre>
     *   if this satisfies abstract properties
     *     return true 
     *   else
     *     return false</pre>
     */
  	public boolean repOK() {
		if (elements == null)
			return false;

		for (int i = 0; i < elements.size(); i++) {
			Object x = elements.get(i);

			for (int j = i + 1; j < elements.size(); j++) {
				if (elements.get(j).equals(x))
					return false;
			}
		}

		return true;
	}

	/**
	 * @overview An inner class that implements the Iterator interface
	 * @attribute
	 * currentElements Integer int
	 * elements Model.MySet
	 * @object
	 * A typical MySetGen is MySetGen {currentElements, elements}
	 * where currentElements(currentElements), elements(elements)
	 * @abstract_properties
	 * mutable(currentElements) = false /\ optional(currentElement) = false /\
	 * min(currentElements) = 0 /\
	 * mutable(elements) = false /\ optional(elements) = false
	 */
	private static class MySetGen implements Iterator<java.lang.Object> {
  		private int currentElements;
		private MySet elements;

		/**
		 * @effects initialize this as {elements,0}
		 */
  		public MySetGen(MySet elements){
  			this.elements = elements;
  			this.currentElements = -1;
		}

		/**
		 * @effects if currentElements < elements.size
		 * 				return True
		 * 			else
		 * 				return False
		 */
		@Override
		public boolean hasNext() {
			return (currentElements < elements.size());
		}

		/**
		 * @effects if currentElements >= elements.size
		 * 				throw new NoMoreElementException
		 * 			else
		 * 				return invoke element.getIndex(currentElements)
		 */
		@Override
		public java.lang.Object next() {
			currentElements++;
			if (currentElements >= elements.size()) {
				System.out.println("There is no more Object class in the Model.MySet!");
			}
			return elements.getElement(currentElements);
		}
	}
}