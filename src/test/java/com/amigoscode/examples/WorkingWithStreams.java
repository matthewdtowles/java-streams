package com.amigoscode.examples;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class WorkingWithStreams {

    @Test
    void streams() {
    
        List<String> names = List.of("Matt", "Carolyn", "Annie");
        Stream<String> stream = names.stream();

        long count = stream
            .limit(2)
            .map(null)
            .sorted(null)
            .dropWhile(null)
            .count();

        String[] namesArray = {};
        Arrays.stream(namesArray);


        Stream<String> namesStream = Stream.of("Matt", "Carolyn", "Annie");
        
    }
}
