 
public class DigitalCalender {
//field declarations
private Digit minutes;
private Digit hours;
private Digit seconds;
private Digit date;
private Digit months;
private Digit year;

private String [] day = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
private  String [] monthArray = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

//these arrays handle the superScript for our dates
private int [] dateWithSt = {1,21, 31};
private int [] dateWithNd = {2, 22};
private int [] dateWithRd = {3, 23};

//edits the number of days
private int dayIndex;
//private int monthIndex = 0;

//this field is used to display our time
private String time;
private boolean leapYear;
//Constructor
public DigitalCalender (boolean leapYear, int minutes, int hours, int seconds, int date, int year, String monthName, String dayName) {
//initializing our fields
int extractedMonth = extractingMonths(monthName);
int extractedDay = extractingDays(dayName);
this.minutes = new Digit (minutes, 60);
this.seconds = new Digit (seconds, 60);
this.hours = new Digit (hours, 24);
this.date = new Digit (date, 32);
months = new Digit (extractedMonth, 12);
this.year = new Digit (year);
this.leapYear = leapYear;

//initializes the day
    this.dayIndex = extractedDay;

updateTime();

}

private int extractingMonths (String monthName) {
    int i;
    for( i = 0; i<monthArray.length; i++)
    {
        if(monthArray[i].equals(monthName))
            return i;
    }
    return 0;
}

private int extractingDays (String dayName) {
    int i;
    for( i = 0; i<day.length; i++)
    {
        if(day[i].equals(dayName))
            return i;
    }
    return 0;
}
//Ticking implementation
    public void timeTick () {
      seconds.increment();
      if(seconds.getValue() == 0)
          minutes.increment();
      if (minutes.getValue() == 0 && seconds.getValue() == 0)
          hours.increment();
      if (hours.getValue() == 0 && minutes.getValue() == 0 && seconds.getValue() ==0) {
          date.increment();
          dayChange();
      }
      if(date.getValue() == 0 && minutes.getValue() == 0 && seconds.getValue() == 0 && hours.getValue() == 0)
          months.increment();
      if(date.getValue() == 0 && minutes.getValue() == 0 && seconds.getValue() == 0 && hours.getValue() == 0 && months.getValue() == 0)
          year.incrementYear();
      updateTime();
    }
    //This method is used to update/set the time
    private void updateTime () {
    daysTracker();
    if(leapYear)
        isLeapYear();
    if(date.getValue() == 0)
        date.setValue(date.getValue() + 1);
       time = hours.getDisplayValue() + ":" + minutes.getDisplayValue() + ":" + seconds.getDisplayValue() + " " + day[dayIndex] + " " + date.getValue() + superScript() + monthArray[months.getValue()] + "," + year.getValue() ;

    }


    //this method changes the day array
    private void dayChange () {
      dayIndex = (dayIndex + 1)%7;
    }

    //this method is used to display the time
    public void displayTime () {
        System.out.println(time);
    }

    private String superScript () {
    //testing for "st" superScirpt
        for (int i = 0; i < dateWithSt.length; i++) {
            if (dateWithSt[i] == date.getValue())
                return "st ";
        }

        //testing for "nd" superScript
        for(int i =0; i<dateWithNd.length; i++) {
            if(dateWithNd[i] == date.getValue())
                return "nd ";
        }

        //testing for "th" superScirpt
            for (int i = 0; i<dateWithRd.length; i++) {
            if(dateWithRd[i] == date.getValue())
                return "rd ";
        }
        return "th ";
    }
  //checking for leap year
    private void isLeapYear () {
        if (monthArray[months.getValue()] == "February" && date.getValue() >= 30) {
            date.setValue(0);
            minutes.setValue(0);
            seconds.setValue(0);
            months.increment();
            hours.setValue(0);
        }
    }
    //tracks the numberOfDaysOfeachMonth
    private void daysTracker () {
    if(monthArray[months.getValue()] == "April" || monthArray[months.getValue()] == "June" || monthArray[months.getValue()] == "September" || monthArray[months.getValue()] == "November")
        date.setLimit(31);

    }
}
