import java.util.*;

public class Articles{

	MyLinkedList<String> listOfArticles;

	public Articles(){

		listOfArticles = new MyLinkedList<String>();
		listOfArticles.addMember("a");
		listOfArticles.addMember("an");
		listOfArticles.addMember("the");
		listOfArticles.addMember("they");
		listOfArticles.addMember("these");
		listOfArticles.addMember("this");
		listOfArticles.addMember("for");
		listOfArticles.addMember("is");
		listOfArticles.addMember("are");
		listOfArticles.addMember("was");
		listOfArticles.addMember("of");
		listOfArticles.addMember("or");
		listOfArticles.addMember("and");
		listOfArticles.addMember("does");
		listOfArticles.addMember("will");
		listOfArticles.addMember("whose");

	} 

	public MyLinkedList<String> getListOfArticles(){
		return listOfArticles;
	}
}