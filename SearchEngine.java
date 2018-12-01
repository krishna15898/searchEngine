import java.util.*;
import java.io.*;

public class SearchEngine{

	InvertedPageIndex ipi;
	public SearchEngine(){
		ipi = new InvertedPageIndex(); 
	}

	public void performAction(String actionMessage){

		String res = "";
		String[] w = actionMessage.split(" ");

		if(w[0].equals("addPage")){
			PageEntry newPage = new PageEntry(w[1]);
			ipi.addPage(newPage);
		}

		if(w[0].equals("queryFindPagesWhichContainWord")){

			if(w[1].equals("C")) w[1] = w[1].toLowerCase();
			if(w[1].equals("C++")) w[1] = w[1].toLowerCase();

			MySet<PageEntry> pageSet = ipi.getPagesWhichContainWord(w[1]);
			try{
				if(pageSet.IsEmpty())
					System.out.println("No webpage contains word "+w[1]);
				
				else{
					String result = "";
					for(PageEntry page : pageSet)
						result = result + page.getPageName() +", ";
					
					System.out.println(result.substring(0,result.length()-2));
				}
			}
			catch(NullPointerException e){
				System.out.println("No webpage contains word "+w[1]);
			}
		}

		if(w[0].equals("queryFindPositionsOfWordInAPage")){
			
			if(w[1] == "C") w[1] = "c";
			if(w[1] == "C++") w[1] = "c++";

			try{
				FileInputStream fstr = new FileInputStream(w[2]);
				Scanner sc = new Scanner(fstr);
				//fining the page having name y
				PageEntry pageReqd = null;
				for(PageEntry p : ipi.getAllPages()){
					if(p.getPageName().equals(w[2]))
						pageReqd = p;
				}

				//finding wordentry of x in the required page
				WordEntry wordReqd = null;
				Boolean wordFound = false;
				MyLinkedList<WordEntry> wordEntries = pageReqd.getPageIndex().getWordEntries(); 
				for(WordEntry wordEntry : wordEntries)
					if(wordEntry.getString().equals(w[1])){
						wordFound = true;
						wordReqd = wordEntry;
					}

				if( wordFound == false )
					System.out.println("Webpage "+w[2]+" does not contain word "+w[1]);

				else if( wordFound == true ){
					String result = "";
					for(Position p : wordReqd.getAllPositionsForThisWord())
						result = result + p.getWordIndex() + ",";

					System.out.println( result.substring(0,result.length()-1) );
				}
			}
			catch(FileNotFoundException e){
				System . out . println ("No webpage "+w[2]+" found");
			}
		}
	}
}