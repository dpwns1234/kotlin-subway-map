package subway

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class ApplecationTest: NsTest() {
    override fun runMain() {
        main()
    }

    @Test
    fun `main 메뉴에서 주어지지 않은 값이 주어질 경우 예외 처리`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest {
            runException("0", "1", "5")
            Assertions.assertThat(output()).contains("[ERROR]")
        }
    }
}