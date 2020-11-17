import org.junit.Test

/**
 * @author Jongkook
 * @date : 2020/11/17
 */

class Chapter12test {
    lateinit var subject: TestSubject

    fun setup() {
        subject = TestSubject()
    }

    @Test fun test() {
        subject.method()
    }
}

class TestSubject {
    fun method() {}
}
