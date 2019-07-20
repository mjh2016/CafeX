case class CafeX_Order(args: Array[String]) {
	import CafeX_Order._
	def standard_bill_total: Float = standard_bill(args: Array[String])
	def service_charge_total: Float = service_charge(args: Array[String])
}

object CafeX_Order {

   private def standard_bill(args: Array[String]) : Float = {
       var standard_bill = 0.00f
       
       var service_charge_class = 0
       var service_charge = 0.00f
       
       var menu_item_string = new Array[String](4)
       var menu_item_price = new Array[Float](4)
       var menu_item_food_or_drink = new Array[Boolean](4)
       var menu_item_hot_or_cold = new Array[Boolean](4)
       
       
       menu_item_string(0) = "Cola"
       menu_item_price(0) = 0.50f
       menu_item_food_or_drink(0) = true
       menu_item_hot_or_cold(0) = true
       
       menu_item_string(1) = "Coffee"
       menu_item_price(1) = 1.00f
       menu_item_food_or_drink(1) = true
       menu_item_hot_or_cold(1) = false
       
       menu_item_string(2) = "Cheese Sandwich"
       menu_item_price(2) = 2.00f
       menu_item_food_or_drink(2) = false
       menu_item_hot_or_cold(2) = true
       
       menu_item_string(3) = "Steak Sandwich"
       menu_item_price(3) = 4.50f
       menu_item_food_or_drink(3) = false
       menu_item_hot_or_cold(3) = false
       
       // standard bill computation
       for (a <- 0 until args.length)
       {
           for (index <- 0 until menu_item_string.length)
           {
               if (args(a) == menu_item_string(index))
               {
                   standard_bill = standard_bill + menu_item_price(index)
               }
               ;
           }
       }
       
       return standard_bill;
   }
   
   private def service_charge(args: Array[String]) : Float = {
       var standard_bill = 0.00f
       
       var service_charge_class = 0
       var service_charge = 0.00f
       
       var menu_item_string = new Array[String](4)
       var menu_item_price = new Array[Float](4)
       var menu_item_food_or_drink = new Array[Boolean](4)
       var menu_item_hot_or_cold = new Array[Boolean](4)
       
       
       menu_item_string(0) = "Cola"
       menu_item_price(0) = 0.50f
       menu_item_food_or_drink(0) = true
       menu_item_hot_or_cold(0) = true
       
       menu_item_string(1) = "Coffee"
       menu_item_price(1) = 1.00f
       menu_item_food_or_drink(1) = true
       menu_item_hot_or_cold(1) = false
       
       menu_item_string(2) = "Cheese Sandwich"
       menu_item_price(2) = 2.00f
       menu_item_food_or_drink(2) = false
       menu_item_hot_or_cold(2) = true
       
       menu_item_string(3) = "Steak Sandwich"
       menu_item_price(3) = 4.50f
       menu_item_food_or_drink(3) = false
       menu_item_hot_or_cold(3) = false
       
       
       // standard bill computation
       for (a <- 0 until args.length)
       {
           for (index <- 0 until menu_item_string.length)
           {
               if (args(a) == menu_item_string(index))
               {
                   standard_bill = standard_bill + menu_item_price(index)
               }
               ;
           }
       }
     
       // service charge
       for (a <- 0 until args.length)
       {
           for (index <- 0 until menu_item_string.length)
           {
               if (args(a) == menu_item_string(index))
               {
                   if ((!menu_item_food_or_drink(index)) && (!menu_item_hot_or_cold(index)))
                   {
                       service_charge_class = 2
                   }
                   else if ((service_charge_class != 2) && ((!menu_item_food_or_drink(index)) && (menu_item_hot_or_cold(index))))
                   {
                       service_charge_class = 1
                   }
                   ;
               }
           }
       }
       
       if (service_charge_class == 1)
       {
           service_charge = 0.1f*standard_bill
       }
       else if (service_charge_class == 2)
       {
           if ((0.2f*standard_bill) > 20f)
           {
               service_charge = 20f
           }
           else
           {
               service_charge = 0.2f*standard_bill
           }
           ;
       }
       
       return service_charge;
   }
}