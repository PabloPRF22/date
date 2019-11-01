package es.unileon.prg.date;

public class Date{

	private int day;
	private int month;
	private int year;
	
	
	/**
	 * Constructor de la clase.Hace set si los valores recibido son corectos sino manda una Exception
	 * 
	 * @param day,month,year
	 *            valor del dia
	 *            valor del mes
	 *            valor del año
	 * 
	 **/
	public Date(int day, int month, int year) throws DateException{
	
		StringBuilder error = new StringBuilder();
			this.setMonth(month);
			this.setDay(day);
			this.setYear(year);
		
	}
	/**
	 * hace set del mes si este es valido
	 * 
	 * @parame month
	 * 			month: numero del mes
	 */
	public void setMonth(int month) throws DateException{
		if(month<1 || month>12){
			throw new DateException("Date error: month value" + month + " not valid value. It should be from 1 to 12");	
		}else{
			this.month = month;
		}
	}
	/**
	 * Hace set del mes si este es valido
	 * 
	 * @parame dia
	 * 			dia: numero del dia
	 */
	public void setDay(int day) throws DateException{
		if(day<1 ||day>this.daysOfMonth(month)){
			throw new DateException("Date error: day value" + day + " not valid value" +  "At" + month + "Day should be from 1 to" + daysOfMonth(month));
		}else{
			this.day = day;
		}	
	}
	/**
	 * Hace set si el año es valido
	 * 
	 * @parame year
	 * 			year: año
	 */
	public void setYear(int year) throws DateException{
		if(year<0){
			throw new DateException("Date error: year value" + year + " not valid value. It should be higther than 0 ");
		}else{
			this.year = year;
		}
	}
	/**
	 * Retorna el año
	 * 
	 * @return year
	 */
	public int getYear(){
		return this.year;
	}
	/**
	 * Retorna el mes
	 * 
	 * @return month
	 */
	public int getMonth(){
		return this.month;
	}
	/**
	 * Retorna el dia
	 * 
	 * @return day
	 */
	public int getDay(){
		return this.day;
	}
	
	/**
	 * Devuelve el numero de dias que tiene el mes
	 * 
	 * @parame month
	 * 			month: numero del mes
	 * @return maxDays
	 */
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
	/**
	 * Devuelve el nombre del mes
	 * 
	 * @parame month
	 * 			month: numero del mes
	 * @return monthName
	 */
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
	/**
	 * Devuelve la estacion del año
	 * 
	 * @parame month
	 * 			month: numero del mes
	 * @return season
	 */
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
	/**
	 * Devuelve cuantos meses quedan para acabar el  año
	 * 
	 * @parame month
	 * 			month: numero del mes
	 * @return remaining
	 */
	public int monthsToEndYear(int month){
		int remaining = 12-month;
		return remaining;
	}
	/**
	 * Muestra todas las fechas que quedan para acabar el mes
	 * 
	 * @parame none
	 * 
	 */
	public void datesToFinishMonth() throws DateException {
		for (int i = getDay(); i < daysOfMonth(getMonth()); i++) {
			Date nueva = new Date(i, this.getMonth(), this.getYear());
			System.out.println(nueva.toString());
			
		}
	}
	/**
	 * Devuelve los meses con el mismo numero de dias
	 * 
	 * @parame none
	 * 			
	 */
	public String monthsWithSameDays() {
		StringBuffer meses = new StringBuffer();
		for (int i = 1; i <= 12; i++) {
			if(daysOfMonth(i) == daysOfMonth(getMonth())) {
				meses.append(nameOfMonth(i)+ " ");
			}
		}
		return meses.toString();
		
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
