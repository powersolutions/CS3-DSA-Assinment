package abc;

public class search {
	
	TreeNode nd = new TreeNode();

	public search() {
		// TODO Auto-generated constructor stub
	}
public Boolean search(Node node, int val) {
        
        Boolean res = false;
        while (node != null && res.equals(false)) {
            if (node.value > val) {
                node = node.left;
            } else if (node.value < val) {
                node = node.right;
            } else {
                res = true;
                
                break;
            }
            res = search(node, val);
        }
        return res;
    }

}
