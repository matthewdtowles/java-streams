package com.amigoscode.examples;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.sound.sampled.SourceDataLine;

import org.junit.jupiter.api.Test;

import com.amigoscode.beans.Car;
import com.amigoscode.mockdata.MockData;
import com.google.common.base.Predicate;

public class Filtering {

    @Test
    public void filter() throws Exception {
        List<Car> cars = MockData.getCars();
        List<Car> cheapCars = cars.stream()
            .filter(c -> c.getPrice() < 20_000.00)
            .collect(Collectors.toList());
        cheapCars.forEach(System.out::println);
    }

    @Test
    public void multiFilter() throws Exception {
        // multiple filters example:
        List<Car> cars = MockData.getCars();
        // you can also save predicates used for filters to a variable
        Predicate<Car> pricePredicate = c -> c.getPrice() < 20_000.00;
        Predicate<Car> yellowColorPredicate = c -> c.getColor().equals("Yellow");
        List<Car> cheapYellowCars = cars.stream()
            // .filter(c -> c.getPrice() < 20_000.00)
            .filter(pricePredicate)
            // .filter(c -> c.getColor().equals("Yellow"))
            .filter(yellowColorPredicate)
            .collect(Collectors.toList());
        cheapYellowCars.forEach(System.out::println);
    }

    @Test
    public void dropWhile() throws Exception {
        System.out.println("using filter");
        Stream.of(2, 4, 6, 8, 9, 10, 12).filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
        System.out.println("using dropWhile");
    }

    @Test
    public void takeWhile() throws Exception {
        // using filter
        System.out.println("using filter");
        Stream.of(2, 4, 6, 8, 9, 10, 12).filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));

        System.out.println();
        System.out.println("using take while");
    }

    @Test
    public void findFirst() throws Exception {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    }

    @Test
    public void findAny() throws Exception {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 10};
    }

    @Test
    public void allMatch() throws Exception {
        int[] even = {2, 4, 6, 8, 10};
    }

    @Test
    public void anyMatch() throws Exception {
        int[] evenAndOneOdd = {2, 4, 6, 8, 10, 11};
    }

}



