package week5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class findMostUsedWord {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Kullanıcıdan metni al
            System.out.println("Lütfen bir metin giriniz:");
            String inputText = scanner.nextLine();

            // Metni kelimelere ayır
            String[] words = inputText.split("\\s+");

            // Kelimeleri saymak için HashMap kullan
            HashMap<String, Integer> wordCountMap = new HashMap<>();

            for (String word : words) {
                word = word.toLowerCase();  // Kelimeleri küçük harfe dönüştür
                if (wordCountMap.containsKey(word)) {
                    wordCountMap.put(word, wordCountMap.get(word) + 1);
                } else {
                    wordCountMap.put(word, 1);
                }
            }

            // En çok geçen kelimeyi bul
            String mostFrequentWord = null;
            int maxCount = 0;

            for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
                if (entry.getValue() > maxCount) {
                    mostFrequentWord = entry.getKey();
                    maxCount = entry.getValue();
                }
            }

            // Sonucu ekrana yazdır
            System.out.println("Metinde en çok geçen kelime: " + mostFrequentWord + " (Geçme sayısı: " + maxCount + ")");
        }
    }


