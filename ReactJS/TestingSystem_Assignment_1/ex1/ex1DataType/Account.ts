import { Department } from "./Department";
import { Position } from "./Positon";
export class Account{

//   AccountID: định danh của User (auto increment)
//  Email:
//  Username:
//  FullName:
//  DepartmentID: phòng ban của user trong hệ thống
//  PositionID: chức vụ của User
//  CreateDate: ngày tạo tài khoản

    private id: number;
    private email: string;
    private username: string;
    private fullName: string;
    private department: Department;
    private position: Position;
    private createDate: Date;

    constructor() {
	}


    /**
     * Getter id
     * @return {number}
     */
	public getId(): number {
		return this.id;
	}

    /**
     * Getter email
     * @return {string}
     */
	public getEmail(): string {
		return this.email;
	}

    /**
     * Getter username
     * @return {string}
     */
	public getUsername(): string {
		return this.username;
	}

    /**
     * Getter fullName
     * @return {string}
     */
	public getFullName(): string {
		return this.fullName;
	}

    /**
     * Getter department
     * @return {Department}
     */
	public getDepartment(): Department {
		return this.department;
	}

    /**
     * Getter position
     * @return {Position}
     */
	public getPosition(): Position {
		return this.position;
	}

    /**
     * Getter createDate
     * @return {Date}
     */
	public getCreateDate(): Date {
		return this.createDate;
	}

    /**
     * Setter id
     * @param {number} value
     */
	public setId(value: number) {
		this.id = value;
	}

    /**
     * Setter email
     * @param {string} value
     */
	public setEmail(value: string) {
		this.email = value;
	}

    /**
     * Setter username
     * @param {string} value
     */
	public setUsername(value: string) {
		this.username = value;
	}

    /**
     * Setter fullName
     * @param {string} value
     */
	public setFullName(value: string) {
		this.fullName = value;
	}

    /**
     * Setter department
     * @param {Department} value
     */
	public setDepartment(value: Department) {
		this.department = value;
	}

    /**
     * Setter position
     * @param {Position} value
     */
	public setPosition(value: Position) {
		this.position = value;
	}

    /**
     * Setter createDate
     * @param {Date} value
     */
	public setCreateDate(value: Date) {
		this.createDate = value;
	}

}