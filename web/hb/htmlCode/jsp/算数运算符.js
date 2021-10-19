document.write("<hr />")
document.write((3>4)+"<br />")
document.write(("125">123)+"<br />")
document.write(("123" == 123) +"<br />" )
document.write(("123" === 123) +"<br />" )

/*
	&&:与
	||:或
	!:非
	
	其他类型转boolean
	1、number转Boolean: 0或NaN为假,非0为真
	2、string:除了空字符串，其他都为真
	3、obj:除了null和undefined外，都是真
*/
document.write("<hr />")
var flag = true
document.write(!flag+"<br />")

var num1 = 1
document.write(!num1+"<br />")

var str1 = "";
document.write(!str1+"<br />")

var obj1 
document.write(!obj1)