import { FlexLayoutModule } from '@angular/flex-layout';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatIconModule } from '@angular/material/icon';
import { MatCardModule } from '@angular/material/card';
import { MatListModule } from '@angular/material/list';
import { MatSortModule } from '@angular/material/sort';
import { MatInputModule } from '@angular/material/input';
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogModule } from '@angular/material/dialog';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatAutocompleteModule, MatOptionModule } from '@angular/material';

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        ReactiveFormsModule,
        MatIconModule,
        MatCardModule,
        MatListModule,
        MatSortModule,
        MatInputModule,
        MatTableModule,
        MatButtonModule,
        MatDialogModule,
        MatSidenavModule,
        MatToolbarModule,
        MatFormFieldModule,
        MatAutocompleteModule,
        FlexLayoutModule,
        MatOptionModule
    ],
    exports: [
        FormsModule,
        ReactiveFormsModule,
        MatIconModule,
        MatCardModule,
        MatListModule,
        MatSortModule,
        MatInputModule,
        MatTableModule,
        MatButtonModule,
        MatDialogModule,
        MatSidenavModule,
        MatToolbarModule,
        MatAutocompleteModule,
        MatOptionModule,
        MatFormFieldModule,
        FlexLayoutModule
       

    ],
    declarations: []
})
export class AppMaterialModule { }