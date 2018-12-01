import java.util.*;
import java.io.*;

public class PageEntry{

	String name;
	PageIndex pageIndex = new PageIndex();
	Articles a = new Articles();
	public PageEntry(String pageName){
		name = pageName;

		try{
			FileInputStream fstr = new FileInputStream(pageName);
			Scanner scan = new Scanner(fstr);
			int wordIndex = 0;
			while (scan.hasNextLine()){

				String str = scan.nextLine();
				str = str.toLowerCase();
				/*
				for(int i = 0; i < str.length() ; i++){
					if(str.charAt(i) == '\"' || str.charAt(i) == '\'') 
						str.charAt(i) = ' ' ;
				}
				*/
				String[] wordsWOSpaces = str.split(" ");

				for(String wordWOSpaces : wordsWOSpaces){

					String[] wordsWOPuncs = wordWOSpaces.split("[\\-<\\[/\\];:.,\\()?{}]");
					for(String word : wordsWOPuncs){
						if(word.length() != 0){	
							while( ( word.substring(word.length()-1,word.length()) == "'" ) || ( word.charAt(word.length() - 1 ) == '"' ) )
					        	word=word.substring(0,word.length()-1);
					      	while( ( word.charAt(0) == '"' ) || ( word.substring(0,1) == "'" ) )
					        	word=word.substring(1,word.length());
				    	}	
						if( !(word.equals("")) && !(a.getListOfArticles().IsMember(word)) ){

							wordIndex++;
							if(word.equals("stacks"))
								word = "stack";
							if(word.equals("structures"))
								word = "structure";
							if(word.equals("applications"))
								word = "application";
							Position p = new Position(this, wordIndex);
							pageIndex.addPositionForWord( word, p);
						}
					}
					
				}  
				
			}
		}
		catch(FileNotFoundException e){
			System.out.println("No webpage "+pageName+" found");
		}
	}
	

	public String getPageName(){
		return name;
	}

	public PageIndex getPageIndex(){
		return pageIndex;
	}
  
	public static void main(String[] args)
	{
		PageEntry p = new PageEntry("stackmagazine");
	}

}
