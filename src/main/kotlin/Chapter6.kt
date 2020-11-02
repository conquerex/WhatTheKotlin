/**
 * @author Jongkook
 * @date : 2020/11/02
 * 6. 컬렉션 프레임워크
 */

fun main(args: Array<String>) {
    /**
     * 두 개의 컬렉션을 병합하는 방법
     */
    var listA = mutableListOf<String>("a", "b", "c")
    var listB = mutableListOf<String>("a", "c")
    listB.addAll(listA)
    println(listB)
    // 중복제거
    val listC = listB.union(listA)
    println(listC)

    // 가변 set : 집이기 때문에 유일한 값만 허용, addAll이 union 메소드의 결과와 유사
    val setA = mutableSetOf<String>("a", "b", "c")
    val setB = mutableSetOf("a", "b", "c", "ddd")
    setB.addAll(setA)
    println(setB)
    println(setB.union(setA))

    // map : putAll(), addAll이나 union 없음
    val mapA = mutableMapOf("a" to 1, "b" to 2)
    val mapB = mutableMapOf("a" to 22, "d" to 33)
    mapA.putAll(mapB)
    println(mapA)
}