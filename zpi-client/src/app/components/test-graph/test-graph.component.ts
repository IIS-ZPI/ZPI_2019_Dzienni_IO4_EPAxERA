import {Component, Input, OnInit} from '@angular/core';
import * as CanvasJS from './canvasjs.min';

@Component({
  selector: 'app-test-graph',
  templateUrl: './test-graph.component.html',
  styleUrls: ['./test-graph.component.scss']
})
export class TestGraphComponent implements OnInit {
  @Input() title: string;
  @Input() subtitle: string;

  ngOnInit() {
    let dataPoints = [];
    let y = 0;
    for ( var i = 0; i < 98; i++ ) {
      y += Math.round(5 + Math.random() * (-5 - 5));
      dataPoints.push({ y: y});
    }

    let chart = new CanvasJS.Chart("chartContainer", {
      zoomEnabled: true,
      animationEnabled: true,
      exportEnabled: true,
      title: {
        text: this.title
      },
      subtitles:[{
        text: this.subtitle
      }],
      data: [
        {
          type: "line",
          dataPoints: dataPoints
        }]
    });

    chart.render();
  }

}
