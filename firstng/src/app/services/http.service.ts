import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Request} from '../request';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {Response} from '@angular/http';
import {Premium} from '../premium';


@Injectable()
export class HttpService {

  constructor(private http: HttpClient) { }

  postData(req: Request) {
    const body = {calcID: req.calcID, compareType: req.compareType};
    console.log(req.calcID);
    return this.http.post('http://localhost:8083/RCCT-2.0-SNAPSHOT/rest/get', body);
  }

  public getData(url: string): Observable<any> {
    return this.http.get(url);
  }


  public getData2(url: string) {
    return this.http.get(url);
  }

  public getData4(url: string): Observable<Premium[]> {
    console.log('GET DATA......');
    console.log(url);
    return this.http.get<Premium[]>(url);
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
