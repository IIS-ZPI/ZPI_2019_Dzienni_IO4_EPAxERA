import { Rate } from '../Rate';

export class ExchangeRate {
  table: string;
  currency: string;
  code: string;
  rates: Rate[];
}
