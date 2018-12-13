import {AfterViewInit, Component, OnInit} from '@angular/core';
import {FormsComponent} from './forms.component';
import {Premium} from '../../premium';
import {Request} from '../../request';
import {HttpService} from '../../services/http.service';
import {Entity1Service} from '../../services/Entity1Service';
import {Entity1} from '../../entities/Entity1';
import {Observable} from 'rxjs';



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
  myUrl = 'http://localhost:8083/RCCT-2.0-SNAPSHOT/rest/v3?id1=1&id2=1';
  myUrl4All = 'http://localhost:8083/RCCT-2.0-SNAPSHOT/rest/v2';
  localJson = '../app/entities/test.json';

  premiumsO: Premium[] = [];
  premiums: Observable<Premium[]> ;

  entity: Entity1[];

  onChanged(req: Request) {

    this.httpService.postData(req)
      .subscribe(
        (data: Premium) => {this.receivedPrem = data; this.done = true; console.log(this.receivedPrem.name); },
        error => console.log(error)
      );
 //   this.httpService.getData(this.url).subscribe((data: User) => this.user = data); http GET
}

// .subscribe((data: Premium[]) => {

  /*getEmployee() {

     this.httpService.getData3(this.myUrl4All)
       .subscribe((res => {
       console.log(res);
       this.premiums = res.;
    });
  }*/



  constructor(private httpService: HttpService, private entity1Service: Entity1Service) { }

  ngOnInit() {
  //  const entityObservable  = this.entity1Service.getEntities3();
  //  entityObservable.subscribe((studentsData: Entity1[]) => {
  //    this.entity = studentsData;
  //  });

    // this.getEmployee();

    this.httpService.getData4(this.myUrl4All).subscribe(data => this.premiumsO = data['premiumList']);
  }


}
