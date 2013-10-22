package Java;

import java.util.LinkedList;
import java.util.Queue;

import CareerCupLibrary.LinkedListNode;
import CareerCupLibrary.TreeNode;
import CareerCupLibrary.AssortedMethods;

public class LinkedListToBT {

	public static void main(String[] args) {
		LinkedList<Integer> l = new LinkedList<Integer>();
		for (int i = 1; i < 11; i++) {
			l.add(i);
		}
		
		TreeNode root = convertLinkListToBT(l);
		inOrderTraverse(root);
		System.out.println("");
		preOrderTraverse(root);
		System.out.println("");
	}

	public static TreeNode convertLinkListToBT (LinkedList<Integer> n) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode root = null;
		if (!n.isEmpty()) {
			root = new TreeNode(n.removeFirst());
			queue.add(root);
		}
		while (!queue.isEmpty()) {
			TreeNode newRoot = queue.remove();
			TreeNode lChild = null;
			TreeNode rChild = null;
			int d;
			if (!n.isEmpty()) {
				d = n.removeFirst();
				lChild = new TreeNode(d);
				queue.add(lChild);
			}
			if (!n.isEmpty()) {
				d = n.removeFirst();
				rChild = new TreeNode(d);
				queue.add(rChild);
			}
			newRoot.left = lChild;
			newRoot.right = rChild;
		}
		return root;
	}
	
	public static void preOrderTraverse(TreeNode root) {
		if (root == null) return;
		System.out.print(root.data + " ");
		preOrderTraverse(root.left);
		preOrderTraverse(root.right);
	}
	
	public static void inOrderTraverse(TreeNode root) {
		if (root == null) return;
		inOrderTraverse(root.left);
		System.out.print(root.data + " ");
		inOrderTraverse(root.right);
	}
}
