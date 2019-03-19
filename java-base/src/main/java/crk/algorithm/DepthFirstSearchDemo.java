package crk.algorithm;

/**
 * 深度优先遍历
 * Created by chenrongkun on 2019/3/14.
 */
public class DepthFirstSearchDemo {


	static class TreeNode {

		int value;

		TreeNode left;

		TreeNode right;

		public TreeNode(int value) {
			this.value = value;
		}
	}

	public TreeNode createBinaryTree(int[] array, int index) {
		if (index < array.length) {
			int rootValue = array[index];
			if (rootValue != 0) {
				TreeNode treeNode = new TreeNode(rootValue);
				treeNode.left = createBinaryTree(array, index * 2 + 1);
				treeNode.right = createBinaryTree(array, index * 2 + 2);
				return treeNode;
			}
		}
		return null;
	}

	public void printTreeNode(TreeNode treeNode) {
		if (treeNode != null) {
			System.out.println(treeNode.value);
			if (treeNode.left != null) {
				printTreeNode(treeNode.left);
			}
			if (treeNode.right != null) {
				printTreeNode(treeNode.right);
			}
		}
	}

	public void printTreeNodeBSF(TreeNode treeNode) {
		if (treeNode != null) {
			System.out.println(treeNode.value);
			for (int i=0;i < 4; i ++) {
				if (treeNode.left != null ) {
					System.out.println(treeNode.left.value);
				}
				if (treeNode.right != null) {
					System.out.println(treeNode.right.value);
				}
				treeNode = treeNode.left;
			}
		}
	}

	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
		DepthFirstSearchDemo depthFirstSearchDemo = new DepthFirstSearchDemo();
		TreeNode tree = depthFirstSearchDemo.createBinaryTree(array, 0);
		depthFirstSearchDemo.printTreeNode(tree);
		System.out.println("----------------------------------");
		depthFirstSearchDemo.printTreeNodeBSF(tree);
	}
}
