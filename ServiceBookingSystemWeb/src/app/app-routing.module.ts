import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignupClientComponent } from './basic/services/auth/signup-client/signup-client.component';

export const routes: Routes = [
  // Route for client signup
  { path: 'register_client', component: SignupClientComponent },

  // Lazy-loaded route for company module
  { 
    path: 'company', 
    loadChildren: () => import('./company/company.module').then(m => m.CompanyModule),
  },

  // Lazy-loaded route for client module
  { 
    path: 'client', 
    loadChildren: () => import('./client/client.module').then(m => m.ClientModule),
  },

  // Default route redirects to 'register_client'
  { path: '', redirectTo: 'register_client', pathMatch: 'full' },

  // Wildcard route to handle undefined paths
  { path: '**', redirectTo: 'register_client' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}