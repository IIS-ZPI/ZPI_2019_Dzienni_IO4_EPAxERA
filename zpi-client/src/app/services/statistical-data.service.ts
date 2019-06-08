import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {catchError, tap} from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class StatisticalDataService {

  constructor(private http: HttpClient) { }

  getMedianOfChosenCurrencyForTimeSpecifiedInDayParameter(currency: string, day: string): Observable<number> {
    return this.http.get<number>(`http://localhost:8080/statistical-data/median/${currency}/${day}`)
      .pipe(
        tap(median => console.log(`Fetched median of currency.`)),
        catchError(this.handleError<number>(`getMedianError`))
      );
  }

  getDeviationOfChosenCurrencyForTimeSpecifiedInDayParameter(currency: string, day: string): Observable<number> {
    return this.http.get<number>(`http://localhost:8080/statistical-data/deviation/${currency}/${day}`)
      .pipe(
        tap(deviation => console.log(`Fetched deviation of currency`)),
        catchError(this.handleError<number>(`getDeviationError`))
      );
  }

  getDominantOfChosenCurrencyForTimeSpecifiedInDayParameter(currency: string, day: string): Observable<number> {
    return this.http.get<number>(`http://localhost:8080/statistical-data/dominant/${currency}/${day}`)
      .pipe(
        tap(dominant => console.log(`Fetched dominant of currency`)),
        catchError(this.handleError<number>(`getDominantError`))
      );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      console.log(`${operation} failed: ${error.message}`);
      return of(result as T);
    };
  }
}
