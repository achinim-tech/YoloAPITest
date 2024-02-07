package pojo;

/*
POJO class for the Deposit endpoint request body
 */
public class Deposit {

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
