import {Component, Input, OnChanges, OnInit, SimpleChanges, ViewEncapsulation} from '@angular/core';
import * as jspdf from 'jspdf';
import html2canvas from 'html2canvas';

@Component({
  selector: 'app-tables-component',
  templateUrl: 'tables.component.html',
  styles: ['.pager li.btn:active { box-shadow: none; }'],
  encapsulation: ViewEncapsulation.None
})
export class TablesComponent implements OnInit, OnChanges {

  constructor() {
  }


  returnedArray: any[];
  currentPage: number = 1;
  smallnumPages: number = 0;

  @Input() childElements: any [];


  ngOnInit(): void {
    this.returnedArray = this.childElements.slice(0, 30);
  }


  ngOnChanges(changes: SimpleChanges) {


    if (changes['childElements']) {
      console.log('Sliced array 1: ' + this.returnedArray.length);
    }

    if (typeof changes.childElements !== 'undefined') {
      this.returnedArray = changes.childElements.currentValue.slice(0, 30);
      console.log('myVal = ', changes.childElements.currentValue);
    }
  }

  public captureScreen() {
    this.returnedArray = this.childElements;

    var data = document.getElementById('contentToConvert').outerHTML;
    // var temp = document.getElementById("exportme").outerHTML;
    console.log(data);
  }

  public captureScreenToPdf() {

    var data = document.getElementById('contentToConvert');
    html2canvas(data).then(canvas => {

      var imgWidth = 208;
      var pageHeight = 295;
      var imgHeight = canvas.height * imgWidth / canvas.width;
      var heightLeft = imgHeight;

      const contentDataURL = canvas.toDataURL('image/png');
      let pdf = new jspdf('p', 'mm', 'a4'); // A4 size page of PDF
      var position = 0;
      pdf.addImage(contentDataURL, 'PNG', 0, position, imgWidth, imgHeight);
      pdf.save('MYPdf.pdf'); // Generated PDF
    });

  }


  pageChanged(event: any): void {
    const startItem = (event.page - 1) * event.itemsPerPage;
    const endItem = event.page * event.itemsPerPage;
    this.returnedArray = this.childElements.slice(startItem, endItem);
  }


  getCompareStatus(str: boolean): string {
    let result = 'OK';
    if (str === false) {
      result = 'X';
    }
    return result;
  }


}
