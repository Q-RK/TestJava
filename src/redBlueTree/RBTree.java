package redBlueTree;

public class RBTree {
	 private final Node NIL = new Node(null,null,null,Color.BLACK,-1);  
	    private Node root;  
	      
	    public RBTree() {  
	        root = NIL;  
	    }  
	      
	    public RBTree(Node  root) {  
	        this.root = root;  
	    }  
	      
	    //插入节点  
	    public void rbInsert(Node node) {  
	          
	        Node previous = NIL;  
	        Node temp = root;  
	          
	        while (temp != NIL) {  
	            previous = temp;  
	            if (temp.getValue() < node.getValue()) {  
	                temp = temp.getRight();  
	            } else {  
	                temp = temp.getLeft();  
	            }  
	        }  
	        node.setParent(previous);  
	          
	        if (previous == NIL) {  
	            root = node;  
	            root.setParent(NIL);  
	        } else  if (previous.getValue() > node.getValue()) {  
	            previous.setLeft(node);  
	        } else {  
	            previous.setRight(node);  
	        }  
	          
	        node.setLeft(NIL);  
	        node.setRight(NIL);  
	        node.setColor(Color.RED);  
	        rb_Insert_Fixup(node);  
	          
	    }  
	      
	    //插入节点后的调整  
	    private void rb_Insert_Fixup(Node node) {  
	      
	        while (node.getParent().getColor() == Color.RED) {  
	              
	            if (node.getParent() == node.getParent().getParent().getLeft()) {  
	                  
	                Node rightNuncle = node.getParent().getParent().getRight();  
	                  
	                if (rightNuncle.getColor() == Color.RED) {         //Case 1  
	                      
	                    rightNuncle.setColor(Color.BLACK);  
	                    node.getParent().setColor(Color.BLACK);  
	                    node.getParent().getParent().setColor(Color.RED);  
	                    node = node.getParent().getParent();  
	                                          
	                } else if (node == node.getParent().getRight()) {  //case 2  
	                      
	                    node = node.getParent();  
	                    leftRotate(node);  
	                      
	                } else {                                          //case 3  
	                      
	                    node.getParent().setColor(Color.BLACK);  
	                    node.getParent().getParent().setColor(Color.RED);  
	                      
	                    rightRotate(node.getParent().getParent());  
	                      
	                }  
	                                  
	            } else {  
	                  
	                Node leftNuncle = node.getParent().getParent().getLeft();  
	                  
	                if (leftNuncle.getColor() == Color.RED) {     //case 4  
	                      
	                    leftNuncle.setColor(Color.BLACK);  
	                    node.getParent().setColor(Color.BLACK);  
	                    node.getParent().getParent().setColor(Color.RED);  
	                    node = node.getParent().getParent();  
	                  
	                } else if (node == node.getParent().getLeft()) { //case 5  
	                  
	                    node = node.getParent();  
	                    rightRotate(node);  
	                                          
	                } else {                                          // case 6  
	                      
	                    node.getParent().setColor(Color.BLACK);  
	                    node.getParent().getParent().setColor(Color.RED);  
	                    leftRotate(node.getParent().getParent());  
	                              
	                }  
	                                  
	            }  
	              
	              
	        }  
	          
	        root.setColor(Color.BLACK);  
	          
	    }  
	      
	      
	    //删除节点  
	    public Node rbDelete(int data) {  
	          
	        Node node = search(data);  
	        Node temp = NIL;  
	        Node child = NIL;  
	        if (node == null) {  
	            return null;  
	        } else {  
	            if (node.getLeft() == NIL || node.getRight() == NIL) {  
	                temp = node;              
	            } else {  
	                temp = successor(node);  
	            }  
	              
	            if (temp.getLeft() != NIL) {  
	                child = temp.getLeft();  
	            } else {  
	                child = temp.getRight();  
	            }  
	              
	            child.setParent(temp.getParent());  
	              
	            if (temp.getParent() == NIL) {  
	                root = child;  
	            } else if (temp == temp.getParent().getLeft()) {  
	                temp.getParent().setLeft(child);  
	            } else {  
	                temp.getParent().setRight(child);  
	            }  
	              
	            if (temp != node) {  
	                node.setValue(temp.getValue());  
	            }  
	              
	            if (temp.getColor() == Color.BLACK) {  
	                rb_Delete_Fixup(child);  
	            }  
	            return temp;  
	        }  
	          
	          
	          
	          
	    }  
	      
