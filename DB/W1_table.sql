
--W1 ���̺� ����
create table w1_table(
W1_NO NUMBER(5),
W1 VARCHAR2(30),
W1_H VARCHAR2(200),
constraint PK_W1_NO PRIMARY KEY(W1_NO));

--W1 ���츮�� ������ ����
CREATE SEQUENCE W1_SQ
INCREMENT BY 1
START WITH 1
MAXVALUE 99999
MINVALUE 1
NOCYCLE
NOCACHE;

drop sequence w1_sq;

--W1 ���츮�� DB ����
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'����','��ǥ�� ���ؿ� �°� �� ������ ��Ƹ��� ��, ��Ʒ� ���� ����. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'������','���� ��� ���Ⱑ ���� ��. ��(��). �ط���(����ة) ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'��ġ����','ǳ���� �� �� �ھƿ����� �Ͼ� ����ǰ.');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'��Ż','1. ���� �����ϰ� ���� �ʵ��� �����ϴ� �� 2. ���� Ʈ���� ��� ��ٷӰ� ���� ��. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'���ٱ���','[�׹�] ���� ���� ���� ���� �͸� ��� �������� ���̾� ���� ��� ��. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'���߷�','[��, �繰] �� ������Լ� ���� �׼��� ���̳� ������ �ŵ�. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'������','���� �Ͽ� �ѹ��� ���� ���. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'������','1. ������ �� �����Ͽ� ������. 2. ������. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'��ġ��','������ �濡�� ������ ��� �����ڴ� ��. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'����','����, ���� ������ �������� �Լ��� ���� ���̾� �� ����. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'������','���� �� ���� ����. ������. ����(��٥). ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'������','[�ൿ] ������ ��� ����. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'����','���� �̸����� ���� ��. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'������','�տ� �ͼ��� ����. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'����','1. �������� ����� ��. 2. ���� ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'������','ä�ҹ�. (���) ä���� ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�����ƺ�','�Ƴ��� �ִ� �系. ���γ�(������).');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�������','������ �ִ� ����. ���γ�(����ҳ). ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'������','���� �� ���������ϱ���, ������� ����Ͽ� ���´� ��.');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�ʳ�����','���� �ʴ� ���� �ϰ� �θ��� �ͳ��� ������ ����. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�ʸ���','1. ���̳� ���� ������� �ּ��ϴ� �ؾ� 2. �ǼҸ����� ������ ����.');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�ʽ���','[�ൿ] ���� ����� �þ���� ���ؾ�. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�ʿ�','[õ��, ���] �ٴ��� �糪�� ū ����. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�ʿﰡ��','���� �� ��ʹ� �ؾ�. ���Ӽ�. ���뼺. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�˻�','���� ���� ���׹��� ���� ��. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�ʹ���','�Ҹ��� ��ĥ ������ ���� ����. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�����Ҹ�','���� �Ѱ� �ǹ��� �Ҹ�. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�׶Ѹ�','[�ൿ] ����̳� ������ ���ſ��� ������� �ʰ� ���� �� ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'���','�������� ��. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�������','�Ƿ��� ���� �ɺθ���. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'���','1. ������ ������ ����. �׻� 2. �ݵ��, �� ��������. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'���','�����Ϳ� �ϸ� ���̿� �� ����. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'���㵷','�� ���� ������ �� ��� ���. �Ǵ�, �󿩲۵鿡�� �� �ִ� ����� ����. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�����ٶ�','�ϵ�ǳ. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'������','���� �ҿ뵹�� ġ�� �귯������ ���. ����, �ҿ뵹��. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�°�','[õ��, ���] �Ȱ����� ���� ���� �̽��񺸴� ���� ���� ��. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'����','������ ���� ������ ���ɼ�. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�ٸ��丮','ū ������ ���ָ� ���ô� ��. �Ǵ� ū ������ ���ָ� �Ĵ� ��. *������. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�ټ�','��ƶ�� ����� ����.');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�۴�','���ƴ뼭 �۾Ƽ���. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�ܴ�ٶ�','�ܹ��� ����. [���]��ٶ�. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�ޱ���','�̸� ������ ���� �� ��. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'����','�� ���� �� ����. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'���','���� ������ ���� ������ �ൿ�ϴ� ���. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'���','�绡�� ������ų� Ž������ �ȴ� ���. [���]���. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�백��','������ ���� ������ ������ �״�� ����. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'���','�ºθ� ���������� �����ϴ� ��. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'��ٶ�','��ǳ. ���ʿ��� �δ� ū �ٶ�. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'��ٶ�','[�׹�] 1. �Ͽ� ���Ͽ� �� ù������ 2. �ܹ��� ��ü���� �ʰ� ��. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'��¥','���� �Ǵ� ���. ��, ������. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'���ͱ�','������ �Ѱܾ���ų� �Ѱܹ��� �����Ÿ�. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'������츲','�繰�� �ִٰ��� ��� �ῡ ���ڱ� �������� ������ �Ҿ����� �츲������ ������. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'������ħ','�԰� �; ��Ű�� ħ. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'������','[����, ����]����� ���� ���� �ʴ� ���� ��. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'������','[õ��, ���] ó������ �ھƿ����� �޺�. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�������','�� ��� �̻��� ���� �濵�ϴ� ���. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�ɳ�','�� �� �ִ� ���ɼ�. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�η�','[����] �븧�̳� ���̷� ���� ����� ���� ��. ���� ������ �ѵ� ���� ����. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�η�','���̿��� ����⿡ ���� �����Ͽ� ���� �۾��� �ϱ� ���� ���� ����.');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�ݵ���','�ڿ��� �ŵ�� �����ִ� ��. �Ǵ� �׷� ���. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�޹�','[��] ǥ�鿡 ������ �ʰ� �ڿ��� �������ִ� ��. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�����','�鿡 õ���� �� ���� �Ʒ��̳� �޾��� �ϴ� ��Ȱ. [���]�߿�, ķ��.');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'��¸�','[��(��)] �ܷ���. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'���ָӴ�','�ַ� ���ڵ��� �տ� ��� �ٴϴ� �ָӴ�. �ڵ��. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�����ε�','������ ���� �̷��������� ������ ���. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'����','��÷. ��÷�ϴ� ��. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'����','1. ���� ���� ��� 2. Ű�� ���� ���. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�ұ�','���� ��Ƽ�� ���� ���. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�����','������ ��������� �췯���� ���̳� ���� ��.');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'������','���� ���� �巯���� �������� �ܴ��� �ž� �� ����. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'����','ó�� ���� ����.');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'����','[��(��)] ���� ���ϴ� �翡�� ���޾� �����ϴ� ��. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'���ű�','���. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�ŷոŷ�','���̳� ������ �ǷǶǷ��� ���. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�ۼ���','�ʹ� �ǰ��Ͽ� �ƹ� ������ ������ �ڴ� ��. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'����','[����] ���� ����� ���̳� ��ġ������ ���̴� ��. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'����','[����] �����ϰ� �ɼ��İ� ����� �θ��� ����.  ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'���ż�','���� �� ���� ���� �� �⻵�ϰų� ���� �� �𸣴� ���. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�̸���','���ϼ� ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�̸�','���迡�� ���� ���� ��ġ. ���');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'����','�ٸ� ���� ����, ����, ����, ����. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'����','�Ÿ��� �� ������. ���̰� �ſ� ª��. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'��״�','���� �״�. ��, ���� ����̳� ����. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'���','��� ������ ����� ����. [���]��Һ�. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�����','[����] ���� ������ �ձ۰� ��� ��� ����� ������ �θ����� �� ���� ����. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'���Ƽ','�����ϴ� ����. ���׽�. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�����','���ǿ� ���� ����. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�����','����μ� ��� ���̴� ��. [���]����(����) ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'��¯','����ϰ� ������ �Ӹ���. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'����','�����ϴ� �����. �����. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�̺�','�� ������ �ձ۰� ���� �׸��� õõ�� ���� ���. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'����','�������� ���� ���� �ۺξ� �ο�. ���� �÷��� �������� ��. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�ϻ�','���� ������� ���� �ߴܽ����� �λ궰�� ��.');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'���','����. ��� ���� �ְ� �ϴ� ���');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'��Ƴ�','��̿� �µ��� �����Ÿ�. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'����','� �ൿ�� �ſ� ���� �Ͼ�� ���. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�Ƿη�','������������ ��� �����̴� ���. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�糯','[����] 1. ���� �ϰ� ���� ��� �ϴ� �µ��� ���� 2. �������� ���� �Ͽ� ������ ���ϴ� ��. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'��ٻ��','�ޱ������� �����Ͽ� ������� �ذ��ϰų� �̲��� �޴� ��.');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'��ö���','������ ����̳� ����. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'����','����. ����. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'������','[����] �����Ͽ� �� ���� �ʿ��� ���� ����. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'����','[õ��, ���] ���� �� ����. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'������','������ ����. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'����','1. ���� ���� 2. ���� ȿ��. ���� ���� 3. �� ���Ѿ� �� ���. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�ջ緡','[�ൿ] � ���� �����ϰų� �����ϱ⸦ �䱸�� �� ���� �켭 ������ ��. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�ֺ���','�̽����� ���� ���� ���� ���. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�ó����','1. ���� ���ϴ� ���̿� ���ݾ� ���ݾ� 2. �ٸ� ���� �ϴ� ���� ���̿�.');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'����','ģô�� ���ϴ� ����. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'����','[����] �� �� �� ���� �����ϰ� �س����� ����. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�˽�','[�ɸ�����] 1. ������ �����ϴ� ���� 2. ���⺸�ٴ� �߹��� ��. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�ָ�','1. �����ϰ� �� 2. �ָ��ϰ� ��. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�','�� ������ ���� ���� �ڸ�. # �ϴð� ���� �´��� �. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'���','���� �ۺ׵� ������ ������ ��. �̺��� ���� ������ �ִ� ���� �Ǽ��� ����. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'���캵','�� ���� �� ��� ��¦�شٰ� ������� ��. ��');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'������','������ ����. �������� ����. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'������','����ϰ� �����ϰ� ȣ���ϰ�. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'���ֱ�','��Ǯ�ӿ� �� ȣ���� ��. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'����','������ �ٷ� ���� ��. �� ������ ���ϴ� ����� ��.');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�ܰ�','�Ѱ����θ� ���ϴ� ��.');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'���','�ó����� ���� �帣�� ���ĸ��� ���� ���¥��. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'����','���� �� �� ���� ����� ������ ���� �����ٰ� ��� ��ģ ��. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'������û','�ٸ����� �� �츮��. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�ǹ���','�ǹ������� �ӳ�. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'����','���Ⱓ�� ����. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�̳�','���� �迡 Ǫ�������ϰ� �帴�� ���. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'����','����. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�ԸŽô�','������ ���� �Կ� ��� �� ���� �� �ϴ� ��. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�ں�','�������� ����. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'���','����ö�� ������ ��. ������ �� ���� ���� �ٰܴ� �ؼ� �ٿ��� ���̴�. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'���','��ġ�� ũ�� �Ǹ� ���. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'������','������. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�ַ�','�Ƿ��Ͽ� ����� ����. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�����','�þ ����� ���� ���� �����ϰ�. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'��Ƽ','���� �߸��Ǿ� ���� ����. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'¥��','��, ����, ������. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'ġ��','�� �Ÿ����� ����� ���� ��. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'Ÿ����ġ','Ÿ����. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'���','[����] ���̳� ������ �߰ſ� ������ ���� ���� �ξ��� ������ �Ͽ� ������. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�Ĵ�','�ƹ� �ϴ� �� ���� ��� ���. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'Ǫ����','1. ��ĥ�� �ܴ����� ���Ͽ� �ν������� ���� ���� 2. �˰����� ���ϰ� ���� ������ ���� ���. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�ϳ�����','�Ǿ��� ������ �̾߱�. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'����','����(ҭ��)�� ����̸�.');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'����','����� �Ʒ��κ��� ���� ��Ī. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�Ѱ�','[õ��, ���] �Ϸ��� 4���� 1�� �ð�. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�Ѳø�','������(������)�� ������ ��. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�Ұ�','[�ൿ] 1. ���� ����� ���� ��Ÿ�� 2. ���� �������� ���� �ٺ��� �����ϴ� ��. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�Թ�','�з��� ���� ������ �����ϰ�. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�ض�','���� ������ ���� ����� ���. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'ȸ�θ�','���� ������� �� ��. �� ���߿� ���ƿ��� ����. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�Ǹ���','�ֱ� �� ��Ҹ�. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�ֶѷ縶�ѷ�','�̰����� ������ �ʰ� ��ġ�� ��� ���� ��ġ��� ���. ');
INSERT INTO W1_table VALUES(W1_SQ.NEXTVAL,'�񳪸�','[����] �� ���� ����. ');

select * from w1_table;


