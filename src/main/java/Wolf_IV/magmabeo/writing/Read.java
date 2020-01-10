package Wolf_IV.magmabeo.writing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

public class Read {
	public Read() {}
	public static String read(UUID uuid) throws IOException{
		 FileReader fileReader =
		            new FileReader(uuid+".json");

		      
		        BufferedReader bufferedReader =
		            new BufferedReader(fileReader);

		        
		        String line = bufferedReader.readLine();
		        return line;
	}
}
