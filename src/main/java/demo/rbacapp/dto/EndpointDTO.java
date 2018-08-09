package demo.rbacapp.dto;

import demo.rbacapp.entity.Endpoint;

public class EndpointDTO extends BaseDTO {
	private String make;
	private String productName;
	private String os;
	private String version;
	
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	public static EndpointDTO toDto(Endpoint ep) {
		EndpointDTO dto = null;
		if(ep != null) {
			dto = new EndpointDTO();
			dto.setId(ep.getId());
			dto.setMake(ep.getMake());
			dto.setOs(ep.getOs());
			dto.setProductName(ep.getProductName());
			dto.setVersion(ep.getVersion());
		}
		
		return dto;
	}

}
