use mydb
db
show dbs
show collections
db.member.find()
db.emp.drop()
db.emp.insertOne({empno:7369, ename:'SMITH',sal:800, deptno:20, job:'CLERK'})
db.emp.find()
db.emp.insertMany([
{empno:7499, ename:'ALLEN',sal:1600,deptno:30, job:'SALESMAN',com:300},
{empno:7521, ename:'WARD',sal:1250,deptno:30, job:'SALESMAN',com:0},
])

var empArr=[
        {
                "empno" : 7499,
                "ename" : "ALLEN",
                "job" : "SALESMAN",
                "mgr" : 7698,
                "hiredate" : "1981-02-20",
                "sal" : 1600.00,
                "comm" : 300.00,
                "deptno" : "30"
        },
        {
                "empno" : 7521,
                "ename" : "WARD",
                "job" : "SALESMAN",
                "mgr" : 7698,
                "hiredate" : "1981-02-22",
                "sal" : 1250.00,
                "comm" : 500.00,
                "deptno" : "30"
        },
        {
                "empno" : 7654,
                "ename" : "MARTIN",
                "job" : "SALESMAN",
                "mgr" : 7698,
                "hiredate" : "1981-09-28",
                "sal" : 1250.00,
                "comm" : 1400.00,
                "deptno" : 30
        },
        {
                "empno" : 7844,
                "ename" : "TURNER",
                "job" : "SALESMAN",
                "mgr" : 7698,
                "hiredate" : "1981-09-08",
                "sal" : 1500.00,
                "comm" : 0.00,
                "deptno" : 30
              },

{"empno":7369, "ename":"SMITH","job":"CLERK",mgr:7902,"hiredate" : "1980-12-17","sal":800.0, "comm" : "0.00","deptno":20},
{"empno":7566, "ename":"JONES","job":"MANAGER",mgr:7839,"hiredate" : "1981-04-02","sal":2975.0, "comm" : "0.00","deptno":20.0},
{"empno":7782,"ename":"CLARK","job":"MANAGER",mgr:7839,"hiredate" : "1981-09-08","sal":2450.0, "comm" : "0.00","deptno":10.0},
{"empno":7934,"ename":"MILLER","job":"CLERK",mgr:7782,"hiredate" : "1981-09-08","sal":1300.0, "comm" : "0.00","deptno":10.0},
{"empno":7788,"ename":"SCOTT","job":"ANALYST",mgr:7566,"hiredate" : "1982-12-09","sal":3000.0, "comm" : "0.00","deptno":10.0},
{"empno":7839,"ename":"KING","job":"PRESIDENT","hiredate" : "1981-11-17","sal":5000.0, "comm" : "0.00","deptno":10.0},
{"empno":7876,"ename":"ADAMS","job":"CLERK",mgr:7788,"hiredate" : "1983-01-12","sal":1100.0, "comm" : "0.00","deptno":20.0},
{"empno":7902,"ename":"FORD","job":"ANALYST",mgr:7566,"hiredate" : "1981-12-03","sal":3000.0, "comm" : "0.00","deptno":20.0},
{"empno":7934,"ename":"MILLER","job":"CLERK",mgr:7782,"hiredate" : "1982-01-23","sal":1300.0, "comm" : "0.00","deptno":10.0}
]
db.emp.insertMany(empArr)
db.emp.find()

var deptArr=[{
                "deptno" : 10,
                "dname" : "ACCOUNTING",
                "loc" : "NEW YORK"
        },
        {
                "deptno" : 20,
                "dname" : "RESEARCH",
                "loc" : "DALLAS"
        },
        {
                "deptno" : 30,
                "dname" : "SALES",
                "loc" : "CHICAGO"
        },
        {
                "deptno" : 40,
                "dname" : "OPERATIONS",
                "loc" : "BOSTON"
        }
  ]
db.dept.insertMany(deptArr)
db.dept.find()

