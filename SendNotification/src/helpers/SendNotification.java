package helpers;

import java.util.List;
import models.User;

public class SendNotification<T extends User>
{
    List<T> users;
    String message;

    public SendNotification(List<T> users,String message)
    {
        this.users = users;
        this.message = message;
    }

    public void send()
    {
        for(T user : users)
        {
            System.out.println("Send To: " + user.name +", Message = " + message + ", Dept = " + user.dept);
        }
    }
}
