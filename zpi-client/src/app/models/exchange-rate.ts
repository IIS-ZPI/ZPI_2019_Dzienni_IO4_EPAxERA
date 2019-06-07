import { Rate } from './rate';

export class ExchangeRate {
  table: string;
  currency: string;
  code: string;
  rates: Rate[];
}
