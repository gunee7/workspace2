-- @@@@@@@@@@@@@@
-- �׷� �Լ�
-- sum : �հ�
-- avg : ���
-- count : ����
-- min : �ּҰ�
-- max : �ִ밪
-- @@@@@@@@@@@@@@

-- ��ü �������� ����Ͻÿ�
select count(*) from emp;

-- ��� ������ �޿�(sal) �Ѿ�(sum), �޿����(avg), �ִ�޿�(max), �ּұ޿�(min) ���ϱ�
select sum(sal),avg(sal),max(sal),min(sal) from emp;

-- emp ���̺��� �� ������ ������?
select count(*) from emp;

-- ename �ߺ� ������ ������ ���Ͻÿ� 17�� count + distinct ���� ����.
select count( distinct ename ) from emp;

-- Ŀ�̼�(comm)�� �޴� ������ ���� ���ϱ�. 4��
select comm from emp where comm is not null;

-- �������� Ŀ�̼�(comm) �Ѿ� ���ϱ�
select comm from emp where comm is not null;
select sum( comm ) from emp;

-- ��ü ������ ���� Ŀ�̼�(comm)�� �޴� ������ ���� ���ϱ�. �����.
select count(*) as ��ü������ ,count(comm) as Ŀ�̼������� from emp;


-- @@@@@@@@@@@@@@
-- group by ��
-- ������ �κ� �հ� ���ϱ�� ����.
-- 1. �����͸� �׷����� �� ��� 
-- 2. �׷� �Լ��� ����� �� ���
-- 3. GROUP BY ���� ��õ� �÷��� SELECT ���� ����� �� �ִ�.
-- @@@@@@@@@@@@@@



-- -----------------------------------
-- a. ��ü �����߿��� �ִ�޿��� �ּұ޿��� ����Ͻÿ�
select max(sal), min(sal) from emp;
-- -----------------------------------

-- -----------------------------------
-- b. deptno�� 10�� �μ��� �ִ�, �ּұ޿� ����Ͻ�
-- -----------------------------------
select max(sal), min(sal) from emp where deptno=10;

-- -----------------------------------
-- c. �μ��� �ִ�, �ּ� �޿� ���ϱ�
select distinct deptno from emp order by deptno asc;
-- -----------------------------------

-- c.1 union�� �̿��ϴ� ���
-- deptno = 10 �� �����߿��� �޿�(sal)�� �ִ�, �ּҸ� ���Ͻÿ�
-- deptno = 20 �� �����߿��� �޿�(sal)�� �ִ�, �ּҸ� ���Ͻÿ�
-- deptno = 21 �� �����߿��� �޿�(sal)�� �ִ�, �ּҸ� ���Ͻÿ�
-- deptno = 30 �� �����߿��� �޿�(sal)�� �ִ�, �ּҸ� ���Ͻÿ�
-- deptno = 31 �� �����߿��� �޿�(sal)�� �ִ�, �ּҸ� ���Ͻÿ�
select max(sal), min(sal) from emp where deptno=31
union
select max(sal), min(sal) from emp where deptno=10
union
select max(sal), min(sal) from emp where deptno=20
union
select max(sal), min(sal) from emp where deptno=21
union
select max(sal), min(sal) from emp where deptno=30
union
select max(sal), min(sal) from emp where deptno=31;

-- c.2 group by�� �̿��ϴ� ���
select deptno, max(sal), min(sal) from emp group by deptno;



-- -----------------------------------
-- emp ���̺��� �ߺ����� �ʴ� ��å(job)�� �������� ����Ͻÿ�
-- 1. �����͸� ����ϵ� ��å(job)�� �������� ������������ ���� �Ͻÿ�.
-- 2. ��å(job)�� �������� ����Ͻÿ�
-- -----------------------------------
select job, count(job) from emp group by job order by job asc;




-- -----------------------------------
-- emp ���̺��� �μ���(deptno)�� �������� Ŀ�̼�(comm)�� �޴� �������� 
-- �����ȣ(deptno) ������������ ����Ͻÿ�
-- ������: �μ���ȣ, �μ���������, �μ���Ŀ�̼ǹ޴�������
-- -----------------------------------
select deptno, count(deptno), count(comm) from emp group by deptno order by deptno asc; �����Ѱ�
select deptno, count(*), count(comm) from emp group by deptno order by deptno asc;



-- @@@@@@@@@@@@@@
-- having ��
-- �׷��ε� �����Ϳ��� �˻��� �� ���
-- group by ���� �׻� ���� ���Ǿ�� ��
-- �ܵ� ��� �Ұ�
-- @@@@@@@@@@@@@@


-- -----------------------------------
-- �μ��� ��� �޿�(sal)�� �μ���ȣ(deptno) ����Ͻÿ�.
-- -----------------------------------
select deptno, avg(sal) from emp group by deptno;

-- -----------------------------------
-- �μ��� �޿� ����� 500�̻��� �μ� ��ȣ�� �޿� ��� ���ϱ�
-- 1. �μ����� �μ���ȣ�� �޿���� ���ϱ�
select deptno, avg(sal)
from emp
group by deptno;
-- 2. �׷��ε� �����Ϳ��� �޿� ����� 500�̻��� �����͸� ��˻�
-- -----------------------------------
select deptno, avg(sal)
from emp
group by deptno
having avg(sal) >= 500;


