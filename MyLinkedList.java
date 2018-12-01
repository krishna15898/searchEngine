import java.util.*;

public class MyLinkedList<Object> implements Iterable<Object>{

	node head;
		
	class node{
		Object data;
		node next;
	}

	public Boolean IsEmpty() {
		if(head == null) return true;
		return false;
	}

	public Boolean IsMember(Object o) {
		
		node temp = head;
		while( temp != null ) {
			if(temp.data.equals(o)) return true;
			temp = temp.next;
		}
		
		return false;
	}
	public void addMember(Object o) {
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
	
	public MyLinkedList<Object> Union(MyLinkedList<Object> a) {
		
		MyLinkedList<Object> res = this;
		
		node temp2 = new node();
		temp2 = a.head;
		
		node temp = new node();
		temp = res.head;
		
		while (temp.next != null) {
			temp = temp.next;
		}
		
		while (temp2 != null) {
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
	
	public MyLinkedList<Object> Intersection(MyLinkedList<Object> a) {
		
		MyLinkedList<Object> res = new MyLinkedList<Object>();
		node temp1 = new node();
		
		temp1 = head;
		
		while(temp1 != null) {			
			temp1 = temp1.next;
		}
		
		return res;
	}

	public Iterator<Object> iterator() { return new ListIterator(); }

    private class ListIterator implements Iterator<Object>
    {
        private node current = head;

        public boolean hasNext() { return current != null; }
        
        public void remove() { throw new UnsupportedOperationException(); } 
        
        public Object next()
        {
            if(hasNext()==false)
                throw new NoSuchElementException();
            else
            {
                Object o = current.data;
                current = current.next;
                return o;
            }
        }
    }
}