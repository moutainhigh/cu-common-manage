package com.aotain.cu.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * 时间处理的工具类
 * @author Jason.CW.Cheung
 *
 */
public class DateUtils {

	public static int WEEK_DAY_NUM = 7;
	private static Logger log = LoggerFactory.getLogger(DateUtils.class.getName());

	/**
	 * Cut time on the Date object including hour, min, sec and msec and return
	 * a new object contains year, month and day only.
	 * 
	 * @param date
	 *            The date to be trimmed
	 * @param unit
	 *            see Calendar.HOUR_OF_DAY, MINUTE, SECOND, etc
	 * @return
	 */
	public static Date trimDate(Date date, int unit) {
		if (date != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);

			return trimDate(cal, unit).getTime();
		} else {
			return null;
		}
	}

	public static java.sql.Date addDays(java.sql.Date date2, int unit) {
		Calendar c = Calendar.getInstance();
		c.setTime(date2);
		c.add(Calendar.DAY_OF_MONTH, unit);
		date2.setTime(c.getTimeInMillis());
		return date2;
	}

	public static Calendar trimDate(Calendar cal, int unit) {
		Calendar calendar = (Calendar) cal.clone();

		switch (unit) {
		case Calendar.YEAR:
			calendar.set(Calendar.MONTH, 0);

		case Calendar.MONTH:
			calendar.set(Calendar.DAY_OF_MONTH, 0);

		case Calendar.DAY_OF_MONTH:
			calendar.set(Calendar.HOUR, 0);
			calendar.set(Calendar.HOUR_OF_DAY, 0);

		case Calendar.HOUR_OF_DAY:
			calendar.set(Calendar.MINUTE, 0);

		case Calendar.MINUTE:
			calendar.set(Calendar.SECOND, 0);

		case Calendar.SECOND:
			calendar.set(Calendar.MILLISECOND, 0);

		case Calendar.MILLISECOND:

			// clear nothing
			break;
		}

		return calendar;
	}

	public static String formatCurrDateyyyyMMddHHmmssSSS() {
		return formatDateTime(DateFormatConstant.DATETIME_WITHOUT_SEPARATOR_LONG_WITH_MILLIS, new Date()); 
	} 
	
	public static String formatCurrDateyyyyMMddHHmmss() {
		return formatDateTime(DateFormatConstant.DATETIME_CHS, new Date()); 
	} 
	
	public static String formatDateyyyyMMdd(Date date) {
		return formatDateTime(DateFormatConstant.DATE_WITHOUT_SEPARATOR_SHORT, date);
	}

	public static String formatDateTime(Date date) {
		return formatDateTime(DateFormatConstant.DATETIME_CHT, date);
	}

	public static String formatDateLongTime(Date date) {
		return formatDateTime(DateFormatConstant.DATETIME_CHS_LONG, date);
	}

	public static String getCurrentyyyMMddHHmmss() {
		return formatDateTime(DateFormatConstant.DATETIME_CHS, new Date());
	}

	public static String formatDateTime(String format, Date date) {
		if (date == null) {
			return "";
		}

		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	public static String formatNetricsDate(String formate, Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat(formate, Locale.ENGLISH);
		return sdf.format(d);
	}

}
