package dao;

import entity.result;

import java.util.List;

public interface RateDao {
    public List<result> selets(String fromDate, String toDate, String money);
}
