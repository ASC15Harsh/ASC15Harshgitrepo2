import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { user } from "../model/user.model";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class EmployeeService {
    // baseUrl: string = "http://localhost:3000/user";
    baseUrl: string = "http://localhost:8080/api/v1";

    constructor(private http: HttpClient) { }

    getEmployees(): Observable<user[]> {
        return this.http.get<user[]>(this.baseUrl);
    }

    addEmployee(employee: user): Observable<user> {
        return this.http.post<user>(this.baseUrl, employee);
    }

    updateEmployee(employee: user): Observable<user> {
        return this.http.put<user>(`${this.baseUrl}/${employee.id}`, employee);
    }

    deleteEmployee(id: number): Observable<void> {
        return this.http.delete<void>(`${this.baseUrl}/${id}`);
    }
    
}
