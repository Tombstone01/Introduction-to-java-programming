import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.InetAddress;

public class Main extends Application {

	// this is the UPD port that the server runs on.
	private static int UDP_PORT = 9876;

	private static GUI gui = null;

	public void start(Stage stage) throws Exception {

		gui = new GUI();

		Scene scene = new Scene(gui, 500, 350);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) throws Exception {

		// this socket is used to communicated with the server.
		DatagramSocket clientSocket = new DatagramSocket();

		Client client = new Client(clientSocket, gui);

		Thread thread = new Thread(client);
		thread.start();

		launch(args);
	}
}
