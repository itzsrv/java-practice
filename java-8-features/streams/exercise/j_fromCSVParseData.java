package streams.exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class j_fromCSVParseData {
    
    public static void main(String[] args) throws IOException{
        Stream<String> rows = Files.lines(Paths.get("java-features/streams/exercise/data.txt"));
		rows
			.map(x -> x.split(","))
            .filter(x -> x.length == 3)
			.filter(x -> Integer.parseInt(x[1]) > 15)
			.forEach(x -> System.out.println(x[0] + "  " + x[1] + "  " + x[2]));
		rows.close();
    }
}
