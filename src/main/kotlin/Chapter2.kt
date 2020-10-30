/**
 * @author Jongkook
 * @date : 2020/10/15
 */

fun main() {
    var x: Int
    x = if (10 > 20) {
        doSomething()
        25
    } else if (12 > 14) {
        26
    } else {
        27
    }
    println("$x is x")

    learnWhen()
}

fun doSomething() {
    var a = 6
    println("$a")
}

fun learnWhen() {
    val x = 10
    val y = ob(15, true, 500)
    when (x) {
        magicNum(x) -> println("magic number")
        in (1..10) -> println(
            """
            1..10
            value : ${if (x < 20) x else 0}
        """.trimIndent()
        )
        !in (1..10) -> println("Not 1~10")
        else -> println("else...")
    }

    when (y.value) {
        magicNum(y.value) -> println("$y is a magic number and ${if (y.valid) "valid" else "invalid"}")
        in (1..10) -> println(
            """
            1..10
            value : ${if (y.value < y.max) y.value else y.max}
        """.trimIndent()
        )
        !in (1..10) -> println("Not 1~10")
        else -> println("else...")
    }

    /**
     * also 함수를 이용한 swap 함수 만들기
     */
    var a = 1
    var b = 2
    a = b.also { b = a }
    println(a)
    println(b)

    /**
     * 다중 조건 반복문
     * takeWhile : 주어진 조건을 만족하는 첫번째 요소 그룹을 반환. 그래서 12는 반환이 안됨.
     * asSequence : 지연처리
     */
    var numbers = arrayOf(5, 6, 7, 1, 2, 3, 12, 1)
    (0..9).asSequence().takeWhile {
        println(it)
        it < numbers[it]
    }.forEach {
        println("$it - ${numbers[it]}")
    }
}

fun magicNum(a: Int): Int {
    return if (a in (15..25)) a else 0
}

data class ob(val value: Int, val valid: Boolean, val max: Int)