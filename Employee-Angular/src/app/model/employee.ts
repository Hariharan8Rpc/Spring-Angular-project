import { Address } from "./address";
import { Project } from "./project";
export class Employee {
    id!: number;
    firstName!: String ;
    lastName!: String ;
    department!: String;
    address: Address = new Address(); 
    // address! :Address;
    project:Array<Project>=[];
 
}
