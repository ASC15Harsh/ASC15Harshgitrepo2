import { Component, OnInit } from "@angular/core";
import { FormGroup,FormBuilder } from "@angular/forms"; 


@Component({
    selector: "app-login",
    templateUrl: "./login.component.html",
    styleUrls: ["./login.component.css"]
})
 
export class LoginComponent implements OnInit{
    loginForm: FormGroup;
    constructor(private formBuilder:FormBuilder){}
    ngOnInit(){
        this.loginForm = this.formBuilder.group ({
            loginid:["reddy"],
            password: []
        })
    }
    onSubmit(){
        console.log(this.loginForm.value);
    }
}