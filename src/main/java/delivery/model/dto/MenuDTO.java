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
	private int food_price;
	private String diner_id;
	private String menu;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FoodDTO [food_price=");
		builder.append(food_price);
		builder.append(", diner_id=");
		builder.append(diner_id);
		builder.append(", menu=");
		builder.append(menu);
		builder.append("]");
		return builder.toString();
	}
		
	
	
}	
