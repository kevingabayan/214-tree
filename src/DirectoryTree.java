/**
 * The <code>DirectoryTree<code> class implements a ternary tree of DirectoryNodes.
 *    e-mail: kevin.gabayan@stonybrook.edu
 *    Stony Brook ID: 111504873
 */
import java.util.Scanner;
public class DirectoryTree {
	private DirectoryNode root;
	private DirectoryNode cursor;
	/**
	 * DirectoryTree variables
	 * @param root
	 * A reference to the root of the tree.
	 * @param cursor
	 */
	
	/**
	 * This method initializes a DirectoryTree object with a single DirectoryNode named "root".
	 * <dt><b>Postconditions:</b><dd>
	 * The tree contains a single DirectoryNode named "root", and cursor and root reference this node.
	 */
	public DirectoryTree() {
		DirectoryNode node = new DirectoryNode();
		node.setName("root");
		this.root = node;
		this.cursor = node;
	}
	
	/**
	 * This method moves the cursor to the root node of the tree.
	 * <dt><b>Postconditions:</b><dd>
	 * The cursor now references the root node of the tree.
	 */
	public void resetCursor() {
		this.cursor = root;
	}
	
	/**
	 * Moves the cursor to the directory with the name indicated by name.
	 * <dt><b>Preconditions:</b><dd>
	 * 'Name' references a valid directory ('name' cannot reference a file).
	 * <dt><b>Postconditions:</b><dd>
	 * The cursor now references the directory with the name indicated by name.
	 * If a child cannot be found with that name, then the user is prompted to enter
	 * a different directory name. If the name was not a directory, a NotADirectoryException
	 * has been thrown.
	 * @param name
	 * The name to be searched for in the directory.
	 * @throws NotADirectoryException
	 * Thrown if the node with the indicated name is a file, as files cannot be selected by the cursor, 
	 * or cannot be found.
	 */
	public void changeDirectory(String name) throws NotADirectoryException {
		if(cursor.getRight() == null && cursor.getMiddle() == null && cursor.getLeft() == null) {
			System.out.println("There are no children... XD");
			return;
		}
		if(cursor.getLeft() != null) {
			if(cursor.getLeft().getName().equals(name)) {
				DirectoryNode addcheck = cursor.getLeft();
				if(!addcheck.isFile()) {
					cursor = addcheck;
					return;
				}
				else {
					// NotADirectoryException
					System.out.println("This is a file!");
					return;
			}
			}
		}
		if(cursor.getMiddle() != null) {
			if(cursor.getMiddle().getName().equals(name)) {
				DirectoryNode addcheck = cursor.getMiddle();
				if(!addcheck.isFile()) {
					cursor = addcheck;
					return;
				}
				else {
					// NotADirectoryException
					System.out.println("This is a file!");
					return;
				}
			}
		}
		if(cursor.getRight() != null) {
			if(cursor.getRight().getName().equals(name)) {
				DirectoryNode addcheck = cursor.getRight();
				if(!addcheck.isFile()) {
					cursor = addcheck;
					return;
				}
				else {
					// NotADirectoryException
					System.out.println("This is a file!");
					return;
				}
			}
		}
		Scanner input = new Scanner(System.in);
		System.out.println("A child cannot be found with that name. Enter a new one or type 'q' to quit: ");
		String newOne = input.nextLine();
		if(newOne.equals("q")) {
			return;
		}
		changeDirectory(newOne);
	}
	
	/**
	 * This method returns a String containing the path of directory names from the root node of the tree to the cursor,
	 * with each name separated by a forward slash "/".
	 * <dt><b>Postconditions:</b><dd>
	 * The cursor remains at the same DirectoryNode.
	 * @return
	 * The concatenated string.
	 */
	public String presentWorkingDirectory() {
		DirectoryNode ghost = cursor;
		String anime = "";
		if(ghost == root) {
			return anime = ghost.getName();
		}
		while(ghost != null) {
			String reverse = ghost.getName();
			if(anime.equals("")) {
				anime = reverse;
			}
			else {
				anime = reverse + "/" + anime;
			}
			ghost = ghost.getParent();
		}
		return anime;
	}
	
