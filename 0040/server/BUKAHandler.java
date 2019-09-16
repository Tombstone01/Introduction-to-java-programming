import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BUKAHandler implements Runnable {

	private Socket clientSocket = null;

	private BufferedReader br = null;
	private BufferedWriter bw = null;

	private String usersFile = "data/users.txt";
	private String pdfFile = "data/PdfList.txt";

	public BUKAHandler(Socket newConnectionToClient) {

		this.clientSocket = newConnectionToClient;

		// set up stream of client connection.
		this.br = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
		this.bw = new BufferedWriter(this.clientSocket.getOutputStream(), true);
	}

	public void run() {
		// Process commands from client
		String req = br.readLine();

		StringTokenizer tokens = new StringTokenizer(req);

		String command = tokens.nextToken();

		switch (command) {
		case "AUTH":

			// get username and password
			String username = tokens.nextToken();
			String password = tokens.nextToken();

			// check if user exists.
			bool isFound = this.matchUser(username, password);

			// if the user is found.
			if (isFound) {

				// formulate response message and send message
				String message = "Login sucess";
				this.sendResponse(message);
			}

			break;
		case "LIST":

			ArrayList<String> users = this.getFileList();

			String message = "";

			for (int x = 0; x < users.size(); x++) {
				message += users.get(x);
			}

			sendResponse(message);

			break;
		case "PDFRT":

			String pdf_id = tokens.nextToken();
			String file = this.idToFile(pdf_id);

			sendResponse(file);

			break;
		case "LOGOUT":
			break;
		default:
			break;
		}
	}

	private boolean matchUser(String username, String password) {

		boolean found = false;

		File userFile = new File(new File(this.usersFile));

		try {
			Scanner scan = new Scanner(userFile);
			while (scan.hasNextLine() && !found) {
				String line = scan.nextLine();
				String lineSec[] = line.split("\\s");

				// Compare user

			}
			scan.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return found;
	}

	private ArrayList<String> getFileList() {

		ArrayList<String> result = new ArrayList<String>();
		File lstFile = new File(pdfFile);

		try {
			Scanner scan = new Scanner(lstFile);

			while (scan.hasNext()) {
				result.add(scan.nextLine());
			}

			scan.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return result;
	}

	private String idToFile(String ID) {
		String result = "";
		File lstFile = new File(/* File location */);
		try {
			Scanner scan = new Scanner(lstFile);

			while (scan.hasNextLine()) {

				String file = scan.nextLine();

				if (file.equalsIgnoreCase(ID)) {

					result = ID;

					// break out of the while loop??
					break;
				}
			}

			// Read filename from file

			scan.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return result;
	}

	private void sendResponse(String message) {
		String response = "200 " + message;

		bw.write(response);
	}
}
