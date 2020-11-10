import java.net.URL

/**
 * @author Jongkook
 * @date : 2020/11/10
 */

fun main(args: Array<String>) {
    /**
     * 네트워크로부터 데이터 가져오기
     */
//    var response = URL("URL").readText()
//    println(response)

    /**
     * 데이터 클래스를 생성하기
     */
    var student = GoodStudent("John", "2020001", 22)
    println("""
        Student Info
        >> ${student.name}
        >> ${student.roll_number}
        >> ${student.age}
    """.trimIndent())
    println(student.toString())
    val (name, roll_number, age) = student
    println("""
        Student Info2
        >> ${name}
        >> ${roll_number}
        >> ${age} 
    """.trimIndent())
}

data class GoodStudent(var name: String, var roll_number: String, var age: Int)