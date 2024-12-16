package com.example.smartcanteen.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smartcanteen.R;
import com.google.android.material.button.MaterialButton;

public class ItemDetailsActivity extends AppCompatActivity {

    private TextView itemName, itemDescription, itemPrice, itemStock;
    private ImageView itemImage;
    private MaterialButton addToCartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        // Initialize UI components
        itemName = findViewById(R.id.itemName);
        itemDescription = findViewById(R.id.itemDescription);
        itemPrice = findViewById(R.id.itemPrice);
        itemStock = findViewById(R.id.itemStock);
        itemImage = findViewById(R.id.itemImage);
        addToCartButton = findViewById(R.id.addToCartButton);

        // Mock data - Replace with intent extras or API calls
        String mockName = "Classic Burger";
        String mockDescription = "A delicious burger with fresh lettuce, tomatoes, and a juicy beef patty.";
        double mockPrice = 45.0;
        int mockStock = 10;
        int mockImage = R.drawable.burger_image; // Add a sample image in res/drawable

        // Set data to UI components
        itemName.setText(mockName);
        itemDescription.setText(mockDescription);
        itemPrice.setText(String.format("$%.2f", mockPrice));
        itemStock.setText(String.format("Stock: %d", mockStock));
        itemImage.setImageResource(mockImage);

        addToCartButton.setOnClickListener(view -> {
            if (mockStock > 0) {
                Toast.makeText(this, mockName + " added to cart!", Toast.LENGTH_SHORT).show();
                // Reduce stock and notify the cart
                // Add logic to update the cart or database
            } else {
                Toast.makeText(this, "Sorry, this item is out of stock.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
