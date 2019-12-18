import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  constructor(private http: HttpClient) { }

  registerUser(user): Observable<any> {
    return this.http.post(`http://localhost:8080/asset/add`, user);
  }

  loginUser(user): Observable<any> {
    return this.http.post(`http://localhost:8080/asset/login`, user);
  }

  removeUser(user): Observable<any> {
      return this.http.delete(`http://localhost:8080/asset/remove-can/${user.id}`, user);
  }

  addAsset(user): Observable<any> {
      return this.http.post(`http://localhost:8080/asset/add-ass`, user);
  }

  updateAsset(user): Observable<any> {
    return this.http.put(`http://localhost:8080/asset/modify`, user);
  }

  candList(): Observable<any> {
    return this.http.get(`http://localhost:8080/asset/get-all-can`);
  }

  appartList(): Observable<any> {
    return this.http.get(`http://localhost:8080/asset/get-all-ass`);
  }

  flatList(): Observable<any> {
    return this.http.get(`http://localhost:8080/asset/get-all-flats`);
  }

  removeAss(user): Observable<any> {
    return this.http.delete(`http://localhost:8080/asset/remove-ass/${user.requestNo}`, user);
}
bookFlat(user): Observable<any> {
  return this.http.post(`http://localhost:8080/asset/book-flat`, user);
}

request(): Observable<any> {
  return this.http.get(`http://localhost:8080/asset/request`);
}

approve(user): Observable<any> {
  return this.http.post(`http://localhost:8080/asset/approve`, user);
}
reject(user): Observable<any> {
  return this.http.post(`http://localhost:8080/asset/reject`, user);
}
seereq(user): Observable<any> {
  return this.http.post(`http://localhost:8080/asset/seereq`, user);
}
}
