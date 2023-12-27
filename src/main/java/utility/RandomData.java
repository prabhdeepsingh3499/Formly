package utility;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.github.javafaker.Faker;
public class RandomData {
	Faker faker;
	Random rnd;
	public RandomData() {
		faker = new Faker();
		rnd = new Random();
	}
	public String getFirstName() {
		return faker.name().firstName();
	}
	public String getLastName() {
		return faker.name().lastName();
	}
	public String getJobTitle() {
		return faker.job().title();
	}
	public String createRandomDate() {
		String pattern = "mm/dd/yyyy";
		DateFormat df = new SimpleDateFormat(pattern);
		Date date = new Date(Math.abs(System.currentTimeMillis() - rnd.nextLong()));
		String convertedDate = df.format(date);
		return convertedDate;
	}
	public int getRandomNumber(int size) {
		int randomNumber = rnd.nextInt(size);
		if(randomNumber==0) {
			return 1;
		}
		else {
			return randomNumber;
		}
	}
}
