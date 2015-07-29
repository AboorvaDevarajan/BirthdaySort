package org.sample.birthday;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DateSortTest {

     // Test for Differenct list of dates
	public static void main(String[] args) {
		
		List<Person> persons = new ArrayList<>();
		
		try {
			persons.add(new Person("Sam", "JAN 1, 2001"));
			persons.add(new Person("Lily", "JUL 29, 2015"));
			persons.add(new Person("Mark", "JUL 23, 1976"));
			persons.add(new Person("Louis", "MAR 4, 1985"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Collections.sort(persons);
		for (Person p : persons) {
			System.out.println(p.getName()+"\t"+p.getFormattedBirthDate());
		}
		
		int pivot = SortUtils.getPivotValueByDate(persons);
		System.out.println();
		persons = SortUtils.getSortedDateList(persons, pivot);

		for (Person p : persons) {
			System.out.println(p.getName()+"\t"+p.getFormattedBirthDate());
		}
	}

}
