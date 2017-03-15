package time.warmup;

import time.Time;

public class HomesteadStudent {
	public static final Time schoolStartTime = new Time("7:50 AM");
	public static final Time schoolEndTime = new Time("3:15 PM");

	private Time startTime;
	private Time endTime;

	public HomesteadStudent(Time startTime, Time endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public HomesteadStudent() {
		this(HomesteadStudent.schoolStartTime);
	}

	public HomesteadStudent(Time startTime) {
		this(startTime, HomesteadStudent.schoolEndTime);
	}

	public HomesteadStudent(String startTime) {
		this(new Time(startTime));
	}

	public HomesteadStudent(String startTime, String endTime) {
		this(new Time(startTime), new Time(endTime));
	}

	public Time getStartTime() {
		return this.startTime;
	}

	public Time getEndTime() {
		return this.endTime;
	}

	public static void main(String[] args) {
		HomesteadStudent James = new HomesteadStudent("7:30 AM");
		System.out.println(HomesteadStudent.schoolStartTime);
		System.out.println(HomesteadStudent.schoolEndTime);
		System.out.println(James.getStartTime());
	}
}
