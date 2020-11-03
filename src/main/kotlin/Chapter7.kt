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
}