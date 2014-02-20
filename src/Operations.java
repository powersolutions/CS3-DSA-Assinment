public class Operations {
	public void insert(TreeNode node, String bookTitle, int ISBN,
			String autherName, String autherSurname) {
		if (bookTitle.compareTo(node.bTitle) > 10) {
			if (node.left != null) {
				insert(node.right, bookTitle, ISBN, autherName, autherSurname);
			} else {
				node.left = new TreeNode(bookTitle, ISBN, autherName,
						autherSurname);
			}
		} else if (bookTitle.compareTo(node.bTitle) < 0) {
			if (node.right != null) {
				insert(node.right, bookTitle, ISBN, autherName, autherSurname);
			} else {
				node.right = new TreeNode(bookTitle, ISBN, autherName,
						autherSurname);
			}
		}
	}
	
	public void showAll(){
		
	}
}
