package APITest;

import pojo.CreateUser;
import pojo.Deposit;
import pojo.Send;
import pojo.Withdraw;

public class DataBuild {

    /*
        Contain methods to pass values for request body in an endpoint
        */
public CreateUser createUserPojo()
{
    CreateUser createUser=new CreateUser();
    createUser.setFirstName("John");
    createUser.setLastName("Doe");
    createUser.setEmail("johndoe@gmail.com");
    createUser.setPassword("Welcome@123");

return createUser;
}

public Deposit depositPojo()
{
    Deposit deposit=new Deposit();
    deposit.setUserid(1234);
    deposit.setAmount(200);
    return deposit;
}


    public Withdraw withdrawPojo()
    {
        Withdraw withdraw=new Withdraw();
        withdraw.setUserid(1234);
        withdraw.setAmount(200);
        return withdraw;
    }

    public Send sendPojo()
    {
        Send send=new Send();
        send.setSender_id(1234);
        send.setReceiver_id(3333);
        send.setAmount(100);
        return send;
    }
}
