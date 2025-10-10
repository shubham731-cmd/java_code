//Library Book Management
class Book {
	boolean isIssueBook;
	String name;
	boolean isReturn;
	Book(String name) {
		this.name=name;
	}
}
class Fiction extends Book {
	Fiction(String name) {
		super(name);
		isIssueBook=false;
		isReturn=false;
	}
}
class NonFiction extends Book{
    NonFiction(String name){
        super(name);
        isIssueBook=true;
        isReturn=false;
    }
}
class Magazine extends Book{
    Magazine(String name){
        super(name);
        isIssueBook=true;
        isReturn=true;
    }
}

class Out{
    void print(Book b){
        System.out.println("Name of the book: "+b.name+" Book Issued :"+(b.isIssueBook?"yes":"no")+" Book Returned :"+(b.isReturn?"yes":"no"));
    }
}

public class LibraryBookManagement
{
	public static void main(String[] args) {
	    Book b1=new Fiction("Harry");
	    Book b2=new NonFiction("Mind");
	    Book b3 =new Magazine("Ghost");
	    
	    Out o=new Out();
	    o.print(b1);
	    o.print(b2);
	    o.print(b3);
	}
}