-- -----------------------------------
-- �μ���ȣ(deptno)�� 10, 20, 30�� �μ��߿��� 
-- �μ��� �μ���ȣ�� �޿�(sal)��� ����Ͻÿ�
-- �μ��� �޿������ 500�̻��� �μ���ȣ�� �޿���� ���ϱ�
-- ���� �����͸� �μ���ȣ ������������ �����Ͻÿ�. 
-- 
-- �μ���ȣ(deptno)�� 10, 20, 30�� --> where
-- �μ���                          --> group by
-- �μ���ȣ�� �޿�(sal)��� ���   --> select
-- �μ��� �޿������ 500�̻�       --> having
-- 
-- deptno=20 �� ��µǸ� ����. 1��
-- -----------------------------------
select avg(sal),
deptno from emp
where deptno in (10,20,30)
group by deptno
having avg(sal) >= 500
order by deptno asc;


-- -----------------------------------
-- ���� 1: ���޺� �޿� �Ѿ� ���ϱ�
-- '���'�� �����ϰ� 
-- ����(job)�� 
-- �޿��Ѿ��� 1000 �̻��� ���� �߿���
-- �޿��Ѿװ� ������ ����Ͻÿ�.
-- ��, ��½� �޿��Ѿ� ������ �������� �����Ѵ�.
--                            --> select
-- '���'�� ����              --> where
-- ����(job)��                --> group by
-- �޿� �Ѿ��� 1000 �̻�      --> having
-- �޿��Ѿ� ������ �����Ͻÿ� --> order by
-- -----------------------------------
select job, sum(sal)
from emp
where job != '���'
group by job
having sum(sal) >= 1000
order by sum(sal) asc;


-- -----------------------------------
-- ���� 2:  
-- ���� �ֱٿ� �Ի��� ������ �Ի���(hiredate)�� �̸�(ename)�� ���Ͻÿ�. "�߽ż� ���"
-- 2.1 oracle�� rowid�� rownum�� �䳻���� ���
-- 2.2 limit �� �̿��ϴ� ���
-- -----------------------------------
-- ���߿� ���� �ؾ� �ϴ� ����
select max(hiredate) from emp
select ename, hiredate from emp where hiredate = ( select max(hiredate) from emp);



-- -----------------------------------
-- ���� 3:  
-- �ֱٿ� �Ի��� ���� 10���� �Ի���(hiredate) �� �̸�(ename)�� ���Ͻÿ�
-- 3.1 oracle : rowid�� rownum�� �䳻���� ���
-- 3.2 mysql  : top�� �̿��ϴ� ���
-- 3.3 mysql  : limit�� �̿��ϴ� ���
-- -----------------------------------
select rownum, ename hiredate from emp;
select rownum, ename, hiredate from emp order by hiredate desc;

select * from
select rownum, ename, hiredate
 from ( select rownum, ename, hiredate from emp order by hiredate desc)
 where rownum <= 10;

-- @@@@@@@@@@@@@@
-- �̼�
-- @@@@@@@@@@@@@@

-- �̼� 1. �޿� �ְ��, ������, �Ѿ� �� ����� ����Ͻÿ�
select max(sal) �ְ��, min(sal) ������, sum(sal) �Ѿ�, avg(sal) ��� from emp;
-- �̼� 2. ��� ����(job)���� �޿� �ְ��, ������, �Ѿ� �� ��� �޿� ����Ͻÿ�.
select job, max(sal), min(sal), sum(sal), avg(sal) job from emp group by job;
-- �̼� 3. ��� ����(job)�� �������� ����ϱ�.
select job, count(job) from emp group by job;
-- �̼� 4. ������ ���� ����Ͻÿ�.
select job, count(job) from emp where job = '����' group by job;

-- �̼� 5. ���޺� �޿� �Ѿ��� ���Ͻÿ�.
--         a. ������ �����ϴ� ������ �ۼ�
select job
from emp
where job != '���';

--         b. ������ �����ϰ� ���޺� �޿� �Ѿ�(sum) ���ϱ�
select job, sum(sal)
from emp
where job != '���'
group by job;

--         c. ������ �����ϰ� ���޺� �޿� �Ѿ��� 1000 �̻���  �����͸� ���.
select job, sum(sal)
from emp
where job != '���'
group by job
having sum(sal) >= 1000
order by sum(sal) asc;

-- �̼� 6. �޿� �ְ��, �޿� �������� ���� ����Ͻÿ�.
select max(sal), min(sal) from emp;
select max(sal) - min(sal) from emp;

-- �̼� 7. ���޺� ������ ���� �޿� ����Ͻÿ�.
select job, min(sal)
from emp
group by job;

-- �̼� 8. �μ����� �μ���ȣ, ������, ��� �޿� ����Ͻÿ�.
select deptno, count(deptno), avg(sal) from emp group by deptno order by deptno asc;