//db.컬렌션명.find({}) ==> select * from 컬렉션
//findOne()
//find({조건},{필드들})
//member에서 이름과 아이디만 가져오기
db.member.find({},{name:1,userid:1,_id:0})
//select name, userid from member
db.member.find({},{name:true,userid:true,_id:false})

//member에서 나이가 20세인 회원 정보 중 이름, 아이디, 나이를 보여주세요
db.member.find({age:20},{name:1, userid:1, age:1})

db.member.drop()

db.member.insertMany([
	{name:'홍길동',userid:'hong',tel:'010-1222-3333',age:20, grade:'A'},	
	{name:'김수지',userid:'kim',tel:'010-2222-3333',age:22, grade:'C'},
	{name:'신철민',userid:'shincm',tel:'010-3222-3333',age:25, grade:'B'},
	{name:'김유신',userid:'youshin',tel:'010-3222-3333',age:25, grade:'C'},
	{name:'홍명희',userid:'hong2',tel:'010-5222-3333',age:19, grade:'A'},
	{name:'이신혜',userid:'leeshinhye',tel:'010-1222-33633',age:23}
]);
/*
--------------------------------------------------
비교 문법
$eq     =    
$gt     >    
$gte    >=   
$in          목록 중의 어느 하나라도 있는지 여부를 체크
$lt     <    
$lte    <=   
$ne     !=   not equal
$nin         $in의 반대. not in

논리연산
$and : 배열안 두개 이상의 조건이 모두 참인 경우를 반환 
$or  : 배열안 두개 이상의 조건 중 하나라도 참인 경우를 반환 
$nor : $or의 반대. 배열안 두개 이상의 조건이 모두 아닌 경우 를 반환
-------------------------------------------------------------
*/
db.member.find()
//나이가 20세이고 아이디가 'hong'인 회원 정보를 보여주세요
db.member.find({age:20, userid:'hong'})
//나이가 20세이거나 아이디가 'hong2'인 회원 정보를 보여주세요
db.member.find({$or:[{age:20},{userid:'hong2'}]})
//select * from where age=20 or userid='hong2'
//<1>member에서 userid가 'shincm'인 회원의 name,userid,tel가져오기
db.member.find({userid:'shincm'},{name:1,userid:1,tel:1})
//<2> age가 25세 이거나 이름이 김수지인 회원의 모든 정보 가져오기
db.member.find({$or:[{age:25},{name:'김수지'}]})
//<3> 나이가 22세 초과인 회원의 이름,나이만 가져오기
db.member.find({age:{$gt:22}},{name:1,age:1,_id:0})
//<4> emp에서 사원의 이름과 급여를 가져와 보여주세요
db.emp.find({},{ename:1,sal:1})
//<5> emp에서 담당 업무가 'MANAGER'인 사원의 사번,이름,업무를 보여주세요
db.emp.find({job:'MANAGER'},{empno:1,ename:1,job:1})
//<6> emp에서 급여가 3000 이상인 사원의 사원번호,이름,	담당업무,급여를 출력하세요
db.emp.find({sal:{$gte:3000}},{empno:1, ename:1,job:1,sal:1})
//<7> emp 급여가 1300에서 2000사이의 사원의 이름,업무,급여,부서번호를 출력하세요
db.emp.find({$and:[{sal:{$gte:1300}},{sal:{$lte:2000}}]},{ename:1,job:1,sal:1,deptno:1})
//<8>	emp에서 사원번호가 7369,7654,7934인 사원의 사원번호,이름,업무,급여,입사일자를 출력하세요.
db.emp.find({empno:{$in:[7369,7654,7934]}},{empno:1, name:1, job:1, sal:1, hiredate:1})
//<9>	emp에서부서번호가 20번 부서인 사원의 이름,업무,부서번호를 출력하세요
db.emp.find({deptno:20},{ename:1, job:1, deptno:1})
//<10> emp에서 부서번호가 20번 부서가 아닌 사원의 이름,업무,부서번호를 출력하세요
db.emp.find({deptno:{$ne:20}},{ename:1,job:1,deptno:1})
//<11> emp에서업무가 CLERK이거나 MANAGER인 사원의 모든 정보를 출력하세요
db.emp.find({$or:[{job:'CLERK'},{job:'MANAGER'}]})
//<12> emp에서업무가 CLERK이거나 MANAGER가 아닌 사원의 모든 정보를 출력하세요
db.emp.find({$nor:[{job:'CLERK'},{job:'MANAGER'}]})

