import { Account } from "./Account.js";
import { Department } from "./Department.js";
import { Position } from "./Positon.js";

var department = new Department();
department.setId(1);
department.setName("Giám Đốc");
console.log(department);

var position = new Position();
position.setId(1);
position.setName("ABCXYZ");
console.log(position);


var account = new Account();
account.setId(1);
account.setEmail("taoquan178@gmail.com");
account.setUsername("quanvip123");
account.setFullName("Nguyễn Trung Quân");
account.setPosition(position);
account.setDepartment(department);
let date: Date = new Date("2001-05-29");  
account.setCreateDate(date);

console.log(account);