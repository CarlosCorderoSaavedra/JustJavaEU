package com.example.shine.justjavaeu;

/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 */

import android.icu.text.NumberFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    String priceMessage;
    int quantity = 3;
    int pricePerCup = 5;
    int price;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void submitOrder(View view) {

        price = calculatePrice();
        createOrderSummary();
        displayMessage(priceMessage);

    }

    private String createOrderSummary(){


        String nameOrder="Kaptain Kunal \n";
        String quantityOrder= "Quantity: "+ quantity + "\n";
        String thanksOrder ="Thank You!";
        String totalOrder = "Total: " + price + "€ \n";
        priceMessage=nameOrder+quantityOrder+totalOrder+thanksOrder;

        return priceMessage;


    }
    /**
     * Calculates the price of the order.
     *
     * @return  total price
     */
    private int calculatePrice() {

        int price = quantity * pricePerCup;
        return price;
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void incrementQuantity(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrementQuantity(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summay_text_view);
        orderSummaryTextView.setText(message);

    }



}
