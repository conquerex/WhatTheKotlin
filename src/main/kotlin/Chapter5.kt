/**
 * @author Jongkook
 * @date : 2020/10/30
 */

fun main(args: Array<String>) {
    /**
     * 코틀린의 인터페이스
     */
    var interfaceImple = InterfaceImple()
    interfaceImple.impleMethod()

    var ii = InterfaceImplementation()
    ii.bar()
    ii.foo()

    var interfaceimpl = InterfaceImpl(object : A {})
    interfaceimpl.someMethod()

    /**
     * 코틀린에서 다중 오버라이드된 메소드로 복잡한 인터페이스를 구현하는 방법
     */
    Simple().callMethod()

    /**
     * 클래스 확장하기(상속 및 확장 함수)
     */
    BBB("hi").foo()

    /**
     * 코틀린에서 제네릭을 사용하는 방법
     */
    val intA: GenCl<Int> = GenCl(10)
    println(intA.a)
    // 코틀린 컴파일러가 타입을 추론하게 한다.
    val strgen = GenCl("String....")
    println(strgen.a)

    fun <T> addTwo(a: List<T>) {
        for (x in a) {
            println(x)
        }
    }

    addTwo(listOf(2, 3, 4, 5))
    addTwo(listOf("aa", "bbb", "ccccc"))

    /**
     * 코틀린에서 다형성을 구현하는 방법
     */
    println(doubleOf(4))
    println(doubleOf(4.3))
    println(doubleOf(4.222))

    var a = Sup()
    a.method1()
    a.method2()
    var b = Sum()
    b.method1()
    b.method2()

}

open class Sup {
    open fun method1() {
        println("Printing 1..... indide Sup")
    }

    fun method2() {
        println("Printing 2..... indide Sup")
    }
}

class Sum : Sup() {
    override fun method1() {
        println("Printing 1..... indide sum!!!")
    }
}

fun doubleOf(a: Int): Int {
    println(1)
    return 2 * a
}

fun doubleOf(a: Float): Float {
    println(2)
    return 2 * a
}

fun doubleOf(a: Double): Double {
    println(3)
    return 2.00 * a
}

class GenCl<T>(t: T) {
    var a = t;
}

class DDD(str: String) : CCC() {
    override fun methodCCC() {
        TODO("Not yet implemented")
    }

}

abstract class CCC {
    abstract fun methodCCC()
    fun imple() {}
}

class BBB(text: String) : AAA(text) {
    override fun foo() {
        println("foooo from BBB")
    }
}

open class AAA(str: String) {
    open fun foo() {
        println("fooooo")
    }

    final fun bar() {
        println("barrrrrrr")
    }
}

class BB(val randomString: String) : AA(randomString)

class BB2 : AA {
    constructor(ran: String) : super(ran)
    constructor(ran: String, ranInt: Int) : super(ran)
}

open class AA(val str: String)

class Simple : A {
    fun callMethod() {
        bar()
    }
}

class InterfaceImpl2(val a: A) : A by a {
    fun someMethod() {
        foo()
    }
}

class InterfaceImpl(var a: A) {
    fun someMethod() {
        a.foo()
    }
}

class InterfaceImplementation : A, B {
    override fun bar() {
        super<A>.bar()
        super<B>.bar()
    }
}

interface A {
    fun foo() {
        println("foo from A")
    }

    fun bar() {
        println("bar from A")
    }
}

interface B {
    fun bar() {
        println("bar from B")
    }
}

interface DemoInterface {
    fun impleMethod() {
        println("From demo interface")
    }
}

class InterfaceImple : DemoInterface