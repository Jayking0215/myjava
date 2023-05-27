/*
집계 파이프라인 명령어 aggregation
$project : select절
$match: where절, having절
$group: group by절
$sort : order by절
$limit
$unwind
*/
use mydb
db
db.articles.insertMany([
    { "_id" : ObjectId("512bc95fe835e68f199c8686"), "author" : "john", "score" : 80, "views" : 100 },
    { "_id" : ObjectId("512bc962e835e68f199c8687"), "author" : "john", "score" : 85, "views" : 521 },
    { "_id" : ObjectId("55f5a192d4bede9ac365b257"), "author" : "ahn", "score" : 60, "views" : 1000 },
    { "_id" : ObjectId("55f5a192d4bede9ac365b258"), "author" : "li", "score" : 55, "views" : 5000 },
    { "_id" : ObjectId("55f5a1d3d4bede9ac365b259"), "author" : "annT", "score" : 60, "views" : 50 },
    { "_id" : ObjectId("55f5a1d3d4bede9ac365b25a"), "author" : "li", "score" : 94, "views" : 999 },
    { "_id" : ObjectId("55f5a1d3d4bede9ac365b25b"), "author" : "ty", "score" : 95, "views" : 1000 }
])
db.articles.find()

//select author,score from articles
db.articles.aggregate([{
    $project:{_id:0, author:1, score:1}
}])
//select * from articles where author='annT'
db.articles.aggregate([{
    $match:{author:'li'}
}])
//select * from articles where author='li and score>=60
db.articles.aggregate([{
    $match:{author:'li',score:{$gte:60}}
}])
//작성자별 score 총합계 점수를 보여주세요
//select author, sum(score) totalScore from articles group by author
db.articles.aggregate([{
    $group:{_id:'$author',totalScore:{$sum:'$score'}}
}])
//select author, sum(score) totalScore from articles group by author 
//having totalScore > 100
db.articles.aggregate([    
    {
        $group:{_id:'$author',totalScore:{$sum:'$score'}}
    },
    {
        $match:{totalScore:{$gt:100}}
    }        
])
//select count(*) from articles
db.articles.aggregate([
    {
         $group:{
             _id:null,
             cnt:{$sum:1}
         }   
    }
])
//$sum:1==>도큐먼트 하나당 1을 더하라는 의미

db.articles.aggregate([
    {
         $group:{
             _id:'$author',
             cnt:{$sum:1}
         }   
    }
])

db.createCollection('orders')
show collections
db.orders.insertMany([
{
      cust_id: "abc123",
      ord_date: ISODate("2012-01-02T17:04:11.102Z"),
      status: 'A',
      price: 100,
      items: [ { sku: "xxx", qty: 25, price: 1 },
               { sku: "yyy", qty: 25, price: 1 } ]
    },
    {
      cust_id: "abc123",
      ord_date: ISODate("2012-01-02T17:04:11.102Z"),
      status: 'A',
      price: 500,
      items: [ { sku: "xxx", qty: 25, price: 1 },
               { sku: "yyy", qty: 25, price: 1 } ]
    },
    {
      cust_id: "abc123",
      ord_date: ISODate("2012-01-02T17:04:11.102Z"),
      status: 'B',
      price: 130,
      items: [ { sku: "jkl", qty: 35, price: 2 },
               { sku: "abv", qty: 35, price: 1 } ]
    },
    {
      cust_id: "abc123",
      ord_date: ISODate("2012-01-02T17:04:11.102Z"),
      status: 'B',
      price: 230,
      items: [ { sku: "jkl", qty: 25, price: 2 },
               { sku: "abv", qty: 25, price: 1 } ]
    },
    {
      cust_id: "abc123",
      ord_date: ISODate("2012-01-02T17:04:11.102Z"),
      status: 'A',
      price: 130,
      items: [ { sku: "xxx", qty: 15, price: 1 },
               { sku: "yyy", qty: 15, price: 1 } ]
    },
    {
      cust_id: "abc456",
      ord_date: ISODate("2012-02-02T17:04:11.102Z"),
      status: 'C',
      price: 70,
      items: [ { sku: "jkl", qty: 45, price: 2 },
               { sku: "abv", qty: 45, price: 3 } ]
    },
    {
      cust_id: "abc456",
      ord_date: ISODate("2012-02-02T17:04:11.102Z"),
      status: 'A',
      price: 150,
      items: [ { sku: "xxx", qty: 35, price: 4 },
               { sku: "yyy", qty: 35, price: 5 } ]
    },
    {
      cust_id: "abc456",
      ord_date: ISODate("2012-02-02T17:04:11.102Z"),
      status: 'B',
      price: 20,
      items: [ { sku: "jkl", qty: 45, price: 2 },
               { sku: "abv", qty: 45, price: 1 } ]
    },
    {
      cust_id: "abc456",
      ord_date: ISODate("2012-02-02T17:04:11.102Z"),
      status: 'B',
      price: 120,
      items: [ { sku: "jkl", qty: 45, price: 2 },
               { sku: "abv", qty: 45, price: 1 } ]
    },
    {
      cust_id: "abc780",
      ord_date: ISODate("2012-02-02T17:04:11.102Z"),
      status: 'B',
      price: 260,
      items: [ { sku: "jkl", qty: 50, price: 2 },
               { sku: "abv", qty: 35, price: 1 } ]
    }
])

