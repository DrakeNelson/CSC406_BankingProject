package DatabaseObjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PurchasesThisMonth
{
    @SerializedName("PurchaseID")
    @Expose
    String purchaseID;
    @SerializedName("PurchaseTitle")
    @Expose
    String purchaseTitle;
    @SerializedName("PurchaseLocation")
    @Expose
    String purchaseLocation;
    @SerializedName("PurchaseAmt")
    @Expose
    double purchaseAmt;
    public double getPurchaseAmt() {
        return this.purchaseAmt;
    }
    public void setPurchaseAmt(double purchaseAmt) {
        this.purchaseAmt = purchaseAmt;
    }
    public String getPurchaseLocation() {
        return this.purchaseLocation;
    }
    public void setPurchaseLocation(String purchaseLocation) {
        this.purchaseLocation = purchaseLocation;
    }
    public String getPurchaseTitle() {
        return this.purchaseTitle;
    }
    public void setPurchaseTitle(String purchaseTitle) {
        this.purchaseTitle = purchaseTitle;
    }
    public String getPurchaseID() {
        return this.purchaseID;
    }
    public void setPurchaseID(String purchaseID) {
        this.purchaseID = purchaseID;
    }
}
