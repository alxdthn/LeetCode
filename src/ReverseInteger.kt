import kotlin.math.absoluteValue

class ReverseInteger {
    fun reverse(x: Int): Int {
        var num: Int
        val sing: Int

        if (x < 0) {
            num = -x
            sing = -1
        } else {
            num = x
            sing = 1
        }
        var ans = 0
        while (num > 0) {
            ans = ans * 10 + num % 10
            num /= 10
        }
        return ans * sing
    }

    fun runTests() {
        Test(::reverse).apply {
            run(123, 321)
            run(-123, -321)
            run(120, 21)
            run(0, 0)
            run(654321, 123456)
            run(1534236469, 0)
        }
    }

    class Test(private val testFun: (Int) -> Int) {
        var testCounter = 1
        fun run(value: Int, answer: Int) {
            try {
                val out = testFun.invoke(value)
                if (out == answer) {
                    println("TEST ${testCounter++}: DONE")
                } else {
                    println("TEST ${testCounter++}: FAILED in: $value, out: $out, expected: $answer")
                }
            } catch (e: Throwable) {
                println("TEST ${testCounter++}: FAILED:")
                e.printStackTrace()
            }
        }
    }
}