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

	private String menu_id;
	private String diner_id;
	private String menu_name;
	private String menu_price;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MenuDTO [menu_id=");
		builder.append(menu_id);
		builder.append(", diner_id=");
		builder.append(diner_id);
		builder.append(", menu_name=");
		builder.append(menu_name);
		builder.append(", menu_price=");
		builder.append(menu_price);
		builder.append("]");
		return builder.toString();
	}	
}
