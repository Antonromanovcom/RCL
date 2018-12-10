import { Component } from '@angular/core';
import {HttpService} from '../../services/http.service';
import {User} from '../../user';

@Component({
  selector: 'app-form-component',
  templateUrl: 'forms.component.html',
  providers: [HttpService]
})
export class FormsComponent {

  constructor(private httpService: HttpService) { }

  isCollapsed: boolean = false;
  iconCollapse: string = 'icon-arrow-up';
  user: User = new User(); // данные вводимого пользователя
  receivedUser: User; // полученный пользователь
  done: boolean = false;



  collapsed(event: any): void {
    // console.log(event);
  }

  expanded(event: any): void {
    // console.log(event);
  }

  toggleCollapse(): void {
    this.isCollapsed = !this.isCollapsed;
    this.iconCollapse = this.isCollapsed ? 'icon-arrow-down' : 'icon-arrow-up';
  }

  submit(user: User) {
    this.httpService.postData(user)
      .subscribe(
        (data: User) => {this.receivedUser = data; this.done = true; },
        error => console.log(error)
      );
  }

}
