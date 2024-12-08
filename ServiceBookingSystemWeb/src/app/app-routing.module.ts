import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignupClientComponent } from './basic/services/auth/signup-client/signup-client.component';

export const routes: Routes = [
  { path: 'register_client', component: SignupClientComponent },
  { path: 'company', loadChildren: () => import('./company/company.module').then(m => m.CompanyModule)},
  { path: 'client', loadChildren: () => import('./client/client.module').then(m => m.ClientModule)},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}

