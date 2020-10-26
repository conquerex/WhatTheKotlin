import kotlin.properties.Delegates
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.memberProperties

/**
 * @author Jongkook
 * @date : 2020/10/15
 */

class StudentOld(var roll_number: Int, var name: String = "(Empty)")
class StudentOld2 constructor(var roll_number: Int, var name: String) : Person(name)
class StudentOld3 : Person {
    constructor(name: String) : super(name)
    constructor(roll_number: Int, name: String) : super(name)
}

class Student(var roll_number: Int, var name: String = "(Empty)") {
    companion object {
        val log by logger()
    }

    init {
        log.info("...init...")
    }
}

open class Person(val firstname: String) {
    constructor(name: String, lastname: String) : this(name) {
        // 초기화를 위한 코드
    }

    val isHuman: Boolean = true
}

fun main() {

    var student_A = Student(1, "Sam")
    println(student_A)
    println("name : ${student_A.name}")

    var student_B = Student(2)
    println("name : ${student_B.name}")

    var a: Any = 1
    var b: Any = "1"
    if (a is String) println("a = $a is String")
    else println("a = $a is not String")
    if (b !is String) println("b = $b is not String")
    else println("b = $b is String")

    /**
     * 추상클래스
     */
    var x = Dog()
    x.move("North")
    println(x.show(222))

    /**
     * 클래스 속성 순회
     */
    var student = StudentOld2(12333, "Kane")
    for (property in StudentOld2::class.memberProperties) {
        println(">>> ${property.name} = ${property.get(student)}")
    }
    for (property in StudentOld2::class.declaredMemberProperties) {
        println("<<< ${property.name} = ${property.get(student)}")
    }

    /**
     * 인라인 속성
     */
    var aa = x()
    aa.valueIsMaxedOut = false
    println(aa)

    /**
     * 중첩클래스
     */
    var a1 = outCl()
    a1.pringAB()
    outCl.inCl().printB()

    var a2 = outCl2()
    a2.pringAB()
    a2.inCl2().printB()


    /**
     * observable 위임 속성
     */
    val paris = Travel()
    paris.placeName = "Paris"
    paris.placeName = "Korea"

    /**
     * vetoable 위임 속성
     */
    val paris2 = Travel2()
    paris2.placeName = "Paris"
    paris2.placeName = "Korea"
    println(paris2.placeName)

    val paris3 = Travel3(
        mutableMapOf(
            "placeName" to "Seoul"
        )
    )
    println(paris3.placeName)

    /**
     * 열거형 사용
     */
    var north_dir = Direction.NORTH
    if (north_dir == Direction.NORTH) {
        println("Going North")
    } else {
        println("Nooooooo")
    }

    var south_dir = 2
    if (south_dir == DirectionNew.NORTH.value) {
        println("Going North")
    } else {
        println("Nooooooo : $south_dir")
    }
}

enum class Direction {
    NORTH, SOUTH, EASH, WEST
}

enum class DirectionNew(var value: Int) {
    NORTH(1), SOUTH(2), EASH(3), WEST(4)
}

class Travel {
    var placeName: String by Delegates.observable("<>") { property, oldValue, newValue ->
        println("old = $oldValue, new = $newValue")
    }
}

class Travel2 {
    var placeName: String by Delegates.vetoable("<>") { property, oldValue, newValue ->
        if (!newValue.equals("Paris")) {
            return@vetoable false
        }
        true
    }
}

class Travel3(val map: MutableMap<String, Any?>) {
    val placeName: String by map
}

class outCl {
    var a = 6
    fun pringAB() {
        var b_ = inCl().b
        println("a = $a and b = $b_ from inside outCl")
    }

    class inCl {
        var b = "9"
        fun printB() {
            println("b = $b from inside inCl")
        }
    }
}

class outCl2 {
    var a = 6
    fun pringAB() {
        var b_ = inCl2().b
        println("a = $a and b = $b_ from inside outCl")
    }

    inner class inCl2 {
        var b = "9"
        fun printB() {
            println("a = $a and b = $b from inside outCl")
        }
    }
}

class x {
    companion object {
        val CONST_MAX = 3
    }

    var someValue = 3

    var valueIsMaxedOutOld: Boolean
        inline get() = someValue == CONST_MAX
        inline set(value) {
            println("Value set!!")
        }

    inline var valueIsMaxedOut: Boolean
        get() = someValue == CONST_MAX
        set(value) {
            println("Value set!!")
        }
}

abstract class Mammal {
    init {
        println("init ::: Mammal")
    }

    abstract fun move(direction: String)
    fun show(y: Int): String {
        return y.toString()
    }
}

class Dog : Mammal() {
    init {
        println("init ::: Dog")
    }

    override fun move(direction: String) {
        println("......$direction")
    }
}