import java.util.*;

public class MyHashTable{

	MyLinkedList<WordEntry>[] hashMap;

	public MyHashTable(){
		hashMap = new MyLinkedList[101];
	}

	private int getHashIndex(String str){
		int hashIndex =  (str.hashCode())%101;
		return (int)Math.sqrt((hashIndex)*(hashIndex));
	}

	public int sameAsGetHashIndex(String str){
		return getHashIndex(str);
	}

	public void addPositionsForWord(WordEntry w){
		
		int hashIndex = this.getHashIndex( w.getString() );
		if( hashMap[hashIndex] == null)
			hashMap[hashIndex] = new MyLinkedList<WordEntry>();
		hashMap[hashIndex].addMember(w);		
	}

	public MyLinkedList<WordEntry>[] getHashMap(){
		return hashMap;
	}
}