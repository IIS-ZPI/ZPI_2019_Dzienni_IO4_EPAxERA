import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {HttpHeaders , HttpClient} from '@angular/common/http';
import {catchError} from 'rxjs/operators/catchError';
import {ExchangeRate} from '../models/exchange-rate';
import { tap, map } from 'rxjs/operators';

const httpOptions = {
  header: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  basicUrl = '/api';

  constructor(private http: HttpClient) {
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
 }

  getLastQuotationOfTheAverageExchangeRate(currency: string, day: string): Observable<ExchangeRate[]> {
    return this.http.get<ExchangeRate[]>(`${this.basicUrl}/${currency}/${day}`)
      .pipe(
        tap(exchangeRate => console.log(`Fetched exchange rate of currency=${currency} on day=${day}`)),
        catchError(this.handleError<ExchangeRate[]>(`getLastQuotationOfTheAverageExchangeRate currency=${currency} day=${day}`, []))
      );
  }
}
