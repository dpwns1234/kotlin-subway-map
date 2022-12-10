package subway

import subway.domain.Station

class Output {
    fun mainView() {
        println()
        println(MAIN_MENU)
    }

    fun stationView() {
        println()
        println(STATION_MENU)
    }

    fun registerStation() {
        println()
        println(REGISTER_STATION)
    }

    fun registerInfo() {
        println()
        println("[INFO] 지하철 역이 등록되었습니다.")
    }

    fun removeStation() {
        println()
        println(REMOVE_STATION)
    }

    fun removeInfo() {
        println()
        println("[INFO] 지하철 역이 삭제되었습니다.")
    }

    fun inquiryStations(stations: List<Station>) {
        println()
        for (station in stations) {
            println("[INFO] ${station.name}")
        }
    }

    // -- line --
    fun lineView() {
        println(LINE_MENU)
    }

    // 리팩터
    companion object {
        const val MAIN_MENU = "## 메인 화면\n" +
                "1. 역 관리\n" +
                "2. 노선 관리\n" +
                "3. 구간 관리\n" +
                "4. 지하철 노선도 출력\n" +
                "Q. 종료\n" +
                "\n" +
                "## 원하는 기능을 선택하세요."
        const val STATION_MENU =
            "## 역 관리 화면\n" +
                    "1. 역 등록\n" +
                    "2. 역 삭제\n" +
                    "3. 역 조회\n" +
                    "B. 돌아가기\n\n" +
                    "## 원하는 기능을 선택하세요."
        const val REGISTER_STATION = "## 등록할 역 이름을 입력하세요."
        const val REMOVE_STATION = "## 삭제할 역 이름을 입력하세요."

        const val LINE_MENU = "## 노선 관리 화면\n" +
                "1. 노선 등록\n" +
                "2. 노선 삭제\n" +
                "3. 노선 조회\n" +
                "B. 돌아가기"
    }

}