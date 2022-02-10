package delivery.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenuDTO {

	private String diner_id;
	private String menu_name;
	private String food_price;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("FoodDTO [food_price=");
		builder.append(food_price);
		builder.append(", diner_id=");
		builder.append(diner_id);
		builder.append(", menu=");
		builder.append(menu_name);
		builder.append("]");
		return builder.toString();
	}
		
}
