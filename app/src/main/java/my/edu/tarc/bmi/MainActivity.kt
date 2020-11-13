package my.edu.tarc.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.pow

// variableName : Type
// val = value (immutable), var = variable
// E.g. val pi: Double = 3.14159
// E.g. var num: Float
// fun = function
// lateinit = late initialize, assign value later
// override onCreate in AppCompatActivity

class MainActivity : AppCompatActivity() {
    // Global variable
    private lateinit var editTextWeight: EditText
    private lateinit var editTextHeight: EditText
    private lateinit var textViewBMI : TextView
    private lateinit var imageViewBMI: ImageView

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
        val imageViewMoreInfo: ImageView = findViewById(R.id.imageViewMoreInfo)

        imageViewMoreInfo.setOnClickListener {
            val intent = Intent(this, InfoActivity::class.java)
            startActivity(intent)
        }

        buttonCalculate.setOnClickListener {
            // To retrieve value from a view
            val weight: Float = editTextWeight.text.toString().toFloat() // toDouble()
            val height: Float = editTextHeight.text.toString().toFloat()

            //BMI = kg/m pow 2
            val bmi = weight/((height/100).pow(2))


            //if else statement to display image of different BMI results
            if (bmi < 18.5) {
                textViewBMI.text = String.format("%1.2f, %s", bmi, getString(R.string.underweight))
                imageViewBMI.setImageResource(R.drawable.under)
            }
            else if (bmi >= 18.5 && bmi < 25) {
                textViewBMI.text = String.format("%1.2f, %s", bmi, getString(R.string.normal))
                imageViewBMI.setImageResource(R.drawable.normal)
            }
            else if (bmi >= 25 && bmi < 29.9) {
                textViewBMI.text = String.format("%1.2f, %s", bmi, getString(R.string.overweight))
                imageViewBMI.setImageResource(R.drawable.over)
            }
        } // end of Calculate onClickListener

        buttonReset.setOnClickListener {
            textViewBMI.text = "BMI"
            editTextWeight.text = null
            editTextHeight.text = null // or text.clear()
            imageViewBMI.setImageResource(R.drawable.empty)
        } // end of Reset onClickListener



    } // end of function
} // end of class