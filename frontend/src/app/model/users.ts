export class Users {
  id: number;
  login: string;
  password: string;
  roleId: number;

  static cloneBase(users: Users): Users {
    let clonedUsers: Users = new Users();
    clonedUsers.id = users.id;
    clonedUsers.login = users.login;
    clonedUsers.password = users.password;
    clonedUsers.roleId = users.roleId;

    return clonedUsers;
  }

}
