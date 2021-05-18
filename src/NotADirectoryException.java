/**
 * A NotADirectoryException will be used when the node is a file, as files cannot be selected by the cursor, or cannot be found. Most likely not used in the program at all.
 * e-mail: kevin.gabayan@stonybrook.edu
 * Stony Brook ID: 111504873
 *
 */

public class NotADirectoryException extends Exception {
	public NotADirectoryException(String message) {
		super(message);
	}

}