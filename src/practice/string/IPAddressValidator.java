package practice.string;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class IPAddressValidator {
    private static Pattern VALID_IPV4_PATTERN = null;
    private static Pattern VALID_IPV6_PATTERN = null;
    private static final String ipv4Pattern = "(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])";
    private static final String ipv6Pattern = "([0-9a-f]{1,4}:){7}([0-9a-f]){1,4}";

    static {
        try {
            VALID_IPV4_PATTERN = Pattern.compile(ipv4Pattern, Pattern.CASE_INSENSITIVE);
            VALID_IPV6_PATTERN = Pattern.compile(ipv6Pattern, Pattern.CASE_INSENSITIVE);
        } catch (PatternSyntaxException e) {
            //logger.severe("Unable to compile pattern", e);
        }
    }

    public static boolean isIpAddress(String ipAddress) {

        Matcher m1 = VALID_IPV4_PATTERN.matcher(ipAddress);
        if (m1.matches()) return true;
        Matcher m2 = VALID_IPV6_PATTERN.matcher(ipAddress);
        return m2.matches();
    }

    private static boolean isValidIPv4Address(String ip) {
        String[] groups = ip.split("\\.");
        if (groups.length != 4) return false;
        try {
            return Arrays.stream(groups)
                    .map(String::trim)
                    .filter(s -> !(s.length() > 1 && s.startsWith("0")))
                    .peek(System.out::println)
                    .map(Integer::parseInt)
                    .filter(i -> (i >= 0 && i <= 255))
                    .count() == 4;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isValidIPv6Address(String ip) {
        String[] groups = ip.split(":");
        if (groups.length != 8) return false;
        if (ip.endsWith(":") || ip.startsWith(":")) return false;
        try {
            return Arrays.stream(groups)
                    .filter(s -> s.length() >= 1 && s.length() <= 4)
                    .filter(s -> {
                        for (int i = 0; i < s.length(); i++) {
                            char ch = s.charAt(i);
                            if ((ch >= 'a' && ch <= 'f') || (ch >= 'A' && ch <= 'F') || (ch >= '0' && ch <= '9')) continue;
                            else return false;
                        }
                        return true;
                    })
                    .count() == 8;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String validIPAddress(String queryIP) {
        if (isValidIPv4Address(queryIP)) return "IPv4";
        if (isValidIPv6Address(queryIP)) return "IPv6";
        return "Neither";
    }

    public static void main(String[] args) {
        String queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334";
        String ip2 = "256.256.256.256";
        String ip3 = "2001:0db8:85a3:0:0:8A2E:0370::7334";
        String ip4 = "192.0.0.1";
        IPAddressValidator ipAddressValidator = new IPAddressValidator();
        System.out.println(ipAddressValidator.validIPAddress(ip4));
    }
}
