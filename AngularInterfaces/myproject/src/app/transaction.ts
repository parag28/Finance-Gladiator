import { Product } from "./product";
import { User } from "./user";

export class Transaction {
    productquantity:number;
    transactionid:number;
    transactionstatus:number;
    transactionamount:number;
    transactiondate:string;
    product:Product;
    user:User;


}