	    //删除节点后的调整  
	    private void rb_Delete_Fixup(Node node) {  
	          
	        while (node != root && node.getColor() == Color.BLACK) {  
	              
	            if (node == node.getParent().getLeft()) {  
	                  
	                Node rightBrother = node.getParent().getRight();  
	                if (rightBrother.getColor() == Color.RED) {          //case 1 node节点为左孩子，node节点的兄弟为RED  
	                    rightBrother.setColor(Color.BLACK);  
	                    node.getParent().setColor(Color.RED);  
	                    leftRotate(node.getParent());  
	                    rightBrother = node.getParent().getRight();  
	                }  
	                  
	                if (rightBrother.getLeft().getColor() == Color.BLACK && rightBrother.getRight().getColor() == Color.BLACK) {  
	                    rightBrother.setColor(Color.RED);  
	                    node = node.getParent();  
	                } else if (rightBrother.getRight().getColor() == Color.BLACK) {  
	                    rightBrother.getLeft().setColor(Color.BLACK);  
	                    rightBrother.setColor(Color.RED);  
	                    rightRotate(rightBrother);  
	                    rightBrother = node.getParent().getRight();  
	                } else {  
	                    rightBrother.setColor(node.getParent().getColor());  
	                    node.getParent().setColor(Color.BLACK);  
	                    rightBrother.getRight().setColor(Color.BLACK);  
	                    leftRotate(node.getParent());  
	                    node = root;  
	                }  
	                  
	                  
	            } else {  
	                  
	                Node leftBrother = node.getParent().getLeft();  
	                if (leftBrother.getColor() == Color.RED) {  
	                    leftBrother.setColor(Color.BLACK);  
	                    node.getParent().setColor(Color.RED);  
	                    rightRotate(node.getParent());  
	                    leftBrother = node.getParent().getLeft();  
	                }   
	                  
	                if (leftBrother.getLeft().getColor() == Color.BLACK && leftBrother.getRight().getColor() == Color.BLACK) {  
	                    leftBrother.setColor(Color.RED);  
	                    node = node.getParent();  
	                                                      
	                } else if (leftBrother.getLeft().getColor() == Color.BLACK) {  
	                      
	                    leftBrother.setColor(Color.RED);  
	                    leftBrother.getRight().setColor(Color.BLACK);  
	                    leftRotate(leftBrother);  
	                    leftBrother = node.getParent().getLeft();  
	                      
	                } else {  
	                      
	                    leftBrother.setColor(node.getParent().getColor());  
	                    node.getParent().setColor(Color.BLACK);  
	                    leftBrother.getLeft().setColor(Color.BLACK);  
	                    rightRotate(node.getParent());  
	                    node = root;  
	                                                              
	                }  
	                                  
	            }  
	                      
	        }  
	              
	        node.setColor(Color.BLACK);  
	    }  
	      
	      
	    //查找节点node的后继节点  
	  
	    public Node successor(Node node) {  
	          
	        Node rightChild = node.getRight();  
	        if  (rightChild != NIL) {  
	            Node previous = null;  
	            while (rightChild != NIL) {  
	                previous = rightChild;  
	                rightChild = rightChild.getLeft();  
	            }  
	            return previous;  
	        } else {  
	              
	            Node parent = node.getParent();  
	            while (parent != NIL && node != parent.getLeft()) {  
	                node = parent;  
	                parent = parent.getParent();  
	            }  
	              
	            return parent;  
	                          
	        }  
	  
	    }  
	      
	      
	    //查找节点  
	    public Node search(int data) {  
	        Node temp = root;  
	          
	        while (temp != NIL) {  
	            if (temp.getValue() == data) {  
	                return temp;  
	            } else  if (data < temp.getValue()) {  
	                temp = temp.getLeft();  
	            } else {  
	                temp = temp.getRight();  
	            }  
	        }  
	        return null;  
	    }  
	      
	      
	      
	      
	    //左转函数  
	    private void leftRotate(Node node) {  
	          
	        Node rightNode = node.getRight();  
	          
	        node.setRight(rightNode.getLeft());  
	        if (rightNode.getLeft() != NIL) {  
	            rightNode.getLeft().setParent(node);  
	        }  
	        rightNode.setParent(node.getParent());  
	          
	        if (node.getParent() == NIL) {  
	            rightNode = root;  
	        } else if (node == node.getParent().getLeft()) {  
	            node.getParent().setLeft(rightNode);  
	        } else {  
	            node.getParent().setRight(rightNode);  
	        }  
	          
	        rightNode.setLeft(node);  
	        node.setParent(rightNode);  
	          
	          
	    }  
	      
	    //右转函数  
	    private void rightRotate(Node node) {  
	          
	        Node leftNode = node.getLeft();  
	        node.setLeft(leftNode.getRight());  
	          
	        if (leftNode.getRight() != null) {  
	            leftNode.getRight().setParent(node);  
	        }  
	          
	        leftNode.setParent(node.getParent());  
	          
	        if (node.getParent() == NIL) {  
	            root = leftNode;  
	        } else if (node == node.getParent().getLeft()) {  
	            node.getParent().setLeft(leftNode);  
	        } else {  
	            node.getParent().setRight(leftNode);  
	        }  
	          
	        leftNode.setRight(node);  
	        node.setParent(leftNode);  
	                      
	    }  
	      
	    //中序遍历红黑树  
	    public void printTree() {  
	        inOrderTraverse(root);  
	    }  
	      
	    private void inOrderTraverse(Node node) {  
	          
	        if (node != NIL) {  
	            inOrderTraverse(node.getLeft());  
	            System.out.println(" 节点："+node.getValue() + "的颜色为：" + node.getColor());  
	            inOrderTraverse(node.getRight());  
	        }  
	          
	    }  
	      
	      
	    public Node getNIL() {  
	        return NIL;  
	    }  
}
