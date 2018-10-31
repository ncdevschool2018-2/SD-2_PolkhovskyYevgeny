import {Component, OnInit, TemplateRef} from '@angular/core';
import {Group} from "../model/group";
import {Subscription} from "rxjs/internal/Subscription";
import {GroupService} from "../service/group.service";
import {BsModalRef, BsModalService} from "ngx-bootstrap";


@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})

export class AdminComponent implements OnInit {

  public groups: Group[];
  public editableGroup: Group = new Group();
  private subscriptions: Subscription[] = [];
  public modalRef: BsModalRef;
  constructor(
              private groupService: GroupService,
              private modalService: BsModalService
  ) {
  }

  ngOnInit() {
  }

  public _openModal(template: TemplateRef<any>): void {


      this.refreshGroup();



    this.modalRef = this.modalService.show(template); // and when the user clicks on the button to open the popup
                                                      // we keep the modal reference and pass the template local name to the modalService.
  }
  public _closeModal(): void {
    this.modalRef.hide();
  }




  public _addGroup(): void {

    this.subscriptions.push(this.groupService.saveGroup(this.editableGroup).subscribe(() => {
      this._updateGroups();
      this.refreshGroup();


    }));
  }
  private refreshGroup(): void {
    this.editableGroup = new Group();
  }

  public _updateGroups(): void {
    this.loadGroups();
  }


  private loadGroups(): void {

    // Get data from BillingAccountService
    this.subscriptions.push(this.groupService.getGroups().subscribe(groups => {
      // Parse json response into local array
      this.groups = groups as Group[];
      // Check data in console
      //console.log(this.groups);// don't use console.log in angular :)

    }));
  }
  /*add(Group: Group): void {

        this.subscriptions.push();
      };*/

}
