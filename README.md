# Vert.x_Web-Server-Quickstart
내가 Vert.x Web 서버를 만들 때 쓸 퀵스타트


## 패키지 구조
	> main
	> restful
	> support.crypto
	> support.routing
	> support.utilities
### com.planb.main
#### Main.java
main 메소드 위치, Vert.x 객체와 Verticle 배치 구문
#### MainVerticle.java
main 메소드에서 분기, Router 객체와 Body, Cookie, Session, Static 핸들러 배치
com.planb.restful 패키지 하위 클래스들을 리플렉션 탐색 후 80 포트로 서버 시작

### com.planb.restful
RESTful 클래스들을 위치시킬 패키지
#### Sample.java
퀵스타트의 코딩 스타일을 적용하여 /test URI에 매핑된 클래스

### com.planb.support.crypto
암호화 클래스들이 모인 패키지
#### AES256.java
String 형태의 key를 생성자로 가진 AES256 암호화 클래스
encrypt(String str)와 decrypt(String str) 메소드 존재
#### AESKeyManager.java
AES256 클래스의 인스턴스를 미리 가지고 있는 클래스
퀵스타트로 서버 개발 시작 시 키를 입력해 두어야 함
	private static AES256 aes = new AES256("");
	
	public static AES256 getAES() {
		return aes;
	}
#### SHA256.java
SHA256 암호화 클래스
encrypt(String str) 메소드 존재

### com.planb.support.routing
커스텀 어노테이션이 붙은 클래스들을 탐색하여 라우팅하는 패키지
#### Route.java
String uri, HttpMethod method 필드를 가진 커스텀 어노테이션
런타임에 작동
#### Routing.java
Router 객체와 가변 갯수의 패키지 네임을 받아서 Route 어노테이션이 선언된 클래스들을 라우팅

### com.planb.support.utilities
유틸리티성 클래스들이 모인 패키지
#### DataBase.java
MySQL에 연결하여 쿼리를 수행
퀵스타트로 서버 개발 시작 시 테이블, 유저 네임, 패스워드를 입력해 두어야 함
	private final String TABLE_NAME = "";
	private final String USER = "";
	private final String PASSWORD = "";
#### Log.java
서버의 작동 날짜로 이루어진 txt 파일에 로그를 남김
	Log.I("Something");
#### SessionUtil.java
세션과 쿠키를 다루기 위한 클래스
