package delivery.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
	private String user_id;
	private String user_name;
	private String user_loc;
	private String user_mobile;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerDTO [user_id=");
		builder.append(user_id);
		builder.append(", user_name=");
		builder.append(user_name);
		builder.append(", user_loc=");
		builder.append(user_loc);
		builder.append(", user_mobile=");
		builder.append(user_mobile);
		builder.append("]");
		return builder.toString();
	}
	
	
}