db.orders.find()
//총 주문건수가 몇개 있는지 보여주세요
//select count(*) cnt from orders
db.orders.aggregate([
    {
        $group:{_id:null, cnt:{$sum:1}}                
    }
])
//고객아이디별 구매가격총액을 가져와 보여주세요
//select cust_id, sum(price) as totalPrice from orders group by cust_id order by totalprice asc
db.orders.aggregate([
{
    $group:{_id:'$cust_id', totalPrice:{$sum:'$price'}}
},
{
    $sort:{totalPrice:1}//-1=>desc
}
])
//고객별 최소 구매가와 최대 구매가를 보여주세요
//select max(price) mxPrice, min(price) mnprice from order group by cust_id
db.orders.aggregate([
{
    $group:{_id:'$cust_id',mxPrice:{$max:'$price'}, mnPrice:{$min:'$price'}}    
},
{
    $sort:{cust_id:1}
}
])
//고객별 평균 구매가를 보여주세요
//select avg(price) avPrice from orders group by cust_id
db.orders.aggregate([
{
    $group:{_id:'$cust_id',avPrice:{$avg:'$price'}}
},
{
    $sort:{avPrice:-1}
}
])

//고객의 주문날짜별 구매총액을 보여주세요
//selct cust_id, ord_date, sum(price) totalPrice from orders
//group by cust_id, ord_date
db.orders.aggregate([
{
    $group:{
        _id:{cust_id:'$suct_id',ord_date:'$ord_date'},
        totalPrice:{$sum:'$price'}
    }    
}
])
//날짜 문자열 포맷:$dateToString:{format:'날짜 포맷패턴',date:'$적용할 필드'}
db.orders.aggregate([
{
    $group:{
        _id:{
            cust_id:'$suct_id',
            ord_date:{$dateToString:{format:'%Y-%m-%d',date:'$ord_date'}}
            },
        totalPrice:{$sum:'$price'}
    }    
}
])
//고객별 주문건수가 1개를 초과하는 데이터를 보여주세요
//select cust_id, count(*) cnt from orders group by cust_id having count(*) > 1
db.orders.aggregate([
{
    $group:{
        _id:'$cust_id',
        cnt:{$sum:1}
    }
},
{
    $match:{cnt:{$gt:1}}
}
])
//status별로 묶어 주문건수가 2개 이상인 데이터를 보여주세요
//select status, count(*) cnt group by status having cnt > 1
db.orders.aggregate([
{
    $group:{_id:'$status', cnt:{$sum:1}}
},
{
    $match:{cnt:{$gt:1}}
}
])
//status별 주문총액을 가져와 출력하세요
//select sum(price) totalPrice from orders group by status
db.orders.aggregate([
{
    $group:{_id:'$status',totalPrice:{$sum:'$price'}}
}
])
//고객의 주문일자별 주문총액을 보여주되 주문총액이 250 초과하는 주문정보를 보여주세요
//selct cust_id, ord_date, sum(price) totalPrice from orders
//group by cust_id, ord_date having totalPrice > 250
db.orders.aggregate([
{
    $group:{
        _id:{
            cust_id:'$suct_id',
            odate:{$dateToString:{format:'%Y-%m-%d %H-%M-%S', date:'$ord_date'}}
        },
        totalPrice:{
            $sum:'$price'
        }
    }    
},
{
    $match:{totalPrice:{$gt:250}}
}
])
//status가 'A'인 주문건수 중에서 고객별 주문 총액을 구하세요
//select cust_id, sum(price) totalPrice from orders
//where status='A' group by cust_id
//having totalPrice > 250
db.orders.aggregate([
{
    $match:{status:'A'}    
},
{
    $group:{
        _id:'$cust_id', totalPrice:{$sum:'$price'}
    }
},
{
    $match:{
        totalPrice:{$gt:250}
    }
}
])

db.inventory.find()
db.inventory.find({item:'journal'})
db.inventory.find({_id:ObjectId()})

db.inventory.insertOne({item:'note',sized:['S','M','L']})
db.inventory.aggregate([
{
    $unwind:'$sized'
}
])



















