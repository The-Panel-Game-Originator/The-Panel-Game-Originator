package Server;


public class ServerMain extends Thread{

	public static void main(String[] args)
	{
		Server server = new Server(80);
		server.start();
	}
	
}