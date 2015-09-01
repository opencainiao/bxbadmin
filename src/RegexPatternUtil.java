

import java.util.regex.Pattern;

public class RegexPatternUtil {

	/***
	 * 获取用于like的正则表达式
	 * 
	 * @param strIn
	 * @return
	 */
	public static Pattern getLikePattern(String strIn) {

		String use = null;

		if (strIn == null || strIn.trim().length() == 0) {
			use = "";
		} else {
			use = strIn.trim();
		}

		return Pattern.compile(".*" + use + ".*", Pattern.CASE_INSENSITIVE);
	}
}
