package day10;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTreeEx {
    TreeNode root;

    public void preorder(TreeNode node) {
        if (node == null) { return; }

        System.out.print(node.value + " "); // 현재 노트 방문(출력)
        preorder(node.left); // 왼쪽 서브트리 순회
        preorder(node.right); // 오른쪽 서브트리 순회
    }

    public void inorder(TreeNode node) {
        if (node == null) { return; }

        preorder(node.left); // 왼쪽 서브트리 순회
        System.out.print(node.value + " "); // 현재 노트 방문(출력)
        preorder(node.right); // 오른쪽 서브트리 순회
    }

    public void postorder(TreeNode node) {
        if (node == null) { return; }

        preorder(node.left); // 왼쪽 서브트리 순회
        preorder(node.right); // 오른쪽 서브트리 순회
        System.out.print(node.value + " "); // 현재 노트 방문(출력)
    }

    public static void main(String[] args) {
        BinaryTreeEx tree = new BinaryTreeEx();
        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(7);
        tree.root.right = new TreeNode(15);
        tree.root.left.left = new TreeNode(5);
        tree.root.left.right = new TreeNode(8);
        tree.root.right.right = new TreeNode(20);

        System.out.println("preorder : ");
        tree.preorder(tree.root);

        System.out.println("\ninorder : ");
        tree.inorder(tree.root);

        System.out.println("\npostorder :");
        tree.postorder(tree.root);
    }
}
