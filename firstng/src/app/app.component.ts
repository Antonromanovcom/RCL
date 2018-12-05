import {Component, OnInit} from '@angular/core';
import { CatPictureService} from './services/catPicture.service';
import {User} from './user';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [CatPictureService]
})
export class AppComponent implements OnInit {

user: User;

  constructor(private httpService: CatPictureService) {}

  ngOnInit() {
    this.httpService.getData('assets/data/user.json').subscribe((data: User) => this.user = data);
  }


}
