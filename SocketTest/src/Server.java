import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;



public class Server {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ServerSocket server = null;
		Socket client = null;
		InputStream is = null;
		OutputStream os = null;
		ByteArrayOutputStream arr = new ByteArrayOutputStream();
		try {
			server = new ServerSocket(6765);
			client = server.accept();
			is = client.getInputStream();
			os = client.getOutputStream();
			int len = 0;
			byte[] buf = new byte[2];
			while ((len = is.read(buf)) != -1) {
				arr.write(buf, 0, len);
				System.out.println(arr.toString("utf-8"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