	/**
	 * This method returns a String containing a space-separated list of names of all the child directories or files of the cursor.
	 * <dt><b>Postconditions:</b><dd>
	 * The cursor remains at the same DirectoryNode.
	 * @return
	 * A formatted String of DirectoryNode names.
	 */
	public String listDirectory() {
		String anime = "";
		if(cursor.getLeft() != null) {
			anime += cursor.getLeft().getName();
			anime += " ";
		}
		if(cursor.getMiddle() != null) {
			anime += cursor.getMiddle().getName();
			anime += " ";
		}
		if(cursor.getRight() != null) {
			anime += cursor.getRight().getName();
		}
		return anime;
	}
	
	/**
	 * This method prints a formatted nested list of names of all the nodes in the tree, starting from the cursor.
	 * The helper method assists the recursion process.
	 * <dt><b>Postconditions:</b><dd>
	 * The cursor remains at the same DirectoryNode.
	 */
	public void printDirectoryTree() {
		DirectoryNode ghost = cursor;
		int spaceCountGG = 0;
		System.out.println();
		printDirectoryTreeHelper(ghost,spaceCountGG);
	}
	public void printDirectoryTreeHelper(DirectoryNode iLoveRecursion, int spaceCountGG) {
		// Accounts for Spaces in the next root term
		int count = 0;
		// Prints out spaces
		while(spaceCountGG > count++) {
			System.out.print(" ");
		}
		// Prints depending on whether or not it is a file
		if(iLoveRecursion.isFile()) {
			System.out.print("- " + iLoveRecursion.getName() + "\n");
		}
		else {
			System.out.print("|- " + iLoveRecursion.getName() + "\n");
		}
		if(iLoveRecursion.getLeft() != null) {
			printDirectoryTreeHelper(iLoveRecursion.getLeft(), spaceCountGG + 4);
		}
		if(iLoveRecursion.getMiddle() != null) {
			printDirectoryTreeHelper(iLoveRecursion.getMiddle(), spaceCountGG + 4);
		}
		if(iLoveRecursion.getRight() != null) {
			printDirectoryTreeHelper(iLoveRecursion.getRight(), spaceCountGG + 4);
		}
	}
	/**
	 * Creates a directory with the indicated name and adds it to the children of the cursor node.
	 * Children are added in a left to right order.
	 * @param name
	 * The name of the directory to add.
	 * <dt><b>Preconditions:</b><dd>
	 * 'name' is a legal argument(does not contain " " or forward slashes "/")
	 * <dt><b>Postconditions:</b><dd>
	 * A new DirectoryNode has been added to the children of the cursor, or an exception has been thrown.
	 * @throws IllegalArgumentException
	 * Thrown if the 'name' argument is invalid. (CAN'T YOU JUST DO THIS WITHOUT IT?)
	 * @throws FullDirectoryException
	 * Thrown if all child references of this directory are occupied.
	 */
	public void makeDirectory(String name) throws IllegalArgumentException, FullDirectoryException {
		if(name.contains(" ") || name.contains("/")) {
			// IllegalArgumentException
			System.out.println("No whitespace or forward slashes allowed!");
			return;
		}
		else {
			DirectoryNode okay = new DirectoryNode();
			okay.setName(name);
			try {
				// FullDirectoryException already handled in the prior code
				cursor.addChild(okay);
			} catch (NotADirectoryException e) {
				System.out.print("What did the computer science student say to his harrassers? Stop BOOLEAN me!");
			}
		}
	}
	/**
	 * Creates a file with the indicated name and adds it to the children of the cursor node.
	 * @param name
	 * @throws IllegalArgumentException
	 * @throws FullDirectoryException
	 */
	public void makeFile(String name) throws IllegalArgumentException, FullDirectoryException {
		if(name.contains(" ") || name.contains("/")) {
			// IllegalArgumentException
			System.out.println("No whitespace or forward slashes allowed!");
			return;
		}
		else {
			DirectoryNode okay = new DirectoryNode();
			okay.setName(name);
			okay.setFile(true);
			if(cursor.getLeft() == null) {
				cursor.setLeft(okay);
				okay.setParent(cursor);
			}
			else if(cursor.getMiddle() == null) {
				cursor.setMiddle(okay);
				okay.setParent(cursor);
			}
			else if(cursor.getRight() == null) {
				cursor.setRight(okay);
				okay.setParent(cursor);
			}
			else {
				// FullDirectoryException
				System.out.println("All child references are occupied!");
				return;
			}
		}
	}
}
