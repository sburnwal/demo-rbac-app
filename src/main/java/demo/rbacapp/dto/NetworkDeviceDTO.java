package demo.rbacapp.dto;

import demo.rbacapp.entity.NetworkDevice;

public class NetworkDeviceDTO extends BaseDTO {
	private String make;
	private String model;
	private String version;
	
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	public static NetworkDeviceDTO toDto(NetworkDevice device) {
		NetworkDeviceDTO dto = null;
		if(device != null) {
			dto = new NetworkDeviceDTO();
			dto.setId(device.getId());
			dto.setMake(device.getMake());
			dto.setModel(device.getModel());
			dto.setVersion(device.getVersion());
		}
		
		return dto;
	}
}
