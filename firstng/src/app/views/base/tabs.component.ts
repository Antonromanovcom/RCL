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
  notEqualsParams = 1;
  // notEqualsCount: number[];
  notEqualsCount = [1, 2, 3];
  notEqualsCount2 = new Array(10);
  compareResultMessage = '';
  user: Request = new Request(); // данные вводимого пользователя
  receivedPrem: Premium; // полученная премия
  done = false;

  //  url = 'http://localhost:8083/RCCT-2.0-SNAPSHOT/rest/check?id=1';
  //  myUrl = 'http://localhost:8083/RCCT-2.0-SNAPSHOT/rest/v3?id1=1&id2=1';
  myUrl4All = 'RCCT-2.0-SNAPSHOT/rest/v2';
  myUrlbyId = 'RCCT-2.0-SNAPSHOT/rest/v3';
  myUrlbyId2 = 'RCCT-2.0-SNAPSHOT/rest/v10';
  myUrlbyId3 = 'RCCT-2.0-SNAPSHOT/rest/getcompare';
  mismatchesCount = 'RCCT-2.0-SNAPSHOT/rest/getcount';
  localJson = 'assets/data/test.json';
  premiumsO: Premium[] = [];
  wsCommonLogs: Premium[] = [];


  ngOnInit(): void {

    // this.httpService.getData4(this.myUrlbyId2).subscribe(data => {

    this.httpService.getData4(this.localJson).subscribe(data => {
      this.premiumsO = data['compareList'];




    });
  }

  onChanged(req: Request) {

    let serverPredicat = 'http://localhost:8083/';
    let serverMainRequestFinalString;
    let serverCountRequestFinalString;

    //  this.httpService.getData4(this.myUrlbyId2).subscribe(data => this.premiumsO = data['compareList']);

    console.log('SERVER TYPE = ' + req.serverLocal);

    if (req.serverLocal == 1 ||  req.serverLocal === null) {
      serverPredicat = 'http://localhost:8083/';
      console.log('SERVER TYPE 2 = ' + req.serverLocal);
    } else {
      serverPredicat = 'https://192.168.0.14:33246/';
    }

    serverMainRequestFinalString = serverPredicat + this.myUrlbyId2;
    serverCountRequestFinalString = serverPredicat + this.mismatchesCount;

    console.log('МЫ ОБРАЩАЕМСЯ К....' + serverMainRequestFinalString);


 //  ----------------- WS CALC LOGS NEW --------------------------
    this.httpService.getData5(serverMainRequestFinalString, req).subscribe(data => this.premiumsO = data['compareList']);
    this.httpService.getData6(serverCountRequestFinalString, req, '1').subscribe(data => this.notEqualsParams = data);

 //  ----------------- WS COMMON LOGS --------------------------

    serverMainRequestFinalString = serverPredicat + this.myUrlbyId3;
    serverCountRequestFinalString = serverPredicat + this.mismatchesCount;


    this.httpService.getData7(serverMainRequestFinalString, req).subscribe(data => this.wsCommonLogs = data['compareList']);
    console.log(this.wsCommonLogs);
    this.httpService.getData6(serverCountRequestFinalString, req, '2').subscribe(data => this.notEqualsCount2[2] = data);


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
