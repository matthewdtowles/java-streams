package com.amigoscode.examples;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.beans.PersonDTO;
import com.amigoscode.mockdata.MockData;

import static org.assertj.core.api.Assertions.assertThat;

public class TransformationsMapAndReduce {

    /*
     * Transform from List<A> to List<B> with .map()
     */
    
    @Test
    void yourFirstTransformationWithMap() throws IOException {
        List<Person> people = MockData.getPeople();
        // transform this list of Person to PersonDTO 
        List<PersonDTO> dtos = people.stream()
            .map(p -> new PersonDTO(p.getId(), p.getFirstName(), p.getAge()))
            .collect(Collectors.toList());
        // above can also be done like:
        /*
        List<PersonDTO> dtos = people.stream()
            .map(p -> {
                return new PersonDTO(p.getId(), p.getFirstName(), p.getAge());
            }).collect(Collectors.toList());
         */
        dtos.forEach(System.out::println);
        assertThat(people.size()).isEqualTo(dtos.size());
    }

    @Test
    void transformWithMapUsingFunction() throws Exception {
        List<Person> people = MockData.getPeople();
        // the inside of .map() is a Function<From, To> type which can be defined as:
        Function<Person, PersonDTO> personToDtoFn = p -> new PersonDTO(p.getId(), p.getFirstName(), p.getAge());
        List<PersonDTO> dtos = people.stream()
            .map(personToDtoFn)
            .collect(Collectors.toList());
        dtos.forEach(System.out::println);
        assertThat(people.size()).isEqualTo(dtos.size());
    }

    @Test
    void transformWithMapUsingPredefinedFunction() throws Exception {
        List<Person> people = MockData.getPeople();
        List<PersonDTO> dtos = people.stream()
            .map(PersonDTO::map)
            .collect(Collectors.toList());
        dtos.forEach(System.out::println);
        assertThat(people.size()).isEqualTo(dtos.size());
    }

    @Test
    void mapToDoubleAndFindAverageCarPrice() throws IOException {
        List<Car> cars = MockData.getCars();
    }

    @Test
    public void reduce() {
        int[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};
    }
}

