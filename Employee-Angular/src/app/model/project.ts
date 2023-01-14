import Admin from "./admin";

export class Project {
    id!: number;
    title!: String;
    domain!:String;
    duration!:number;
    admin!:Admin;
}