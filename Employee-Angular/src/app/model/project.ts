import Admin from "./admin";

export class Project {
    id!: number;
    title: String | undefined;
    domain!:String;
    duration!:number;
    admin!:Admin;
}