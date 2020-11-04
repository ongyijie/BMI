package my.edu.tarc.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.pow

// variableName : Type
// val = value, var = variable
// E.g. val pi: Double = 3.14159
// E.g. var num: Float
// fun = function
// override onCreate in AppCompatActivity



class MainActivity : AppCompatActivity() {
    // Global variable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Display the UI (layout)
        // R - resources class (res)
        setContentView(R.layout.activity_main)
        //Link UI to program
        val editTextWeight: EditText = findViewById(R.id.editTextWeight)
        val editTextHeight: EditText = findViewById(R.id.editTextHeight)
        val buttonCalculate: Button = findViewById(R.id.buttonCalculate)
        val buttonReset: Button = findViewById(R.id.buttonReset)
        val textViewBMI: TextView = findViewById(R.id.textViewBMI)
        val imageViewBMI: ImageView = findViewById(R.id.imageViewBMI)

        buttonCalculate.setOnClickListener {
            // To retrieve value from a view
            val weight: Float = editTextWeight.text.toString().toFloat()
            val height: Float = editTextHeight.text.toString().toFloat()

            //BMI = kg/m pow 2
            val bmi = weight/((height/100).pow(2))

            //TODO: Determine the status of BMI and present the result to the user
            if (bmi < 18.5) {
                imageViewBMI.setImageResource(R.drawable.under)
            }
            else if (bmi >= 18.5 && bmi < 24.9) {
                imageViewBMI.setImageResource(R.drawable.normal)
            }
            else if (bmi >= 25 && bmi < 29.9) {
                imageViewBMI.setImageResource(R.drawable.over)
            }
            textViewBMI.text = bmi.toString()
        } // end of Calculate onClickListener

        buttonReset.setOnClickListener {
            textViewBMI.text = "BMI"
            editTextWeight.text = null
            editTextHeight.text = null
            imageViewBMI.setImageResource(R.drawable.empty)
        } // end of Reset onClickListener

    } // end of function
} // end of class