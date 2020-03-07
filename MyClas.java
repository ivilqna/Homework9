package fmi.informatics.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Assert;

import fmi.informatics.extending.Student;
import sun.management.counter.Units;

public class MyClas {
	
	public static void functionalTask() {
		ArrayList<Student> students = new ArrayList<Student>();
		Stream.of(Student.StudentGenerator.make(), Student.StudentGenerator.make(), Student.StudentGenerator.make())
				.filter(s -> s.getName().length() >= 5).sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
				.forEach(System.out::println);
		Assert.assertEquals(students.get(0).getName().toString(), "Mariya");
	}

	public static void testStreams() {
		ArrayList<String> animal = new ArrayList<String>();
		Stream.of("cat", "dog", "cow", "bird").map(String::toUpperCase).collect(Collectors.toList())
				.forEach(System.out::println);
		Assert.assertEquals(animal.get(0), "CAT");
	}

	public static void task() {
		ArrayList<Student> students = new ArrayList<Student>();

		for (int i = 0; i < 5; ++i) {
			students.add(Student.StudentGenerator.make());
		}

		String studentsNames = students.stream().sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
				.map(s -> s.getName()).reduce((s1, s2) -> {
					if (s2 != null)
						return s1 + ", " + s2;
					return s1;
				}).get();
		System.out.println(studentsNames);
		Assert.assertEquals(studentsNames, "Mariya", "Lilly");
	}

	public static void moreStreams() {
	     ArrayList<Integer> expected = new ArrayList<Integer>();
	        expected.add(6);
	        expected.add(8);
	        expected.add(10);
	        expected.add(12);
	        expected.add(14);
	        ArrayList<Integer> num = new ArrayList<Integer>();
	        IntStream.iterate(0, i -> i + 1)
			.skip(5)
			.limit(10)
			.forEach(i -> {
				if (i%2 == 0) System.out.println(i);  
	                    ;
	                });
	        Assert.assertEquals(expected, num);
	    }
	
	
	}

