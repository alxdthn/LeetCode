import java.lang.StringBuilder

class Atoi {

    fun myAtoi(str: String): Int {
        var res: Long = 0
        var i = 0
        val len = str.length

        while (i < len && str[i].isSpace()) i++

        val sing = when (str[i]) {
            '-' -> {
                i++
                -1
            }
            '+' -> {
                i++
                1
            }
            else -> 1
        }

        while (i < len && str[i].isDigit()) {
            res = res * 10 + str[i++].toInt() - 48
        }
        return res.toInt() * sing
    }

    private fun Char.isDigit(): Boolean {
        return this in '0'..'9'
    }

    private fun Char.isSpace(): Boolean {
        return this == ' ' || this == '\t' || this == '\r'
    }

    fun runTests() {
        Test(::myAtoi).apply {
            run("0", 0)
            run("-1", -1)
            run("1", 1)
            run("10", 10)
            run("255", 255)
            run("512512", 512512)
            run("  -51512521", -51512521)
            run("512ss", 512)
            run("\t\t \t-1120", -1120)
            run("- -51", 0)
            run("+-51", 0)
            run("--51", 0)
            run("-+51", 0)
            run("++51", 0)
            run("+a", 0)
            run("+42", 42)
            run("++42", 0)
            run("--42", 0)
            run("4202-1", 4202)
        }
    }

    class Test(private val testFun: (String) -> Int) {
        var testCounter = 1
        fun run(str: String, answer: Int) {
            try {
                val out = testFun.invoke(str)
                if (out == answer) {
                    println("TEST ${testCounter++}: DONE")
                } else {
                    println("TEST ${testCounter++}: FAILED in: $str, out: $out, expected: $answer")
                }
            } catch (e: Throwable) {
                println("TEST ${testCounter++}: FAILED:")
                e.printStackTrace()
            }
        }
    }
}