package backend.utils;

import java.nio.charset.Charset;
import java.util.Random;

public class RandomKeyGenerator {
  public static String generate() {
    int leftLimit = 97;
    int rightLimit = 122;
    int targetStringLength = 8;
    Random random = new Random();
    StringBuilder buffer = new StringBuilder(targetStringLength);
    for (int i = 0; i < targetStringLength; i++) {
      int randomLimitedInt = leftLimit + (int)
        (random.nextFloat() * (rightLimit - leftLimit + 1));
      buffer.append((char) randomLimitedInt);
    }
    return buffer.toString();
  }
}
