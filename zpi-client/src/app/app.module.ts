import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { HomeComponent } from './components/home/home.component';
import { CurrencyDecayComponent } from './components/currency-decay/currency-decay.component';
import { SessionsComponent } from './components/sessions/sessions.component';
import { StatisticalDataComponent } from './components/statistical-data/statistical-data.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CurrencyDecayComponent,
    SessionsComponent,
    StatisticalDataComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    CommonModule,
    HttpClientModule,
    MDBBootstrapModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
