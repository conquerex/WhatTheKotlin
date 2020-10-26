/**
 * @author Jongkook
 * @date : 2020/10/26
 */

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