/**
 * The <code>DirectoryNode<code> class represents a node in the file tree.
 *    e-mail: kevin.gabayan@stonybrook.edu
 *    Stony Brook ID: 111504873
 */
public class DirectoryNode {
	private String name;
	private DirectoryNode left;
	private DirectoryNode middle;
	private DirectoryNode right;
	private boolean isFile;
	private DirectoryNode parent;
	/**
	 * DirectoryNode variables
	 * @param name
	 * The name of the string. NOTE: This should be a full string with no spaces, tabs, or any other whitespace.
	 * @param left
	 * A DirectoryNode reference to the left node.
	 * @param middle
	 * A DirectoryNode reference to the middle node.
	 * @param right
	 * A DirectoryNode reference to the right node.
	 * @param isFile
	 * Differentiates between a file and a folder.
	 * @param parent
	 * The parent of the Directory Node you are referencing.
	 */
	
	/**
	 * This method retrieves the name of the DirectoryNode.
	 * @return
	 * The name of the DirectoryNode.
	 */
	public String getName() {
		return name;
	}
	/**
	 * This method sets the name of the DirectoryNode.
	 * @param name
	 * The new name of the DirectoryNode.
	 */
	public void setName(String name) {
		if(name.contains(" ") || name.contains("/")) {
			System.out.println("No whitespace or forward slashes allowed!");
			return;
		}
		else {
			this.name = name;
		}
	}
	/**
	 * This method retrieves the DirectoryNode reference to the left node.
	 * @return
	 * The reference.
	 */
	public DirectoryNode getLeft() {
		return left;
	}
	/**
	 * This method retrieves the DirectoryNode reference to the middle node.
	 * @return
	 * The reference.
	 */
	public DirectoryNode getMiddle() {
		return middle;
	}
	/**
	 * This method retrieves the DirectoryNode reference to the right node.
	 * @return
	 * The reference.
	 */
	public DirectoryNode getRight() {
		return right;
	}
	/**
	 * This method retrieves the DirectoryNode reference to its parent.
	 * @return
	 * The reference.
	 */
	public DirectoryNode getParent() {
		return parent;
	}
	
	/**
	 * This method adds a new child to any of the open child positions of this node.
	 * @param newChild
	 * The new node.
	 * <dt><b>Preconditions:</b><dd>
	 * This node is not a file and there is at least one empty position in the children of the node.
	 * <dt><b>Postconditions:</b><dd>
	 * newChild has been added as a child of this node. If there is no room for new node, throws an exception.
	 * @throws NotADirectoryException
	 * Thrown if the current node is a file.
	 * @throws FullDirectoryException
	 * Thrown if all child references of this directory are occupied.
	 */
	public void addChild(DirectoryNode newChild) throws FullDirectoryException, NotADirectoryException {
		if(newChild.isFile) {
			// NotADirectoryException
			System.out.println("This is a file!");
			return;
		}
		if(this.getLeft() == null) {
			this.left = newChild;
			newChild.parent = this;
		}
		else if(this.getMiddle() == null) {
			this.middle = newChild;
			newChild.parent = this;
		}
		else if(this.getRight() == null) {
			this.right = newChild;
			newChild.parent = this;
		}
		else {
			// FullDirectoryException
			System.out.println("All child references are occupied!");
			return;
		}
	}
	
	/**
	 * This method sets the DirectoryNode reference to the left node.
	 * @param left
	 * The left node reference to be set.
	 */
	public void setLeft(DirectoryNode left) {
		this.left = left;
	}
	/**
	 * This method sets the DirectoryNode reference to the middle node.
	 * @param middle
	 * The middle node reference to be set.
	 */
	public void setMiddle(DirectoryNode middle) {
		this.middle = middle;
	}
	/**
	 * This method sets the DirectoryNode reference to the right node.
	 * @param right
	 * The right node reference to be set.
	 */
	public void setRight(DirectoryNode right) {
		this.right = right;
	}
	/**
	 * This method sets the DirectoryNode reference to the parent.
	 * @param left
	 * The parent node reference to be set.
	 */
	public void setParent(DirectoryNode parent) {
		this.parent = parent;
	}
	/**
	 * This method tells you if the object is a file or not.
	 * @return
	 * The reference.
	 */
	public boolean isFile() {
		return isFile;
	}
	/**
	 * This method sets whether or not the object is a file or not.
	 * @param isFile
	 * boolean parameter.
	 */
	public void setFile(boolean isFile) {
		this.isFile = isFile;
	}
	
	
}
