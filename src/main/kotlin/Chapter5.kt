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