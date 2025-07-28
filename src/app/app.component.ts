import { Component } from '@angular/core';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { RouterOutlet } from '@angular/router';
import { SaleComponent } from './components/sale/sale.component';
import { CategoryComponent } from './components/category/category.component';
import { ProductComponent } from './components/product/product.component';
import { EditSaleComponent } from './components/edit-sale/edit-sale.component';



@Component({
  selector: 'app-root',
  standalone: true,
  imports: [SaleComponent, SidebarComponent, RouterOutlet, CategoryComponent, ProductComponent, EditSaleComponent],
  template: `
    <div class="d-flex">
      <app-sidebar></app-sidebar>
      <div class="p-4 flex-grow-1 w-100">
        <router-outlet></router-outlet>
      </div>
    </div>
  `,
})
export class AppComponent {}
