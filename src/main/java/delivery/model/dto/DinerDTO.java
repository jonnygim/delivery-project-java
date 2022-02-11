package delivery.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DinerDTO {
	private String diner_id;
	private String diner_name;
	private String diner_loc;
	private String diner_tel;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DinerDTO [diner_id=");
		builder.append(diner_id);
		builder.append(", diner_name=");
		builder.append(diner_name);
		builder.append(", diner_loc=");
		builder.append(diner_loc);
		builder.append(", diner_tel=");
		builder.append(diner_tel);
		builder.append("]");
		return builder.toString();
	}

}
