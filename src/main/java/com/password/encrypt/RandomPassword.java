package com.password.encrypt;

import java.util.Random;

public class RandomPassword {

  public static void main(String[] args) {
    System.out.println(getRandomPassword());
  }

  public static String getRandomPassword() {
    String[] special = { "@", "#", "$", "%", "&", "*", ",", ".", ":" };
    String[] number = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
    String[] lowercase = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
            "s", "t", "u", "v", "w", "x", "y", "z" };

    String[] uppercase = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
            "S", "T", "U", "V", "W", "X", "Y", "Z" };

    boolean specialFlag = false;
    boolean numberFlag = false;
    boolean lowercaseFlag = false;
    boolean uppercaseFlag = false;
    int pwdLength = 12;
    StringBuilder pwd = new StringBuilder();
    for (int i = 0; i < pwdLength; ++i) {
      int index1 = new Random().nextInt(4);
      if (index1 == 0) {
        specialFlag = true;
        pwd.append(special[new Random().nextInt(special.length)]);
      } else if (index1 == 1) {
        numberFlag = true;
        pwd.append(number[new Random().nextInt(number.length)]);
      } else if (index1 == 2) {
        lowercaseFlag = true;
        pwd.append(lowercase[new Random().nextInt(lowercase.length)]);
      } else {
        uppercaseFlag = true;
        pwd.append(uppercase[new Random().nextInt(uppercase.length)]);
      }
    }
    if (!specialFlag) {
      pwd.append(special[new Random().nextInt(special.length)]);
    }
    if (!numberFlag) {
      pwd.append(number[new Random().nextInt(number.length)]);
    }
    if (!lowercaseFlag) {
      pwd.append(lowercase[new Random().nextInt(lowercase.length)]);
    }
    if (!uppercaseFlag) {
      pwd.append(uppercase[new Random().nextInt(uppercase.length)]);
    }
    return pwd.toString();
  }
}
