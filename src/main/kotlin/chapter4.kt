import packageA.chapter4_1

/**
 * @author Jongkook
 * @date : 2020/10/26
 */

//import packageA.*

fun main(args: Array<String>) {
    val sample = Sample()
    println(sample.isListBig)

    var s = SameClass()
    println(s.name)

    /**
     * 변수인수를 함수에 전달 *********************
     */
    someMethod("aa", "bbb", "c", "dddd", "eeee")
    val list = arrayOf("111", "222", "33", "4")
//    someMethod(*list)

    someMethod(3, *list)

    /**
     * 함수를 매개변수로 전달 *************************
     */
    val funcMultiply = { a: Int, b: Int -> a * b }
    val funcSum: (Int, Int) -> Int = { a: Int, b: Int -> a + b }
    println(funcMultiply(44, 3))
    val funcSayHi = { name: String -> println("Hi $name") }
    val funcSayHi2: (String) -> Unit = { name: String -> println("Hi $name") }
    funcSayHi("Mac")
    funcSayHi2("Kane")

    performMath(4, 5, funcSum)

    val price1 = 300
    val price2 = 100
    val total1 = totalCost(price1)
    val total2 = totalCost(price2)
    println("Cost for item1 is ${total1(price1)}")
    println("Cost for item1 is ${total2(price1)}")

    /**
     * 정적 함수 선언 *************************
     */
//    foo()
//    Foo.callFoo()
    chapter4_1.foo2()
}

fun totalCost(prodCost: Int): (Int) -> Int {
    if (prodCost > 199) {
        return { x -> x }
    } else {
        return { x -> x + 50 }
    }
}

fun performMath(a: Int, b: Int, mathFunc: (Int, Int) -> Int) {
    println("value of cal : ${mathFunc(a, b)}")
}

//fun someMethod(vararg a: String) {
//    // vararg : 컴파일러에게 전달받은 인수들을 배열로 래핑하도록 한
//    for (a_ in a) {
//        println(a_)
//    }
//}

fun someMethod(b: String, vararg a: String) {
    // vararg : 컴파일러에게 전달받은 인수들을 배열로 래핑하도록 한
    println("B:::: $b")
    for (a_ in a) {
        println(a_)
    }
}

fun someMethod(b: Int, vararg a: String) {
    // vararg : 컴파일러에게 전달받은 인수들을 배열로 래핑하도록 한
    for (a_ in a) {
        println(a_)
    }
}

class Sample {
    val array = mutableListOf<Int>(1, 3, 5)
    var isListBig: Boolean = false
        get() = array.size > 2
        private set(value) {
            // field 키워드는 backing field에 접근하는 데 사용되며,
            // 접근자 중 하나이상의 기본 구현을 사용하거나 사용자 정의 접근자가 field 식별자를 통해 이를 참조하는 경우 생성된다.
            // setter의 접근을 제한하려면 : private set(value)
            field = array.size > 2
        }
    val isListSmall get() = array.size < 2
}

class SameClass {
    var name = "kook"
        get() = field.toUpperCase()
}