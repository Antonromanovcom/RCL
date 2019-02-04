import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {HttpService} from '../../services/http.service';
import {Request} from '../../request';
import {ITEMS} from '../../entities/mock-data';
import {Item} from '../../entities/item';


@Component({
  selector: 'app-form-component',
  templateUrl: 'forms.component.html',
  providers: [HttpService]
})
export class FormsComponent {
  title = 'app';
  radioSel: any;
  radioSelected: number;
  radioSelectedString: string;
  itemsList: Item[] = ITEMS;

  constructor() {
    this.req.serverLocal = 1;
    this.itemsList = ITEMS;
    this.radioSelected = 1;
    this.getSelecteditem();
  }

  req: Request = new Request(); // данные вводимого пользователя


  @Output() onChanged = new EventEmitter<Request>();

  change(req: Request) {
    this.onChanged.emit(req);
  }

  onItemChange(item) {
    this.getSelecteditem();

  }

  getSelecteditem() {
    // this.radioSel = ITEMS.find(Item => Item.value === parseInt(this.radioSelected.toString(), 10));
     this.radioSel = ITEMS.find(Item => Item.value == this.radioSelected);
    this.radioSelectedString = JSON.stringify(this.radioSel);
    this.req.serverLocal = this.radioSelected;
    console.log(this.req.serverLocal);
  }

  testV() {
    console.log('serverLocal = ');
    console.log(this.req.serverLocal);
  }


}
