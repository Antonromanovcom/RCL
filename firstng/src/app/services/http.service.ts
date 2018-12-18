import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Request} from '../request';
import {Observable, Subject} from 'rxjs';
import {map} from 'rxjs/operators';
import {Response} from '@angular/http';
import {Premium} from '../premium';


@Injectable()
export class HttpService {

  // private subject = new Subject<any>();

  constructor(private http: HttpClient) { }

  postData(req: Request) {
    const body = {calcID: req.calcID, compareType: req.compareType};
    console.log(req.calcID);
    return this.http.post('http://localhost:8083/RCCT-2.0-SNAPSHOT/rest/get', body);
  }

 /* sendMessage(premiums: Premium[]) {
    this.subject.next({ text: premiums });
  }

  clearMessage() {
    this.subject.next();
  }

  getMessage(): Observable<any> {
    return this.subject.asObservable();
  }*/
 /* public getData(url: string): Observable<any> {
    return this.http.get(url);
  }


  public getData2(url: string) {
    return this.http.get(url);
  }*/

  public getData4(url: string): Observable<Premium[]> {
    console.log('GET DATA......');
    console.log(url);
    return this.http.get<Premium[]>(url);
  }


  public getData5(url: string, req: Request): Observable<Premium[]> {
    console.log('GET DATA WITH PARAMETRS  ......');
    console.log(url);

    let header = new HttpHeaders();
    header.append('Content-Type', 'application/json');
   // headers.append('projectid', this.id);
   // let params = new URLSearchParams();
 //   params.append('someParamKey', req.calcID.toString())
    const myvar = new HttpParams().set('id1', req.calcID.toString()).set('id2', '7');

   /* const options = {
      headers: header,
      "observe?": "response",
      "responseType?": "json",
    };*/


    return this.http.get<Premium[]>(url, {params: myvar});
  }


  // 'assets/data/test.json'

 /* public getData3(url: string): Observable<Premium[]> {
    return this.http.get<Premium[]>(url)
      .pipe(map(function(premium: any){
        return {name: premium.name};
      }));
  }

  private extractData(res: Response) {
    let body = <Premium[]>res.json();
    return body || {};
  }*/


  /*public getData3(url: string): Observable<Premium[]> {
    return this.http.get(url)
      .pipe(
        map(data => {
          let premiumList = data["premiumList"];
          return premiumList.map(function ((premium:any){
            return {}
          }) {

          })
        }
      )
  }*/



  /*public getPremiumList(url: string): Observable<Premium[]> {
    return this.http.get(url).pipe()(map(data=>{
      let premiumList = data ["userList"];
      return premiumList.map(function (premium:any) {
        return {id: premium.id, name: premium.name, description: premium.description, risk: premium.risk};
      })
    }))
  }


  public getPremiumList2(url: string): Observable<Premium[]> {
    return this.http.get(url)
      .pipe(
        map((response: Response) => {
      let premiumList = data ["userList"];
      return premiumList.map(function (premium:any) {
        return {id: premium.id, name: premium.name, description: premium.description, risk: premium.risk};
      })
    }))
  }*/


}
