package dao;

import entity.rates;

import java.util.List;

public interface RateDao {
    public List<rates> selets(String fromDate, String toDate, String money);
}
