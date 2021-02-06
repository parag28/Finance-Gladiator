import { Product } from "./product";
import { User } from "./user";

export class Emi {
    emiid:number;
    emidate:string;
    monthlycharge:number;
    emispaid:number;
    remainingemis:number;
    product:Product;
    user:User;
	
}

