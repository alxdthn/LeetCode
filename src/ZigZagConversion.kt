class ZigZagConversion {
	fun convert(s: String, numRows: Int): String {
		val columnOffset = (numRows - 1) * 2
		if (columnOffset == 0) return s
		val len = s.length
		val answer = StringBuilder()
		for (row in 0 until numRows) {
			var i = row
			while (i < len) {
				answer.append(s[i])
				val x = (i + columnOffset) - row * 2
				if (row != 0 && row != numRows - 1 && x < len) {
					answer.append(s[x])
				}
				i += columnOffset
			}
		}
		return answer.toString()
	}

	fun runTests() {
		Test(::convert).apply {
			//run("0123456789", 4, "PAHNAPLSIIGYIR")
			//run("A", 1, "A")
			run("AB", 1, "AB")
			run("ABC", 2, "ACB")
			run("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR")
			run("PAYPALISHIRING", 4, "PINALSIGYAHRPI")
		}
	}

	class Test(private val testFun: (String, Int) -> String) {
		var testCounter = 1
		fun run(str: String, rows: Int, answer: String) {
			try {
				val out = testFun.invoke(str, rows)
				if (out == answer) {
					println("TEST ${testCounter++}: DONE")
				} else {
					println("TEST ${testCounter++}: FAILED in: $str rows: $rows, out: $out, expected: $answer")
				}
			} catch (e: Throwable) {
				println("TEST ${testCounter++}: FAILED:")
				e.printStackTrace()
			}
		}
	}
}