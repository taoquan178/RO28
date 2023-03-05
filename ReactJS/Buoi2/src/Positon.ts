export class Position {

    private id: number;
    private name: string;

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
     * Getter name
     * @return {string}
     */
	public getName(): string {
		return this.name;
	}

    /**
     * Setter id
     * @param {number} value
     */
	public setId(value: number) {
		this.id = value;
	}

    /**
     * Setter name
     * @param {string} value
     */
	public setName(value: string) {
		this.name = value;
	}

}