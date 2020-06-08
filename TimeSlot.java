package GOFO2;

public class TimeSlot {
    int startTime,endTime;
    String day;

    public TimeSlot() {
    }

    public TimeSlot(int startTime, int endTime, String day) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.day = day;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public String getDay() {
        return day;
    }
}
