/**
 * @author Jongkook
 * @date : 2020/10/28
 */

package packageA

fun foo() {
    println("calling from boo method")
}

// object (싱글톤)
object Foo {
    fun callFoo() = println("Foooo")
    var foo = "foo~~"
}

class chapter4_1 {
    companion object {
        fun foo2() = println("In foo method")
    }
}