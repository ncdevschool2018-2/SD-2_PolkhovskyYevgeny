import {Roles} from "./role";
import {GroupContent} from "./GroupContent";
import {Teacher} from "./teacher";

export class Users{
  id:number;
  login:string ;
  password:string;
  rolesByRoleId:Roles;
  roleId:number;

  pupilsById:Set<GroupContent>;

  teachersById:Set<Teacher>;
}