//like절: 정규식 $regex연산자 활용
//member에서 userid에 'm'자가 들어있는 회원정보를 보여주세요
db.member.find({userid:{$regex:/m/}}) //userid like '%m%'와 동일
//member에서 userid에 'sh'가 들어가 있는 회원정보를 보여주세요
db.member.find({userid:/sh/})
//userid가 shin으로 시작하는 회원정보  ^
db.member.find({userid:/^shin/})
//userid가 shin으로 끝나는 회원정보  $
db.member.find({userid:/shin$/})
//<1> emp에서 이름이 S로 시작하는 사람의 정보를 보여주세요
db.emp.find({ename:/^S/})
//<2>이름 중 S로 끝나는 사람의 정보를 보여주세요
db.emp.find({ename:/S$/})
//<3>이름 중 E자가 들어가는 사람의 정보를 보여주세요.
db.emp.find({ename:/E/})

//order by절: find().sort({정렬기준필드: 1}), 오름차순:1, 내림차순:-1
//member에서 나이가 22세 이하인 정보를 보여주되 나이를 오름차순
db.member.find({age:{$lte:22}}).sort({age:1})
db.member.find({age:{$lte:22}}).sort({age:-1})
//<1> 회원의 나이를 내림차순으로 정렬하고, 같은 나이일 때는 이름 가나다순으로 정렬해서 출력하세요
db.member.find().sort({age:-1,name:1})
//<2> emp에서 부서번호로 정렬한 후 부서번호가 같을 경우 급여가 많은 순으로 정렬하여 사번,이름,부서번호,급여를 출력하세요
db.emp.find({},{empno:1, ename:1, deptno:1,sal:1}).sort({dept:1,sal:-1})
//<3> emp에서 부서번호가 10,20인 사원의 이름,부서번호,업무를 출력하되 이름 순으로 정렬하시오
db.emp.find({deptno:{$in:[10,20]}},{ename:1,deptno:1,job:1}).sort({ename:1})

//find().count()함수 활용
//select count(*) from member
db.member.find().count()
db.emp.find().count()
//member에서 성적이 'a'인 회원이 몇명인지 보여주세요
db.member.find({grade:'A'}).count()
//member에서 성적이 없는 회원이 몇명인지 보여주세요
db.member.find({grade:{$exists:false}}).count() //$exists:true(1)/false(0)

//limit()함수 활용
//select * from member limit 3
db.member.find().limit(3)
db.member.find({grade:{$exists:1}}).sort({grade:1}).limit(3)

//distinct()함수 활용
//select distinct(age) from emp
db.member.distinct('age')


//<1> emp에서 30번 부서의 사원수를 출력하시오.
db.emp.find({deptno:30}).count()
//<2> emp에서 보너스(comm)을 받는 사원의 수를 출력하시오
db.emp.find({comm:{$gt:0}}).count()
//<3> 직업이 SALESMAN이면서 보너스를 100이상 받는 사원수를 출력하시오
db.emp.find({$and:[{job:'SALESMAN'},{comm:{$gte:100}}]}).count()
//<4> emp에서 중복되지 않는 부서번호를 출력하세요.
db.emp.distinct('deptno')
//<5> emp의 직업군을 보여주세요
db.emp.distinct('job')

//Embeded Document(내장형 문서) 조회
db.inventory.insertMany( [     
{ item: "journal", qty: 25, size: { h: 14, w: 21, uom: "cm" }, status: "A" } , 
{ item: "notebook", qty: 50, size: { h: 8.5, w: 11, uom: "in" }, status: "A" } , 
{ item: "paper", qty: 100, size: { h: 8.5, w: 11, uom: "in" }, status: "D" } , 
{ item: "planner", qty: 75, size: { h: 22.85, w: 30, uom: "cm" }, status: "D" } , 
{ item: "postcard", qty: 45, size: { h: 10, w: 15.25, uom: "cm" }, status: "A" } 
]);

