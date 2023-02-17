"use strict";
exports.__esModule = true;
var Account_1 = require("./Account");
var Department_1 = require("./Department");
var Positon_1 = require("./Positon");
var department = new Department_1.Department();
department.setId(1);
department.setName("Giám Đốc");
console.log(department);
var position = new Positon_1.Position();
position.setId(1);
position.setName("ABCXYZ");
console.log(position);
var account = new Account_1.Account();
account.setId(1);
account.setEmail("taoquan178@gmail.com");
account.setUsername("quanvip123");
account.setFullName("Nguyễn Trung Quân");
account.setPosition(position);
account.setDepartment(department);
var date = new Date("2001-05-29");
account.setCreateDate(date);
console.log(account);