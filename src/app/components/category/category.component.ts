import { Component, OnInit } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Category } from '../../models/category.model';
import { CategoryService } from '../../services/category.service';

@Component({
  selector: 'app-category',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.scss'],
})
export class CategoryComponent implements OnInit {
  categories: Category[] = [];
  category: Category = this.emptyCategory();

  constructor(private categoryService: CategoryService) {}

  ngOnInit(): void {
    this.loadCategories();
  }

  loadCategories(): void {
    this.categoryService.getAllCategories()
      .subscribe((data: Category[]) => this.categories = data);
  }

  createCategory(): void {
    if (this.category.id) {
      this.categoryService.updateCategoryById(this.category.id, this.category)
        .subscribe(() => {
          this.loadCategories();
          this.category = this.emptyCategory();
        });
    } else {
      this.categoryService.createCategory(this.category)
        .subscribe(() => {
          this.loadCategories();
          this.category = this.emptyCategory();
        });
    }
  }

  editCategory(cat: Category): void {
    this.category = { ...cat };
  }

  deleteCategoryById(id: number | null): void {
    if (id != null) {
      this.categoryService.deleteCategoryById(id)
        .subscribe(() => this.loadCategories());
    }
  }

  cancelEdit(): void {
    this.category = this.emptyCategory();
  }

  private emptyCategory(): Category {
    return { id:null, name: '' };
  }
}
