package jh.zkj.com.yf.Mutils;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Description: 对不同日期和时间的格式方法的封装
 */

public class DateUtil {


    private static DateUtil instance;

    private DateUtil() {

    }

    public static DateUtil getInstance() {
        if (instance == null) {
            synchronized (DateUtil.class) {
                if (instance == null) {
                    instance = new DateUtil();
                }
            }
        }
        return instance;
    }


    /**
     * 通过long类型的值返回当前的 星期几
     *
     * @param time
     * @return
     */
    public String getWeekday(long time) {
        Calendar calen = Calendar.getInstance();
        calen.setTimeInMillis(time);
        int week = calen.get(Calendar.DAY_OF_WEEK);
        String result = "星期一";
        switch (week) {
            case Calendar.SUNDAY:
                result = "星期日";
                break;
            case Calendar.MONDAY:
                result = "星期一";
                break;
            case Calendar.TUESDAY:
                result = "星期二";
                break;
            case Calendar.WEDNESDAY:
                result = "星期三";
                break;
            case Calendar.THURSDAY:
                result = "星期四";
                break;
            case Calendar.FRIDAY:
                result = "星期五";
                break;
            case Calendar.SATURDAY:
                result = "星期六";
                break;
            default:
                result = "星期一";
                break;
        }
        return result;
    }

    /**
     * 判断两个时间是否属于同一天
     *
     * @param time1
     * @param time2
     * @return
     */
    public boolean isSameDay(long time1, long time2) {
        Calendar calen = Calendar.getInstance();
        calen.setTimeInMillis(time1);
        int day1 = calen.get(Calendar.DAY_OF_YEAR);
        calen.setTimeInMillis(time2);
        int day2 = calen.get(Calendar.DAY_OF_YEAR);
        return day1 == day2;
    }

    /**
     * @param time
     * @return
     * @描述: 2017-02-23
     */
    public String getDayOrMonthOrYear(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date(time));
    }

    /**
     * @param time
     * @return
     * @描述: 2017年02月23日
     */
    public String getDayOrMonthOrYear1(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年-MM月-dd日");
        return sdf.format(new Date(time));
    }

    /**
     * @param time
     * @return
     * @描述: 2017年02月23日
     */
    public String getDayOrMonthOrYear2(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        return sdf.format(new Date(time));
    }

    /**
     * @param time
     * @return
     * @描述: 2017/02/23
     */
    public String getDayOrMonthOrYear3(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        return sdf.format(new Date(time));
    }

    /**
     * @param time
     * @return
     * @描述: 2017.02.23
     */
    public String getDayOrMonthOrYear4(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        return sdf.format(new Date(time));
    }

    /**
     * @param time
     * @return
     * @描述: 2017-02-23 06:26:12
     */
    public String dateFormat2(long time) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
                .format(new Date(time));
    }

    public String dateFormat(long time) {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                .format(new Date(time));
    }

    /**
     * @param time
     * @return
     * @描述: 2017年02月23日06点26分12秒
     */
    public String dateFormat3(long time) {
        return new SimpleDateFormat("yyyy年MM月dd日HH点mm分ss秒", Locale.getDefault())
                .format(new Date(time));
    }


    /**
     * @param
     * @return
     * @描述: 2017-02-23 06:26:12  倒计时格式
     */
    public String dateFormat4(long mss) {
        long hours = mss / (1000 * 60 * 60);
        long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
        long seconds = (mss % (1000 * 60)) / 1000;
        return hours + ":" + minutes + ":"
                + seconds;
    }

    public String dateFormat5(long mss) {
        long hours = mss / (1000 * 60 * 60);
        long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
        long seconds = (mss % (1000 * 60)) / 1000;
        return hours + "时" + minutes + "分"
                + seconds + "秒";
    }

    //获取本周的开始时间
    public Date getBeginDayOfWeek() {
        Date date = new Date();
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayofweek == 1) {
            dayofweek += 7;
        }
        cal.add(Calendar.DATE, 2 - dayofweek);
        return getDayStartTime(cal.getTime());
    }

    //获取本月的开始时间
    public Date getBeginDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(getNowYear(), getNowMonth() - 1, 1);
        return getDayStartTime(calendar.getTime());
    }

    //获取某个日期的开始时间
    public  Timestamp getDayStartTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if (null != d) calendar.setTime(d);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }

    //获取今年是哪一年
    public  Integer getNowYear() {
        Date date = new Date();
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(date);
        return Integer.valueOf(gc.get(1));
    }

    //获取本月是哪一月
    public  int getNowMonth() {
        Date date = new Date();
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(date);
        return gc.get(2) + 1;
    }


    // string类型转换为date类型
    // strTime要转换的string类型的时间，formatType要转换的格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日
    // HH时mm分ss秒，
    // strTime的时间格式必须要与formatType的时间格式相同
    public Date stringToDate(String strTime, String formatType)
            throws ParseException, java.text.ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        Date date = null;
        date = formatter.parse(strTime);
        return date;
    }
}
