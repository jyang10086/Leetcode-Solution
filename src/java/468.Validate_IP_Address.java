class LC468 {
  /**
   * Given a string IP, return "IPv4" if IP is a valid IPv4 address,
   * "IPv6" if IP is a valid IPv6 address or "Neither" if IP is not a correct IP of any type.
   * <p>
   * A valid IPv4 address is an IP in the form "x1.x2.x3.x4" where 0 <= xi <= 255 and xi cannot contain leading zeros.
   * For example, "192.168.1.1" and "192.168.1.0" are valid IPv4 addresses but "192.168.01.1",
   * while "192.168.1.00" and "192.168@1.1" are invalid IPv4 addresses.
   * <p>
   * A valid IPv6 address is an IP in the form "x1:x2:x3:x4:x5:x6:x7:x8" where:
   * 1 <= xi.length <= 4
   * xi is a hexadecimal string which may contain digits, lower-case English letter ('a' to 'f') and upper-case English letters ('A' to 'F').
   * Leading zeros are allowed in xi.
   * For example, "2001:0db8:85a3:0000:0000:8a2e:0370:7334" and "2001:db8:85a3:0:0:8A2E:0370:7334" are valid IPv6 addresses, while "2001:0db8:85a3::8A2E:037j:7334" and "02001:0db8:85a3:0000:0000:8a2e:0370:7334" are invalid IPv6 addresses.
   */
  public String validIPAddress(String IP) {
    String[] ipv4 = IP.split("\\.");
    String[] ipv6 = IP.split(":");
    if (ipv4.length == 4) {
      for (String str : ipv4) {
        if (str.length() == 0 || str.length() > 3) return "Neither";
        if (str.charAt(0) == '0' && str.length() > 1) return "Neither";
        int subVal = 0;
        for (int i = 0; i < str.length(); i++) {
          char ch = str.charAt(i);
          if (!Character.isDigit(ch)) return "Neither";
          subVal = subVal * 10 + (ch - '0');
          if (subVal > 255) return "Neither";
        }
      }
      return "IPv4";
    }
    if (ipv6.length == 8 && IP.charAt(0) != ':' && IP.charAt(IP.length() - 1) != ':') {
      for (String str : ipv6) {
        if (str.length() < 1 || str.length() > 4) return "Neither";
        for (int i = 0; i < str.length(); i++) {
          char ch = str.charAt(i);
          if (Character.isDigit(ch)) continue;
          if (!(ch >= 'A' && ch <= 'F' || ch >= 'a' && ch <= 'f')) return "Neither";
        }
      }
      return "IPv6";
    }
    return "Neither";
  }

  public static void main(String[] args) {
    LC468 lc = new LC468();
    String res = lc.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:");
    System.out.println(res);
  }
}