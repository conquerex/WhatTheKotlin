import java.io.File
import java.io.InputStream

/**
 * @author Jongkook
 * @date : 2020/11/03
 */

fun main(args: Array<String>) {
    /**
     * InputReader를 이용해 파일 읽기
     */
    val inputStream: InputStream = File("/Users/jongkook/dev/WhatTheKotlin/Android11Blog.txt").inputStream()
//    val inputString = inputStream.reader().use {
//        it.readText()
//    }
//    println(inputString)

    val listOfLines = mutableListOf<String>()
    inputStream.reader().useLines { lines ->
        lines.forEach {
            listOfLines.add(it)
        }
    }
    listOfLines.forEach {
        println("$ " + it)
    }

    /**
     * InputReader를 이용해 파일의 모든 데이터 읽기
     */
    val inputStream2: InputStream = File("/Users/jongkook/dev/WhatTheKotlin/Android11Blog.txt").inputStream()
    val inputString2 = inputStream2.reader().use { it.readText() }
    println(inputString2)

    val inputString3 = File("/Users/jongkook/dev/WhatTheKotlin/Android11Blog.txt").reader().use {
        it.readText()
    }
    println(inputString3)

    /**
     * InputReader를 이용해 파일로부터 한줄씩 읽기
     */
    val listOfLines2 = mutableListOf<String>()
    val inputStream4: InputStream = File("/Users/jongkook/dev/WhatTheKotlin/Android11Blog.txt").inputStream()
    inputStream4.reader().useLines { lines ->
        lines.forEach {
            listOfLines2.add(it)
        }
    }
    listOfLines2.forEach {
        println("** $it")
    }
}