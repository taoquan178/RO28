"use strict";
exports.__esModule = true;
exports.Account = void 0;
var Account = /** @class */ (function () {
    function Account() {
    }
    /**
     * Getter id
     * @return {number}
     */
    Account.prototype.getId = function () {
        return this.id;
    };
    /**
     * Getter email
     * @return {string}
     */
    Account.prototype.getEmail = function () {
        return this.email;
    };
    /**
     * Getter username
     * @return {string}
     */
    Account.prototype.getUsername = function () {
        return this.username;
    };
    /**
     * Getter fullName
     * @return {string}
     */
    Account.prototype.getFullName = function () {
        return this.fullName;
    };
    /**
     * Getter department
     * @return {Department}
     */
    Account.prototype.getDepartment = function () {
        return this.department;
    };
    /**
     * Getter position
     * @return {Position}
     */
    Account.prototype.getPosition = function () {
        return this.position;
    };
    /**
     * Getter createDate
     * @return {Date}
     */
    Account.prototype.getCreateDate = function () {
        return this.createDate;
    };
    /**
     * Setter id
     * @param {number} value
     */
    Account.prototype.setId = function (value) {
        this.id = value;
    };
    /**
     * Setter email
     * @param {string} value
     */
    Account.prototype.setEmail = function (value) {
        this.email = value;
    };
    /**
     * Setter username
     * @param {string} value
     */
    Account.prototype.setUsername = function (value) {
        this.username = value;
    };
    /**
     * Setter fullName
     * @param {string} value
     */
    Account.prototype.setFullName = function (value) {
        this.fullName = value;
    };
    /**
     * Setter department
     * @param {Department} value
     */
    Account.prototype.setDepartment = function (value) {
        this.department = value;
    };
    /**
     * Setter position
     * @param {Position} value
     */
    Account.prototype.setPosition = function (value) {
        this.position = value;
    };
    /**
     * Setter createDate
     * @param {Date} value
     */
    Account.prototype.setCreateDate = function (value) {
        this.createDate = value;
    };
    return Account;
}());
exports.Account = Account;
