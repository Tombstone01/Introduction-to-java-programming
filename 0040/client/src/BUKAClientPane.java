import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class BUKAClientPane extends GridPane {

	PrintWriter pw = null;
	BufferedReader br = null;

	Socket clientSocket = null;
	private boolean isServerRunning = false;

  public BUKAClientPane() {

		Text reportStatus = new Text();

		try {
			
			// create a client socket.
			this.clientSocket = new Socket("localhost", 3000);
			
			isServerRunning = true;

			// For reading and writing to a socket.
			this.pw = new PrintWriter(this.clientSocket.getOutputStream(), true);
			this.br = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
		} catch (Exception e) {

			// server is down
			isServerRunning = false;
		}

		if (isServerRunning) {
			// crete user interface
			createUI(reportStatus);
		} else {
			reportError(reportStatus);
		}
	}

	/** This function displays an error on the UI
	 * 
	 * @param text
	 */
	public void reportError(Text text) {
		
		text.setText("Could not connect to server, make sure server is running.");

		this.add(text, 0, 1);

		text.setFill(Color.RED);
		text.setFont(Font.font("Verdana", 15));
	}
	
	/** This function creates all functionalities
	 *  to enable client to interact with the server
	 * 
	 * @param text
	 */
	private void createUI(Text text) {
		
		Text result = new Text();

		createLogin(text, result);
		createList();
		createLogout(result);
	}

	/** This function create UI that enables a client to
	 *  logout from the serve
	 * 
	 * @param result
	 */
	private void createLogout(Text result) {

		Text logoutResult = new Text();

		Button logout = new Button("Logout");

		logout.setOnAction(event -> {

			result.setText("");

			try {
				pw.println("LOGOUT");	
				pw.flush();
			} catch (Exception e) {
			  System.out.println("Error logging out ... ");
			}

			try { 
				String response = br.readLine();

				System.out.println("Server response: " + response);

				StringTokenizer tokens = new StringTokenizer(response);

				if (tokens.nextToken().equalsIgnoreCase("200")) {
					logoutResult.setText("Logout success");
				} else {
					logoutResult.setText("You must be logged in");
				}

			} catch (Exception e) {
	      System.out.println("Error receiving logging out response.");
			}

		});

		this.add(logout, 0, 8);

		this.add(logoutResult, 0, 9);
	}

	/** This function enables client to view all pdf file
	 *  on the server
	 * 
	 */
	private void createList() {
		
		TextArea list = new TextArea();

		this.add(list, 0, 6, 3, 1);

		Button listButton = new Button("List all");
		Button clearButton = new Button("Clear all");
		
		this.add(clearButton, 1, 7);
		this.add(listButton, 0, 7);

		// if user presses "list" button
		listButton.setOnAction(event -> {
			try {

				// send list command to server.
				pw.println("LIST");
				pw.flush();
			} catch (Exception e) {
				System.out.println("Could not tell server to retrieve files.");
			}

			try {

				// read response from server.
				String line = br.readLine();

				StringTokenizer tokens = new StringTokenizer(line, ":");

				// if previous command success.
				if (tokens.nextToken().startsWith("200")) {

					// get a list of books available
					String files = tokens.nextToken();

					String[] listOfFiles = files.split(",");

					// clear the text area
					list.clear();

					// loop through every file
					for (String file : listOfFiles) {
						list.appendText(file.replace("[", "").replace("]", "") + "\n");
					}
				} else {
					System.out.println("Could not retrieve list from server.");
				}
			} catch (Exception e) {
				System.out.println("Could not read file list from server.");
			}

		});

		clearButton.setOnAction(e -> {
			list.clear();
		});
	}

	/** This function create GUI that enables user to 
	 *  login into the server
	 * 
	 * @param text
	 * @param result
	 */
	private void createLogin(Text text, Text result) {
		Text usernameText = new Text();
		usernameText.setText("Username");

		TextField userNField = new TextField();

		this.add(text, 0, 1);

		this.add(usernameText, 0, 2);
		this.add(userNField, 1, 2);
		
		Text passwordText = new Text();
		passwordText.setText("Password");

		TextField passField = new TextField();

		this.add(passwordText, 0, 3);

		this.add(passField, 1, 3);

		Button login = new Button();
		login.setText("Login");

		// when login button is clicked
		login.setOnAction(event -> {

			result.setText("");

			// if username and password is not empty
      if (!userNField.getText().isEmpty() || !passField.getText().isEmpty() || userNField.getText() != null || passField.getText() != null) {

			  // get username and password
			  String username = userNField.getText();
			  String password = passField.getText();
				
				// clear those text fields.
				userNField.clear();
				passField.clear();
	
				try {
					pw.println("AUTH " + username + " " + password);
					pw.flush();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				result.setText("Please fill username and password correctly");
			}

			String response = null;

			try {
				response = br.readLine();
			} catch (Exception e) {
				System.out.println("Could not read response from server.");
			}

			StringTokenizer tokens = new StringTokenizer(response);

			if (tokens.nextToken().equalsIgnoreCase("200")) {
				result.setText("Login success");
			}
		});

		this.add(login, 0, 5);
		
		this.add(result, 1, 4);
	}
}
