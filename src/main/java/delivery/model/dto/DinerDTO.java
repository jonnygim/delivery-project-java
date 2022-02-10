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
	
	
	
}
