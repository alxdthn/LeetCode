class LengthOfLongestSubstring {
	fun lengthOfLongestSubstring(s: String): Int {
		var i = 0
		var res = 0
		val len = s.length
		val hash = mutableMapOf<Char, Boolean>()
		while (i < len && len - i > res) {
			var tmp = 0
			hash.clear()
			for (j in i until len) {
				if (hash[s[j]] != null) {
					break
				} else {
					hash[s[j]] = true
				}
				tmp++
			}
			res = Math.max(res, tmp)
			i++
		}
		return res
	}
}