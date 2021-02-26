package neu.edu.his.bean;

public class ReceiptBean {
    private int receiptId;
    private int receiptSeqNum;
    private double cost;
    private String statement;
    private String date;
    private int RegisId;
    private String isDeleted;

    public int getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }

    public int getReceiptSeqNum() {
        return receiptSeqNum;
    }

    public void setReceiptSeqNum(int receiptSeqNum) {
        this.receiptSeqNum = receiptSeqNum;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getRegisId() {
        return RegisId;
    }

    public void setRegisId(int regisId) {
        RegisId = regisId;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }
}
