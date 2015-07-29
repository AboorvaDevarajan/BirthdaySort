package org.sample.birthday;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//Simple Object class for Person
class Person implements Comparable<Person> {

	private String name;

	private Date birthDate;

	static SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");

	public Person(String name, String birthDay) throws ParseException {
		this.birthDate = formatter.parse(birthDay);
		if(!SortUtils.isGreaterThanCurrentDate(birthDate)){
			throw new IllegalArgumentException("Not a valid birthday");
		}
		this.name = name;
	}

	// Compare function to sort the values based on the birthday
	@Override
	public int compareTo(Person o) {

		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(this.birthDate);

		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(o.birthDate);

		int month1 = cal1.get(Calendar.MONTH);
		int month2 = cal2.get(Calendar.MONTH);

		if (month1 < month2)
			return -1;
		else if (month1 == month2)
			return cal1.get(Calendar.DAY_OF_MONTH)
					- cal2.get(Calendar.DAY_OF_MONTH);
		else
			return 1;
	}

	public String getName() {
		return name;
	}

	@SuppressWarnings("unused")
	private void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public String getFormattedBirthDate() {

		return Person.formatter.format(this.getBirthDate());
	}

	@SuppressWarnings("unused")
	private void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

}