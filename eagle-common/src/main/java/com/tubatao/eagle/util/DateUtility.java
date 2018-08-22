/**
 * Copyright(c) tubatao Technology Co.,Ltd.
 * All Rights Reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p>
 * project: eagle-authorization-server
 * <p>
 * Revision History:
 * Date         Version     Name                Description
 * 7/17/18  1.0         liuzhiheng         Creation File
 */
package com.tubatao.eagle.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * Description:
 *
 *
 * @author liuzhiheng
 * @date 7/17/18 2:49 PM
 */
public class DateUtility {
    public static final String FULL_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String LONG_DATE_FORMAT = "yyyy-MM-dd";
    public static final String LONG_TIME_FORMAT = "HH:mm:ss";
    public static final String YEAR_MONTH_FORMAT = "yyyy-MM";
    public static final String COMPACT_YEAR_MONTH_DAY_FORMAT = "yyyyMMdd";

    public static String getCurrentDateTime() {
        return getTimeString(LocalDateTime.now(), FULL_DATE_TIME_FORMAT);
    }

    public static String getTimeString(LocalDateTime date, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);//.ofLocalizedDateTime(FormatStyle.FULL)//.ofPattern("MM dd, yyyy - HH:mm");//DateTimeFormatter.ISO_DATE_TIME;
        String curTime = formatter.format(date);
        return curTime;
    }

    public static String getStandardDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
        String curTime = formatter.format(LocalDateTime.now());
        return curTime;
    }

    public static LocalDate stringToLongDate(String value) {
        return stringToLocalDate(value, LONG_DATE_FORMAT);
    }

    public static String dateToLongString(LocalDate value) {
        return dateToFormatString(value, LONG_DATE_FORMAT);
    }

    public static LocalDateTime stringToISOLocalDateTime(String value) {

        return LocalDateTime.parse(value, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public static LocalDateTime stringToLocalDateTime(String value, String format) {
        if (value == null)
            return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDateTime localDateTime = null;
        try {
            localDateTime = LocalDateTime.parse(value, formatter);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return localDateTime;
    }

    public static LocalDate stringToLocalDate(String value, String format) {
        if (value == null)
            return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDate localDate = null;
        try {
            localDate = LocalDate.parse(value, formatter);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return localDate;
    }
    public static String dateToFormatString(LocalDate value, String format) {
        if (value == null)
            return "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        String dateString = formatter.format(value);
        return dateString;
    }

    public static LocalDate dateToLocalDate(Date value) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(value);
        LocalDate localDate = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
        return localDate;
    }

    public static Date localDateToDate(LocalDate value) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(value.getYear(),value.getMonthValue()-1,value.getDayOfMonth());
        return calendar.getTime();
    }

    public static LocalDateTime dateToLocalDateTime(Date value) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(value);
        LocalDateTime localDateTime = LocalDateTime.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));
        return localDateTime;
    }

    public static Date localDateTimeToDate(LocalDateTime value) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(value.getYear(), value.getMonthValue()-1, value.getDayOfMonth(), value.getHour(), value.getMinute(), value.getSecond());
        return calendar.getTime();
    }

    public static LocalDateTime sqlDateToLocalDateTime(java.sql.Date value) {
       /* Calendar calendar = Calendar.getInstance();
        calendar.setTime(value);
        LocalDateTime localDateTime = LocalDateTime.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));
        return localDateTime;*/
        return  LocalDateTime.ofInstant(value.toInstant(), ZoneId.of("Asia/Shanghai"));
    }

    public static java.sql.Date localDateTimeToSqlDate(LocalDateTime value) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(value.getYear(), value.getMonthValue()-1, value.getDayOfMonth(), value.getHour(), value.getMinute(), value.getSecond());
        return new java.sql.Date(calendar.getTimeInMillis());
    }
    public static LocalDateTime sqlTimestampToLocalDateTime(java.sql.Timestamp value) {
       /* Calendar calendar = Calendar.getInstance();
        calendar.setTime(value);
        LocalDateTime localDateTime = LocalDateTime.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));
        return localDateTime;*/
        return  LocalDateTime.ofInstant(value.toInstant(),ZoneId.of("Asia/Shanghai"));
    }
    public static java.sql.Timestamp localDateTimeToSqlTimestamp(LocalDateTime value) {
        Instant instant = value.toInstant(ZoneOffset.of("+08:00"));
        return java.sql.Timestamp.from(instant);
    }

    public static LocalDate sqlDateToLocalDate(java.sql.Date value) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(value);
        return  LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
    }

    public static java.sql.Date localDateToSqlDate(LocalDate value) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(value.getYear(), value.getMonthValue()-1, value.getDayOfMonth());
        return new java.sql.Date(calendar.getTimeInMillis());
    }
    public static LocalDate sqlTimestampToLocalDate(java.sql.Timestamp value) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(value);
        return LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
    }

    public static java.sql.Timestamp localDateToSqlTimestamp(LocalDate value) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = value.atStartOfDay().atZone(zone).toInstant();
        return java.sql.Timestamp.from(instant);
    }

    public static long calculateTimeDuration(LocalDateTime beginTime, LocalDateTime endTime) {
        return calculateTimeDuration(beginTime, endTime, ChronoUnit.MINUTES);
    }

    public static long calculateTimeDuration(LocalDateTime beginTime, LocalDateTime endTime, ChronoUnit unit) {
        return unit.between(beginTime,endTime);
    }

    public static LocalDateTime adjustInToEarlyMorning(LocalDateTime dateTime){
        return dateTime.withHour(0).withMinute(0).withSecond(0);
    }
    public static LocalDateTime adjustInToMidnight(LocalDateTime dateTime){
        return dateTime.withHour(23).withMinute(59).withSecond(59);
    }


    /**
     * Date to time stamp
     * @param dateTime 2017-11-11 11:11:11
     * @return stamp
     * @throws ParseException
     */
    public static Long dateToStamp(String dateTime) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(dateTime);
        long ts = date.getTime();
        return ts;
    }


    /**
     * Time stamp to date
     * @param timestamp
     * @return
     */
    public static String stampToDate(Long timestamp){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(timestamp);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
}