package jep440;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class RecordPatternTest {

  record PrivateAccount(String owner, AccountNumber accountNumber) {}

  record AccountNumber(String number) {}

  @Test
  void testNestedRecordPattern() {
    Object account = createPrivateAccount();
    if (account instanceof PrivateAccount(String holder, AccountNumber(String number))) {
      assertThat(holder).isEqualTo("jack");
      assertThat(number).isEqualTo("account-11");
      return;
    }
    fail("expectations were not fulfilled");
  }

  private Object createPrivateAccount() {
    return new PrivateAccount("jack", new AccountNumber("account-11"));
  }
}
