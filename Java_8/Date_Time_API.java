package Java_8;

public class Date_Time_API {

}


//Under the package java.time, Java 8 offers a new date-time API. The following are the most prominent classes among them:
//
//Local: Simplified date-time API with no timezone management complexity.
//Zoned: specialized date-time API that can handle several time zones.
//For Example: 
//
//Class	Description
//LocalDate	Represents a date (year, month, day (yyyy-MM-dd))
//LocalTime	Represents a time (hour, minute, second and nanoseconds (HH-mm-ss-ns))
//LocalDateTime	Represents both a date and a time (yyyy-MM-dd-HH-mm-ss-ns)
//DateTimeFormatter	Formatter for displaying and parsing date-time objects
//Dates
//
//In Java 8, the Date class has been deprecated. The following are the new courses that have been introduced:
//
//A date is defined by the LocalDate class. It is devoid of any indication of time or time zone.
//A time is defined by the LocalTime class. It doesn’t have a date or time-zone representation.
//A date-time is defined by the LocalDateTime class. It doesn’t have a time-zone representation
//To combine time-zone information with date functions, you may utilize Lambda’s OffsetDate, OffsetTime, and OffsetDateTime classes. Another class – “ZoneId” – is used to express the timezone offset here.