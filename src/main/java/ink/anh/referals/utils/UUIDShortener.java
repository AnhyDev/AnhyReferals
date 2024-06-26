package ink.anh.referals.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.UUID;

public class UUIDShortener {
    public static String generateShortString(UUID uuid) {
        try {
            byte[] uuidBytes = uuid.toString().getBytes(StandardCharsets.UTF_8);
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(uuidBytes);
            String base64Encoded = Base64.getUrlEncoder().withoutPadding().encodeToString(hash);
            return "$" + base64Encoded.substring(0, 8);  // Додаємо символ долара на початок
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Не знайдено алгоритму хешування", e);
        }
    }
}
