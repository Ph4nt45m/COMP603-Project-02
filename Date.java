
package Project_02;

public class Date {

    private int day;
    private int month;
    private int year;

    /*Date constructor takes in three integers parameters for day, month and year and initialises an instance of the class with these values.
    */
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    //Returns the value of the private 'day' variable.
    public int getDay() {
        return day;
    }

    //Sets the value of the private 'day' variable. Takes in an integer value as a parameter, sets the value of the 'day' variable to that parameter value.
    public void setDay(int day) {
        this.day = day;
    }

    //Returns the value of the private 'month' variable.
    public int getMonth() {
        return month;
    }

    //Sets the value of the private 'month' variable. Takes in an integer value as a parameter, sets the value of the 'month' variable to that parameter value.
    public void setMonth(int month) {
        this.month = month;
    }

    //Returns the value of the private 'year' variable.
    public int getYear() {
        return year;
    }

    //Sets the value of the private 'year' variable. Takes in an integer value as a parameter, sets the value of the 'year' variable to that parameter value.
    public void setYear(int year) {
        this.year = year;
    }

    /*This method overrides the default toString() method to return a formatted date string. It converts the day and month values to two-digit 
    *format by prepending a "0" if necessary. It then creates a string in the format "dd/mm/yyyy" using these values and the year value 
    *stored in the object. Finally, it returns the resulting string.
    */
    @Override
    public String toString() {
        String day;
        String month;
        if (this.day < 10) {
            day = "0" + this.day;
        } else {
            day = "" + this.day;
        }
        
        if (this.month < 10) {
            month = "0" + this.month;
        } else {
            month = "" + this.month;
        }
        String date = day + "/" + month
                + "/" + this.year;

        return date;
    }
}