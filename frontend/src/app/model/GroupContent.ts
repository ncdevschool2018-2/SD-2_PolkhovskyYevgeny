export class GroupContent {
  id: number;
  name: string;
  surname: string;
  groupId: number;
  userId: number;


  static cloneBase(groupContent: GroupContent): GroupContent {
    let clonedGroupContent: GroupContent = new GroupContent();
    clonedGroupContent.id = groupContent.id;
    clonedGroupContent.name = groupContent.name;
    clonedGroupContent.surname = groupContent.surname;
    clonedGroupContent.groupId = groupContent.groupId;
    clonedGroupContent.userId = groupContent.userId;


    return clonedGroupContent;
  }
}
