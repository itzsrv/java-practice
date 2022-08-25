package streams.exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class i_fromCSVFileCount {
    
    public static void main(String[] args) throws IOException{
        
        Stream<String> rows = Files.lines(Paths.get("java-features/streams/exercise/data.txt"));
    
        int rowCount = (int)rows
            .map(x -> x.split(","))             //each row will become an array of items
            .filter(x -> x.length == 3)               //select only those array with 3 items
			.count();                                 //stream will be reduced, and count of no of items will be returned

        System.out.println(rowCount + " rows.");
		rows.close();
    }
}
