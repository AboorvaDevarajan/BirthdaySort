package org.sample.birthday;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SortUtils {

	/**
	 * @param persons
	 * @return
	 * returns the pivoted value for the birthday list based on current date
	 */
	public static int getPivotValueByDate(List<Person> persons) {
		if(persons.size() == 0){
			throw new IllegalArgumentException("No person found!");
		}else{
			Calendar currentDate = Calendar.getInstance();
			Date curr = new Date();
			currentDate.setTime(curr);
	
			int pivot = 0;
			int month = currentDate.get(Calendar.MONTH);
			int day = currentDate.get(Calendar.DAY_OF_MONTH);
	
			for (Person p : persons) {
				Calendar pBday = Calendar.getInstance();
				pBday.setTime(p.getBirthDate());
	
				if (pBday.get(Calendar.MONTH) >= month) {
					if (pBday.get(Calendar.DAY_OF_MONTH) >= day)
						return pivot;
				}
				pivot = pivot + 1;
			}
		}
		return 0;
	}


	
	public static boolean isGreaterThanCurrentDate(Date bDate) {
			Calendar currentDate = Calendar.getInstance();
			Date curr = new Date();
			currentDate.setTime(curr);
			
			Calendar bDay = Calendar.getInstance();
			bDay.setTime(bDate);
			
			int cMonth = currentDate.get(Calendar.MONTH);
			int cDay = currentDate.get(Calendar.DAY_OF_MONTH);
			int cYear = currentDate.get(Calendar.YEAR);
			
			int bMonth = bDay.get(Calendar.MONTH);
			int bD = bDay.get(Calendar.DAY_OF_MONTH);
			int bYear = bDay.get(Calendar.YEAR);
			
			if(cYear < bYear){
				return false;
			}
			else if(cYear == bYear){
				
				if(cMonth < bMonth){
					return false;
				}
				else if(cMonth == bMonth){
					
					if(cDay < bD){
						return false;
					}
				}
			}
			
			return true;
	}

	/**
	 * @param persons
	 * @param pivot
	 * @return
	 * returns the rotated sorted list using the pivoted value
	 */
	public static List<Person> getSortedDateList(List<Person> persons, int pivot) {
		List<Person> rotatedLst = new ArrayList<Person>();
		if(persons.size() == 0){
			throw new IllegalArgumentException("No person found!");
		}
		else{
			
			for (int i = pivot; i < persons.size(); i++) {
				rotatedLst.add(persons.get(i));
			}
			for (int i = 0; i < pivot; i++) {
				rotatedLst.add(persons.get(i));
			}
		}
		return rotatedLst;
	}
}
