public class TreeNode {
	TreeNode left;
	TreeNode right;
	
	String bTitle, aName, aSurname;
	int ISBN;
	
	public TreeNode(String bookTitle, int ISBN, String autherName, String autherSurname){
		this.bTitle = bookTitle;
		this.ISBN=ISBN;
		this.aName=autherName;
		this.aSurname=autherSurname;
	}
}
