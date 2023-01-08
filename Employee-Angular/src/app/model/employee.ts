import { Address } from "./address";
import { Project } from "./project";
export class Employee {
    id!: number;
    firstName: String | undefined;
    lastName: String | undefined;
    department: String | undefined;  
    address!:Address; 
    project:Array<Project>=[];
 
}
