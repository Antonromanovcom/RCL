import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {HttpService} from '../../services/http.service';
import {Request} from '../../request';


@Component({
  selector: 'app-form-component',
  templateUrl: 'forms.component.html',
  providers: [HttpService]
})
export class FormsComponent {

  constructor() {
  }

  req: Request = new Request(); // данные вводимого пользователя


  @Output() onChanged = new EventEmitter<Request>();

  change(req: Request) {
    this.onChanged.emit(req);
  }


}
