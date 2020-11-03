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

    /**
     * 원본 컬렉션을 컬렉션쌍으로 분할
     */
    val listAA = listOf(1, 2, 3, 4, 5, 9)
    val setAA = setOf(3, 4, 5, 6, 7, 8)
    val pair = listAA.partition {
        it % 2 == 0
    }
    val pair2 = setAA.partition {
        it % 2 == 0
    }
    println(pair)
    println(pair2)

    /**
     * 지정된 비교자로 리스트 정렬
     */
    val p1 = Person6(91)
    val p2 = Person6(22)
    val p3 = Person6(77)
    val listOfPerson = listOf(p1, p2, p3)
    var sortedListOfPerson = listOfPerson.sortedBy {
        it.age
    }
    var sortedListOfPerson2 = listOfPerson.sortedWith<Person6>(object : Comparator<Person6> {
        override fun compare(p0: Person6, p1: Person6): Int {
            if (p0.age > p1.age) {
                return 1
            }

            if (p0.age == p1.age) {
                return 0
            }

            return -1
        }
    })

    /**
     * 내림차순으로 정렬
     */
    val listOfInt = listOf(3, 4, 5, 6, 9)
    var sortedIntList = listOfInt.sortedDescending()
    sortedIntList.forEach {
        println(it)
    }
    val sortedPersonDes = sortedListOfPerson.sortedByDescending {
        it.age
    }
    sortedPersonDes.forEach {
        println(it.age)
    }

    /**
     * 람다식을 사용하여 필터링 및 매핑하는 방법
     */
    val listOfNumbers = listOf(1, 2, 3, 5, 6, 7, 8, 11, 12)
    var evenList = listOfNumbers.filter { it % 2 == 0 }
    println(evenList)
    // map : 리스트를 변환하고 변환된 새로운 리스트를 반환
    val map = listOfNumbers.map {
        it * 2
    }
    println(map)
    // mapIndexed : 아이템과 함께 순서에 대한 색인도 제공
    val map2 = listOfNumbers.mapIndexed { index, it ->
        it * index
    }
    println(map2)

    /**
     * 객체 목록을 정렬하고 끝에 null 객체를 유지하는 방법
     */
    val listOfpersonns = listOf(Personn(10), Personn(22), Personn(6), Personn(null))
    val sortedListt = listOfpersonns.sortedWith(compareBy(nullsLast<Int>(), {
        it.age
    }))
    sortedListt.forEach {
        println(it.age)
    }
}

class Personn(var age: Int?)

class Person6(var age: Int)