import { Component } from '@angular/core';
import {FormsComponent} from './forms.component';
import {Premium} from '../../premium';
import {Request} from '../../request';
import {HttpService} from '../../services/http.service';



@Component({
  templateUrl: 'tabs.component.html',
  providers: [HttpService]
})
export class TabsComponent {

  // user: Premium;
  user: Request = new Request(); // данные вводимого пользователя
  receivedPrem: Premium; // полученная премия
  done: boolean = false;


  onChanged(req: Request) {
   // this.user.calcID = req.calcID;
    this.httpService.postData(req)
      .subscribe(
        (data: Premium) => {this.receivedPrem = data; this.done = true; console.log(this.receivedPrem.name); },
        error => console.log(error)
      );
}


  constructor(private httpService: HttpService) { }

}
