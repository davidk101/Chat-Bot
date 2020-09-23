
import org.jibble.pircbot.*;
import java.io.IOException;

// this class is a subclass of the abstract PircBot class and implements the methods defined there
public class myChatBot extends PircBot {
	
	// no-arg constructor 
	public myChatBot() {
		
		// giving the chatbot a Nick 
		this.setName("EarlTheChatBot");
	}
	
	// default message when the chatbot goes live
	public void onJoin(String channel, String sender, String login, String hostname) {
		
		sendMessage("#pircbot", "Hello there! My name is Earl, the automated chatbot. Ask for the weather in a city or a random kanye quote!");
	}
	// this function instructs the bot to perform a set of tasks as soon as a message is recieved from another user
	public void onMessage(String channel, String sender, String login, String hostname, String message){
		
		String city = "";
		
		// parsing through the message to look for certain keywords 
		if (message.contains("weather")) {
			
			// identifying the name of the city after 8 characters "weather "
			city = message.substring(9);
			
			try {
				
				// displaying this message in the chat 
				sendMessage(channel, sender + ", " + ParseData.weather(city));
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
		}
		
		if (message.contains("kanye")) {
			
			try {
				
				// displaying this message in the chat 
				sendMessage(channel, sender + ", Kanye once said: \"" + ParseData.kanyeQuote() + "\"");
				
			} catch(IOException e) {
				
				e.printStackTrace();
			}
			
		}	
	
		if(message.contains("bye")) {
			
			// leaving the channel
			disconnect();
		}
		
	}
		
}
