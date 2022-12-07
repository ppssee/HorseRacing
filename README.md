# HorseRacing

## 주제: 경주마 레이싱 프로그램

## 요구사항
1. 경주마의 정보는 이름, 등급, 체력, 스피드가 있다.
2. 이용할 경주마들을 선택할 수 있다.
3. 경주를 통해 상금을 획득한다.
4. 상금을 통해 경주마를 뽑는다.
5. 경주마의 등급과 스피드는 랜덤으로 정해진다.
6. 경주가 끝나고 체력이 일정 감소한다.
7. 체력이 60이상만 경주가 가능하다.
8. 휴식을 통해 체력을 회복한다.

## 동작화면
================== 경마 프로그램 ==================<br/>
기본 경주마를 생성합니다.<br/>
사용하실 경주마의 정보를 입력해주세요.<br/>
경주마의 이름 : <br/>

=================== 경주마 선택 ===================<br/>
 0. 이름: 박상은   	| 스피드: 17 | 등급: 하<br/>

입력: <br/>

==================== 메인 메뉴 ====================<br/>
이름: 박상은   	 <br/>
체력: 100 | 스피드: 17 | 등급: 하 | 재산: 0 |  <br/>

0. 선택<br/>
1. 경주<br/>
2. 휴식<br/>
3. 뽑기<br/>
4. 종료<br/>
입력: <br/>

=================== 휴식 메뉴 ===================<br/>
휴식 중 ... 현재 체력 : 87<br/>

=================== 경주마 뽑기 ===================<br/>
200원을 사용해 경주마를 뽑으시겠습니까?<br/>
1. YES <br/>
2. NO <br/>
선택: <br/>

## 보완할 부분
1. try~catch 예외 처리하기.
2. 경주 메뉴
    - 경주마 추가.
    - 경주마의 스피드에 따라 결과가 차이 설계하기.
3. 코드 리팩토링.
