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
	
	public void getAll(TreeNode node){
		if(node != null){
			getAll(node.left);
			data.add(node);
			getAll(node.right);
		}
	}
}
