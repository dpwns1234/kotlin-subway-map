package subway

class Output {
    fun mainView() {
        println(MAIN_MENU)
    }

    fun stationView() {
        println()
        println(STATION_MENU)
    }

    fun registerStation() {
        println()
        println(registerStation)
    }

    fun registerInfo() {
        println()
        println("[INFO] 지하철 역이 등록되었습니다.")
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
        const val registerStation = "## 등록할 역 이름을 입력하세요."
    }

}