import {Component, Input, OnInit, ViewEncapsulation} from '@angular/core';
import * as jspdf from 'jspdf';
import html2canvas from 'html2canvas';

@Component({
  selector: 'app-tables-component',
  templateUrl: 'tables.component.html',
  styles: ['.pager li.btn:active { box-shadow: none; }'],
  encapsulation: ViewEncapsulation.None
})
export class TablesComponent implements OnInit {

  constructor() {
    // this.subscription = this.httpService.getMessage().subscribe(message => { this.premiums2 = message; });
  }

  // contentArray = new Array(90).fill('');
   returnedArray: any[];
  // subscription: Subscription;
  // premiums2: Premium[] = [];
  currentPage: number = 1;
  smallnumPages: number = 0;

  @Input() childElements: any [];

  /*elements: any = [
    {id: 1, first: 'Mark', last: 'Otto', handle: '@mdo'},
    {id: 2, first: 'Jacob', last: 'Thornton', handle: '@fat'},
    {id: 3, first: 'Larry', last: 'the Bird', handle: '@twitter'},
  ];*/


  ngOnInit(): void {
  //  this.contentArray = this.contentArray.map((v: string, i: number) => `Content line ${i + 1}`); заполняем массив
   // this.returnedArray = this.contentArray.slice(0, 10);
  }

  public captureScreen()  {

    var data = document.getElementById('contentToConvert').outerHTML;
    // var temp = document.getElementById("exportme").outerHTML;
    console.log(data);
  }

  public captureScreenToPdf()  {


    var data = document.getElementById('contentToConvert');
    html2canvas(data).then(canvas => {
      // Few necessary setting options

      var imgWidth = 208;
      var pageHeight = 295;
      var imgHeight = canvas.height * imgWidth / canvas.width;
      var heightLeft = imgHeight;

      const contentDataURL = canvas.toDataURL('image/png')
      let pdf = new jspdf('p', 'mm', 'a4'); // A4 size page of PDF
      var position = 0;
      pdf.addImage(contentDataURL, 'PNG', 0, position, imgWidth, imgHeight)
      pdf.save('MYPdf.pdf'); // Generated PDF
    });

  }



  pageChanged(event: any): void {
    // console.log('Page changed to: ' + event.page);
    // console.log('Number items per page: ' + event.itemsPerPage);

    const startItem = (event.page - 1) * event.itemsPerPage;
    const endItem = event.page * event.itemsPerPage;
    this.returnedArray = this.childElements.slice(startItem, endItem);

   // this.captureScreen();
    // console.log('contentArray: ' + this.contentArray);
    // console.log('====================');
    // console.log('returnedArray: ' + this.returnedArray);
  }


}
