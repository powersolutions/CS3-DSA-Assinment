import java.util.LinkedList;
import java.util.Queue;

public class Operations {
	public static Queue<TreeNode> data = new LinkedList<TreeNode>();
	
	public void insert(TreeNode node, String bookTitle, int ISBN,
			String autherName, String autherSurname) {
		if (bookTitle.length() < node.bTitle.length()) {
			if (node.left != null) {
				insert(node.left, bookTitle, ISBN, autherName, autherSurname);

			} else
				node.left = new TreeNode(bookTitle, ISBN, autherName,
						autherSurname);

		}else if(bookTitle.length()>node.bTitle.length()){
			if(node.right != null)
				insert(node.right, bookTitle, ISBN, autherName, autherSurname);
			else
				node.right = new TreeNode(bookTitle, ISBN, autherName, autherSurname);
		}
	}
<<<<<<< HEAD

	/*
	 * inorder to get all data from the database
	 * frist you need to call the getAll method in the operations class through a object 
	 * then you can access the data through the queue "data" in the operations class;
	 * 
	 * the queue "data" will hold the information about the data it's holding. 
	 * so to access the data in the node, 
	 * within your local method, create a variable with the TreeNode calss to hold the node infromation 
	 * taken from the queue"data"
	 * then through that TreeNode variable you'll be able to access the data like,
	 * 
	 * to get bookname, you can use TreeNodeObject.bName
	 */
	public void getAll(TreeNode node) {
		if (node != null) {
=======
	
	public void getAll(TreeNode node){
		if(node != null){
>>>>>>> parent of c718298... added sample application
			getAll(node.left);
			data.add(node);
			getAll(node.right);
		}
	}
}