//상품 중에서 size가 높이:10, 폭:15.25, 단위:'cm'인 상품 조회
db.inventory.find()
db.inventory.find({size:{h:10,w:15.25,uom:'cm'}})
//size중 높이가 10미만인 상품을 보여주세요
db.inventory.find({size:{$lt:{h:10}}})
db.inventory.find({'size.h':{$lt:10}})
//단위가(uom)가 cm인 상품들만 가져와 보여주세요
db.inventory.find({'size.uom':'cm'})
//높이가 10미만인 상품 중 상태가 'A'급인 상품만 보여주세요
db.inventory.find({'size:h':{$lt:10}, status:'A'})

db.inventory.insertMany([
	{ item: "journal", qty: 25, tags: ["blank", "red"], dim_cm: [ 14, 21 ] },
	 { item: "notebook", qty: 50, tags: ["red", "blank"], dim_cm: [ 14, 21 ] },
	 { item: "paper", qty: 100, tags: ["red", "blank", "plain"], dim_cm: [ 14, 21 ] },
	 { item: "planner", qty: 75, tags: ["blank", "red"], dim_cm: [ 22.85, 30 ] },
	 { item: "postcard", qty: 45, tags: ["blue"], dim_cm: [ 10, 15.25 ] },
	 { item: "card", qty: 55, tags: ["red"], dim_cm: [ 9, 9 ] }  
]);
db.inventory.insertOne({ item: "card2", qty: 155, tags: ["red"], dim_cm: [ 9, 9 ], 
    review:[
    {no:1,content:'좋아요',userid:'aa'},
    {no:2,content:'너무 좋아요',userid:'bb'},
    {no:3,content:'그냥 그래요',userid:'cc'}
    ] })
db.inventory.find()

//tag "red", "blank" 값이 있는 상품을 조회
db.inventory.find({tags:["red","blank"]})

//배열 선택자
//$all: 주어진 조건에 모든 요소를 포함하는 배열
//$elemMatch: 주어진 조건의 요소와 일치하는 배열
//$size: 크기 조건과 일치하는 배열

db.inventory.find({tags:{$all:['red','blank']}})
//tags배열의 크기가 2인 상품을 가져와보세ㅛ
db.inventory.find({tags:{$size:2}})
//dim_cm에 25이상 값이 포함된 상품을 가져오세요
db.inventory.find({dim_cm:{$gte:25}})
db.inventory.find({'dim_cm.0':{$gte:12}})
db.inventory.find({'dim_cm.1':{$gte:24}})

//review중 글번호가 1번 달려있는 상품 정보
db.inventory.find({review:{$elemMatch:{no:1}}})
db.inventory.find()

let cr=db.member.find()
while(cr.hasNext()){
    pirntjson(cr.next())
}
//forEach()
var cr2=db.member.find({grade:'A'})
cr2.forEach(printjson)

//배열로 받기
let cr3=db.emp.find({deptno:30})
let arr=cr3.toArray();
arr[0]
arr[1]
for(i=0;i<arr.length;i++){
    arr[i]
}

//update
//updateOne():1개의 도큐먼트 수정
//updateMany():여러개 수정
//replaceOne({조건},{교체할 문서}):도큐먼트를 교체하는 함수
//replaveOne()의 옵션 upsert:true값을 주면, 검색 조건의 문서가 없을경우 insert함
db.member.find(
)
db.member.replaceOne({userid:/lee/},{name:'이혜신',userid:'lee',tel:'010-6222-333',age:24})
db.member.replaceOne({userid:'choi'},{name:'최명길',userid:'choi',tel:'010-7222-3333',age:25},{upsert:true})

//updateOne()/updateMany()
//$set연산자: 필드값을 설정할 때 사용
db.member.updateMany({age:{$lt:22}},{$set:{grade:'B+'}})






