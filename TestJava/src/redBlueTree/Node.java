package redBlueTree;

public class Node {
	 private Node left;  
	    private Node right;  
	    private Node parent;  
	    private Color color;  
	    private int value;  
	    public Node(Node left, Node right, Node parent, Color color, int value) {  
	        super();  
	        this.left = left;  
	        this.right = right;  
	        this.parent = parent;  
	        this.color = color;  
	        this.value = value;  
	    }  
	      
	    public Node() {  
	    }  
	      
	    public Node(int value) {  
	        this(null,null,null,null,value);  
	    }  
	  
	    public Node getLeft() {  
	        return left;  
	    }  
	  
	    public void setLeft(Node left) {  
	        this.left = left;  
	    }  
	  
	    public Node getRight() {  
	        return right;  
	    }  
	  
	    public void setRight(Node right) {  
	        this.right = right;  
	    }  
	  
	    public Node getParent() {  
	        return parent;  
	    }  
	  
	    public void setParent(Node parent) {  
	        this.parent = parent;  
	    }  
	  
	    public Color getColor() {  
	        return color;  
	    }  
	  
	    public void setColor(Color color) {  
	        this.color = color;  
	    }  
	  
	    public int getValue() {  
	        return value;  
	    }  
	  
	    public void setValue(int value) {  
	        this.value = value;  
	    }  
	      
	}  
	  
	enum Color {  
	    RED,BLACK  
	}  

