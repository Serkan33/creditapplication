import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CreditserviceService {

  constructor(private http: HttpClient) {
  }

  creditLoan(user) {
    const header = new HttpHeaders({'content-type': 'application/json'});
    return this.http.post('http://localhost:8080/query/credit/limit', user, {headers: header});
  }
}
