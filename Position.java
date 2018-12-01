import java.util.*;

public class Position{

	int wordPosition;
	PageEntry pageEntry;
	public Position(PageEntry p, int wordIndex){
		this.pageEntry = p;
		this.wordPosition = wordIndex;  
	}

	public PageEntry getPageEntry(){
		return pageEntry;
	}

	public int getWordIndex(){
		return wordPosition;
	}
} 