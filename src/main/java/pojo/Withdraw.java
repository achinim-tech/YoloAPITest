package pojo;

/*
POJO class for the Withdraw endpoint request body
 */
public class Withdraw {
    private int userid;
    private float amount;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
