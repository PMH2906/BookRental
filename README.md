# Book Rental Service


## SUBJECT 
자바와 MySQl을 활용하여 도서 대여 서비스 구현

## Requirements
1) 전체 데이터(베스트셀러 리스트)중 상위 5개 조회
2) 신간 도서 추가 기능 구현
3) 파손 여부 확인 후 도서 삭제 기능 구현
4) 도서 대출 여부 확인 후 대출 기능 구현
5) 도서 반납 기능 구현
6) --------------------------------------프로그램 스타트 메서드를 이용하여 원하는 서비스를 이용할 수 있는 기능을 구현 --> 미희님 이거 맞나요,,,,?^___^--------------


## MEMBER
* [강윤조](https://github.com/YunJo0618) 🌷
* [박미희](https://github.com/PMH2906) 🌼
* [서예원](https://github.com/woodybuzz02) 🌻
* [이수민](https://github.com/Leesumin0424) 🌹


## RESULT
- 3번 기능까지 merge 완료하여 구현을 완료.
- 4,5번 기능은 구현했으나 예외상황이 발생함.

## TROUBLE SHOOTING
:exclamation: [Trouble Shooting](./TroubleShooting.md) :exclamation:
- SELECT문과 UPDATE문을 함게 사용하여 구현하려고 할 때 오류가 발생 
  - 해결방식:  PreparedStatement의 객체를 두 번 사용하여 해결.
 
- CRUD 기능별로 각자 맡아서 구현하여 변수명, 변수의 자료형 등이 달라 SAVE기능을 MERGE 할 때 많은 시간을 소요함.
  - 해결방식 : 이후 기능들은 Convention을 기준으로 먼저 맞춘 후 MERGE하는 시간을 단축함. // 다시 정리하기(미희님 수정가능....?ㅜㅡㅜ)

- 한 팀원의 환경설정이 달라서 clone이 되지 않아 별개의 파일로 UPDATE를 구현하였으나 MERGE를 하지 못함 --해결중--ㅜ.ㅜ
 
- csv 파일을 MySQL로 import 시 오류발생하면서 테이블이 생성되지 않았음 -> Unhandled exception : cp949 codec can't decode byte 0xed in position 45
  - 해결방식 : import 하려고 했던 *.csv 파일을 메모장으로 불러와 형식을 utf-8(BOM)으로 바꾸었으나 해결되지 않아 새로 엑셀 파일을 만들어서 해결.

- UPDATE 기능 구현 시 도서 테이블의 도서명의 값을 불러오지 못하여 원하는 조건으로 출력하지 못함.


## REVIEW
🌷 코드를 단순화하고 논리적으로 만들기 위해 파일 여러개를 연결시켜 하나의 기능을 구현을 하게 되었는데, 
   그때 사용된 Import 기능을 단축기를 통해 습관적으로 사용은 했지만 정확히 어떻게 연결이 되는지 알지 못하는것 같음을 알게 되었다.
   코드간의 결합력을 높히기 위해 다음 프로젝트땐 구조를 더 이해하여 Import를 하고, 변수명을 지정하고자 한다.

🌼
🌻 패키지와 클래스, 변수명, 데이터 등 틀을 잘 작성을 한 후해야겠다는 생각이 들었다. 패키지만 구성을 하고 자세히 정하지 않았더니 다양하게 나와서 merge 하는데 시간이 꽤 걸렸다. 
   나중에 고생하지 않으려면 정해야 되는 것은 다 정해야 되는 것을 깨달았다. 그래도 git을 이용해 협업하는 것을 경험하면서 git에 좀 더 익숙해질 수 있었고 어떻게 팀원들과 소통해야 
   할지 배울 수 있었다. 다음에는 시간을 좀 더 효율적으로 사용하고 싶다.
   
🌹 팀프로젝트를 하면서 팀원들의 중요성을 느꼈고 각자 기능별로 구현했는데 거기서 합치는 과정에서 어려움을 느꼈다. sql과 연결하는 try코드문에서 어떤 순서로 실행하는지 제대로 파악하지   못해 코드를 구현하는데 어려움을 느꼈다. 하지만 계속 수정하고 고치다보니 어느정도 어떻게 코드가 실행되는지 알 수 있어 뿌듯하고 아직은 완벽히 구현되지 않아 원래하고자 하는 목표까지   구현하고 점점 더 발전시키고 싶다. 이번 프로젝트로 깃에 대해 좀 더 자세히 알게 되었는데 아직은 너무 어렵다. 이번 기회로 좀 공부를 해봐야할 거 같다.
 
## REFERENCE
- https://dogsavestheworld.tistory.com/m/156 //MySQL import 오류
- https://woodybuzz.notion.site/woodybuzz/GIT-249c462b607940b58208c0e5c78b220a //git 참고 내용
- https://www.yalco.kr/lectures/git-github/ // git 참고 내용2
                             


## STACK
<img src="https://img.shields.io/badge/JAVA-007396?style=flat-square&logo=java&logoColor=white"></a> 
<img src="https://img.shields.io/badge/mysql-4479A1?style=flat-square&logo=mysql&logoColor=white"></a> 


