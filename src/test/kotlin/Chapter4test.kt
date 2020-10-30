import org.junit.Test

/**
 * @author Jongkook
 * @date : 2020/10/29
 */

class Chapter4test {
    @Test
    fun funLiteralTest() {
        var str1 = "The start of a "
        val addStr = fun String.(succesor: String): Int {
            return this.length + succesor.length
        }

        var x = str1.addStr("bad day.")
        println(x)

        fun testIfEqual(
            op: (String, String) -> Int,
            a: String,
            b: String,
            c: Int
        ) = assert(op(a, b) == c)

        testIfEqual(addStr, str1, "nice day.", str1.length + "nice day.".length)
    }
}