public class Clock {

    private int hour;
    private int minute;
    private int second;

    public Clock(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void tick() {
        this.second += 1;

        if (this.second >= 60) {
            this.minute += 1;
            this.second = 0;
        }

        if (this.minute >= 60) {
            this.hour += 1;
            this.minute = 0;
        }

        if (this.hour >= 24) {
            this.hour = 0;
        }
    }

    public String getCurrentTime() {
        return this.hour + ":" + this.minute + ":" + this.second;
    }

    public void setHour(int hour) {
        if(hour >= 1 && hour <= 24) {
            this.hour = hour;
        }
    }

    public void setMinute(int minute) {
        if(minute >=0 && minute < 60) {
            this.minute = minute;
        }
    }

    public void setSecond(int second) {
        if(second >=0 && second < 60) {
            this.second = second;
        }
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public int getSecond() {
        return this.second;
    }
}
