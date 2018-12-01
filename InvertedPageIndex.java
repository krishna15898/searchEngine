import java.util.*;

public class InvertedPageIndex{

	MySet<PageEntry> allPages = new MySet<PageEntry>();
	MyHashTable myHashTable = new MyHashTable();
	
	public MySet<PageEntry> getAllPages(){
		return allPages;
	}

	public void addPage(PageEntry p){
		allPages.addElement(p);

		for(WordEntry word : p.getPageIndex().getWordEntries()){
			myHashTable.addPositionsForWord(word);
		}
	}
/*THESE METHOD IS CHECKING ALL PAGES TO HAVE THE STRING 
	public MySet<PageEntry> getPagesWhichContainWord(String str){
		//System.out.println("enterd 1");
		MySet<PageEntry> pagesWithStr = new MySet<PageEntry>();
		for(PageEntry page : allPages){
			//System.out.println("enter 2");
			//System.out.println(page.getPageName());
			Boolean containsWord = false;

			MyLinkedList<WordEntry> wordsInPage = page.getPageIndex().getWordEntries();
			for(WordEntry wordEntry : wordsInPage){
				//System.out.println("checking " + wordEntry.getString());
				if(wordEntry.getString().equals(str)){
					//System.out.println("found match");
					containsWord = true;
				}
			}
			if(containsWord == true)
				pagesWithStr.addElement(page);
		}

		return pagesWithStr;
	}
*/	
	public MySet<PageEntry> getPagesWhichContainWord(String str){
		//System.out.println("enterd 1");
		MySet<PageEntry> pagesWithStr = new MySet<PageEntry>();
		//finding the linked list (chain) in which it is
		int posn = myHashTable.sameAsGetHashIndex(str);
		try{
			for( WordEntry word : myHashTable.getHashMap()[posn]){
				if(word.getString().equals(str))
				{
					for( Position position : word.getAllPositionsForThisWord())
						pagesWithStr.addElement(position.getPageEntry());
				}
			}
		}
		catch(NullPointerException e){
			return null;
		}

		return pagesWithStr;
	}
/*
	public MySet<PageEntry> getPagesWhichContainPhrase(String str[]){

		
	}
*/
/*
	public static void main(String[] args)
	{
	   	InvertedPageIndex i = new InvertedPageIndex();
	   	i.addPage(new PageEntry("demo"));
	   	i.addPage(new PageEntry("stack_oracle"));
	   	i.addPage(new PageEntry("stacklighting"));
	   	i.addPage(new PageEntry("stackmagazine"));
	   	i.addPage(new PageEntry("stack_datastructure_wiki"));
	   	i.addPage(new PageEntry("stack_cprogramming"));

	   	MySet<PageEntry> result = new MySet<PageEntry>();

	  	result = i.getPagesWhichContainWord("stack");
		
		if(result == null)
			System.out.println("No page contains this");

		for(PageEntry p : result)
		    System.out.println(p.getPageName());

	}
*/
}   	
	