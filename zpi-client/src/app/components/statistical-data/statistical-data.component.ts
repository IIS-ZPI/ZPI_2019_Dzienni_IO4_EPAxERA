import { Component, OnInit } from '@angular/core';
import {StatisticalDataService} from '../../services/statistical-data.service';

@Component({
  selector: 'app-statistical-data',
  templateUrl: './statistical-data.component.html',
  styleUrls: ['./statistical-data.component.css']
})
export class StatisticalDataComponent implements OnInit {

  median: number;
  deviation: number;
  dominant: number;

  chosenFirstOption: string;
  chosenSecondOption: string;
  chosenThirdOption: string;
  time: string;

  constructor(private statisticalDataService: StatisticalDataService) { }

  ngOnInit() {
  }

  getSpecificOption() {
    this.time = this.getPeriodOfTime();

    if (this.chosenFirstOption === 'median') {
      this.getMedianOfChosenCurrencyForTimeSpecifiedInDayParameter(this.chosenThirdOption, this.time);
    }
    if (this.chosenFirstOption === 'dominant') {
      this.getDominantOfChosenCurrencyForTimeSpecifiedInDayParameter(this.chosenThirdOption, this.time);
    }
    if (this.chosenFirstOption === 'deviation') {
      this.getDeviationOfChosenCurrencyForTimeSpecifiedInDayParameter(this.chosenThirdOption, this.time);
    }
  }

  getPeriodOfTime(): string {
    if (this.chosenSecondOption === 'oneWeek') {
      return '7';
    } else if (this.chosenSecondOption === 'twoWeeks') {
      return '14';
    } else if (this.chosenSecondOption === 'oneMonth') {
      return '30';
    } else if (this.chosenSecondOption === 'oneQuartal') {
      return '90';
    } else if (this.chosenSecondOption === 'halfOfYear') {
      return '182';
    } else if (this.chosenSecondOption === 'oneYear') {
      return '255';
    }
  }

  getDeviationOfChosenCurrencyForTimeSpecifiedInDayParameter(currency: string, day: string) {
    this.statisticalDataService.getDeviationOfChosenCurrencyForTimeSpecifiedInDayParameter(currency, day)
      .subscribe(deviation => this.deviation = deviation);
  }

  getDominantOfChosenCurrencyForTimeSpecifiedInDayParameter(currency: string, day: string) {
    this.statisticalDataService.getDominantOfChosenCurrencyForTimeSpecifiedInDayParameter(currency, day)
      .subscribe(dominant => this.dominant = dominant);
  }

  getMedianOfChosenCurrencyForTimeSpecifiedInDayParameter(currency: string, day: string) {
    this.statisticalDataService.getMedianOfChosenCurrencyForTimeSpecifiedInDayParameter(currency, day)
      .subscribe(median => this.median = median);
  }

}
