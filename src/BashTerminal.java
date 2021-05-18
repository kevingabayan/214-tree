/**
 * The <code>BashTerminal<code> class contains a single main method which allows a user
 * to interact with a file system implemented by an instance of DirectoryTree using various commands.
 *	  @author Kevin Gabayan
 *    e-mail: kevin.gabayan@stonybrook.edu
 *    Stony Brook ID: 111504873
 */
import java.util.Scanner;

public class BashTerminal {
	public static void main(String[] args) throws NotADirectoryException, IllegalArgumentException, FullDirectoryException {
		System.out.println("Starting bash terminal.");
		Scanner input = new Scanner(System.in);
		DirectoryTree jhin = new DirectoryTree();
		String format = "[111504873@AutumnLeaf]: $ ";
		boolean end = false;
		
		while(end != true) {
			System.out.print(format);
			String command = input.nextLine();
			
			if(command.equals("pwd")) {
				System.out.println(jhin.presentWorkingDirectory());
			}
			if(command.equals("ls")) {
				 System.out.println(jhin.listDirectory());
			}
			if(command.equals("ls -R")) {
				jhin.printDirectoryTree();
				System.out.println();
			}
			String movecursor = "cd ";
			if(command.indexOf(movecursor) == 0 && !command.equals("cd /")) {
				String searchname = command.substring(3);
				jhin.changeDirectory(searchname);
			}
			if(command.equals("cd /")) {
				jhin.resetCursor();
			}
			String checkdirectory = "mkdir ";
			if(command.indexOf(checkdirectory) == 0) {
				String nameofchild = command.substring(6);
				jhin.makeDirectory(nameofchild);
			}
			String checkfile = "touch ";
			if(command.indexOf(checkfile) == 0) {
				String nameoffile = command.substring(6);
				jhin.makeFile(nameoffile);
			}
			if(command.equals("exit")) {
				end = true;
				System.out.println("Program terminating normally.");
			}
			
		}
		
	}
}
