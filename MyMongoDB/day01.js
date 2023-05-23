use mydb
show dbs
//컬렉션 생성:db.createCollection('컬렉션명')
db.createCollection('emp')
show dbs
show collections
//컬렉션의 이름 변경:db.컬렉션명.renameCollection('변경할 이름')
//emp이름을 'employee'로 변경
db.emp.renameCollection('employee')
//컬렉션 삭제:db.컬렉션명.drop()
db.employee.drop()
show collections

//컬렉션 생성시 옵션: capped:true, size:10000
//==>저장공간이 차면 기존 공간을 재상해서 새로운 데이터로 저장
//컬렉션명: cappedCol
db.createCollection('cappedCol',{capped:true, size:10000})
db.cappedCol.stats()

//컬렉션에 데이터 삽입:insertOne({속성명:속성값}), insertMany([{},{}.....])
for(i=0;i<1000;i++){
    db.cappedCol.insertOne({x:i})
}
//컬렉션 조회:db.컬렉션명.find({검색조건})
db.cappedCol.find()
db.cappedCol.find().count()
db.cappedCol.stats()
db.cappedCol.isCapped()
///emp 컬렉션 생성
db.createCollection('emp')
show collections

db.emp.stats()
db.emp.isCapped()
db.createCollection('member')

show collections
//삽입: insertOne(객체), insertMany(배열)
db.member.insertOne({
    name: '홍길동',
    userid: 'hong',
    tel: '010-1234-1234',
    age:20
})
//조회 find()
db.member.find()

db.member.insertMany([
    {name:'김길동',userid:'kim',tel:'010-1234-1523',age:22,grade:'A'},
    {name:'민들레',userid:'min',tel:'010-1234-9823',age:32,grade:'B'},
    {name:'초이',userid:'choi',tel:'010-9864-1523',age:27,grade:'C'},
    {name:'박공원',userid:'park',tel:'010-1434-1223',age:22,grade:'B'}
])
db.member.find()

db.member.insert({name:'후아유',userid:'you',tel:'010-2942-2345',age:42})
db.member.insert([
    {name:'후아유',userid:'you',tel:'010-2942-2345',age:42},
    {name:'유엔미',userid:'me',tel:'010-2142-2945',age:24}
])
db.member.find()

db.user.insertMany([
    {_id:1, name:'김철수',uid:'kim1',upw:'111'},
    {_id:2, name:'이영희',uid:'lee',upw:'222'},
    {_id:1, name:'홍길동',uid:'hong',upw:'333'}
],{ordered:false})

db.user.find()
/*
[실습1]---------------------------------------------------------------------
1. boardDB생성
2. board 컬렉션 생성
3. board 컬렉션에 name 필드값으로 "자유게시판"을 넣어본다
4. article 컬렉션을 만들어 document들을 삽입하되,
   bid필드에 3에서 만든 board컬렉션 자유게시판의 _id값이 참조되도록 처리해보자.

5. 똑 같은 방법으로 "공지사항게시판"을 만들고 그 안에 공지사항 글을 작성하자.
--------------------------------------------------------------------------
*/
use boardDB
db.article.drop()
db.board.drop()

show dbs
db.createCollection('board')
db.createCollection('article')
show collections

res=db.board.insertOne({name:'자유게시판2'})
freeboard_id=res.insertedId
db.atricle.insertMany([
    {bid:freeboard_id,title:'안녕하세요',writer:'홍길동',contexnt:'오늘 처음 글 씁니다.'},
    {bid:freeboard_id,title:'반갑',writer:'홍길서',contexnt:'반갑습니다..'},
    {bid:freeboard_id,title:'나도야 ',writer:'홍길남',contexnt:'저도 처음 글 씁니다.'}
])
db.board.find()
db.article.find()

res2=db.board.insertOne({name:'공지사항게시판'})
motice_od=res2.insertedId
db.article.insertOnc(bid:motice_id, title:'스터디그룹 모집',content:'monghodb배운번,whrete'admin')