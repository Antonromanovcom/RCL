import {Component, OnInit} from '@angular/core';
import {getStyle, rgbToHex} from '@coreui/coreui/dist/js/coreui-utilities';
import {User} from './user';
import {CatPictureService} from './services/catPicture.service';

@Component({
  templateUrl: 'colors.component.html',
  providers: [CatPictureService]
})
export class ColorsComponent implements OnInit {

  user: User;
  url = 'http://localhost:8083/RCCT-2.0-SNAPSHOT/rest/check?id=1';
  urlServer = 'https://192.168.0.14:33246/RCCT-2.0-SNAPSHOT/rest/check?id=1';

  constructor(private httpService: CatPictureService) {
  }


  ngOnInit(): void {
    this.httpService.getData(this.url).subscribe((data: User) => this.user = data);
  }
}
