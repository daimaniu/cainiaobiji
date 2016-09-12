package cn.daimaniu.blog.date;

/**
 * Author :chenqisheng
 * Date   :15/9/11.
 */
public class TimePair {
    private long startTime;
    private long endTime;

    public TimePair(){}

    public TimePair(long startTime, long endTime) {
        this.endTime = endTime;
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }
}
