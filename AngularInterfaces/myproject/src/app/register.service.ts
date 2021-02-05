import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaderResponse, HttpErrorResponse } from '@angular/common/http';
import { Register } from './DTO1/register.dto';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  private _tempurl =  'http://localhost:8080/';
      private _url =      'http://localhost:8080/';


  constructor(private _http : HttpClient) { }

  addNewUser(newUser: Register)
  {
     this._url = this._tempurl;
     this._url += 'initializeNewUser';
     return this._http.post(this._url,newUser);
   }
}
