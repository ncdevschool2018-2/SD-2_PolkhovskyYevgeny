export class UsersChange {
  id: number;
  login: string;
  passwordOld: string;
  passwordNew: string;
  roleId: number;

  static cloneBase(users: UsersChange): UsersChange {
    let clonedUsers: UsersChange = new UsersChange();
    clonedUsers.id = users.id;
    clonedUsers.login = users.login;
    clonedUsers.passwordOld = users.passwordOld;
    clonedUsers.passwordNew = users.passwordNew;
    clonedUsers.roleId = users.roleId;

    return clonedUsers;
  }

}
