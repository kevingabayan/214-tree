/**
 * A FullDirectoryException will be used when all child references of this directory are occupied. Most likely not used in the program.
 * e-mail: kevin.gabayan@stonybrook.edu
 * Stony Brook ID: 111504873
 *
 */

public class FullDirectoryException extends Exception {
	public FullDirectoryException(String message) {
		super(message);
	}

}