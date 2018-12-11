import {Component, EventEmitter, Output} from '@angular/core';
import {HttpService} from '../../services/http.service';
import {Request} from '../../request';
import {Premium} from '../../premium';


@Component({
  selector: 'app-form-component',
  templateUrl: 'forms.component.html',
  providers: [HttpService]
})
export class FormsComponent {

  constructor(private httpService: HttpService) { }

  req: Request = new Request(); // данные вводимого пользователя
  receivedPrem: Premium; // полученная премия
  done: boolean = false;


  @Output() onChanged = new EventEmitter<Request>();
  change(req: Request) {
    this.onChanged.emit(req);
  }


  submit(req: Request) {
    this.httpService.postData(req)
      .subscribe(
        (data: Premium) => {this.receivedPrem = data; this.done = true; console.log(this.receivedPrem.name); },
        error => console.log(error)
      );
  }





}
