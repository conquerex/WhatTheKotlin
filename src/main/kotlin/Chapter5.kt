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