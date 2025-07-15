import { Routes } from '@angular/router';
import { SaleComponent } from './components/sale/sale.component';
import { CategoryComponent } from './components/category/category.component';
import { ProductComponent } from './components/product/product.component';

export const routes: Routes = [
  { path: '', redirectTo: '/sale', pathMatch: 'full' },
  { path: 'sale', component: SaleComponent },
  { path: 'category', component: CategoryComponent },
  { path: 'product', component: ProductComponent }

];
