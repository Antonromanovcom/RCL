import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Request} from '../request';
import {Observable} from 'rxjs';


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
}
