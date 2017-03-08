package time;

import java.text.DecimalFormat;

/* import java.util.Calendar; */

public class Time {
	public int hour;
	public int min;

	private boolean twelveHrTime;

	public Time(int hours, int min) {
		if (hours < 0 || min < 0) {
			throw new IllegalArgumentException("Hours and Minutes must be positive integers.");
		}
		/* this.hours = hours; */
		if (min < 0 || min >= 60) {
			this.min = min % 60;
			this.hour += min / 60;
		} else {
			this.min = min;
		}
		if (hours < 0 || hours >= 24) {
			this.hour = hours % 24;

		} else {
			this.hour = hours;
		}
	}

	public Time(int min) {
		this(min / 60, min % 60);
	}

	public Time(Time other) {
		this.hour = other.hour;
		this.min = other.min;
		this.twelveHrTime = other.twelveHrTime;
	}

	public Time() {
		// set to midnight and 24 hr time
		/* this sets time to now */
		/* hours = Calendar.HOUR_OF_DAY; min = Calendar.MINUTE; */
	}

	public Time(int hours, int min, boolean m) {
		this(hours + ((m) ? 12 : 0), min);
		this.twelveHrTime = !m;
	}

	public boolean lessThan(Time other) {
		// this < other
		return (this.hour < other.hour || (this.hour == other.hour && this.min < other.min));
	}

	public int elapsedSince(Time other) {
		int x;
		return ((x = ((this.hour - other.hour) * 60) + (this.min - other.min)) < 0) ? (x + (24 * 60)) : (x);
	}

	public Time add(Time other) {
		return new Time((this.hour + other.min) * 60 + this.min + other.min);
	}

	public Time add(int min) {
		return new Time(this.hour * 60 + this.min + min);
	}

	public boolean equals(Time other) {
		return (this.hour == other.hour && this.min == other.min);
	}

	@Override
	public String toString() {
		return (!this.twelveHrTime) ? (format(hour) + ":" + format(min))
				: (hour < 12) ? (format(hour) + ":" + format(min) + " AM")
						: (hour == 12) ? (format(hour) + ":" + format(min) + " PM")
								: (format(hour - 12) + ":" + format(min) + " PM");
	}

	private String format(int value) {
		return (new DecimalFormat("00").format(value));
	}

	public void setPrintAMPM(boolean b) {
		this.twelveHrTime = b;

	}

	public int toMins() {
		return (hour * 60 + min);
	}

}
