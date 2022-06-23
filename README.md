# JAVA Mini Project(프로젝트 이름)
## 프로젝트 개요
## 사용 언어
Java, JavaSwing(JFrame), Oracle(Database)
## 개발자(GIT 계정)
서연운 ([yws9612](https://github.com/yws9612))  
이송이 ([nonameleel](https://github.com/nonameleel))  
황용학 ([yonghyng](https://github.com/YONGHYNG))  
문종주 ([admoonistrator](https://github.com/admoonistrator))  
최서영 ([seoyoung](https://github.com/seoyoung1029))  
이윤경 ([yiyk7](https://github.com/yiyk7))  

## **데이터 테이블**
### Member Table
|순번|이름|구조|제약조건|
|:--:|:--:|:--:|:--:|
|1|회원번호|Number|**Primary Key**|
|2|ID|Varchar2|Not null, Unique|
|3|PW|varchar2|Not null|
|4|이름|Varchar2|Not null|
|5|E-mail|Varchar2|Not null, Unique|
|6|관리자 권한|char|

### Manage Table
|순번|이름|구조|제약조건|
|:--:|:--:|:--:|:--:|
|1|회원번호|Number|Foreign Key|
|2|가입일|Date|
|3|최종 플레이 일|Date|

### Score Table
|순번|이름|구조|제약조건|
|:--:|:--:|:--:|:--:|
|1|회원번호|Number|Foreign Key|
|2|점수|Number|
|3|플레이 날짜|Date|

### 순우리말 단어 Table
|순번|이름|구조|제약조건|
|:--:|:--:|:--:|:--:|
|1|단어번호|Number|**Primary Key**|
|2|단어|Varchar2|
|3|뜻|varchar2|

### 순화어 단어 Table
|순번|이름|구조|제약조건|
|:--:|:--:|:--:|:--:|
|1|단어번호|Number|**Primary Key**|
|2|단어|Varchar2|
|3|뜻|varchar2|

## **JavaSwingUI**


