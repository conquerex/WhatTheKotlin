import Chapter11.Response
import com.google.gson.Gson
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

    /**
     * 데이터 클래스를 수정하면서 복제하기
     */
    var olderStudent = student.copy(name = "Tom")
    println(olderStudent.toString())

    /**
     * JSON 파싱
     * WARNING : 아래 URL 동작하지 않음
     */
    var response2 =
        URL("https://api.instagram.com/v1/media/1571595528561539504_5812999640/comments?access_token=5812999640.42ee6f0.9441d5bd909f40319bad89407ffd7082").readText()
    var gson = Gson()
    val comments = gson.fromJson(response2, Response::class.java)
    println(comments.data?.get(0))
}

data class GoodStudent(var name: String, var roll_number: String, var age: Int)