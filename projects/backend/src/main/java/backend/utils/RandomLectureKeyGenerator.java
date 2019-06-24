package backend.utils;

import java.nio.charset.Charset;
import java.util.Random;

public class RandomLectureKeyGenerator {
  public static String generate() {
    byte[] array = new byte[8];
    new Random().nextBytes(array);
    return new String(array, Charset.forName("UTF-8"));
  }
}
