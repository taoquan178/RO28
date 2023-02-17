"use strict";
exports.__esModule = true;
exports.Position = void 0;
var Position = /** @class */ (function () {
    function Position() {
    }
    /**
     * Getter id
     * @return {number}
     */
    Position.prototype.getId = function () {
        return this.id;
    };
    /**
     * Getter name
     * @return {string}
     */
    Position.prototype.getName = function () {
        return this.name;
    };
    /**
     * Setter id
     * @param {number} value
     */
    Position.prototype.setId = function (value) {
        this.id = value;
    };
    /**
     * Setter name
     * @param {string} value
     */
    Position.prototype.setName = function (value) {
        this.name = value;
    };
    return Position;
}());
exports.Position = Position;
