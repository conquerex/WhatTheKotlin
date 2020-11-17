import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * @author Jongkook
 * @date : 2020/11/17
 */

lateinit var kp: KoPerson

fun main(args: Array<String>) {
    // 초기값 : 빈 문자열 ""
    var a: String by Delegates.observable("", { _, old, new ->
        println("Old : $old, Updated : $new")
    })
    a = "A"
    a = "B"

    var person: KoPerson by Delegates.vetoable(KoPerson(12), { _, old, new ->
        if (new.age > 20) {
            println("Nooooooooo")
            return@vetoable false
        }
        true
    })

    person = KoPerson(22)

    /**
     * 사용자 정의 Delegate
     */
    var aa: String by SingleInitProperty()
    aa = "first"
    println(aa)
//    aa = "second"
//    println(aa)

    /**
     * 전역변수 만들기
     */
    kp = KoPerson(11)
    println(kp.age)
}

data class KoPerson(var age: Int)

class SingleInitProperty<T> : ReadWriteProperty<Any?, T> {
    private var value: T? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        if (value == null) {
            throw IllegalStateException("값이 할당되지 않았습니다.")
        } else {
            return value!!
        }
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        if (this.value == null) {
            this.value = value
        } else {
            throw IllegalStateException("값은 초기에 한 번만 할당될 수 있습니다.")
        }
    }
}