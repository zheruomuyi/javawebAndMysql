package server;

import dao.imp.RateDaoImp;
import entity.rates;
import entity.result;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author liujinjin
 * 将查询集处理并输出结果
 */
public class Server {
    public List<result> rateHandle(String fromDate, String toDate, String money) {
        RateDaoImp rateDaoImp = new RateDaoImp();
        List<rates> list = rateDaoImp.selets(fromDate, toDate, money);
        List<result> listr = new ArrayList<>();
//      将字符串按照格式转换成日期并计算相隔天数
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date firstdate = null;
        Date seconddate = null;
        try {
            firstdate = format.parse(fromDate);
            seconddate = format.parse(toDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int countday = getDays(firstdate, seconddate);
        BigDecimal m = new BigDecimal(money);
        BigDecimal mcopy = m;
        BigDecimal percent = new BigDecimal("100");
        Date first = null;
        Date second = null;
        for (int i = 0; i <= list.size() - 1; i++) {
            try {
                if (i == 0) {
                    first = firstdate;
                } else {
                    first = format.parse(list.get(i).getDate());
                }
                if (i == list.size() - 1) {
                    second = seconddate;
                } else {
                    second = format.parse(list.get(i + 1).getDate());
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            BigDecimal imcopy = m;
            System.out.println("imcopy" + imcopy);
            int cd = getDays(first, second);
            if (i == list.size() - 1) {
                cd++;
            }
            for (int j = 0; j < cd; j++) {
                m = m.multiply(new BigDecimal(list.get(i).getRate() + 100)).divide(new BigDecimal(100), 3, BigDecimal.ROUND_HALF_UP);

            }
            String fdate = format.format(first);
            String sdate = format.format(second);
            BigDecimal imoney = m.subtract(imcopy);
            System.out.println("m" + m);
            BigDecimal irate = imoney.divide(imcopy, 3, BigDecimal.ROUND_HALF_UP).multiply(percent);

            setList(listr, fdate, imcopy, sdate, m, imoney, irate, cd);
        }
        BigDecimal summoney = m.subtract(mcopy);
        BigDecimal sumrate = summoney.divide(mcopy, 3, BigDecimal.ROUND_HALF_UP).multiply(percent);

        setList(listr, fromDate, mcopy, toDate, m, summoney, sumrate, countday + 1);
        return listr;
    }

    private void setList(List<result> list, String fdate,BigDecimal beginmoney,String sdate, BigDecimal endmoney,BigDecimal rate,BigDecimal money,int days){
        result rs = new result();
        rs.setFromDate(fdate);
        rs.setBeginmoney(beginmoney);
        rs.setToDate(sdate);
        rs.setEndmoney(endmoney);
        rs.setRate(money);
        rs.setRatemoney(rate);
        rs.setDays(days);
        list.add(rs);
    }

    private int getDays(Date firstdate, Date seconddate){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(firstdate);
        int countday = 0;
        while (calendar.getTime().compareTo(seconddate) != 0) {
            calendar.add(Calendar.DATE, 1);
            countday++; //相隔天数
        }
        return countday;

    }
}
