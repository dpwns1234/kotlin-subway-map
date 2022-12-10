package subway.manager

import subway.Input
import subway.Output
import subway.domain.Station
import subway.domain.StationRepository
import subway.utils.Constants.BACK
import subway.utils.Constants.INQUIRY
import subway.utils.Constants.REGISTRATION
import subway.utils.Constants.REMOVE

// 가상 클래스로 만든 후 해보기 (다 구현 후 리팩터 해보자고)
abstract class SubwayManager {
    private val input = Input()
    private val output = Output()

    fun perform() {
        menuView() // 등록할 것인지 삭제할 것인지 등 묻는 output
        // 그 값 입력 받고 ->
        when(inputCommand()) {
            REGISTRATION -> register()
            REMOVE -> remove()
            INQUIRY -> inquiry()
            BACK -> return
        }
    }
    protected abstract fun menuView()
    protected abstract fun inputCommand(): String

    abstract fun register()
    abstract fun remove()
    abstract fun inquiry()
}