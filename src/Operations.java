import java.util.LinkedList;
import java.util.Queue;

public class Operations {
	public static Queue<TreeNode> data = new LinkedList<TreeNode>();

	/*
	 * insert operation to insert a value to the database. first you have to
	 * create a object with the TreeNode class 
	 * 
	 * lest's assume that the object name is root
	 * 
	 * then create another object with operations class (op)
	 * 
	 * now to insert a value, all you have to do is pass values using the insert
	 * method through operations object(op)
	 * 
	 * give the object name you created with the TreeNode as the first
	 * parameter. (root)
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

	public void insertByIsbn(TreeNode node, String bookTitle, int ISBN,
			String autherName, String autherSurname) {
		if (ISBN < node.ISBN) {
			if (node.left != null) {
				insertByIsbn(node.left, bookTitle, ISBN, autherName, autherSurname);
			}else{
				node.left = new TreeNode(bookTitle, ISBN, autherName, autherSurname);
			}
		}else if(ISBN > node.ISBN){
			if(node.right != null){
				insertByIsbn(node.right, bookTitle, ISBN, autherName, autherSurname);
			}else
				node.right = new TreeNode(bookTitle, ISBN, autherName, autherSurname);
		}
	}

	public void orderByIsbn(TreeNode treenode, TreeNode isbnNode) {
		//data = null;
		
		
		while (!data.isEmpty()) {
			TreeNode node = data.remove();
			String bName = node.bTitle;
			int isbn = node.ISBN;
			String aName = node.aName;
			String aSurname = node.aSurname;
			insertByIsbn(node, bName, isbn, aName, aSurname);
		}
	}

	/*
	 * inorder to get all data from the database frist you need to call the
	 * getAll method in the operations class through a object then you can
	 * access the data through the queue "data" in the operations class;
	 * 
	 * the queue "data" will hold the information about the data it's holding.
	 * so to access the data in the node, within your local method, create a
	 * variable with the TreeNode calss to hold the node infromation taken from
	 * the queue"data" then through that TreeNode variable you'll be able to
	 * access the data like,
	 * 
	 * to get bookname, you can use TreeNodeObject.bName
	 */

	public void getAll(TreeNode node) {
		//data = null;
		if (node != null) {

			getAll(node.left);
			data.add(node);
			getAll(node.right);
		}
	}

	static TreeNode n;

	public TreeNode searchByName(TreeNode node, String bookName) {
		n = null;
		if (node.bTitle.length() == bookName.length()) {
			if (node.bTitle.equals(bookName)) {
				n = node;
			} else
				searchByName(node.right, bookName);
		}
		if (bookName.length() > node.bTitle.length()) {
			searchByName(node.right, bookName);
		}
		if (bookName.length() < node.bTitle.length()) {
			searchByName(node.left, bookName);

		}
		return n;
	}

	public TreeNode searchByIsbn(TreeNode node, int isbn) {
		n = null;
		if(node.ISBN == isbn){
			n=node;
		}
		if(node.ISBN < isbn){
			searchByIsbn(node.right, isbn);
		}
		if(node.ISBN > isbn){
			searchByIsbn(node.left, isbn);
		}

		return n;
	}
	public TreeNode minNode(TreeNode node){
		while(node.left != null){
			node = node.left;
		}
		return node;
	}
	public TreeNode deleteByName(TreeNode node, String bookTitle){
		if(bookTitle.equals(node.bTitle)){
			if(node.left==null && node.right==null){
				return null;
			}
			if(node.left==null){
				return node.right;
			}
			if(node.right==null){
				return node.left;
			}else{
				node= minNode(node);
				node.right = deleteByName(node.right, bookTitle);
				return node;
			}

		}else if(node.bTitle.length() < bookTitle.length()){
			node.left =(deleteByName(node.left, bookTitle));
			return node;
		}
		else{
			node.right = deleteByName(node.right, bookTitle);
			return node;
		}
	}
}
