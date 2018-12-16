import {Component, OnInit} from '@angular/core';
import {Subscription} from "rxjs";
import {Users} from "../model/users";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {AuthService} from "../service/auth.service";
import {TokenStorage} from "../service/token.storage";
import {UsersService} from "../service/users.service";
import {Router} from "@angular/router";
import {NewUser} from "../model/newUser";
import {Roles} from "../model/role";
import {RolesService} from "../service/roles.service";
import {Group} from "../model/group";
import {GroupService} from "../service/group.service";
import {PupilService} from "../service/pupil.service";
import {Subjects} from "../model/subjects";
import {SubjectService} from "../service/subject.service";
import {TeacherService} from "../service/teacher.service";


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  public subjectsAll: Subjects[];
  public alertUserAboutError: boolean = false;
  public wrongPassword: boolean = false;
  public editableNewUser: NewUser = new NewUser();
  public login: string;
  public password: string;
  public confirmPassword: string = "";
  public roles: Roles[];
  private subscriptions: Subscription[] = [];
  public groups: Group[];
  public chooseRole: number;
  private authorizationAccount: Users;

  constructor(private loadingService: Ng4LoadingSpinnerService,
              private authService: AuthService,
              private tokeStorage: TokenStorage,
              private usersService: UsersService,
              private groupService: GroupService,
              private rolesService: RolesService,
              private pupilService: PupilService,
              private teacherService: TeacherService,
              private subjectService: SubjectService,
              private router: Router,
  ) {
  }

  ngOnInit() {
    this.loadRoles();
    this.loadGroups();
    this.loadAllSubjects();
  }

  private loadRoles(): void {


    this.subscriptions.push(this.rolesService.getRoles().subscribe(role => {

      this.roles = role as Roles[];
      this.roles.splice(0, 1);
    }));
  }

  private loadGroups(): void {

    this.subscriptions.push(this.groupService.getGroups().subscribe(groups => {

      this.groups = groups as Group[];

    }));
  }

  public register(num: number): void {

    if (this.confirmPassword && this.editableNewUser.password
      && this.editableNewUser.name && this.editableNewUser.surname && this.editableNewUser.login) {
      if (this.editableNewUser.password.includes(this.confirmPassword)) {
        if (num == 3 && this.editableNewUser.groupId) {
          this.subscriptions.push(this.pupilService.saveNewPupil(this.editableNewUser).subscribe(n => {
            if (n == null) {
              alert("user with this login already exist or you enter invalid data");
              this.wrongPassword = false;
              return
            }
            this.router.navigate(['signin']);
          }));
        } else if (num == 2 && this.editableNewUser.subjectId) {
          this.subscriptions.push(this.teacherService.saveNewTeacher(this.editableNewUser).subscribe(n => {
            if (n == null) {
              alert("user with this login already exist or you enter invalid data");
              this.wrongPassword = false;
              return
            }
            this.router.navigate(['signin']);
          }));
        }
        else {
          alert("enter subject or group");
          return
        }
      } else {
        this.wrongPassword = true;
      }
    }

  }

  private loadAllSubjects(): void {

    this.subscriptions.push(this.subjectService.getSubjectsAll().subscribe(subjectsAll => {

      this.subjectsAll = subjectsAll as Subjects[];
    }));
  }
}
