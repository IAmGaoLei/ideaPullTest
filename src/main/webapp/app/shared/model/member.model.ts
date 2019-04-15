export interface IMember {
    id?: number;
    name?: string;
    age?: number;
    teamname?: string;
    role?: number;
    station?: string;
    tel?: string;
}

export class Member implements IMember {
    constructor(
        public id?: number,
        public name?: string,
        public age?: number,
        public teamname?: string,
        public role?: number,
        public station?: string,
        public tel?: string
    ) {}
}
