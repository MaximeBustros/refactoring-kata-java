package com.sipios.refactoring.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sipios.refactoring.enums.CustomerType;
import com.sipios.refactoring.model.Customer;
import com.sipios.refactoring.model.Item;

@RestController
@RequestMapping("/shopping")
public class ShoppingController {

    private Logger logger = LoggerFactory.getLogger(ShoppingController.class);

    @PostMapping
    public String getPrice(@RequestBody Customer customer) {
        double p = 0;
        double d;

        Date date = new Date();
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));
        cal.setTime(date);

        // Compute discount for customer
        if (customer.getCustomerType() == CustomerType.STANDARD_CUSTOMER) {
            d = 1;
        } else if (customer.getCustomerType() == CustomerType.PREMIUM_CUSTOMER) {
            d = 0.9;
        } else if (customer.getCustomerType() == CustomerType.PLATINUM_CUSTOMER) {
            d = 0.5;
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        // Compute total amount depending on the types and quantity of product and
        // if we are in winter or summer discounts periods
        if (
            !(
                cal.get(Calendar.DAY_OF_MONTH) < 15 &&
                cal.get(Calendar.DAY_OF_MONTH) > 5 &&
                cal.get(Calendar.MONTH) == 5
            ) &&
            !(
                cal.get(Calendar.DAY_OF_MONTH) < 15 &&
                cal.get(Calendar.DAY_OF_MONTH) > 5 &&
                cal.get(Calendar.MONTH) == 0
            )
        ) {
            if (customer.getCartItems().isEmpty()) {
                return "0";
            }

            for (int i = 0; i < customer.getCartItems().size(); i++) {
                Item it = customer.getCartItems().get(i);

                if (it.getName().equals("TSHIRT")) {
                    p += 30 * it.getNb() * d;
                } else if (it.getName().equals("DRESS")) {
                    p += 50 * it.getNb() * d;
                } else if (it.getName().equals("JACKET")) {
                    p += 100 * it.getNb() * d;
                }
                // else if (it.getType().equals("SWEATSHIRT")) {
                //     price += 80 * it.getNb();
                // }
            }
        } else {
            if (customer.getCartItems().isEmpty()) {
                return "0";
            }

            for (int i = 0; i < customer.getCartItems().size(); i++) {
                Item it = customer.getCartItems().get(i);

                if (it.getName().equals("TSHIRT")) {
                    p += 30 * it.getNb() * d;
                } else if (it.getName().equals("DRESS")) {
                    p += 50 * it.getNb() * 0.8 * d;
                } else if (it.getName().equals("JACKET")) {
                    p += 100 * it.getNb() * 0.9 * d;
                }
                // else if (it.getType().equals("SWEATSHIRT")) {
                //     price += 80 * it.getNb();
                // }
            }
        }

        try {
            if (customer.getCustomerType() == CustomerType.STANDARD_CUSTOMER) {
                if (p > 200) {
                    throw new Exception("Price (" + p + ") is too high for standard customer");
                }
            } else if (customer.getCustomerType() == CustomerType.PREMIUM_CUSTOMER) {
                if (p > 800) {
                    throw new Exception("Price (" + p + ") is too high for premium customer");
                }
            } else if (customer.getCustomerType() == CustomerType.PLATINUM_CUSTOMER) {
                if (p > 2000) {
                    throw new Exception("Price (" + p + ") is too high for platinum customer");
                }
            } else {
                if (p > 200) {
                    throw new Exception("Price (" + p + ") is too high for standard customer");
                }
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

        return String.valueOf(p);
    }
}
