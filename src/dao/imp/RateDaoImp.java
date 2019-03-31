package dao.imp;

import dao.RateDao;
import entity.rates;
import mySQL.MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author liujinjin
 */
public class RateDaoImp implements RateDao {
    private Connection con = null;

    @Override
    public List<rates> selets(String fromDate, String toDate, String money) {
        List<rates> list = new ArrayList<>();
        con = MySQL.conn();
        //找出开始日期的前一个数据库记录
        String sql = "select * from tb_rate as t where eff_date = (select max(eff_date) from tb_rate as t1  where eff_date < ?) ";
        setRateList(list, sql,fromDate,null);
        //找出开始结束日期之间的数据库记录
        sql = "select*from tb_rate where eff_date >= ? AND eff_date <= ? order by eff_date";
        setRateList(list,sql,fromDate,toDate);
        return list;
    }

    /**
    进行SQL语句查询并将结果存入list中
     */
    private void setRateList(List<rates> list,String sql, String fromDate, String toDate){
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, fromDate);

            //区分是哪个SQL语句
            if(toDate!=null){
                ps.setString(2, toDate);
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                rates ty = new rates();
                //获取结果集中的rate（利率）和eff_date（日期）
                ty.setRate(rs.getInt("rate"));
                ty.setDate(rs.getString("eff_date"));
                list.add(ty);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
