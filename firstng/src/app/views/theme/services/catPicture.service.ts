import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable()
export class CatPictureService {

  constructor(private httpClient: HttpClient) { }

  public getData(url: string): Observable<any> {
    return this.httpClient.get(url);
  }

}
