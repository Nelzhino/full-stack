import { Component } from '@angular/core';
import { RegisterService } from '../service/register.service';
import { UserDto } from '../models/UserDto';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  username: string;
  password: string;
  roles: string[];

  invalidRegister: boolean;
  messageInvalid: string;
  successfulRegister: boolean;
  messageSuccessful: string;

  constructor(private registerService: RegisterService) {
    this.roles = [];
    this.username = '';
    this.password = '';

    this.invalidRegister = false;
    this.successfulRegister = false;
    this.messageInvalid = 'There was a problem with the register.';
    this.messageSuccessful = 'User created!';
  }

  handleSaveRegister() {
    if (this.username !== '' && this.password !== '' && this.roles.length > 0) {
      const user: UserDto = {
        username: this.username,
        password: this.password,
        roles: this.roles
      };

      this.registerService.saveRegisterUser(user).subscribe( response => {
        this.showSuccessfulRegister();
      }, error => {
        if (error) {
          this.showMessageRegister();
        }
      });

    } else {
      this.showMessageRegister();
    }
  }

  addRol(name: string, $event) {
    const findRol = this.roles.filter( rol => rol === name);
    if (findRol.length === 0 && $event.target.checked) {
      this.roles.push(name);
    } else if (findRol.length > 0 && !$event.target.checked) {
      this.roles = this.roles.filter( rol => rol !== name);
    }
  }

  showMessageRegister() {
    this.invalidRegister = true;
    setTimeout(() => {
      this.invalidRegister = false;
    }, 3000);
  }

  showSuccessfulRegister() {
    this.successfulRegister = true;
    setTimeout( () => {
      this.successfulRegister = false;
    }, 3000);
  }

}
