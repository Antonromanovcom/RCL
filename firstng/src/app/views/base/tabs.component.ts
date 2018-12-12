import {AfterViewInit, Component, OnInit} from '@angular/core';
import {FormsComponent} from './forms.component';
import {Premium} from '../../premium';
import {Request} from '../../request';
import {HttpService} from '../../services/http.service';
import {Entity1Service} from '../../services/Entity1Service';
import {Entity1} from '../../entities/Entity1';



@Component({
  templateUrl: 'tabs.component.html',
  providers: [HttpService, Entity1Service]
})
export class TabsComponent implements OnInit {

  // user: Premium;
  user: Request = new Request(); // данные вводимого пользователя
  receivedPrem: Premium; // полученная премия
  done = false;
  url = 'http://localhost:8083/RCCT-2.0-SNAPSHOT/rest/check?id=1';

  entity: Entity1[];

  onChanged(req: Request) {

    this.httpService.postData(req)
      .subscribe(
        (data: Premium) => {this.receivedPrem = data; this.done = true; console.log(this.receivedPrem.name); },
        error => console.log(error)
      );
 //   this.httpService.getData(this.url).subscribe((data: User) => this.user = data); http GET
}

  getEmployee() {
    // this.entity1Service.getEntities(1).su
      // .subscribe((data:Employee[]) => {});
  }



  constructor(private httpService: HttpService, private entity1Service: Entity1Service) { }

  ngOnInit() {
    const entityObservable  = this.entity1Service.getEntities3();
    entityObservable.subscribe((studentsData: Entity1[]) => {
      this.entity = studentsData;
    });
  }


}
