package com.bridgelabz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebTable extends BaseClass {
    @Test
    public void test() throws InterruptedException {
        setting();
        List<WebElement> headings = driver.findElements(By.xpath("/html/body/div[1]/div[3]/div[1]/table/tbody"));

        Map<String, Integer> wordFrequency = new HashMap<>();

        for (WebElement heading : headings) {
            String[] words = heading.getText().split("\\s+");
            for (String word : words) {
                if (wordFrequency.containsKey(word)) {
                    wordFrequency.put(word, wordFrequency.get(word) + 1);
                } else {
                    wordFrequency.put(word, 1);
                }
            }
        }
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println("Word : " + entry.getKey() + " ---- Frequency : " + entry.getValue());
        }

        String mostCommonWord = "";
        int highestFrequency = 0;
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            if (entry.getValue() > highestFrequency) {
                mostCommonWord = entry.getKey();
                highestFrequency = entry.getValue();
            }
        }
        System.out.println();
        System.out.println("Most common words  :  " + mostCommonWord);
        System.out.println("Highest Frequency  :  " + highestFrequency);
        closeWindow();
    }
}

