import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private baseUrl = 'http://localhost:8090/api/auth';

  constructor(private http: HttpClient) {}

  registerClient(data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/client/sign-up`, data);
  }

  registerCompany(data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/company/sign-up`, data);
  }
}
