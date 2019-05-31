import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './components/home/home.component';
import { CurrencyDecayComponent } from './components/currency-decay/currency-decay.component';
import { SessionsComponent } from './components/sessions/sessions.component';
import { StatisticalDataComponent } from './components/statistical-data/statistical-data.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'currency-decay', component: CurrencyDecayComponent },
  { path: 'sessions', component: SessionsComponent },
  { path: 'statistical-data', component: StatisticalDataComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
