// len_s and len_t are the number of characters in string s and t respectively
public class Suggestion1 {
	public int LevenshteinDistance(String s, String t, int len_s, int len_t) {
		int cost;
		int result = -1;
		int j = java.lang.Math.max(len_s,len_t);

		if (len_s ==0 || len_t == 0) {
			if (len_s == 0) {
				result = len_t;
			} else {
				result = len_s;
			}
		} else {

			for (int i = 0; i < j; i++) {
				if (s.substring(len_s-1) == t.substring(len_t-1)) {
					cost = 0;
					} else {
					cost = 1;
					}
				result = java.lang.Math.min(java.lang.Math.min(LevenshteinDistance(s, len_s - 1, t, len_t) + 1,
                 LevenshteinDistance(s, len_s    , t, len_t - 1) + 1),
                 LevenshteinDistance(s, len_s - 1, t, len_t - 1) + cost);
                }
			}


		return result;
	}
}
