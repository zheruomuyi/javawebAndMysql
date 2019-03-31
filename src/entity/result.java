package entity;

import java.math.BigDecimal;

public class result {
    private String fromDate;
    private String toDate;
    private BigDecimal beginmoney;
    private BigDecimal endmoney;
    private BigDecimal rate;
    private BigDecimal ratemoney;
    private int days;
    public BigDecimal getBeginmoney() {
        return beginmoney;
    }

    public void setBeginmoney(BigDecimal beginmoney) {
        this.beginmoney = beginmoney;
    }

    public BigDecimal getEndmoney() {
        return endmoney;
    }

    public void setEndmoney(BigDecimal endmoney) {
        this.endmoney = endmoney;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getRatemoney() {
        return ratemoney;
    }

    public void setRatemoney(BigDecimal ratemoney) {
        this.ratemoney = ratemoney;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
