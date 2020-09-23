

import java.io.IOException;
import org.jibble.pircbot.*;

// this class contains the driver function to set up the chatbot, connect to a server, and join a channel  
public class myChatBotMain {
	
	// main() driver function 
	public static void main(String[] args){
		
		// creating a chatbot by calling the default constructor of myChatBot();
		myChatBot bot = new myChatBot();
		
		// printing everything as it arrives from the IRC server 
		bot.setVerbose(true);
		
		// connecting to a server
		try {
			bot.connect("irc.freenode.net");
		} catch (NickAlreadyInUseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IrcException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// joining a channel
		bot.joinChannel("#pircbot");
		

	}

}
