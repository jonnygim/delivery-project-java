package delivery.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryProjectDTO {
	private String delivery_project_id;
	private String diner_id;
	private String diner_name;
	private String user_id;
	private String user_loc;
	private String menu_id;
	private String menu_name;
	private String menu_price;
	private String reg_date;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DeliveryProjectDTO [delivery_project_id=");
		builder.append(delivery_project_id);
		builder.append(", diner_id=");
		builder.append(diner_id);
		builder.append(", diner_name=");
		builder.append(diner_name);
		builder.append(", user_id=");
		builder.append(user_id);
		builder.append(", user_loc=");
		builder.append(user_loc);
		builder.append(", menu_id=");
		builder.append(menu_id);
		builder.append(", menu_name=");
		builder.append(menu_name);
		builder.append(", menu_price=");
		builder.append(menu_price);
		builder.append(", reg_date=");
		builder.append(reg_date);
		builder.append("]");
		return builder.toString();
	}
}
