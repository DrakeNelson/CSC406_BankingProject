package DatabaseObjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by user on 12/8/2016.
 */
public class Check {
    @SerializedName("Date")
    @Expose
    String date;
    @SerializedName("OrderOf")
    @Expose
    String orderOf;
    @SerializedName("Amount")
    @Expose
    double amt;
    @SerializedName("AccountID")
    @Expose
    String accountID;
    @SerializedName("CheckNumber")
    @Expose
    double checkNum;
    @SerializedName("Memo")
    @Expose
    String memo;

    public Check(String Date, String OrderOf, Double Amount, String AccountID, Double CheckNumber, String Memo) {
        this.date = Date;
        this.orderOf = OrderOf;
        this.amt = Amount;
        this.accountID = AccountID;
        this.checkNum = CheckNumber;
        this.memo = Memo;
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
