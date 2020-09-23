
// this class defines the functionality in using the weather bot
public class WeatherBot {

	// defining the class and its variables for the puprose of resembling the JSON script to match with
	// a specific data set of the JSON script
	public class Main {

		double temp;
		double temp_max;
		double temp_min;
	}

	Main main;

	// this function converts the temperature from Kelvin to Fahrenheit and returns
    // a String
	public String Temperature() {

		// converting kelvin to fahrenheit
		double temper = (((main.temp - 273.15 + 15)*9)/5) 32 ;
		double temper_max = (((main.temp_max - 273.15 + 15)*9)/5) + 32;
		double temper_min = (((main.temp_min - 273.15 + 15)*9)/5) + 32;

		// rounding the double values
		double temp_r = Math.floor(temper*100)/100;
		double temp_max_r = Math.floor(temper_max*100)/100;
		double temp_min_r = Math.floor(temper_min*100)/100;

		// converting the double values to String
		String string_temp = Double.toString(temp_r);
		String string_temp_max = Double.toString(temp_max_r);
		String string_temp_min = Double.toString(temp_min_r);

		return "the current temperature is " + string_temp +  " degrees Fahrenheit with a high of " + string_temp_max + " degrees Fahrenheit and a low of " + string_temp_min + " degrees Fahrenheit.";

	}

}
