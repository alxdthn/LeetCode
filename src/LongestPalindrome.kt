class LongestPalindrome {
	private var palSize = 0
	private var palLeft = 0

	fun longestPalindrome(s: String): String {
		palLeft = 0
		palSize = 0
		val length = s.length
		if (length < 2) return s
		for (i in 0 until length) {
			getPalindrome(i, i + 1, s, length, 0)
			if (i > 0) {
				getPalindrome(i - 1, i + 1, s, length, 1)
			}
			if (palSize >= length) break
		}
		return s.substring(palLeft, palLeft + palSize)
	}

	private fun getPalindrome(startLeft: Int, startRight: Int, s: String, len: Int, startPal: Int) {
		var left = startLeft
		var right = startRight
		var pal = startPal
		while (left >= 0 && right < len) {
			if (s[left] == s[right]) {
				pal += 2
			} else break
			right++
			left--
		}
		if (pal >= palSize) {
			palSize = pal
			palLeft = left + 1
		}
	}

	fun runTests() {
		Test(::longestPalindrome).apply {
			run("a", "a")
			run("aa", "aa")
			run("aca", "aca")
			run("aaaacc", "aaaa")
			run("cacac", "cacac")
			run("xafvfaxxafvfa", "afvfaxxafvfa")
			run("ababababa", "ababababa")
		}
	}

	class Test(private val testFun: (s: String) -> String) {
		var testCounter = 1
		fun run(arg: String, answer: String) {
			try {
				val out = testFun.invoke(arg)
				if (out == answer) {
					println("TEST ${testCounter++}: DONE")
				} else {
					println("TEST ${testCounter++}: FAILED in: $arg, out: $out, expected: $answer")
				}
			} catch (e: Throwable) {
				println("TEST ${testCounter++}: FAILED:")
				e.printStackTrace()
			}
		}
	}
}