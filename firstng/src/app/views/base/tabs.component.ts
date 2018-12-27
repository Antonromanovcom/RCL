import {AfterViewInit, Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {Premium} from '../../premium';
import {Request} from '../../request';
import {HttpService} from '../../services/http.service';
import {Entity1Service} from '../../services/Entity1Service';
import { BsModalRef, BsModalService } from 'ngx-bootstrap/modal';
import { ModalDirective } from 'ngx-bootstrap/modal';


@Component({
  templateUrl: 'tabs.component.html',
  providers: [HttpService, Entity1Service]
})
export class TabsComponent implements OnInit {
  @ViewChild('successModal')
   public successModal: TemplateRef<any>;
   // public successModal;

  public modalRef: BsModalRef;
  configOk = {
    animated: true,
    keyboard: true,
    backdrop: true,
    ignoreBackdropClick: false,
    class: 'my-modal'
  };
  configFail = {
    animated: true,
    keyboard: true,
    backdrop: true,
    ignoreBackdropClick: false,
    class: 'my-modal-fail'
  };
  notEqualsParams = 28;
  compareResultMessage = '';
  user: Request = new Request(); // данные вводимого пользователя
  receivedPrem: Premium; // полученная премия
  done = false;
//  url = 'http://localhost:8083/RCCT-2.0-SNAPSHOT/rest/check?id=1';
//  myUrl = 'http://localhost:8083/RCCT-2.0-SNAPSHOT/rest/v3?id1=1&id2=1';
  myUrl4All = 'http://localhost:8083/RCCT-2.0-SNAPSHOT/rest/v2';
  myUrlbyId = 'http://localhost:8083/RCCT-2.0-SNAPSHOT/rest/v3';
  myUrlbyId2 = 'http://localhost:8083/RCCT-2.0-SNAPSHOT/rest/v10';
  mismatchesCount = 'http://localhost:8083/RCCT-2.0-SNAPSHOT/rest/v11';
  localJson = 'assets/data/test.json';

  premiumsO: Premium[] = [];


  ngOnInit(): void {

    // this.httpService.getData4(this.myUrlbyId2).subscribe(data => {

    this.httpService.getData4(this.localJson).subscribe(data => {
      this.premiumsO = data['compareList'];




    });
  }

  onChanged(req: Request) {

   //  this.httpService.getData4(this.myUrlbyId2).subscribe(data => this.premiumsO = data['compareList']);
     this.httpService.getData5(this.myUrlbyId2, req).subscribe(data => this.premiumsO = data['compareList']);
     this.httpService.getData6(this.mismatchesCount, req).subscribe(data => this.notEqualsParams = data);
    console.log(' this.notEqualsParams: ');
    console.log(this.notEqualsParams);

    if (this.premiumsO.length > 1) {
      console.log('this.premiumsO.length > 1');
      this.compareResultMessage = 'Загрузка результатов сравнения выполнена успешно! Перейдите к следующим вкладкам!';
      this.openModal();
    } else {
      this.compareResultMessage = 'Параметры заданы неверно или что-то пошло не так! Сравнение не выполнено';
      this.openModalFail();
    }

}

  constructor(private httpService: HttpService, private entity1Service: Entity1Service, private modalService: BsModalService) {
     }

  openModal() {
    this.modalRef = this.modalService.show(this.successModal, this.configOk);
  }

  openModalFail() {
    this.modalRef = this.modalService.show(this.successModal, this.configFail);
  }

  getCompareResultMessage(): string {
    return this.compareResultMessage;
  }
}
