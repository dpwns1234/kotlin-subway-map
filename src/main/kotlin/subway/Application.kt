package subway

import subway.utils.Constants.QUIT

fun main(args: Array<String>) {
    val subwayManger = SubwayManager()
    val input = Input()

    while(true) {
        val command = input.mainView()
        when (command) {
            // 1. 역 관리
            // 2. 노선 관리
            // 3. 구간 관리
            // 4. 지하철 노선도 출력
            // Q. 종료
            QUIT -> break
        }
    }

}