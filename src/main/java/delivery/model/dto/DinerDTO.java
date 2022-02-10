package delivery.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
<<<<<<< Updated upstream

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DinerDTO {
	private String dinerId;
	private String dinerName;
	private String dinerTel;
	private String dinerLoc;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DinerDTO [dinerTel=");
		builder.append(dinerTel);
		builder.append(", dinerId=");
		builder.append(dinerId);
		builder.append(", dinerName=");
		builder.append(dinerName);
		builder.append(", dinerLoc=");
		builder.append(dinerLoc);
		builder.append("]");
		return builder.toString();
	}
	
	
=======

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

>>>>>>> Stashed changes
	
}
