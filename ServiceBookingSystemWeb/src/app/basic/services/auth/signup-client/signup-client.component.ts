import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, AbstractControl } from '@angular/forms';
import { AuthService } from '../auth.service';
import { NzNotificationService } from 'ng-zorro-antd/notification';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup-client',
  templateUrl: './signup-client.component.html',
  styleUrls: ['./signup-client.component.scss'],
})
export class SignupClientComponent implements OnInit {
  validateForm!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private notification: NzNotificationService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.validateForm = this.fb.group({
      email: [null, [Validators.email, Validators.required]],
      firstname: [null, [Validators.required]],
      lastname: [null, [Validators.required]],
      phonenumber: [null, [Validators.pattern(/^[0-9]{10}$/)]], // Validation for a 10-digit phone number
      password: [null, [Validators.required]],
      checkpassword: [null, [Validators.required, this.matchPassword('password')]],
    });
  }

  // Custom validator to check if password and confirm password match
  matchPassword(passwordField: string) {
    return (control: AbstractControl) => {
      const formGroup = control.parent as FormGroup;
      if (!formGroup) return null;

      const password = formGroup.get(passwordField)?.value;
      const confirmPassword = control.value;

      return password === confirmPassword ? null : { mismatch: true };
    };
  }

  submitForm(): void {
    if (this.validateForm.valid) {
      this.authService.registerClient(this.validateForm.value).subscribe(
        (res) => {
          this.notification.success('SUCCESS', 'Signup Successful', { nzDuration: 5000 });
          this.router.navigateByUrl('/login');
        },
        (error) => {
          if (error.status === 409) {
            // Handle conflict error
            this.notification.error('ERROR', 'Email already exists. Please use a different email.', {
              nzDuration: 5000,
            });
          } else {
            console.error('Error occurred:', error); // Log other errors
            const errorMessage = error.error?.message || 'An unexpected error occurred.';
            this.notification.error('ERROR', errorMessage, { nzDuration: 5000 });
          }
        }
      );
    } else {
      this.notification.error('ERROR', 'Please complete the form correctly.', { nzDuration: 5000 });
    }
  }
}