import java.util.*;

class Program {
	// O(1) time | O(1) space
  public ArrayList<String> validIPAddresses(String string) {
    // Write your code here.
		ArrayList<String> validIpAddresses = new ArrayList<String>();
		for (int i = 1; i < Math.min(string.length(), 4); i++) {
			String[] parts = new String[] {"", "", "", ""};
			parts[0] = string.substring(0, i);
			if (!isValidPart(parts[0])) {
				continue;
			}
			for (int j = i + 1; j < i + Math.min(string.length() - i, 4); j++) {
				parts[1] = string.substring(i, j);
				if (!isValidPart(parts[1])) {
					continue;
				}
				for (int k = j + 1; k < j + Math.min(string.length() - j, 4); k++) {
					parts[2] = string.substring(j, k);
					parts[3] = string.substring(k);
					if (isValidPart(parts[2]) && isValidPart(parts[3])) {
						validIpAddresses.add(String.join(".", parts));
					}
				}
			}
		}
    return validIpAddresses;
  }
	
	private static boolean isValidPart(String part) {
		int value = Integer.parseInt(part);
		if (value > 255) {
			return false;
		}
		return part.length() == Integer.toString(value).length();
	}
}
