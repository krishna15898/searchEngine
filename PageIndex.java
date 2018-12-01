import java.util.*;

public class PageIndex {

	MyLinkedList<WordEntry> wordList = new MyLinkedList<WordEntry>();

	public void addPositionForWord(String str, Position p){
		WordEntry temp = null;
		for(WordEntry word : wordList){
			if(word.getString().equals(str))
				temp = word;
		}
		if(temp == null){
			WordEntry newWord = new WordEntry(str);
			newWord.addPosition(p);
			wordList.addMember(newWord);
		}
		else temp.addPosition(p);

	}

	public MyLinkedList<WordEntry> getWordEntries(){
		return  wordList;
	}
}