import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Request} from '../request';
import {Observable, Subject} from 'rxjs';
import {Premium} from '../premium';


@Injectable()
export class HttpService {

  constructor(private http: HttpClient) { }

  postData(req: Request) {
    const body = {calcID: req.calcID1, compareType: req.compareType};
    console.log(req.calcID1);
    return this.http.post('http://localhost:8083/RCCT-2.0-SNAPSHOT/rest/get', body);
  }

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
    const myvar = new HttpParams().set('id1', req.calcID1.toString()).set('id2', req.calcID2.toString());
    return this.http.get<Premium[]>(url, {params: myvar});
  }

  public getData6(url: string, req: Request): Observable<number> {

    let header = new HttpHeaders();
    header.append('Content-Type', 'application/json');
    const myvar = new HttpParams().set('id1', req.calcID1.toString()).set('id2', req.calcID2.toString());
    return this.http.get<number>(url, {params: myvar});
  }
}
