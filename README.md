## Environment
 - jre 1.8.0_192
 - Spring Tool Suite. Version: 3.9.4.RELEASE
 - apache-tomcat-8.5.37
 - Oracle SQL Developer. Version: 17.2.0.188
 - Encoding : UTF-8
 - spring maven
    + mybatis. Version: 3.4.6
    + mybatis-spring. Version: 1.3.2
    + spring-jdbc. Version: 5.0.6.RELEASE
    + commons-dbcp. Version: 1.4
<hr><br>


## KH Spring ppt
[0_Spring - 개요 & 구조.pdf](https://github.com/hanpotato/KH_spring_study/files/2964542/0_Spring.-.pdf)
<hr><br>


## Eclipse 기본 설정(STS)
<pre>
Preferences 설정

  general - server - server environment - tomcat 등록(기존 서버 제거)
  general - editors - texteditors - spelling - encoding - other UTF-8
  general - web browser - use external web browser - chorome
  
  Encoding 설정
    Json - Json files encoding - UTF-8
    web - css files - UTF-8
    web - HTML files - UTF-8
    web - jsp files - UTF-8
    XML - XML files - UTF-8
    
</pre>
<hr><br>


## Maven
#### 원격저장소에 있는 필요한 라이브러리 파일들을 자동으로 받아주는 기능
<pre>
*원격저장소(MavenRepository)
  필요한 파일의 등록은 Maven 의 설정파일인 pom.xml 에 <dependency>를 등록해서 받아옴
  - https://mvnrepository.com/ 에서 필요 파일 검색 후 maven 등록 형식으로 소스를 받을 수 있음.

- 이용방법 -
1. 'maven.apache.org'에 우측상단 Download 클릭 -> 'apache-maven-3.6.0-bin.zip' 다운받아서 압축을 푼다.
2. tomcat server 더블클릭 - serve modules without publishing 체크
3. Ports에서 HTTP/1.1 설정이 '9090' 으로 되어있는지 확인 (서로 충돌안되게 값을 변경해 줘야 한다.
   - Tomcat -> server.xml -> Connector 태그 port 속성 수정(사용자에 따라 틀림)

- 주의사항 -
Maven이 jar 파일을 받아오다가 손상된경우는 제대로 다시 받아올 수 없기때문에,
Repository 가서 해당 파일을 지우고 다시 받아 해결해야 한다. 그래서 'localRepository' 를 편한 폴더로 지정함

- bin 폴더에서 localRepository 설정 -
  폴더 maven-conf-settings.xml 편집
    52번째줄  <localRepository>/path/to/local/repo</localRepository> 에 주석 해제
    <localRepository>c:\dev\apache-maven-3.6.0\repository</localRepository> 로변경

- STS 에서 Local Repository 설정 -
  설정 경로 : Window - Preferences - maven - User Settings - User Settings - Browse...
    - '메이븐bin폴더\conf\settings.xml' 지정

</pre>


## Spring 기타 설정
<pre>
git 설정
설정 경로 : Window - Preferences - team - Ignored resources
  ' Add pattern ' 클릭
  ' */target/* ' 등록 OK
</pre>
<hr><br>


## Project 새로 시작하기
<pre>
Spring legacy project
-> Spring MVC project
-> package 에 3단계로 써줌
    ex) com.kh.spring
-> finish 누르면 다운받느라 걸림
</pre>
<hr><br>
