package part4.time;

import java.util.*;

public class CalendarTest{
    public String hundredDaysAfter(){
        //오늘부터 100일 뒤의 날짜를 "2016년1월1일"의 형식으로 return하세요.
        Calendar cal = Calendar.getInstance();
        
        cal.add(Calendar.DATE, 100);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int date = cal.get(Calendar.DATE);
    	
        StringBuffer sb = new StringBuffer();
        sb.append(year);
        sb.append("년");
        sb.append(month);
        sb.append("월");
        sb.append(date);
        sb.append("일");
        
    	return sb.toString();
    }
    public static void main(String[] args){}
}