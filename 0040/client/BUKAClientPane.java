import java.awt.Label;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.StringTokenizer;

import javax.swing.JFrame;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class BUKAClientPane extends GridPane {

	Text mainText = null;

	PrintWriter pw = null;
	BufferedReader br = null;

	Socket clientSocket = null;
	private boolean isServerRunning = false;

  public BUKAClientPane() {

		mainText = new Text();

		try {
			
			// create a client socket.
			this.clientSocket = new Socket("localhost", 3000);
			
			isServerRunning = true;

			// For reading and writing to a socket.
			this.pw = new PrintWriter(this.clientSocket.getOutputStream(), true);
			this.br = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
		} catch (Exception e) {
			isServerRunning = false;
		}

		if (isServerRunning) {
			createLogin();
		} else {

			mainText.setText("Could not connect to server, make sure server is running.");

			this.add(mainText, 0, 1);

			mainText.setFill(Color.RED);
			mainText.setFont(Font.font("Verdana", 15));
		}
	}
	
	/** This is function creates GUI for
	 *  login the user.
	 * 
	 */
	private void createLogin() {
		
		Text usernameText = new Text();
		usernameText.setText("Username");

		TextField userNField = new TextField();

		this.add(mainText, 0, 1);

		this.add(usernameText, 0, 2);
		this.add(userNField, 1, 2);
		
		Text passwordText = new Text();
		passwordText.setText("Password");

		TextField passField = new TextField();

		this.add(passwordText, 0, 3);

		this.add(passField, 1, 3);

		Text result = new Text();

		this.add(result, 1, 4);

		Button login = new Button();
		login.setText("Login");

		Text logoutResult = new Text();

		// when login button is clicked
		login.setOnAction(event -> {

			// reset info texts.
			logoutResult.setText("");
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

		TextField list = new TextField();

		this.add(list, 0, 6);

		Button listButton = new Button("List all");
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

				StringTokenizer tokens = new StringTokenizer(line);

				// if previous command success.
				if (tokens.nextToken().equals("200")) {
					String text = "";

					// get all the tokens.
					while (tokens.hasMoreTokens()) {
						text += tokens.nextToken();
					}

					list.setText(line);
				} else {

				}
			} catch (Exception e) {
				System.out.println("Could not read file list from server.");
			}

		});

		Button logout = new Button("Logout");

		logout.setOnAction(event -> {

			result.setText("");

			try {
				pw.println("LOGOUT");	

				pw.flush();
			} catch (Exception e) {
			  System.out.println("Error logging out ... ");
			}

			String response = "";

			try {
				response = br.readLine();

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
}
