package subway

class Output {
    fun mainView() {

    }

    fun stationView() {
        println()
        println("## 역 관리 화면\n" +
                "1. 역 등록\n" +
                "2. 역 삭제\n" +
                "3. 역 조회\n" +
                "B. 돌아가기\n" +
                "\n" +
                "## 원하는 기능을 선택하세요.")
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
        const val subject = "## %s 관리 화면"
        
        const val registerStation = "## 등록할 역 이름을 입력하세요."
    }

}