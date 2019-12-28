class IsPalindrome {
	fun isPalindrome(x: Int): Boolean {
		return when {
			x < 0 -> false
			x < 10 -> true
			else -> {
				val len = x.length()
				var left = len
				var right = 1
				while (left != right && left > right) {
					if (x.digit(left--) != x.digit(right++)) {
						return false
					}
				}
				true
			}
		}
	}

	private fun Int.digit(value: Int) = this / 10.pow(value - 1) % 10

	private fun Int.length() = Math.ceil(Math.log10(toDouble())).toInt()

	private fun Int.pow(value: Int) = Math.pow(toDouble(), value.toDouble()).toInt()

	fun runTests() {
		Test(::isPalindrome).apply {
			run(212, true)
			run(-212, false)
			run(2122, false)
			run(22122, true)
			run(22, true)
			run(3333, true)
			run(33333, true)
			run(23333, false)
			run(122, false)
			run(42212, false)
			run(4224, true)
		}
	}

	class Test(private val testFun: (Int) -> Boolean) {
		var testCounter = 1
		fun run(x: Int, answer: Boolean) {
			try {
				val out = testFun.invoke(x)
				if (out == answer) {
					println("TEST ${testCounter++}: DONE")
				} else {
					println("TEST ${testCounter++}: FAILED in: $x, out: $out, expected: $answer")
				}
			} catch (e: Throwable) {
				println("TEST ${testCounter++}: FAILED:")
				e.printStackTrace()
			}
		}
	}
}