import org.scalatest.FunSuite
import org.scalactic.TypeCheckedTripleEquals._

class CafeX_Order_Tests extends FunSuite {

    // test 1
    test("Cola, Coffee, Steak Sandwich") {
		val customer_bill = CafeX_Order(Array("Cola", "Coffee", "Steak Sandwich"))
        assert(customer_bill.standard_bill_total == 6.0f)
        assert(customer_bill.service_charge_total == 1.2f)
    }

    // test 2
    test("Cola, Coffee, Cheese Sandwich, Steak Sandwich") {
        val customer_bill = CafeX_Order(Array("Cola", "Coffee", "Cheese Sandwich", "Steak Sandwich"))
        assert(customer_bill.standard_bill_total == 8.0f)
        assert(customer_bill.service_charge_total == 1.6f)
    }

    // test 3
    test("10x {Cola, Coffee, Cheese Sandwich, Steak Sandwich}") {
        val customer_bill = CafeX_Order(Array("Cola", "Cola", "Cola", "Cola", "Cola", "Cola", "Cola", "Cola", "Cola", "Cola",
										 "Coffee", "Coffee", "Coffee", "Coffee", "Coffee", "Coffee", "Coffee", "Coffee", "Coffee", "Coffee", 
										 "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich", 
										 "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich"))
        assert(customer_bill.standard_bill_total == 80.0f)
        assert(customer_bill.service_charge_total == 16.0f)
	}

    // test 4
    test("20x {Cola, Coffee, Cheese Sandwich, Steak Sandwich}") {
		val customer_bill = CafeX_Order(Array("Cola", "Cola", "Cola", "Cola", "Cola", "Cola", "Cola", "Cola", "Cola", "Cola",
										 "Cola", "Cola", "Cola", "Cola", "Cola", "Cola", "Cola", "Cola", "Cola", "Cola",
										 "Coffee", "Coffee", "Coffee", "Coffee", "Coffee", "Coffee", "Coffee", "Coffee", "Coffee", "Coffee", 
										 "Coffee", "Coffee", "Coffee", "Coffee", "Coffee", "Coffee", "Coffee", "Coffee", "Coffee", "Coffee", 
										 "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich", 
										 "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich",  
										 "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich",
										 "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich"))
        assert(customer_bill.standard_bill_total == 160.0f)
        assert(customer_bill.service_charge_total == 20.0f)
	}
										 
    // test 5
    test("Boundary Case {Cola = 11; Coffee = 11; Cheese Sandwich = 8; Steak Sandwich = 15}") {
        val customer_bill = CafeX_Order(Array("Cola", "Cola", "Cola", "Cola", "Cola", "Cola", "Cola", "Cola", "Cola", "Cola",
										 "Cola",
										 "Coffee", "Coffee", "Coffee", "Coffee", "Coffee", "Coffee", "Coffee", "Coffee", "Coffee", "Coffee", 
										 "Coffee", 
										 "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich",  
										 "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich",
										 "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich"))
        assert(customer_bill.standard_bill_total == 100.0f)
        assert(customer_bill.service_charge_total == 20.0f)
	}
									 
    // test 6
    test("Boundary Case Below {Cola = 10; Coffee = 11; Cheese Sandwich = 8; Steak Sandwich = 15}") {
        val customer_bill = CafeX_Order(Array("Cola", "Cola", "Cola", "Cola", "Cola", "Cola", "Cola", "Cola", "Cola", "Cola",
										 "Coffee", "Coffee", "Coffee", "Coffee", "Coffee", "Coffee", "Coffee", "Coffee", "Coffee", "Coffee", 
										 "Coffee", 
										 "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich",  
										 "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich",
										 "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich"))
        assert(customer_bill.standard_bill_total == 99.5f)
        assert(customer_bill.service_charge_total == 19.9f)
	}

    // test 7
    test("Boundary Case Above {Cola = 12; Coffee = 11; Cheese Sandwich = 8; Steak Sandwich = 15}") {
        val customer_bill = CafeX_Order(Array("Cola", "Cola", "Cola", "Cola", "Cola", "Cola", "Cola", "Cola", "Cola", "Cola",
										 "Cola", "Cola",
										 "Coffee", "Coffee", "Coffee", "Coffee", "Coffee", "Coffee", "Coffee", "Coffee", "Coffee", "Coffee", 
										 "Coffee", 
										 "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich", "Cheese Sandwich",  
										 "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich",
										 "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich"))
        assert(customer_bill.standard_bill_total == 100.5f)
        assert(customer_bill.service_charge_total == 20.0f)
    }
}