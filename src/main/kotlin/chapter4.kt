/**
 * @author Jongkook
 * @date : 2020/10/26
 */

fun main(args: Array<String>) {
    val sample = Sample()
    print(sample.isListBig)
}

class Sample {
    val array = mutableListOf<Int>(1, 3, 5)
    val isListBig: Boolean
        get() = array.size > 2
}