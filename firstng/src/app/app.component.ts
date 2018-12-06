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
url = 'http://localhost:8083/RCCT-2.0-SNAPSHOT/rest/check?id=1';
   urlServer = 'https://192.168.0.14:33246/RCCT-2.0-SNAPSHOT/rest/check?id=1';

constructor(private httpService: CatPictureService) {}

  ngOnInit() {
    this.httpService.getData(this.url).subscribe((data: User) => this.user = data);
  }


}
