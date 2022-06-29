
--W1 테이블 생성
create table w1_table(
W1_NO NUMBER(5),
W1 VARCHAR2(30),
W1_H VARCHAR2(200),
constraint PK_W1_NO PRIMARY KEY(W1_NO));

--W1 순우리말 시퀀스 생성
CREATE SEQUENCE W1_SQ
INCREMENT BY 1
START WITH 1
MAXVALUE 99999
MINVALUE 1
NOCYCLE
NOCACHE;

drop sequence w1_sq;

--W1 순우리말 DB 삽입
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'가늠','목표나 기준에 맞고 안 맞음을 헤아리는 일, 헤아려 보는 대중. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'가리온','털이 희고 갈기가 검은 말. 낙(駱). 해류마(海류馬) ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'가치노을','풍랑이 일 때 솟아오르는 하얀 물거품.');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'가탈','1. 일이 수월하게 되지 않도록 방해하는 일 2. 억지 트집을 잡아 까다롭게 구는 일. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'각다귀판','[그밖] 인정 없이 서로 남의 것만 뜯어 먹으려고 모이어 덤벼 드는 판. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'각추렴','[돈, 재물] 각 사람에게서 같은 액수의 돈이나 물건을 거둠. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'갈개꾼','남의 일에 훼방을 놓는 사람. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'갈무리','1. 물건을 잘 정돈하여 간수함. 2. 마무리. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'갈치잠','비좁은 방에서 여럿이 모로 끼어자는 잠. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'감물','고통, 아픔 따위를 참으려고 입술을 감아 들이어 꼭 물다. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'갓밝이','날이 막 밝을 무렵. 밝을녘. 여명(黎明). ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'강울음','[행동] 억지로 우는 울음. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'난달','길이 이리저리 통한 곳. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'난든집','손에 익숙한 재주. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'날밤','1. 부질없이 새우는 밤. 2. 생밤 ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'남새밭','채소밭. (비슷) 채마밭 ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'남진아비','아내가 있는 사내. 유부남(有婦男).');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'남진어미','남편이 있는 여자. 유부녀(有夫女). ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'낮새껏','낮이 다 지나가도록까지, 밤새껏에 상대하여 일컫는 말.');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'너나들이','서로 너니 나니 하고 부르며 터놓고 지내는 사이. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'너름새','1. 말이나 일을 떠벌리어서 주선하는 솜씨 2. 판소리에서 광대의 연기.');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'너스레','[행동] 남을 놀리려고 늘어놓는 말솜씨. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'너울','[천문, 기상] 바다의 사나운 큰 물결. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'너울가지','남과 잘 사귀는 솜씨. 붙임성. 포용성. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'넉살','비위 좋게 언죽번죽 구는 짓. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'넌더리','소름이 끼칠 정도로 싫은 생각. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'넘진소리','주제 넘게 건방진 소리. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'네뚜리','[행동] 사람이나 물건을 업신여겨 대수롭지 않게 보는 일 ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'녈비','지나가는 비. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'노랑수건','권력자 밑의 심부름꾼. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'노상','1. 언제나 변함이 없이. 항상 2. 반드시, 늘 습관으로. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'노새','수나귀와 암말 사이에 난 잡종. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'노잣돈','먼 길을 오가는 데 드는 비용. 또는, 상여꾼들에게 찔러 주는 수고비 따위. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'높새바람','북동풍. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'뉘누리','물이 소용돌이 치며 흘러나가는 모습. 물살, 소용돌이. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'는개','[천문, 기상] 안개보다 조금 굵고 이슬비보다 조금 가는 비. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'늘픔','앞으로 좋게 발전할 가능성. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'다모토리','큰 잔으로 소주를 마시는 일. 또는 큰 잔으로 소주를 파는 집. *선술집. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'다솜','애틋한 사랑의 옛말.');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'닦달','몰아대서 닦아세움. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'단댓바람','단번에 곧장. [비슷]댓바람. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'달구리','이른 새벽의 닭이 울 때. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'달포','한 달쯤 된 동안. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'담빡','깊은 생각이 없이 가볍게 행동하는 모양. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'담싹','재빨리 움켜쥐거나 탐스럽게 안는 모양. [비슷]답삭. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'대갚음','남에게 받은 은혜나 원한을 그대로 갚음. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'대매','승부를 마지막으로 결정하는 일. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'댑바람','북풍. 북쪽에서 부는 큰 바람. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'댓바람','[그밖] 1. 일에 당하여 맨 첫번으로 2. 단번에 지체하지 않고 곧. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'덤짜','덤이 되는 사람. 즉, 가욋사람. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'덤터기','남에게 넘겨씌우거나 넘겨받은 걱정거리. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'도깨비살림','재물이 있다가도 어느 결에 갑자기 없어지는 따위의 불안정한 살림살이의 일컬음. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'도리깨침','먹고 싶어서 삼키는 침. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'도린곁','[지리, 지형]사람이 별로 가지 않는 외진 곳. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'돋을볕','[천문, 기상] 처음으로 솟아오르는 햇볕. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'동무장사','두 사람 이상이 같이 경영하는 장사. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'될끼','될 수 있는 가능성. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'두럭','[놀이] 노름이나 놀이로 여러 사람이 모인 떼. 여러 집들이 한데 모인 집단. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'두레','농촌에서 농번기에 서로 협력하여 공동 작업을 하기 위해 만든 조직.');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'뒵들이','뒤에서 거들어 도와주는 일. 또는 그런 사람. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'뒷배','[일] 표면에 나서지 않고 뒤에서 보살펴주는 일. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'들살이','들에 천막을 쳐 놓고 훈련이나 휴양을 하는 생활. [비슷]야영, 캠프.');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'들온말','[말(言)] 외래어. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'들주머니','주로 여자들이 손에 들고 다니는 주머니. 핸드백. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'따따부따','딱딱한 말로 이러쿵저러쿵 따지는 모양. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'따리','아첨. 아첨하는 말. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'딸보','1. 속이 좁은 사람 2. 키가 작은 사람. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'뚝기','굳게 버티어 내는 기운. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'뜻빛깔','낱말의 뜻바탕에서 우러나는 말이나 글의 맛.');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'마음고름','마음 속을 드러내지 않으려고 단단히 매어 둔 다짐. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'맏뜻','처음 먹은 마음.');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'말곁','[말(言)] 남이 말하는 곁에서 덩달아 참견하는 말. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'맘매김','약속. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'매롱매롱','눈이나 정신이 또렷또렷한 모양. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'멍석잠','너무 피곤하여 아무 데서나 쓰러져 자는 잠. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'모꼬지','[놀이] 여러 사람이 놀이나 잔치따위로 모이는 일. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'몽니','[성격] 음흉하고 심술궂게 욕심을 부리는 성질.  ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'물신선','좋은 말 궂은 말을 들어도 기뻐하거나 성낼 줄 모르는 사람. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'미리내','은하수 ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'미립','경험에서 얻은 묘한 이치. 요령');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'바이','다른 도리 없이, 전연, 아주, 과연. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'바투','거리가 썩 가깝게. 길이가 매우 짧게. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'밤그늘','밤의 그늘. 곧, 밤의 기운이나 자취. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'밤빛','어둠 사이의 희미한 밝음. [비슷]어둠빛. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'방망이','[물건] 나무 따위를 둥글고 길게 깍아 만들어 무엇을 두르리는 데 쓰는 도구. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'배알티','반항하는 마음. 반항심. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'뱀뱀이','예의에 대한 교양. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'보기글','보기로서 들어 보이는 글. [비슷]예문(例文) ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'보짱','꿋꿋하게 가지는 속마음. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'볼꾼','구경하는 사람들. 구경꾼. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'뵤뵤','새 따위가 둥글게 원을 그리며 천천히 도는 모양. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'부집','사정없이 마구 말을 퍼부어 싸움. 약을 올려서 말다툼을 함. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'북새','많은 사람들이 아주 야단스럽게 부산떠는 일.');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'비롯','시작. 어떠한 일이 있게 하는 사단');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'비아냥','얄미운 태도로 빈정거림. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'뻔질','어떤 행동이 매우 자주 일어나는 모양. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'뽀로로','종종걸음으로 재게 움직이는 모양. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'사날','[성격] 1. 제가 하고 싶은 대로 하는 태도나 성미 2. 비위좋게 남의 일에 참견을 잘하는 일. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'사바사바','뒷구멍으로 교섭하여 어려움을 해결하거나 이끗을 붸는 것.');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'사시랑이','갸냘픈 사람이나 물건. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'새녘','동쪽. 동편. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'새물내','[냄새] 빨래하여 갓 입은 옷에서 나는 냄새. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'샐녘','[천문, 기상] 날이 샐 무렵. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'생다지','공연한 억지. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'성금','1. 말한 보람 2. 일의 효력. 일한 보람 3. 꼭 지켜야 할 명령. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'손사래','[행동] 어떤 말을 부인하거나 조용하기를 요구할 때 손을 펴서 휘젓는 짓. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'솔봉이','촌스러운 때를 벗지 못한 사람. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'시나브로','1. 알지 못하는 사이에 조금씩 조금씩 2. 다른 일을 하는 사이 사이에.');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'아음','친척을 뜻하는 옛말. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'악지','[성격] 잘 안 될 일을 무리하게 해내려는 고집. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'알심','[심리상태] 1. 은근히 동정하는 마음 2. 보기보다는 야무진 힘. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'애먼','1. 엉뚱하게 딴 2. 애매하게 딴. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'어름','두 물건의 끝이 닿은 자리. # 하늘과 땅이 맞닿은 어름. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'억수','물을 퍼붓듯 세차게 내리는 비. 이보다 작은 느낌을 주는 말고 악수가 있음. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'여우볕','비 오는 날 잠깐 반짝쬐다가 사라지는 볕. 볕');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'열구름','떠가는 구름. 지나가는 구름. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'오롯이','고요하고 쓸쓸하게 호젓하게. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'오솔길','수풀속에 난 호젓한 길. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'올제','오늘의 바로 다음 날. 즉 내일을 뜻하는 토박이 말.');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'외곬','한곳으로만 통하는 길.');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'우금','시냇물이 급히 흐르는 가파르고 좁은 산골짜기. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'웃비','아직 비가 올 듯한 기색은 있으나 좍좍 내리다가 잠깐 그친 비. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'위낮은청','바리톤의 순 우리말. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'의뭉집','의뭉서러운 속내. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'의초','동기간의 우의. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'이내','해질 녘에 푸르스름하고 흐릿한 기운. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'이퉁','고집. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'입매시늉','음식을 조금 입에 대는 둥 마는 둥 하는 짓. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'자빡','결정적인 거절. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'잠비','여름철에 내리는 비. 여름에 비가 오면 잠을 잔다고 해서 붙여진 말이다. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'잠뿍','덩치가 크게 실린 모양. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'졸졸붓','만년필. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'주럼','피로하여 고단한 증세. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'즐빗이','늘어선 모양이 빗살 같이 정연하게. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'진티','일이 잘못되어 가는 빌미. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'짜장','참, 과연, 정말로. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'치레','잘 매만져서 모양을 내는 일. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'타관바치','타향사람. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'토렴','[음식] 밥이나 국수에 뜨거운 국물을 여러 차례 부었다 따랐다 하여 덥게함. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'파니','아무 하는 일 없이 노는 모양. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'푸서기','1. 거칠고 단단하지 못하여 부스러지기 쉬운 물건 2. 옹골차지 못하고 아주 무르게 생긴 사람. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'하나객담','실없고 하찮은 이야기. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'하제','내일(來日)의 토박이말.');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'하초','배꼽의 아랫부분의 배의 총칭. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'한겻','[천문, 기상] 하루의 4분의 1인 시간. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'한꼴말','동음어(同音語)를 다음은 말. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'할경','[행동] 1. 말로 경멸의 뜻을 나타냄 2. 남의 떳떳하지 못한 근본을 폭로하는 말. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'함박','분량이 차고도 남도록 낙낙하게. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'해뜩','밤을 고스란히 꼬빡 새우는 모양. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'회두리','여럿 가운데에서 맨 끝. 맨 나중에 돌아오는 차례. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'훌림목','애교 띤 목소리. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'휘뚜루마뚜루','이것저것 가리지 않고 닥치는 대로 마구 해치우는 모양. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'희나리','[목재] 덜 마른 장작. ');

select * from w1_table;


