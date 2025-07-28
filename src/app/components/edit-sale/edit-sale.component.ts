import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { SaleService } from '../../services/sale.service';
import { Sale } from '../../models/sale.model';

@Component({
  selector: 'app-edit-sale',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './edit-sale.component.html',
  styleUrls: ['./edit-sale.component.scss'],
})
export class EditSaleComponent implements OnInit {
  sales: Sale[] = [];          // Cambiado a plural
  filteredSales: Sale[] = [];
  totalFilteredSales: number = 0;

  startDateTime: string = '';
  endDateTime: string = '';

  constructor(private saleService: SaleService) {}

  ngOnInit(): void {
    this.saleService.getAllSale().subscribe({
      next: (sales: Sale[]) => {
        this.sales = sales;
        this.filteredSales = sales;
      },
      error: (err) => console.error('Error loading sales:', err),
    });
  }


filterSalesByDateRange(): void {
  if (!this.startDateTime || !this.endDateTime) {
    this.filteredSales = [];
    this.totalFilteredSales = 0;
    return;
  }

  const start = new Date(this.startDateTime).getTime();
  const end = new Date(this.endDateTime).getTime();

  this.filteredSales = this.sales.filter(sale => {
    if (!sale.startDate) return false;
    const saleDate = new Date(sale.startDate).getTime();
      return saleDate >= start && saleDate <= end;
  });

  this.totalFilteredSales = this.filteredSales.reduce((sum, sale) => sum + sale.price, 0);
}


}
