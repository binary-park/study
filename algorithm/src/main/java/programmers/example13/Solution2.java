package programmers.example13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution2 {

  public String solution(String encrypted_text, String key, int rotation) {
    var encryptedTexts = encrypted_text.chars()
        .mapToObj(Character::toString)
        .collect(Collectors.toList());

    Collections.rotate(encryptedTexts, -rotation);


    List<String> decryptByKeys = new ArrayList<>();
    for (int i = 0; i < encryptedTexts.size(); i++) {
      char ch = encryptedTexts.get(i).charAt(0);
      var encrypted = String.valueOf(decryptByKey(ch, key.charAt(i)));
      decryptByKeys.add(encrypted);
    }

    return String.join("", decryptByKeys);
  }

  private char decryptByKey(char origin, char key) {
    var decrypt = (char) (origin - (key - 97 + 1));

    return decrypt < 97 ? (char) (decrypt + 26) : decrypt;
  }


  public static void main(String[] args) {
    Solution2 solution2 = new Solution2();
    var solution = solution2.solution("qyyigoptvfb", "abcdefghijk", 3);
    System.out.printf("");
  }
}

