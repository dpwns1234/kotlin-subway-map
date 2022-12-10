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

    fun register() {
        // 각자 상황에 맞는(역, 노선) print 후 (## 등록할 역 이름을 입력하세요.)
        registerView()
        val name = input.stationName() // TODO 여기부터 생각 (이것도 protected로 해야하는지 아님 여기부터 이제 따로 구현할 것인지 등
        StationRepository().addStation(Station(name))
    }
    protected abstract fun registerView()


    // 이걸 abstract로 받아야할까?
    fun remove() {
        // 공통적인 것들 체크하는 부분

        // + protected로 adiitional fuction으로 check하도록?
    }
    fun inquiry() {

    }
}