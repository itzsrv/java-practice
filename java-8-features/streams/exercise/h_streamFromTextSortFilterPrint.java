package streams.exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class h_streamFromTextSortFilterPrint{

    public static void main(String[] args) throws IOException {
        Stream<String> bands = Files.lines(Paths.get("java-features/streams/exercise/bands.txt"));
        bands
            .sorted()
            .filter(x->x.length()>13)
            .forEach(System.out::println);

            bands.close();

        List<String> bands2 = Files.lines(Paths.get("java-features/streams/exercise/bands.txt"))
            .filter(x->x.contains("jit"))
            .collect(Collectors.toList());
            
            bands2.forEach(System.out::println);
        

    }
}