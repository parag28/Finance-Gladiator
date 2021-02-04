import { Emi } from "./emi";
import { Purchase } from "./purchase";
import { Transaction } from "./transaction";

export class Product {

    productid :number;
    numberofproducts :number;
    productinformation :string;
    productname :string;
    productpicture :string;
    productprice :number;
    transactions :Transaction[];
    emis :Emi[];
    purchases :Purchase[];
   
}


