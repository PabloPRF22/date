package es.unileon.prg.date;

public class Date{

	private int day;
	private int month;
	private int year;
	
	
	public Date(int day, int month, int year) throws DateException{
	
		StringBuilder error = new StringBuilder();
		try{
			this.setMonth(month);
			this.setDay(day);
			this.setYear(year);
		}catch(DateException e){
			error.append(e.getMessage());
			throw new DateException(error.toString());
		}
	}
	
	public int daysOfMonth(int month){
		int maxDays =  0;
		switch(month){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12: 
				maxDays = 31;
				break;
			case 2:
				maxDays = 28;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				maxDays = 30;
				break;
				
		}
		return maxDays;
	}

	public String nameOfMonth(int month){
		String monthName = null;
		switch(month){
			case 1:
				monthName ="January";
				break;
			case 3:
				monthName ="March";
				break;
			case 5:
				monthName ="May";
				break;
			case 7:
				monthName ="July";
				break;
			case 8:
				monthName ="August";
				break;
			case 10:
				monthName ="October";
				break;
			case 12: 
				monthName = "December";
				break;
			case 2:
				monthName = "February";

				
				break;
			case 4:
				monthName ="April";
				break;
			case 6:
				monthName ="June";
				break;
			case 9:
				monthName ="September";
				break;
			case 11:
				monthName = "november";
				break;
				
		}
		return monthName;
	}
	public String seasonOfMonth(int month){
		String season = null;
		switch(month){
			case 12:
			case 1:
			case 2:
				season = "Winter";
				break;
			case 3:
			case 4:
			case 5:
				season = "Spring";
				break;
			case 6:
			case 7: 
			case 8:
				season = "Summer";
				break;
			case 9:
			case 10:
			case 11:
				season = "Autumn";
				break;

		
		}
		return season;
	}
	public int monthsToEndYear(int month){
		int remaining = 12-month;
		return remaining;
	}

	public void setMonth(int month) throws DateException{
		if(month<1 || month>12){
			throw new DateException("Date error: month value" + month + " not valid value. It should be from 1 to 12");	
		}else{
			this.month = month;
		}
	}
	public void setDay(int day) throws DateException{
		if(day<1 ||day>this.daysOfMonth(month)){
			throw new DateException("Date error: day value" + day + " not valid value" +  "At" + month + "Day should be from 1 to" + daysOfMonth(month));
		}else{
			this.day = day;
		}	
	}
	public void setYear(int year) throws DateException{
		if(year<0){
			throw new DateException("Date error: year value" + year + " not valid value. It should be higther than 0 ");
		}else{
			this.year = year;
		}
	}
	
	public void datesUntilEndMonth(){
		for(int i = getDay(); i<daysOfMonth(getMonth()); i++){
			this.day = i;
			toString();
		}
	
	}
	public int getYear(){
		return this.year;
	}
	public int getMonth(){
		return this.month;
	}
	public int getDay(){
		return this.day;
	}

	
	public boolean isSameYear(Date otherDate){
		return this.year==otherDate.getYear();
	}
	public boolean isSameDay(Date otherDate){
		return this.day==otherDate.getDay();
	}
	public boolean isSameMonth(Date otherDate){
		return this.month==otherDate.getMonth();
	}
	public boolean isSame(Date otherDate){
		return this.year==otherDate.getYear() && this.month==otherDate.getMonth() && this.day==otherDate.getDay();
	}
	public String toString(){
		StringBuffer Date = new StringBuffer();
		Date.append("\nYear:" + getYear()+ " ");
		Date.append("Month:" + nameOfMonth(getMonth())+ " ");
		Date.append("Day:" + getDay()+ " ");
		return Date.toString();
	}
	



}
