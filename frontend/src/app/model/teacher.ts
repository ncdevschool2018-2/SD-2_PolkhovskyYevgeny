import {Users} from "./users";
import {Subjects} from "./subjects";

export class Teacher {
  id:number;
  name:string;
   surname:string;
   subject:string;
   usersByUserId:Users;
   userId:number;

   subjectsById:Set<Subjects>;
}
