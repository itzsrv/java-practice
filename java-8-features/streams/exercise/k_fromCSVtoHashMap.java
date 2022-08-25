package streams.exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class k_fromCSVtoHashMap {
    
    public static void main(String[] args) throws IOException {
        
        Stream<String> rows = Files.lines(Paths.get("java-features/streams/exercise/data.txt"));
        
        Map<String, Integer> map = new HashMap<>();
		
        map = rows
			    .map(x -> x.split(","))
                .filter(x -> x.length == 3)
			    .filter(x -> Integer.parseInt(x[1]) > 15)
			    .collect(Collectors.toMap(
                    x -> x[0],
                    x -> Integer.parseInt(x[1])
                    )
                );
		rows.close();
		for (String key : map.keySet()) {
			System.out.println(key + "  " + map.get(key));
		}
    }
}
