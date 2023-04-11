import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    @Test
    public void testFeeAccount() {
        Account account = new FeeAccount(100.0) {
            @Override
            public void withdraw(double amount) {
                balance -= amount;
                transactionCount++;
            }
        };
        account.deposit(50.0);
        account.withdraw(25.0);
        account.withdraw(20.0);
        account.endMonth();
        assertEquals(100.0, account.getBalance());
    }

    @Test
    public void testNickleAndDimeAccount() {
        Account account = new NickleAndDimeAccount(100.0);
        account.deposit(50.0);
        account.withdraw(25.0);
        account.withdraw(25.0);
        account.withdraw(10.0);
        account.endMonth();
        assertEquals(88.5, account.getBalance());
    }

    @Test
    public void testGamblerAccount() {
        Account account = new GamblerAccount(100.0);
        account.deposit(50.0);
        account.withdraw(25.0);



        account.endMonth();
        if (((GamblerAccount) account).getRandom().nextDouble() <= 0.5) {
            assertEquals(125.0, account.getBalance());
        } else  {
            assertEquals(100, account.getBalance() );
        }

    }
}
