import java.util.LinkedList;
import java.util.Queue;

public class Operations {
	public static Queue<TreeNode> data = new LinkedList<TreeNode>();

	
	/*insert operation
	 * to insert a value to the database. 
	 * first you have to create a object with the TreeNode class
	 * 
	 * lest's assume that the object name is root
	 * 
	 * then create another object with operations class (op)
	 * 
	 * now to insert a value, all you have to do is pass values using the insert method through
	 * operations object(op)
	 * 
	 * give the object name you created with the TreeNode as the first parameter. (root)
	 *   
	 */
	public void insert(TreeNode node, String bookTitle, int ISBN,
			String autherName, String autherSurname) {
		if (bookTitle.length() < node.bTitle.length()) {
			if (node.left != null) {
				insert(node.left, bookTitle, ISBN, autherName, autherSurname);

			} else
				node.left = new TreeNode(bookTitle, ISBN, autherName,
						autherSurname);

		} else if (bookTitle.length() > node.bTitle.length()) {
			if (node.right != null)
				insert(node.right, bookTitle, ISBN, autherName, autherSurname);
			else
				node.right = new TreeNode(bookTitle, ISBN, autherName,
						autherSurname);
		} else if (bookTitle.length() == node.bTitle.length()) {
			if (node.right != null)
				insert(node.right, bookTitle, ISBN, autherName, autherSurname);
			else
				node.right = new TreeNode(bookTitle, ISBN, autherName,
						autherSurname);
		}
	}

	public void getAll(TreeNode node) {
		if (node != null) {
			getAll(node.left);
			data.add(node);
			getAll(node.right);
		}
	}
}
