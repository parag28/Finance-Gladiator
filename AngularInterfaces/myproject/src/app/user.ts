import { Card } from "./card";
import { Emi } from "./emi";
import { Login } from "./login";
import { Purchase } from "./purchase";
import { Transaction } from "./transaction";

export class User {
    userName :string;
    address :string;
    bankName :string;
    dateOfBirth :string;
    email :string;
    ifscCode:string;
    name :string;
    phoneNumber :number;
    savingsAccountNumber:number;
    card :Card;
    emis : Emi[];
    login:Login;
    purchases:Purchase[];
    transactions:Transaction[];
	
}
