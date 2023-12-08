package com;
import java.util.HashMap;
import java.util.Map;

public class LinkShortener {
    private Map<String, String> shortToLongMap = new HashMap<>();
    private Map<String, String> longToShortMap = new HashMap<>();
    private static final String BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public String shortenLink(String longUrl) {
        if (longToShortMap.containsKey(longUrl)) {
            return longToShortMap.get(longUrl);
        }

        String shortUrl = generateShortUrl();
        shortToLongMap.put(shortUrl, longUrl);
        longToShortMap.put(longUrl, shortUrl);

        return shortUrl;
    }

    public String getLongUrl(String shortUrl) {
        return shortToLongMap.get(shortUrl);
    }

    private String generateShortUrl() {
        // Implement your base62 encoding logic here
        // Example: Using a simple counter for demonstration purposes
        // In a real-world scenario, you may want to use a more sophisticated method.
        int counter = shortToLongMap.size();
        StringBuilder shortUrl = new StringBuilder();
        while (counter > 0) {
            shortUrl.append(BASE62.charAt(counter % BASE62.length()));
            counter /= BASE62.length();
        }
        return shortUrl.reverse().toString();
    }

    public static void main(String[] args) {
        LinkShortener linkShortener = new LinkShortener();

        String longUrl = "https://www.example.com";
        String shortUrl = linkShortener.shortenLink(longUrl);

        System.out.println("Long URL: " + longUrl);
        System.out.println("Short URL: " + shortUrl);

        // Retrieve long URL using short URL
        String retrievedLongUrl = linkShortener.getLongUrl(shortUrl);
        System.out.println("Retrieved Long URL: " + retrievedLongUrl);
    }
}
