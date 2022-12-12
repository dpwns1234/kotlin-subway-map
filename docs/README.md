# 미션 - 지하철 노선도


## 기능 구현 목록 (1차)
### 지하철 역 관련 기능
- [x] 지하철 역을 등록하고 삭제할 수 있다. (단, 노선에 등록된 역은 삭제할 수 없다) ERROR
- [x] 중복된 지하철 역 이름이 등록될 수 없다. ERROR
- [x] 지하철 역 이름은 2글자 이상이어야 한다. ERROR
- [x] 지하철 역의 목록을 조회할 수 있다.

### 지하철 노선 관련 기능
- [x] 지하철 노선을 등록하고 삭제할 수 있다.
- [x] 중복된 지하철 노선 이름이 등록될 수 없다. ERROR
- [x] 지하철 노선 이름은 2글자 이상이어야 한다. ERROR
- [x] 노선 등록 시 상행 종점역과 하행 종점역을 입력받는다. ERROR 하나는 입력 받았는데 두 번째에 옳바른 입력을 받지 못했을 때
- [ ] 지하철 노선의 목록을 조회할 수 있다.

### 지하철 구간 추가 기능
지하철 노선에 구간을 추가하는 기능은 노선에 역을 추가하는 기능이라고도 할 수 있다.
역과 역사이를 구간이라 하고 이 구간들의 모음이 노선이다.
- [ ] 하나의 역은 여러개의 노선에 추가될 수 있다.
- [ ] 역과 역 사이에 새로운 역이 추가 될 수 있다.
- [ ] 노선에서 갈래길은 생길 수 없다.

### 지하철 구간 삭제 기능
- [ ] 노선에 등록된 역을 제거할 수 있다.
- [ ] 종점을 제거할 경우 다음 역이 종점이 된다.
- [ ] 노선에 포함된 역이 두개 이하일 때는 역을 제거할 수 없다. ERROR

### 지하철 노선에 등록된 역 조회 기능
- [ ] 노선의 상행 종점부터 하행 종점까지 연결된 순서대로 역 목록을 조회할 수 있다.





### 프로그래밍 요구사항 - Station, Line
- Station, Line 클래스를 활용하여 지하철역과 노선을 구현해야 한다.
- 제공하는 각 클래스의 기본 생성자를 추가할 수 없다.
- 필드(인스턴스 변수)인 name의 접근 제어자 private을 변경할 수 없다.
- 가능하면 setter 메소드(ex. setXXX)를 추가하지 않고 구현한다.

### 프로그래밍 요구사항 - StationRepository, LineRepository
- Station과 Line의 상태를 저장할 수 있는 StationRepository, LineRepository를 제공한다.
- 필요 시 StationRepository, LineRepository 이 외 추가로 Repository를 만들 수 있다.
- 추가로 생성되는 객체에 대해서 XXXRepository 네이밍으로 저장 클래스를 추가할 수 있다.
- 객체들의 상태를 관리하기 위해서 XXXRepository 클래스를 활용해 저장 로직을 구현해야 한다.
- 필요에 따라 자유롭게 수정이 가능하다.


```java
public class StationRepository {
private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
}```