package testPackage.test.Helpers;

import testPackage.test.common.BaseTest;
import java.security.SecureRandom;

public class DataHelper extends BaseTest {

  public static String generateRandomString(int stringLength) {
    String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    StringBuilder salt = new StringBuilder();
    SecureRandom random = new SecureRandom();
    while (salt.length() < stringLength) { // length of the random string.
      int index = (int) (random.nextFloat() * chars.length());
      salt.append(chars.charAt(index));
    }
    return salt.toString();
  }

  public static int generateRandomNumber(int number) {
    int randomNumber = (int) Math.floor(Math.random() * number);
    return randomNumber;
  }
}
