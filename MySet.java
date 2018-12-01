import java.util.*;

public class MySet<X> implements Iterable<X>{

	node head;
		
	class node{
		X data;
		node next;
	}
	
	public Boolean IsEmpty() {
		if(head == null) return true;
		return false;
	}
	
	public int numberOfXs(){
		node temp = new node();
		temp = head;
		int count = 0;
		while(temp != null){
			count++;
			temp = temp.next;
		}
		return count;
	}
	//REQD TO RETURN ALL XS (IN ANY ORDER)
	public X nthX(int n){
		if(n >= numberOfXs())
			return null;
		node temp = head;
		for (int i = 0; i < n; i++) {
			temp = temp.next;
		}
		return temp.data;
	}

	public Boolean IsMember(X o) {
		
		node temp = head;
		while( temp != null ) {
			if(temp.data.equals(o)) return true;
			temp = temp.next;
		}
		return false;
	}
	
	public void addElement(X o) {
		if(IsMember(o)) return;

		node newnode = new node();
		newnode.data = o;
		newnode.next = null;

		if(head == null){
			head = newnode;
			return;
		}


		node temp = head;
		while(temp.next != null)
			temp = temp.next;

		temp.next = newnode;
		return;
	}
	
	public void Delete(X o) {
		
		if( IsEmpty() == true)
			throw new NoSuchElementException();
			
		node temp = head;
		if(head.data.equals(o))
			head = head.next;

		while( temp != null ) {
			
			if(temp.data.equals(o)) return;
			
			if(temp.next.data.equals(o)) {
				temp.next = temp.next.next;
				return;
			}
			temp = temp.next;
		}
		
		throw new NoSuchElementException();
	}
	
	public MySet<X> Union(MySet<X> a) {
		
		//if( IsEmpty() && a.IsEmpty() ) return null;//both empty
		
		if ( a.IsEmpty() ) return this;//a empty
		if ( this.IsEmpty() ) return a;//our set empty
		
		MySet<X> res = this;
		
		node temp2 = new node();
		temp2 = a.head;
		
		node temp = new node();
		temp = res.head;
		
		while (temp.next != null) {
			temp = temp.next;
		}
		
		while (temp2 != null) {
			if(!(res.IsMember(temp2.data))) {
				temp.next = temp2;
				temp = temp.next;
				
			}
			temp2 = temp2.next;
		}
		node p = new node();
		p = res.head;
		while (p != null) {
			//System.out.println(p.data);
			p = p.next;
		}
		
		return res;
	}
	
	public MySet<X> Intersection(MySet<X> a) {
		
		MySet<X> res = new MySet<X>();
		node temp1 = new node();
		
		temp1 = head;
		
		while(temp1 != null) {			
			if (a.IsMember(temp1.data)) {
				res.addElement(temp1.data);
			}
			temp1 = temp1.next;
		}
		
		return res;
	}

	public Iterator<X> iterator() { return new ListIterator(); }

    private class ListIterator implements Iterator<X>
    {
        private node current = head;

        public boolean hasNext() { return current != null; }
        
        public void remove() { throw new UnsupportedOperationException(); } 
        
        public X next()
        {
            if(hasNext()==false)
                throw new NoSuchElementException();
            else
            {
                X o = current.data;
                current = current.next;
                return o;
            }
        }
    }
}