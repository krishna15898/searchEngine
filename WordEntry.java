import java.util.*;

public class WordEntry{

	MyLinkedList<Position> list = new MyLinkedList<Position>();
	String str;
	public WordEntry(String word){
		str = word;
	}

	public void addPosition(Position position){
		list.addMember(position);
	}

	public void addPositions(MyLinkedList<Position> positions){
		list.Union(positions);
	}

	public MyLinkedList<Position> getAllPositionsForThisWord(){
		return list;
	}

	public String getString(){
		return str;
	}
/*
	public float getTermFrequency(String word){
		return ;
	}
*/
}