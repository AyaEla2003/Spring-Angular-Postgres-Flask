import { Component, OnInit } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-result-display',
  standalone: true,
  imports: [HttpClientModule, CommonModule],
  templateUrl: './result-display.component.html',
  styleUrls: ['./result-display.component.css']
})
export class ResultDisplayComponent implements OnInit {
  counts: any[] = [];

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.fetchData();
  }

  fetchData() {
    this.http.get<any[]>('http://localhost:8080/api/getCounts')
      .subscribe(
        (data: any[]) => {
          this.counts = data;
        },
        (error) => {
          console.error('Error fetching classifications:', error);
        }
      );
  }
}
