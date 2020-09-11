 

public class Digit {
    private int value;
    private int limit;
    //Constructor
    Digit (int value, int limit) {
    this.value = value;
    this.limit = limit;
    }
    Digit (int value) {
        this.value = value;
    }
    //incrementing by 1
    public void increment () {
        value = (value + 1)%limit;
    }
    //incrementing year
    public void incrementYear () {
        value = value  + 1;
    }


    //getters and setters
    public String getDisplayValue () {
        if (value < 10) {
            return "0" + value;
        }
        else {
            return "" + value;
        }
    }



    public int getValue () {
        return value;
    }
    public int getLimit () {
        return limit;
    }
    public void setValue (int value) {
        this.value = value;
    }
    public void setLimit (int limit) {
        this.limit = limit;
    }




}
