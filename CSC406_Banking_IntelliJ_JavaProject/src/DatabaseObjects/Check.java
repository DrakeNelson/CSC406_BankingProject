package DatabaseObjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by user on 12/8/2016.
 */
public class Check {
    @SerializedName("date")
    @Expose
    String date;
    @SerializedName("orderOf")
    @Expose
    String orderOf;
    @SerializedName("amt")
    @Expose
    double amt;
    @SerializedName("accountID")
    @Expose
    String accountID;
    @SerializedName("checkNum")
    @Expose
    int checkNum;
    @SerializedName("memo")
    @Expose
    String memo;

    public Check(String Date, String OrderOf, Double Amount, String AccountID, int CheckNumber, String Memo) {
        this.date = Date;
        this.orderOf = OrderOf;
        this.amt = Amount;
        this.accountID = AccountID;
        this.checkNum = CheckNumber;
        this.memo = Memo;
    }

    public Check() {
        this.date = "asdf";
        this.orderOf = "asdf";
        this.amt = 12;
        this.accountID = "asdf";
        this.checkNum = 12;
        this.memo = "asdf";
    }

    public String getDate() {return this.date;}
    public void setDate(String date) {this.date = date;}
    public String getOrderOf() {return this.orderOf;}
    public void setOrderOf(String orderOf) {this.orderOf = orderOf;}
    public double getAmt() {return this.amt;}
    public void setAmt(double amt) {this.amt = amt;}
    public String getAccountID() {return this.accountID;}
    public void setAccountID(String accountID) {this.accountID = accountID;}
    public double getCheckNum() {return this.checkNum;}
    public void setCheckNum(int checkNum) {this.checkNum = checkNum;}
    public String getMemo() {return this.memo;}
    public void setMemo(String memo) {this.memo = memo;}
}
