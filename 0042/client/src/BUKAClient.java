import java.io.BufferedReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket; 
		
	public class BUKAClient {
	public static void main(String[] args) {

		Socket socket = null;
 
		InputStream is = null;
		OutputStream os = null;

		PrintWriter pw = null;
		BufferedReader br = null;

		try {
			socket = new Socket("localhost", 3000);

			is = socket.getInputStream();
			os = socket.getOutputStream();

			pw = new PrintWriter(os);
			br = new BufferedReader(new InputStream(is));
		} catch (Exception e) {
			e.printStackTrace();
		}

		pw.println("PDFRT 1");
		pw.flush();
	}
}
