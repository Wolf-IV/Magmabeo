package Wolf_IV.magmabeo.writing;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;
public class Write {
	
	public Write() {}
	

	    public static void write(UUID uuid,int power) throws IOException {
	        PrintWriter writer = new PrintWriter(uuid+".json", "UTF-8");
	        writer.println(power);
	        
	        writer.close();
	       
	       

	    }
	    

	}



